<div align="justify">

# Examen de Recuperación — CentroPlus

<div align="center">
    <img src="img/centroplus.png" width=400>
</div>

## Descripción general

El examen está diseñado para evaluar:

- Persistencia en ficheros CSV.
- Persistencia en bases de datos SQLite3.
- Arquitectura por capas.
- Uso de interfaces y repositorios.
- Servicios con lógica de negocio.
- Calidad documental mediante JavaDoc.

El proyecto está dividido en dos grandes bloques:

| Bloque | Tecnología | Peso |
|---|---|---:|
| Ficheros | CSV | 4 puntos |
| BBDD | SQLite3 | 6 puntos |

---

# Arquitectura del proyecto

El proyecto sigue una arquitectura en capas:

```text
models
repositories
services
```

## Modelos

Representan las entidades del sistema:

- `Actividad`
- `Usuario`
- `Inscripcion`

---

## Parte CSV (Ficheros)

### Objetivo

El alumno debe implementar la persistencia mediante un único fichero CSV:

```text
actividades.csv
```

### Repositorio CSV

El alumno implementa:

```java
ActividadCsvRepository
```

Implementando la interfaz:

```java
ActividadRepository
```

### Operaciones obligatorias

```java
findAll()
findById(int id)
save(Actividad actividad)
update(Actividad actividad)
delete(int id)
```

### Lógica de negocio evaluada

La lógica se implementa en:

```java
ActividadService
```

### Operaciones de negocio

```java
reservarPlaza()
cancelarPlaza()
calcularIngresosTotales()
findCompletas()
```

---

## Parte BBDD (SQLite3)

### Objetivo

El alumno implementa persistencia real con SQLite3.

### Repositorios SQLite

#### Usuario

```java
UsuarioSqliteRepository
```

Implementa:

```java
UsuarioRepository
```

---

#### Actividad

```java
ActividadSqliteRepository
```

Implementa:

```java
ActividadRepository
```

---

#### Inscripción

```java
InscripcionSqliteRepository
```

Implementa:

```java
InscripcionRepository
```

---

## Servicios evaluados

### UsuarioService

#### Operaciones

```java
findAll()
findById()
save()
update()
delete()
```

---

### InscripcionService

#### Operaciones

```java
findAll()
findById()
findByUsuario()
findByActividad()
save()
cancelar()
```

### Reglas de negocio evaluadas

#### save()

Debe validar:

- usuario existente;
- actividad existente;
- plazas disponibles;
- inscripción no duplicada;
- fecha válida.

Además:

- incrementa plazas ocupadas;
- guarda la inscripción.

---

#### cancelar()

Debe:

- localizar la inscripción;
- comprobar que está activa;
- liberar plaza;
- cambiar estado a CANCELADA.

---

## Testing

### Filosofía

Los tests se realizan únicamente sobre servicios.

NO se testean directamente los repositorios.

---

## Organización de tests

| Test | Tipo | Nº tests |
|---|---|---:|
| ActividadServiceTest | CSV | 45 |
| UsuarioServiceTest | SQLite | 25 |
| InscripcionServiceTest | SQLite | 33 |

Total:

```text
103 tests
```

---

## Restauración de datos

### CSV

Antes de cada test:

- se restaura el fichero CSV original.

### SQLite

Antes de cada test:

- se elimina la base de datos;
- se recrean tablas;
- se insertan datos iniciales.

Esto garantiza:

- independencia;
- repetibilidad;
- aislamiento.

---

## Corrección automática

La nota se calcula mediante:

```text
calcular_nota.py
```

```
mvn clean verify -Pcalificar
```

---

## Sistema de ponderación

### Ficheros

| Elemento | Peso |
|---|---:|
| Tests CSV | 3.5 |
| Documentación interfaz | 0.5 |
| Total | 4.0 |

---

### BBDD

| Elemento | Peso |
|---|---:|
| UsuarioService | 1.5 |
| InscripcionService | 3.5 |
| Documentación UsuarioRepository | 0.5 |
| Documentación InscripcionRepository | 0.5 |
| Total | 6.0 |

---

## Por qué InscripcionService vale más

Porque incorpora:

- relaciones entre entidades;
- lógica compleja;
- reglas de negocio;
- control de estados;
- validaciones cruzadas;
- sincronización de plazas.

---

## Documentación de APIs

## Objetivo

El examen evalúa documentación profesional mediante JavaDoc.

Las interfaces deben documentarse correctamente.

---

## Patrón obligatorio de documentación

### Ejemplo correcto

```java
/**
 * Busca una actividad por identificador.
 *
 * @param id identificador de la actividad
 * @return actividad encontrada o null
 */
Actividad findById(int id);
```

---

## Reglas para sumar puntuación documental

La documentación SOLO suma si:

```text
el bloque alcanza al menos el 85% de tests correctos
```

---

## Interfaces evaluadas

## CSV

```java
ActividadRepository
```

---

### SQLite

```java
UsuarioRepository
InscripcionRepository
```

---

## Qué analiza el corrector

El corrector revisa:

- existencia de JavaDoc;
- palabras clave;
- descripción coherente;
- métodos documentados.

---

# Ejemplo de salida

```text
ACTIVIDAD CSV
-------------
Tests totales: 45
Tests pasados: 45
Tests fallados: 0
Porcentaje tests: 100.00%
Nota tests: 10.00/10
Aportación tests: 3.50/3.50
Documentación interfaz: 0.50/0.50
Subtotal bloque: 4.00/4.00
Nota bloque sobre 10: 10.00/10
```

---

## Nota final

La nota final muestra:

- subtotal CSV;
- subtotal BBDD;
- nota sobre 10 de cada bloque;
- suma final.

---

## Ejecución

### Ejecutar tests

```bash
mvn clean test
```

## Ejecutar corrector

```bash
mvn clean verify -Pcalificar
```

---

## Recomendaciones para el alumno

### CSV

- trabajar primero el CRUD;
- validar correctamente;
- comprobar escritura en fichero.

---

### SQLite

- comenzar por UsuarioRepository;
- continuar con ActividadRepository;
- terminar con InscripcionService.

---

<div align="center">
    <img src="img/suerte.png" width=300>
</div>

</div>

---

## Versión sin enumerados

Esta versión elimina completamente los `enum` del proyecto.

Se han sustituido:

| Antes | Ahora |
|---|---|
| `TipoActividad` | `String` |
| `TipoUsuario` | `String` |
| `EstadoInscripcion` | `String` |

### Actividad

```text
ACADEMICA
DEPORTIVA
```

### Usuario

```text
ALUMNO
SOCIO
AMBOS
```

### Inscripción

```text
ACTIVA
CANCELADA
```


Para evitar cadenas mágicas se incluye:

```text
src/main/java/es/ies/puerto/models/Constantes.java
```

La funcionalidad, tests, documentación, BBDD, CSV, backups y corrector se mantienen.
