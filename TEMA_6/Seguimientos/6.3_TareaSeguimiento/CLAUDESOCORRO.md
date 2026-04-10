Ahora tengo todo lo que necesito. Voy a darte una explicación arquitectónica muy completa y luego las correcciones.

---

## Arquitectura general del proyecto

Este proyecto implementa un **sistema de gestión de un centro educativo** usando una arquitectura en capas clásica: **Model → Repository → Service → Main (UI)**. Lo que lo hace interesante es que usa **dos fuentes de datos distintas al mismo tiempo**: un fichero XML para los datos estáticos (profesores y módulos) y un fichero JSON para los datos dinámicos (evaluaciones e incidencias).

```
┌─────────────────────────────────────────────────┐
│                  MAIN (UI/Consola)               │
│  Menú, Scanner, llamadas al Service              │
└──────────────────────┬──────────────────────────┘
                       │ usa
┌──────────────────────▼──────────────────────────┐
│               CentroService (interfaz)           │
│         CentroServiceImpl (implementación)       │
│  Contiene TODA la lógica de negocio              │
└────────────┬─────────────────────┬──────────────┘
             │ usa                 │ usa
┌────────────▼──────────┐ ┌───────▼───────────────┐
│  CentroXmlRepository  │ │ EstadoJsonRepository   │
│  (interfaz + impl)    │ │ (interfaz + impl)      │
│  Lee XML estático     │ │ Lee/escribe JSON       │
└────────────┬──────────┘ └───────┬───────────────┘
             │ usa                │ usa
┌────────────▼──────────┐ ┌───────▼───────────────┐
│     XmlManager        │ │     JsonManager        │
│  (Jackson XmlMapper)  │ │  (Jackson ObjectMapper)│
└───────────────────────┘ └───────────────────────┘
```

---

## Capa de Modelo (los datos que circulan)

Son las clases Java puras (POJOs) que representan la realidad del dominio.

**`Profesor`** y **`Modulo`** son los datos que viven en el XML. Ambos tienen una anotación especial `@JacksonXmlProperty(isAttribute = true)` sobre el campo `id`, lo que significa que en el fichero XML ese campo se serializa como *atributo* de la etiqueta XML en lugar de como elemento hijo:

```xml
<!-- Con isAttribute = true -->
<profesor id="P01">
    <nombre>Ana Pérez</nombre>
    ...
</profesor>

<!-- Sin esa anotación sería -->
<profesor>
    <id>P01</id>
    <nombre>Ana Pérez</nombre>
</profesor>
```

El `equals` y `hashCode` de estas clases están definidos **solo por el `id`**. Esto es clave: permite usar `indexOf()` en una lista pasando un objeto construido únicamente con el id, sin necesidad de conocer el resto de campos. Es un truco elegante para buscar sin iterar manualmente.

**`CentroData`** es el objeto raíz que Jackson serializa/deserializa como el fichero XML completo. Las anotaciones `@JacksonXmlElementWrapper` y `@JacksonXmlProperty` controlan cómo se anidan los elementos:

```xml
<centro>
    <profesores>
        <profesor id="P01">...</profesor>
    </profesores>
    <modulos>
        <modulo id="M01">...</modulo>
    </modulos>
</centro>
```

**`Evaluacion`** e **`Incidencia`** viven en el JSON. El `equals` de `Evaluacion` se basa en `(alumno, moduloId)` — esto es semánticamente importante: significa que un alumno solo puede tener **una nota por módulo**, y si se guarda otra, debe sobreescribir la anterior. El `equals` de `Incidencia` usa los tres campos, lo que significa que una incidencia idéntica en todos sus campos no se puede duplicar.

**`EstadoCentro`** es el objeto raíz del JSON, análogo a `CentroData` para el XML.

---

## Capa de Utilidades (los traductores entre Java y disco)

`XmlManager` y `JsonManager` tienen la misma responsabilidad pero para formatos distintos: **traducir entre objetos Java y ficheros en disco**.

**`XmlManager`** usa `XmlMapper` de Jackson (la variante XML de la librería). Sus dos métodos son:
- `read(Path)`: si el fichero no existe, devuelve un `CentroData` vacío en lugar de lanzar excepción. Esto es un diseño defensivo importante.
- `write(Path, CentroData)`: crea los directorios padre si no existen antes de escribir.

**`JsonManager`** hace exactamente lo mismo con `ObjectMapper` estándar de Jackson para JSON.

Estas clases son **stateless** (sin estado): no guardan nada en memoria, cada llamada lee/escribe directamente del disco. Esto tiene implicaciones importantes que veremos más adelante.

---

## Capa de Repositorio (la puerta de acceso a los datos)

Aquí hay dos pares interfaz/implementación.

### CentroXmlRepository / CentroXmlRepositoryImpl

Esta capa gestiona los datos **de solo lectura** (el XML no se modifica en tiempo de ejecución). La implementación tiene tres constructores, lo cual es importante para los tests:

```java
// Constructor básico: crea su propio XmlManager
public CentroXmlRepositoryImpl(Path xmlPath) { ... }

// Constructor con inyección del manager (para tests con mocks)
public CentroXmlRepositoryImpl(Path xmlPath, XmlManager xmlManager) { ... }

// Constructor especial: recibe directamente las listas (para tests sin fichero)
public CentroXmlRepositoryImpl(Path xmlPath, XmlManager xmlManager, List<Profesor> profesores) { ... }
```

El problema actual del código es que la implementación **no llama a `xmlManager.read()`** en ningún constructor para cargar los datos. Las listas `modulos` y `profesores` se quedan a `null`.

Los métodos de búsqueda usan el truco del `equals-por-id` mencionado antes:

```java
public Profesor findProfesorById(String id) {
    Profesor profesorBuscar = new Profesor(id);  // objeto "hueco" solo con id
    int posicion = profesores.indexOf(profesorBuscar);  // equals busca por id
    if (posicion < 0) return null;
    return profesores.get(posicion);
}
```

El test `xmlFindAllProfesoresDevuelveCopiaDefensivaTest` verifica que modificar la lista devuelta no afecte a los datos internos del repositorio — esto implica que `findAllProfesores()` debe devolver `new ArrayList<>(profesores)`, no la referencia directa.

### EstadoJsonRepository / EstadoJsonRepositoryImpl

Esta capa gestiona datos **de lectura y escritura**. El diseño correcto requiere que **al inicializarse lea el JSON del disco** y que **cada vez que se modifique, persista los cambios**. Esto es lo que hace que `jsonPersisteCambiosEntreLecturasTest` funcione: crea un nuevo repositorio y comprueba que los datos siguen ahí.

El método `saveEvaluacion` debe implementar la lógica de "upsert" (actualizar si existe, insertar si no) basándose en el `equals` de `Evaluacion`.

---

## Capa de Servicio (la lógica de negocio)

`CentroServiceImpl` es donde vive la **inteligencia de la aplicación**. Recibe ambos repositorios por constructor (inyección de dependencias) y los coordina. Fíjate que usa `Objects.requireNonNull` para fallar rápido si alguien pasa `null`.

Las responsabilidades del servicio son:
1. **Validar entradas** (blancos, nulls, notas fuera de rango, entidades inexistentes)
2. **Coordinar entre repositorios** (por ejemplo, para registrar una evaluación necesita verificar en el XML que el módulo existe, y luego guardar en el JSON)
3. **Calcular derivados** (medias de módulo, medias de profesor)

El método `calcularMediaDeProfesor` es el más complejo porque necesita:
1. Ir al XML para obtener los módulos del profesor
2. Para cada módulo, ir al JSON para obtener las evaluaciones
3. Agregar todas las notas y calcular la media global

---

## Capa de Presentación (Main)

`Main` es la interfaz de usuario de consola. Separa claramente la inicialización (método `inicializarDatos` que crea los ficheros si no existen), la navegación (`ejecutarMenu`, `mostrarMenu`) y las acciones (`buscarProfesor`, `registrarEvaluacion`, etc.). Cada acción lee del scanner y delega al servicio, luego imprime el resultado con métodos `imprimirX` que manejan el caso `null`.

---

## Los Tests y qué verifican

`TestDataHelper` es una clase de apoyo para tests que siembra datos conocidos. Crea 3 profesores, 4 módulos, 6 evaluaciones y 4 incidencias predefinidas, de manera que los tests puedan hacer aserciones con números concretos.

Los tests están organizados por prefijo:
- `A01...` → tests del repositorio XML
- `A02...` → tests del repositorio JSON
- `B01...` → tests del servicio (integración entre repositorios)

La anotación `@TempDir` de JUnit 5 crea un directorio temporal único por test, garantizando aislamiento total entre pruebas.

---

## Los bugs actuales y sus correcciones

### 1. `CentroXmlRepositoryImpl` — no carga los datos del XML

```java
// En el constructor de dos argumentos, hay que leer el XML:
public CentroXmlRepositoryImpl(Path xmlPath, XmlManager xmlManager) {
    this.xmlPath = xmlPath;
    this.xmlManager = xmlManager;
    CentroData data = xmlManager.read(xmlPath);
    this.profesores = new ArrayList<>(data.getProfesores());
    this.modulos = new ArrayList<>(data.getModulos());
}
```

Y `findAllProfesores` / `findAllModulos` deben devolver copias defensivas:

```java
@Override
public List<Profesor> findAllProfesores() {
    return new ArrayList<>(profesores);
}

@Override
public List<Modulo> findAllModulos() {
    return new ArrayList<>(modulos);
}
```

### 2. `EstadoJsonRepositoryImpl` — no carga ni persiste datos

```java
public EstadoJsonRepositoryImpl(Path jsonPath, JsonManager jsonManager) {
    this.jsonPath = jsonPath;
    this.jsonManager = jsonManager;
    EstadoCentro estado = jsonManager.read(jsonPath);
    this.evaluaciones = new ArrayList<>(estado.getEvaluaciones());
    this.incidencias = new ArrayList<>(estado.getIncidencias());
}

private void persistir() {
    jsonManager.write(jsonPath, new EstadoCentro(evaluaciones, incidencias));
}

@Override
public void saveEvaluacion(Evaluacion evaluacion) {
    int idx = evaluaciones.indexOf(evaluacion);
    if (idx >= 0) {
        evaluaciones.set(idx, evaluacion);  // sobreescribe (upsert)
    } else {
        evaluaciones.add(evaluacion);
    }
    persistir();
}

@Override
public List<Evaluacion> findAllEvaluaciones() {
    return new ArrayList<>(evaluaciones);
}

@Override
public List<Evaluacion> findEvaluacionesByModuloId(String moduloId) {
    return evaluaciones.stream()
        .filter(e -> e.getModuloId().equals(moduloId))
        .collect(Collectors.toList());
}

@Override
public void saveIncidencia(Incidencia incidencia) {
    if (!incidencias.contains(incidencia)) {
        incidencias.add(incidencia);
        persistir();
    }
}

@Override
public List<Incidencia> findAllIncidencias() {
    return new ArrayList<>(incidencias);
}

@Override
public List<Incidencia> findIncidenciasByProfesorId(String profesorId) {
    return incidencias.stream()
        .filter(i -> i.getProfesorId().equals(profesorId))
        .collect(Collectors.toList());
}
```

### 3. `CentroServiceImpl` — implementar todos los métodos

```java
@Override
public Profesor buscarProfesor(String profesorId) {
    if (profesorId == null || profesorId.isBlank()) return null;
    return xmlRepository.findProfesorById(profesorId.trim());
}

@Override
public Modulo buscarModulo(String moduloId) {
    if (moduloId == null || moduloId.isBlank()) return null;
    return xmlRepository.findModuloById(moduloId.trim());
}

@Override
public List<Modulo> listarModulosDeProfesor(String profesorId) {
    if (profesorId == null || profesorId.isBlank()) return List.of();
    return xmlRepository.findAllModulos().stream()
        .filter(m -> m.getProfesorId().equals(profesorId.trim()))
        .collect(Collectors.toList());
}

@Override
public Evaluacion registrarEvaluacion(String alumno, String moduloId, double nota) {
    if (alumno == null || alumno.isBlank()) return null;
    if (moduloId == null || moduloId.isBlank()) return null;
    if (nota < 0 || nota > 10) return null;
    String aLimpio = alumno.trim();
    String mLimpio = moduloId.trim();
    if (xmlRepository.findModuloById(mLimpio) == null) return null;
    Evaluacion evaluacion = new Evaluacion(aLimpio, mLimpio, nota);
    jsonRepository.saveEvaluacion(evaluacion);
    return evaluacion;
}

@Override
public List<Evaluacion> listarEvaluacionesDeModulo(String moduloId) {
    return jsonRepository.findEvaluacionesByModuloId(moduloId.trim());
}

@Override
public double calcularMediaDeModulo(String moduloId) {
    List<Evaluacion> evals = jsonRepository.findEvaluacionesByModuloId(moduloId.trim());
    return evals.stream().mapToDouble(Evaluacion::getNota).average().orElse(0.0);
}

@Override
public double calcularMediaDeProfesor(String profesorId) {
    return listarModulosDeProfesor(profesorId).stream()
        .flatMap(m -> jsonRepository.findEvaluacionesByModuloId(m.getId()).stream())
        .mapToDouble(Evaluacion::getNota)
        .average().orElse(0.0);
}

@Override
public Incidencia registrarIncidencia(String profesorId, String descripcion, String fecha) {
    if (xmlRepository.findProfesorById(profesorId.trim()) == null) return null;
    Incidencia incidencia = new Incidencia(profesorId.trim(), descripcion, fecha);
    jsonRepository.saveIncidencia(incidencia);
    return incidencia;
}

@Override
public List<Incidencia> listarIncidenciasDeProfesor(String profesorId) {
    return jsonRepository.findIncidenciasByProfesorId(profesorId.trim());
}
```

---

## Flujo completo de una operación de ejemplo

Para que veas cómo fluye todo de punta a punta, aquí está lo que ocurre cuando el usuario elige "registrar evaluación" con alumno="Sofía", módulo="M01", nota=9.25:

```
Main.registrarEvaluacion()
  └─► service.registrarEvaluacion("Sofía", "M01", 9.25)
        ├─► valida: alumno no blank ✓, moduloId no blank ✓, nota 0-10 ✓
        ├─► xmlRepository.findModuloById("M01")   ← consulta en RAM (cargado desde XML al inicio)
        │     └─► new Modulo("M01") → indexOf → devuelve Modulo{M01, Programación, P01} ✓
        ├─► crea new Evaluacion("Sofía", "M01", 9.25)
        └─► jsonRepository.saveEvaluacion(evaluacion)
              ├─► indexOf(evaluacion) → busca por (alumno+moduloId) → no encontrado → add()
              └─► persistir() → jsonManager.write(path, new EstadoCentro(...)) → escribe en disco
  └─► Main imprime la evaluación registrada
```

La separación de responsabilidades hace que cada capa solo sepa lo mínimo necesario: `Main` no sabe nada de XML ni JSON, `Service` no sabe cómo se serializa nada, los `Repository` no saben nada de lógica de negocio, y los `Manager` no saben nada de nada salvo convertir entre objetos y bytes.