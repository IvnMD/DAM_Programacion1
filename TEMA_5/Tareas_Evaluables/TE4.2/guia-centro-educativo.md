# 📚 Guía Completa: Gestión de Personas de un Centro Educativo en Java

> **Para quién es esta guía:** Estudiantes de Java que están implementando la práctica de gestión de un centro educativo. Cubre desde los fundamentos técnicos hasta el código concreto que necesitas.

---

## 📋 Índice

1. [Estructura general del proyecto](#estructura)
2. [Clases y Herencia (Persona → Alumno/Profesor)](#herencia)
3. [Clases Abstractas](#abstractas)
4. [Encapsulación: getters, setters y validaciones](#encapsulacion)
5. [Dónde colocar las validaciones](#validaciones-donde)
6. [RegEx: cómo funciona y cómo usarlo](#regex)
7. [Fechas con java.time (LocalDate, Period)](#fechas)
8. [Colecciones: ArrayList, Set y HashSet](#colecciones)
9. [El método equals() y por qué importa](#equals)
10. [Llamar métodos entre clases](#llamar-metodos)
11. [Recursividad: buscarPorPrefijo](#recursividad)
12. [La clase CentroEducativo (servicio)](#centro)
13. [IllegalArgumentException: cuándo y cómo lanzarla](#excepciones)
14. [El menú principal (Main)](#main)
15. [Orden recomendado de implementación](#orden)
16. [Errores comunes a evitar](#errores)

---

## 1. 🗂️ Estructura general del proyecto {#estructura}

Antes de escribir una sola línea de código, organiza tu proyecto en paquetes. Los paquetes en Java son simplemente carpetas que agrupan clases relacionadas.

```
src/
├── com/docencia/app/
│   └── Main.java                  ← Menú y punto de entrada
├── com/docencia/model/
│   ├── Persona.java               ← Clase abstracta base
│   ├── Alumno.java                ← Subclase de Persona
│   └── Profesor.java              ← Subclase de Persona
├── com/docencia/service/
│   └── CentroEducativo.java       ← Gestiona la colección de personas
└── com/docencia/util/
    └── Validaciones.java          ← Métodos estáticos de validación RegEx
```

**¿Por qué esta estructura?**
- `model` → contiene los "datos" (las entidades del mundo real)
- `service` → contiene la "lógica de negocio" (qué se puede hacer con esos datos)
- `util` → herramientas reutilizables sin estado propio
- `app` → el punto de entrada del programa

---

## 2. 🧬 Clases y Herencia: Persona → Alumno / Profesor {#herencia}

### ¿Qué es la herencia?

La herencia permite que una clase **hija** reutilice el código de una clase **padre** y además añada o modifique comportamiento propio.

```
Persona  (padre / superclase)
   ├── Alumno   (hijo / subclase)
   └── Profesor (hijo / subclase)
```

Tanto `Alumno` como `Profesor` **son** `Persona`. Comparten atributos comunes (nombre, documento, email, fechas) pero cada uno añade los suyos propios (curso en Alumno, departamento en Profesor).

### Cómo se declara la herencia en Java

```java
// Clase padre
public abstract class Persona {
    private final int id;
    private String nombre;
    // ... más atributos
}

// Clase hija: "extends" indica herencia
public class Alumno extends Persona {
    private String curso;
    // Alumno hereda TODOS los atributos y métodos de Persona
}

public class Profesor extends Persona {
    private String departamento;
}
```

La palabra clave `extends` es todo lo que necesitas para establecer la herencia.

### El constructor en clases hijas: super()

Cuando creas un `Alumno`, Java necesita que el constructor de `Persona` también se ejecute (para inicializar `id`, `nombre`, etc.). Para eso usas `super()`:

```java
public class Alumno extends Persona {
    private String curso;

    public Alumno(int id, String nombre, String documento, String email,
                  LocalDate fechaNacimiento, LocalDate fechaRegistro, String curso) {
        
        // OBLIGATORIO: llamar al constructor del padre PRIMERO
        // super() debe ser siempre la PRIMERA línea del constructor
        super(id, nombre, documento, email, fechaNacimiento, fechaRegistro);
        
        // Ahora validamos y asignamos los atributos PROPIOS de Alumno
        if (curso == null || curso.trim().length() <= 3) {
            throw new IllegalArgumentException("El curso debe tener más de 3 caracteres.");
        }
        this.curso = curso.trim();
    }
}
```

**⚠️ Regla de oro:** `super(...)` debe ser **siempre la primera instrucción** del constructor de la clase hija. Si no lo pones, Java intentará llamar al constructor vacío `super()` automáticamente, y si el padre no tiene uno, el compilador dará error.

### ¿Qué hereda y qué no?

| Se hereda | No se hereda |
|-----------|-------------|
| Métodos `public` y `protected` | Constructores (deben llamarse con `super()`) |
| Atributos `public` y `protected` | Métodos y atributos `private` del padre |
| Comportamiento de `toString()`, `getEdad()`, etc. | |

Los atributos `private` de `Persona` (como `nombre`) NO son accesibles directamente desde `Alumno`. Solo se accede a ellos a través de los **getters y setters** que `Persona` proporciona.

---

## 3. 🔷 Clases Abstractas {#abstractas}

### ¿Qué es una clase abstracta?

Una clase abstracta es una clase que **no puede ser instanciada directamente**. Existe para ser extendida. Es como un "molde" incompleto que las subclases completan.

```java
// NO puedes hacer esto:
Persona p = new Persona(...); // ❌ ERROR de compilación

// Sí puedes hacer esto:
Persona p = new Alumno(...);  // ✅ Alumno es una Persona
Persona p = new Profesor(...); // ✅ Profesor es una Persona
```

### Métodos abstractos

Un método abstracto es aquel que **se declara pero no se implementa** en la clase padre. Obliga a todas las subclases a implementarlo.

```java
public abstract class Persona {
    // Método abstracto: solo firma, sin cuerpo
    public abstract String getTipo();
    
    // Método concreto: tiene implementación
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
```

```java
// Alumno DEBE implementar getTipo()
public class Alumno extends Persona {
    @Override
    public String getTipo() {
        return "ALUMNO";
    }
}

// Profesor DEBE implementar getTipo()
public class Profesor extends Persona {
    @Override
    public String getTipo() {
        return "PROFESOR";
    }
}
```

La anotación `@Override` no es obligatoria pero es **muy recomendable** porque:
- Le dice al compilador "estoy sobreescribiendo un método del padre"
- Si cometes un error de nombre (ej: `getTipe()` en lugar de `getTipo()`), el compilador te avisará

---

## 4. 🔒 Encapsulación: getters, setters y validaciones {#encapsulacion}

La encapsulación significa que los atributos son `private` (nadie los toca desde fuera) y solo se accede a ellos a través de métodos controlados.

### Estructura básica de Persona

```java
public abstract class Persona {

    // Atributos privados - nadie los ve desde fuera
    private final int id;           // final = no cambia nunca
    private String nombre;
    private String documento;
    private String email;
    private LocalDate fechaNacimiento;
    private final LocalDate fechaRegistro; // final = no cambia nunca

    // Constructor completo
    public Persona(int id, String nombre, String documento, String email,
                   LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        
        // Validar cada parámetro antes de asignarlo
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que 0. Recibido: " + id);
        }
        if (nombre == null || nombre.trim().length() < 2) {
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres.");
        }
        if (!Validaciones.documentoValido(documento)) {
            throw new IllegalArgumentException("Documento inválido: " + documento);
        }
        if (!Validaciones.emailValido(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        if (fechaNacimiento == null || !fechaNacimiento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser anterior a hoy.");
        }
        if (fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de registro no puede ser futura.");
        }
        
        // Normalización y asignación
        this.id = id;
        this.nombre = nombre.trim();
        this.documento = documento.trim().toUpperCase();
        this.email = email.trim();
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    // Constructor simplificado: solo id (para testing o construcción incremental)
    public Persona(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor que 0.");
        }
        this.id = id;
        this.fechaRegistro = LocalDate.now(); // Se fija automáticamente
    }

    // ===== GETTERS =====
    public final int getId() { return id; }          // final: nadie puede sobrescribir getId()
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getEmail() { return email; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public final LocalDate getFechaRegistro() { return fechaRegistro; }

    // ===== SETTERS CON VALIDACIÓN =====
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 2) {
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres.");
        }
        this.nombre = nombre.trim();
    }

    public void setDocumento(String documento) {
        if (!Validaciones.documentoValido(documento)) {
            throw new IllegalArgumentException("Documento inválido: " + documento);
        }
        this.documento = documento.trim().toUpperCase();
    }

    public void setEmail(String email) {
        if (!Validaciones.emailValido(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        this.email = email.trim();
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null || !fechaNacimiento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser anterior a hoy.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    // ===== MÉTODOS CONCRETOS =====
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // ===== MÉTODO ABSTRACTO =====
    public abstract String getTipo();

    // ===== toString =====
    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Nombre: %s | Doc: %s | Email: %s | Nacimiento: %s | Registro: %s | Edad: %d",
            getTipo(), id, nombre, documento, email, fechaNacimiento, fechaRegistro, getEdad());
    }
}
```

---

## 5. 📍 ¿Dónde colocar las validaciones? {#validaciones-donde}

Esta es una pregunta muy importante. Sigue esta regla:

### Regla: validar en el constructor Y en los setters

**En el constructor:** Validas todo antes de crear el objeto. Si algo falla, el objeto nunca se crea.

**En los setters:** Validas antes de modificar el valor. Si algo falla, el objeto mantiene el valor anterior.

**Nunca validar en los getters.** Los getters solo devuelven el valor.

```
¿Cuándo valido?
    │
    ├─ Al CREAR el objeto ────────── En el constructor
    └─ Al MODIFICAR un atributo ──── En el setter
```

### La clase Validaciones: métodos estáticos

Los métodos de validación son `static` porque no necesitan estado propio (no pertenecen a un objeto concreto, son herramientas generales).

```java
package com.docencia.util;

import java.util.regex.Pattern;

public class Validaciones {

    // Constantes: compilar el patrón UNA vez es más eficiente
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    
    private static final Pattern DOCUMENTO_PATTERN = 
        Pattern.compile("^[0-9]{8}[A-Za-z]$");

    // static: se llama con Validaciones.emailValido(email), sin crear objeto
    public static boolean emailValido(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean documentoValido(String documento) {
        if (documento == null) return false;
        return DOCUMENTO_PATTERN.matcher(documento.trim().toUpperCase()).matches();
    }
}
```

### Cómo llamar a estos métodos desde Persona

```java
// Desde cualquier clase, sin necesidad de crear objeto Validaciones
if (!Validaciones.emailValido(email)) {
    throw new IllegalArgumentException("Email inválido");
}
```

---

## 6. 🔍 RegEx: cómo funciona {#regex}

Las expresiones regulares (RegEx) son patrones para validar cadenas de texto.

### Anatomía de un patrón RegEx

```
^[0-9]{8}[A-Za-z]$
│  │      │  │    │
│  │      │  │    └── $ = fin de la cadena
│  │      │  └─────── Un carácter letra (mayús o minús)
│  │      └────────── {8} = exactamente 8 veces lo anterior
│  └───────────────── [0-9] = cualquier dígito del 0 al 9
└──────────────────── ^ = inicio de la cadena
```

### Patrones útiles para este proyecto

**Email:**
```java
"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
//  ─────────────── usuario válido
//                  @ 
//                    ──────────────── dominio válido
//                                   \\. punto literal (necesita escape)
//                                      ──────── extensión de 2+ letras
```

**Nota:** En Java, dentro de un String, la barra invertida se escapa: `\\.` en código Java = `\.` en RegEx real = "un punto literal" (sin el escape, `.` en RegEx significa "cualquier carácter").

**DNI español:**
```java
"^[0-9]{8}[A-HJ-NP-TV-Z]$"  // Versión estricta con letras válidas de DNI
// o simplificado:
"^\\d{8}[A-Za-z]$"           // \\d = dígito, equivale a [0-9]
```

### Cómo usar Pattern y Matcher

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Opción 1: Una sola línea (más simple, menos eficiente si se llama muchas veces)
boolean valido = "12345678A".matches("^\\d{8}[A-Za-z]$");

// Opción 2: Pattern compilado (más eficiente, recomendado)
Pattern patron = Pattern.compile("^\\d{8}[A-Za-z]$");
Matcher matcher = patron.matcher("12345678A");
boolean valido = matcher.matches();
```

Compila el `Pattern` una sola vez (como constante de clase) y reutilízalo para cada validación.

---

## 7. 📅 Fechas con java.time {#fechas}

### LocalDate: la clase principal

`LocalDate` representa una fecha (día, mes, año) sin hora ni zona horaria.

```java
import java.time.LocalDate;
import java.time.Period;

// Obtener la fecha actual
LocalDate hoy = LocalDate.now();

// Crear una fecha específica
LocalDate nacimiento = LocalDate.of(2000, 3, 15); // 15 de marzo del 2000

// Comparaciones
nacimiento.isBefore(hoy);  // ¿Es nacimiento anterior a hoy? → true
nacimiento.isAfter(hoy);   // ¿Es nacimiento posterior a hoy? → false
nacimiento.isEqual(hoy);   // ¿Son la misma fecha?

// Calcular edad con Period
Period periodo = Period.between(nacimiento, hoy);
int años = periodo.getYears();   // Años cumplidos
int meses = periodo.getMonths(); // Meses del año actual
int dias = periodo.getDays();    // Días del mes actual
```

### Implementar getEdad() en Persona

```java
public int getEdad() {
    if (fechaNacimiento == null) return 0;
    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
}
```

`Period.between(inicio, fin).getYears()` calcula correctamente los años cumplidos, teniendo en cuenta si el cumpleaños de este año ya pasó o no.

### Validaciones de fecha

```java
// ¿La fecha de nacimiento es válida? (debe ser en el pasado)
if (fechaNacimiento == null || !fechaNacimiento.isBefore(LocalDate.now())) {
    throw new IllegalArgumentException("La fecha de nacimiento debe ser anterior a hoy.");
}

// ¿La fecha de registro es válida? (puede ser hoy o antes, no en el futuro)
if (fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())) {
    throw new IllegalArgumentException("La fecha de registro no puede ser futura.");
}
```

---

## 8. 📦 Colecciones: ArrayList, Set y HashSet {#colecciones}

### ArrayList: lista ordenada con duplicados permitidos

```java
import java.util.ArrayList;
import java.util.List;

List<Persona> personas = new ArrayList<>();

// Añadir
personas.add(alumno);

// Obtener por índice
Persona p = personas.get(0);

// Tamaño
int total = personas.size();

// Recorrer (for-each)
for (Persona persona : personas) {
    System.out.println(persona);
}

// Eliminar
personas.remove(0);        // por índice
personas.remove(alumno);   // por objeto (usa equals())

// Buscar (devuelve índice o -1)
int indice = personas.indexOf(alumno);

// Contiene
boolean existe = personas.contains(alumno);
```

### Set (HashSet): sin duplicados, sin orden

```java
import java.util.HashSet;
import java.util.Set;

Set<String> documentosRegistrados = new HashSet<>();
Set<String> emailsRegistrados = new HashSet<>();

// add() devuelve true si se añadió, false si ya existía
boolean añadido = documentosRegistrados.add("12345678A"); // true
boolean añadido2 = documentosRegistrados.add("12345678A"); // false (duplicado)

// Comprobar si existe
boolean existe = documentosRegistrados.contains("12345678A");

// Eliminar
documentosRegistrados.remove("12345678A");
```

**¿Por qué usar Set para documentos y emails?**
La búsqueda `contains()` en un `HashSet` es O(1) (prácticamente instantánea), mientras que buscar en un `ArrayList` es O(n) (recorre toda la lista). Para controlar duplicados, el `Set` es mucho más eficiente.

### Set de módulos en Alumno

```java
public class Alumno extends Persona {
    private String curso;
    private Set<String> modulos = new HashSet<>();  // Inicializado aquí

    public boolean addModulo(String modulo) {
        if (modulo == null || modulo.trim().length() <= 2) {
            return false; // No añade si es inválido
        }
        return modulos.add(modulo.trim()); // add() ya devuelve true/false
    }

    public boolean removeModulo(String modulo) {
        if (modulo == null) return false;
        return modulos.remove(modulo.trim());
    }

    public Set<String> getModulos() {
        return new HashSet<>(modulos); // Devuelve copia para proteger el original
    }

    // Para mostrar módulos separados por comas
    public String getModulosComoString() {
        return String.join(", ", modulos);
    }
}
```

---

## 9. ⚖️ El método equals() y por qué importa {#equals}

`equals()` determina si dos objetos son "iguales" según el criterio que tú definas.

### El problema sin equals()

```java
Persona p1 = new Alumno(1, "Ana García", ...);
Persona p2 = new Alumno(1, "Ana García", ...);

p1 == p2               // false: son objetos distintos en memoria
p1.equals(p2)          // false por defecto: Object.equals() compara referencias
```

Java por defecto compara si los dos objetos son **el mismo objeto en memoria**, no si tienen los mismos datos.

### Implementar equals() en Persona

Para este proyecto, dos personas son iguales si tienen el mismo `id` (o el mismo `documento`, dependiendo de lo que necesites):

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;                    // Mismo objeto
    if (obj == null) return false;                   // Nulo no es igual
    if (!(obj instanceof Persona)) return false;     // Diferente tipo
    Persona otra = (Persona) obj;
    return this.id == otra.id;                       // Compara por id
}

@Override
public int hashCode() {
    return Integer.hashCode(id); // Obligatorio si sobreescribes equals()
}
```

**Regla importante:** Si sobreescribes `equals()`, **también debes sobreescribir `hashCode()`**. Los `HashSet` y `HashMap` usan `hashCode()` para organizar internamente los objetos. Si los hash no son consistentes con `equals()`, el Set puede comportarse de forma incorrecta.

### Comparar Strings: nunca uses ==

```java
String a = "ALUMNO";
String b = "ALUMNO";

a == b        // Puede ser false (depende de cómo se crearon)
a.equals(b)   // Siempre correcto: true

// Para ignorar mayúsculas/minúsculas:
a.equalsIgnoreCase(b)  // true aunque sean "alumno" y "ALUMNO"
```

---

## 10. 📞 Llamar métodos entre clases {#llamar-metodos}

### Desde CentroEducativo, llamar a métodos de Persona

```java
public class CentroEducativo {
    private List<Persona> personas = new ArrayList<>();

    public Persona buscarPorId(int id) {
        for (Persona p : personas) {
            // Llamamos al método getId() que pertenece a Persona
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void mostrarTodas() {
        for (Persona p : personas) {
            // toString() se llama implícitamente con println()
            System.out.println(p);
            
            // O explícitamente:
            System.out.println(p.toString());
            
            // Llamamos métodos concretos de Persona
            System.out.println("Tipo: " + p.getTipo());
            System.out.println("Edad: " + p.getEdad());
        }
    }
}
```

### Polimorfismo: cuando la lista contiene Alumnos Y Profesores

```java
List<Persona> personas = new ArrayList<>();
personas.add(new Alumno(...));   // Alumno guardado como Persona
personas.add(new Profesor(...)); // Profesor guardado como Persona

for (Persona p : personas) {
    System.out.println(p.getTipo()); // Llama a Alumno.getTipo() o Profesor.getTipo()
                                     // automáticamente según el tipo real del objeto
}
```

Esto se llama **polimorfismo**: el mismo código (`p.getTipo()`) se comporta diferente según el tipo real del objeto. Java sabe en tiempo de ejecución si `p` es un `Alumno` o un `Profesor` y llama al método correcto.

### Acceder a métodos específicos de Alumno desde una lista de Persona

```java
for (Persona p : personas) {
    // Para acceder a getCurso() necesitas hacer un "cast"
    if (p instanceof Alumno) {
        Alumno alumno = (Alumno) p;        // Cast: "trato p como Alumno"
        String curso = alumno.getCurso(); // Ahora sí puedes llamar getCurso()
    }
}
```

### Listar solo alumnos o solo profesores

```java
public List<Alumno> listarAlumnos() {
    List<Alumno> resultado = new ArrayList<>();
    for (Persona p : personas) {
        if (p instanceof Alumno) {
            resultado.add((Alumno) p);
        }
    }
    return resultado;
}

public List<Profesor> listarProfesores() {
    List<Profesor> resultado = new ArrayList<>();
    for (Persona p : personas) {
        if (p instanceof Profesor) {
            resultado.add((Profesor) p);
        }
    }
    return resultado;
}
```

---

## 11. 🔄 Recursividad: buscarPorPrefijo {#recursividad}

La recursividad es cuando un método **se llama a sí mismo**. Es especialmente útil para recorrer listas sin usar bucles.

### Estructura de un método recursivo

Todo método recursivo necesita:
1. **Caso base:** la condición que detiene la recursión
2. **Caso recursivo:** la llamada a sí mismo con un valor "más pequeño"

### Implementación de buscarPorPrefijo

```java
// Método público (punto de entrada)
public List<Persona> buscarPorPrefijo(String prefijo) {
    if (prefijo == null || prefijo.trim().isEmpty() || prefijo.trim().length() < 2) {
        throw new IllegalArgumentException("El prefijo debe tener al menos 2 caracteres.");
    }
    ArrayList<Persona> resultado = new ArrayList<>();
    buscarRec(0, prefijo.trim().toLowerCase(), resultado); // Empieza desde índice 0
    return resultado;
}

// Método auxiliar privado (la recursión real)
private void buscarRec(int index, String prefijo, ArrayList<Persona> resultado) {
    // CASO BASE: hemos llegado al final de la lista → paramos
    if (index >= personas.size()) {
        return;
    }
    
    // Evaluamos la persona en la posición "index"
    Persona p = personas.get(index);
    if (p.getNombre().toLowerCase().startsWith(prefijo)) {
        resultado.add(p);
    }
    
    // CASO RECURSIVO: avanzamos al siguiente índice
    buscarRec(index + 1, prefijo, resultado);
}
```

### ¿Cómo funciona paso a paso?

Supongamos que hay 3 personas: Ana, Alberto, Carlos. Buscamos prefijo "al".

```
buscarRec(0, "al", [])
  → "ana".startsWith("al")? NO
  → llama buscarRec(1, "al", [])
      → "alberto".startsWith("al")? SÍ → añade Alberto
      → llama buscarRec(2, "al", [Alberto])
          → "carlos".startsWith("al")? NO
          → llama buscarRec(3, "al", [Alberto])
              → 3 >= 3 (tamaño) → CASO BASE → return
          ← vuelve a buscarRec(2)
      ← vuelve a buscarRec(1)
  ← vuelve a buscarRec(0)
Resultado: [Alberto]
```

---

## 12. 🏫 La clase CentroEducativo {#centro}

```java
package com.docencia.service;

import com.docencia.model.*;
import java.util.*;

public class CentroEducativo {

    private List<Persona> personas;
    private Set<String> documentosRegistrados;
    private Set<String> emailsRegistrados;

    public CentroEducativo() {
        personas = new ArrayList<>();
        documentosRegistrados = new HashSet<>();
        emailsRegistrados = new HashSet<>();
    }

    public void registrarPersona(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula.");
        }
        
        // Verificar id duplicado
        if (buscarPorId(persona.getId()) != null) {
            throw new IllegalArgumentException("Ya existe una persona con id: " + persona.getId());
        }
        
        // Verificar documento duplicado
        if (documentosRegistrados.contains(persona.getDocumento())) {
            throw new IllegalArgumentException("Ya existe una persona con documento: " + persona.getDocumento());
        }
        
        // Verificar email duplicado
        if (emailsRegistrados.contains(persona.getEmail())) {
            throw new IllegalArgumentException("Ya existe una persona con email: " + persona.getEmail());
        }
        
        personas.add(persona);
        documentosRegistrados.add(persona.getDocumento());
        emailsRegistrados.add(persona.getEmail());
    }

    public List<Persona> listarPersonas() {
        return new ArrayList<>(personas); // Devuelve copia
    }

    public Persona buscarPorId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El id debe ser > 0");
        for (Persona p : personas) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Persona buscarPorDocumento(String documento) {
        if (documento == null) throw new IllegalArgumentException("El documento no puede ser nulo");
        String docNorm = documento.trim().toUpperCase();
        for (Persona p : personas) {
            if (p.getDocumento().equals(docNorm)) return p;
        }
        return null;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> resultado = new ArrayList<>();
        for (Persona p : personas) {
            if (p instanceof Alumno) resultado.add((Alumno) p);
        }
        return resultado;
    }

    public List<Profesor> listarProfesores() {
        List<Profesor> resultado = new ArrayList<>();
        for (Persona p : personas) {
            if (p instanceof Profesor) resultado.add((Profesor) p);
        }
        return resultado;
    }

    public List<Persona> buscarPorPrefijo(String prefijo) {
        if (prefijo == null || prefijo.trim().length() < 2) {
            throw new IllegalArgumentException("El prefijo debe tener al menos 2 caracteres.");
        }
        ArrayList<Persona> resultado = new ArrayList<>();
        buscarRec(0, prefijo.trim().toLowerCase(), resultado);
        return resultado;
    }

    private void buscarRec(int index, String prefijo, ArrayList<Persona> resultado) {
        if (index >= personas.size()) return;
        Persona p = personas.get(index);
        if (p.getNombre().toLowerCase().startsWith(prefijo)) {
            resultado.add(p);
        }
        buscarRec(index + 1, prefijo, resultado);
    }
    
    // Listar personas mayores de X años
    public List<Persona> listarMayoresDe(int edad) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona p : personas) {
            if (p.getEdad() >= edad) resultado.add(p);
        }
        return resultado;
    }
}
```

---

## 13. 🚨 IllegalArgumentException: cuándo y cómo lanzarla {#excepciones}

`IllegalArgumentException` es una excepción en tiempo de ejecución que se lanza cuando un argumento pasado a un método es inválido.

### Cómo lanzarla

```java
throw new IllegalArgumentException("Mensaje descriptivo del error");
```

El mensaje debe explicar **qué falló** y si es posible **qué se recibió**:

```java
// ❌ Mensaje vago
throw new IllegalArgumentException("Error en el id");

// ✅ Mensaje claro y con contexto
throw new IllegalArgumentException("El id debe ser mayor que 0. Recibido: " + id);
```

### Dónde lanzarla

```java
// En el constructor
public Persona(int id, ...) {
    if (id <= 0) throw new IllegalArgumentException("Id inválido: " + id);
    // ...
}

// En los setters
public void setNombre(String nombre) {
    if (nombre == null || nombre.trim().length() < 2)
        throw new IllegalArgumentException("Nombre demasiado corto: " + nombre);
    this.nombre = nombre.trim();
}

// En métodos de servicio
public void registrarPersona(Persona persona) {
    if (persona == null) throw new IllegalArgumentException("La persona no puede ser nula");
    // ...
}
```

### Cómo capturarla en el menú

En `Main.java`, cuando llames a métodos que puedan lanzar esta excepción, usa `try-catch`:

```java
try {
    Alumno a = new Alumno(id, nombre, documento, email, fechaNacimiento, fechaRegistro, curso);
    centro.registrarPersona(a);
    System.out.println("✅ Alumno registrado correctamente.");
} catch (IllegalArgumentException e) {
    System.out.println("❌ Error: " + e.getMessage());
    // Aquí puedes volver a pedir los datos al usuario
}
```

---

## 14. 💻 El menú principal (Main) {#main}

```java
package com.docencia.app;

import com.docencia.model.*;
import com.docencia.service.CentroEducativo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.List;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final CentroEducativo centro = new CentroEducativo();
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEnteroConValidacion("Opción: ", 1, 7);
            switch (opcion) {
                case 1 -> registrarAlumno();
                case 2 -> registrarProfesor();
                case 3 -> listarPersonas();
                case 4 -> buscarPorId();
                case 5 -> buscarPorPrefijo();
                case 6 -> listarMayoresDe();
                case 7 -> System.out.println("¡Hasta pronto!");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n========= CENTRO EDUCATIVO =========");
        System.out.println("1. Registrar alumno");
        System.out.println("2. Registrar profesor");
        System.out.println("3. Listar personas");
        System.out.println("4. Buscar por id");
        System.out.println("5. Buscar por prefijo (recursivo)");
        System.out.println("6. Listar mayores de X años");
        System.out.println("7. Salir");
        System.out.println("====================================");
    }

    private static void registrarAlumno() {
        System.out.println("\n--- REGISTRAR ALUMNO ---");
        try {
            int id = leerEnteroConValidacion("ID: ", 1, Integer.MAX_VALUE);
            String nombre = leerTextoConValidacion("Nombre: ", 2);
            String documento = leerTextoConValidacion("Documento (DNI): ", 1);
            String email = leerTextoConValidacion("Email: ", 1);
            LocalDate fechaNac = leerFecha("Fecha de nacimiento (dd/MM/yyyy): ");
            String curso = leerTextoConValidacion("Curso: ", 4);

            Alumno alumno = new Alumno(id, nombre, documento, email,
                    fechaNac, LocalDate.now(), curso);
            centro.registrarPersona(alumno);
            System.out.println("✅ Alumno registrado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error al registrar: " + e.getMessage());
        }
    }

    // Método auxiliar: lee un entero en un rango dado, repite si es inválido
    private static int leerEnteroConValidacion(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                if (valor >= min && valor <= max) return valor;
                System.out.println("Por favor, introduce un número entre " + min + " y " + max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número entero.");
            }
        }
    }

    // Método auxiliar: lee texto con longitud mínima
    private static String leerTextoConValidacion(String mensaje, int longitudMinima) {
        while (true) {
            System.out.print(mensaje);
            String valor = sc.nextLine().trim();
            if (valor.length() >= longitudMinima) return valor;
            System.out.println("El texto debe tener al menos " + longitudMinima + " caracteres.");
        }
    }

    // Método auxiliar: lee una fecha en formato dd/MM/yyyy
    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return LocalDate.parse(sc.nextLine().trim(), FORMATO_FECHA);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Usa dd/MM/yyyy (ej: 15/03/2000)");
            }
        }
    }
    
    private static void listarPersonas() {
        List<Persona> lista = centro.listarPersonas();
        if (lista.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }
        System.out.println("\n--- LISTADO DE PERSONAS ---");
        for (Persona p : lista) {
            System.out.println(p);
        }
        System.out.println("Total: " + lista.size());
    }
    
    private static void buscarPorPrefijo() {
        String prefijo = leerTextoConValidacion("Introduce prefijo del nombre (mín. 2 letras): ", 2);
        try {
            List<Persona> resultado = centro.buscarPorPrefijo(prefijo);
            if (resultado.isEmpty()) {
                System.out.println("No se encontraron personas con ese prefijo.");
            } else {
                resultado.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
```

---

## 15. 📐 Orden recomendado de implementación {#orden}

Sigue este orden para no bloquearte:

```
Paso 1:  Validaciones.java
         └── emailValido() y documentoValido() con RegEx
         └── Prueba las validaciones con un main de prueba

Paso 2:  Persona.java (abstracta)
         └── Atributos, constructores con validaciones
         └── Getters, setters con validaciones
         └── getEdad() con Period
         └── toString()
         └── Declara getTipo() como abstracto

Paso 3:  Alumno.java
         └── Extiende Persona
         └── Añade campo curso y su validación
         └── Añade Set<String> modulos
         └── Implementa addModulo, removeModulo, getModulos
         └── getTipo() → "ALUMNO"
         └── @Override toString() añadiendo curso y módulos

Paso 4:  Profesor.java
         └── Extiende Persona
         └── Añade departamento y su validación
         └── getTipo() → "PROFESOR"
         └── @Override toString()

Paso 5:  CentroEducativo.java
         └── Lista de personas + Sets de documentos y emails
         └── registrarPersona() con todas las validaciones
         └── buscarPorId(), buscarPorDocumento()
         └── listarAlumnos(), listarProfesores()
         └── buscarPorPrefijo() con recursividad

Paso 6:  Main.java
         └── Menú principal con Scanner
         └── Métodos auxiliares de lectura validada
         └── Casos del switch para cada opción
```

---

## 16. ⚠️ Errores comunes a evitar {#errores}

### Error 1: NullPointerException al comparar Strings

```java
// ❌ Peligroso: si documento es null, lanza NullPointerException
if (documento.equals("12345678A")) { ... }

// ✅ Seguro: si documento es null, simplemente devuelve false
if ("12345678A".equals(documento)) { ... }

// ✅ También seguro: comprobar null primero
if (documento != null && documento.equals("12345678A")) { ... }
```

### Error 2: Modificar la lista original cuando devuelves una copia

```java
// ❌ Devuelve referencia directa: quien la reciba puede modificar tu lista interna
public List<Persona> listarPersonas() {
    return personas;
}

// ✅ Devuelve copia: tu lista interna está protegida
public List<Persona> listarPersonas() {
    return new ArrayList<>(personas);
}
```

### Error 3: Olvidar normalizar antes de comparar

```java
// Si guardaste "12345678A" pero el usuario escribe " 12345678a ", no lo encontrará
public Persona buscarPorDocumento(String documento) {
    String docNorm = documento.trim().toUpperCase(); // ← normaliza SIEMPRE
    for (Persona p : personas) {
        if (p.getDocumento().equals(docNorm)) return p;
    }
    return null;
}
```

### Error 4: super() no es la primera línea

```java
// ❌ Error de compilación
public Alumno(int id, ..., String curso) {
    this.curso = curso; // ← no puedes hacer esto antes de super()
    super(id, ...);
}

// ✅ Correcto
public Alumno(int id, ..., String curso) {
    super(id, ...);    // ← SIEMPRE primero
    this.curso = curso;
}
```

### Error 5: Usar == para comparar Strings

```java
String a = new String("ALUMNO");
String b = new String("ALUMNO");

a == b         // false (diferentes objetos en memoria)
a.equals(b)    // true (mismo contenido) ← usa SIEMPRE equals() para Strings
```

### Error 6: No llamar super.toString() en la subclase

```java
// En Alumno.toString(), incluye la información del padre:
@Override
public String toString() {
    return super.toString() + " | Curso: " + curso + " | Módulos: " + getModulosComoString();
}
```

---

## 🎯 Resumen de conceptos clave

| Concepto | Palabra clave / Método | Dónde se usa |
|----------|----------------------|--------------|
| Herencia | `extends` | `Alumno extends Persona` |
| Clase abstracta | `abstract` | `public abstract class Persona` |
| Método abstracto | `abstract` en firma | `public abstract String getTipo()` |
| Llamar constructor padre | `super(...)` | Primera línea del constructor hijo |
| Sobreescribir método | `@Override` | `getTipo()`, `toString()` |
| Detectar tipo real | `instanceof` | `if (p instanceof Alumno)` |
| Convertir tipo | cast | `(Alumno) p` |
| Sin duplicados | `HashSet` | Documentos y emails registrados |
| Validación texto | `Pattern.compile()` | Clase `Validaciones` |
| Fecha actual | `LocalDate.now()` | Validaciones y fechaRegistro |
| Calcular edad | `Period.between().getYears()` | `getEdad()` en Persona |
| Error de argumento | `throw new IllegalArgumentException()` | Constructores y setters |

---

*Guía elaborada para la práctica de Gestión de Personas de un Centro Educativo · Java SE 8+*
