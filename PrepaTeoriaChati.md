
1. **Preguntas de examen muy probables**
2. **Patrones de diseño que usa tu proyecto**
3. **Cómo defender la arquitectura**
4. **Cómo funciona `equals()`**
5. **Cómo crear correctamente `equals()` y `hashCode()`**

---

# 1️⃣ 10 preguntas MUY probables de examen

Estas preguntas aparecen constantemente en exámenes cuando hay proyectos con arquitectura como el tuyo.

---

## 1. ¿Qué es una interfaz y para qué sirve?

Una **interfaz** define **qué métodos debe tener una clase**, pero **no cómo se implementan**.

Ejemplo:

```java
public interface IUserRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
```

Una clase la implementa:

```java
public class UserRepositoryImpl implements IUserRepository
```

Ventajas:

* desacopla el código
* permite cambiar implementaciones
* facilita testing
* mejora arquitectura

Ejemplo real en tu proyecto:

```
IUserRepository → UserRepositoryImpl
```

---

# 2️⃣ ¿Qué diferencia hay entre Repository y Service?

### Repository

Responsabilidad:

```
acceso a datos
```

Ejemplos:

```
guardar usuario
buscar usuario
listar usuarios
```

Ejemplo en tu proyecto:

```java
UserRepositoryImpl
```

---

### Service

Responsabilidad:

```
lógica de negocio
```

Ejemplo:

```
validar usuario
controlar login
gestionar usuarios
```

Ejemplo en tu proyecto:

```java
UserServiceImpl
AuthServiceImpl
```

---

# 3️⃣ ¿Qué es Dependency Injection?

Es una técnica donde una clase **recibe sus dependencias desde fuera**.

Ejemplo de tu proyecto:

```java
IUserRepository repo = new UserRepositoryImpl();

IUserService userService = new UserServiceImpl(repo);
```

El servicio **no crea el repositorio**, lo recibe.

Ventajas:

* desacoplamiento
* testabilidad
* arquitectura limpia

---

# 4️⃣ ¿Qué es el desacoplamiento?

Significa que **las clases no dependen directamente entre sí**.

Ejemplo malo:

```
Service → UserRepositoryImpl
```

Ejemplo bueno:

```
Service → IUserRepository
```

Así se puede cambiar la implementación sin romper nada.

---

# 5️⃣ ¿Qué ventaja tiene usar HashSet?

Tu repositorio usa:

```java
Set<Usuario> usuarios = new HashSet<>();
```

Ventajas:

* no permite duplicados
* operaciones rápidas
* usa `equals()` y `hashCode()`

---

# 6️⃣ ¿Por qué Persona es abstracta?

Porque **no tiene sentido crear una Persona genérica**.

Solo existen:

```
Alumno
Profesor
Usuario
```

Por eso se usa:

```java
public abstract class Persona
```

Esto obliga a usar **herencia**.

---

# 7️⃣ ¿Qué es herencia?

Permite que una clase herede propiedades de otra.

Ejemplo:

```
Persona
   ↑
Usuario
```

Usuario hereda:

```
id
nombre
```

---

# 8️⃣ ¿Qué es encapsulación?

Significa que los atributos son privados.

Ejemplo:

```java
private String email;
```

Y se accede mediante:

```
getters
setters
```

---

# 9️⃣ ¿Por qué validar datos?

Para evitar datos incorrectos.

Ejemplos:

```
email inválido
password débil
duplicados
```

Tu proyecto usa:

```
Validaciones.java
```

para centralizar validaciones.

---

# 🔟 ¿Qué es separación de responsabilidades?

Cada clase tiene **una única función**.

Ejemplo en tu proyecto:

| Clase        | Responsabilidad  |
| ------------ | ---------------- |
| Persona      | modelo base      |
| Usuario      | modelo usuario   |
| Repository   | acceso a datos   |
| Service      | lógica           |
| Validaciones | validaciones     |
| Main         | interfaz usuario |

Esto se llama:

```
Single Responsibility Principle
```

---

# 2️⃣ Patrones de diseño que usa tu proyecto

Aunque no lo parezca, tu proyecto usa varios patrones clásicos.

---

# 1. Repository Pattern

Separa la lógica de acceso a datos.

Ejemplo:

```
IUserRepository
UserRepositoryImpl
```

Responsabilidad:

```
guardar
buscar
listar
eliminar
```

---

# 2. Service Layer Pattern

Separar lógica de negocio.

Ejemplo:

```
UserServiceImpl
AuthServiceImpl
```

---

# 3. Dependency Injection

Las dependencias se pasan al constructor.

Ejemplo:

```java
public UserServiceImpl(IUserRepository repository)
```

---

# 4. Domain Model Pattern

Las clases del dominio representan entidades reales.

Ejemplo:

```
Persona
Usuario
```

---

# 3️⃣ Cómo explicar la arquitectura en un examen

Respuesta ideal:

> El proyecto utiliza una arquitectura por capas donde se separan responsabilidades.
> El modelo contiene las entidades del dominio como Persona y Usuario.
> El repository gestiona el acceso a los datos utilizando un HashSet.
> La capa service contiene la lógica de negocio como autenticación y gestión de usuarios.
> Las interfaces permiten desacoplar las implementaciones.
> Finalmente la clase Main actúa como punto de entrada y gestiona la interacción con el usuario.

---

# 4️⃣ Cómo funciona equals()

`equals()` sirve para **comparar objetos**.

Sin equals:

```java
Usuario u1 = new Usuario(1);
Usuario u2 = new Usuario(1);
```

Java piensa que son diferentes.

Porque compara memoria.

---

Con equals:

```java
u1.equals(u2)
```

Puedes definir **qué significa que dos objetos sean iguales**.

---

# 5️⃣ Cómo crear equals()

En tu proyecto lo correcto es:

```
dos usuarios son iguales si tienen el mismo id
```

Ejemplo:

```java
@Override
public boolean equals(Object o) {

    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Persona persona = (Persona) o;

    return id == persona.id;
}
```

---

# Explicación línea por línea

### 1

```java
if (this == o)
```

Si es el mismo objeto en memoria.

---

### 2

```java
if (o == null)
```

Evita errores.

---

### 3

```java
getClass() != o.getClass()
```

Evita comparar clases distintas.

---

### 4

```java
Persona persona = (Persona) o;
```

Convertimos el objeto.

---

### 5

```java
return id == persona.id;
```

Comparación real.

---

# 6️⃣ Por qué también hay que implementar hashCode()

Porque estructuras como:

```
HashSet
HashMap
```

usan `hashCode()`.

Ejemplo correcto:

```java
@Override
public int hashCode() {
    return Objects.hash(id);
}
```

Regla:

```
si equals() es igual → hashCode() debe ser igual
```

---

# 7️⃣ Por qué tu proyecto usa equals()

Porque el repositorio usa:

```java
HashSet<Usuario>
```

El Set usa:

```
equals()
hashCode()
```

para evitar duplicados.

---

# 🎓 Resumen para tu examen

Tu proyecto demuestra:

* arquitectura por capas
* uso de interfaces
* repository pattern
* service layer
* dependency injection
* encapsulación
* herencia
* uso de colecciones
* equals/hashCode

Esto es **exactamente lo que buscan en exámenes de arquitectura básica en Java**.

---

Voy a preparar **un mini-simulacro de examen** sobre programas como el tuyo en **Java**.
Lo dividiré en tres partes:

1️⃣ **20 preguntas tipo test (muy típicas)**
2️⃣ **Errores que suelen preguntar los profesores**
3️⃣ **Cómo explicar la arquitectura del programa en 2 minutos**

Esto es exactamente el tipo de teoría que suele caer en DAM.

---

# 1️⃣ Simulacro – 20 preguntas tipo test

## 1

¿Qué define una **interfaz**?

A) Implementación de métodos
B) Variables globales
C) Un contrato de métodos que deben implementarse
D) Una clase abstracta

✅ **Respuesta:** C

---

## 2

¿Cuál es la principal ventaja de usar interfaces?

A) Menos código
B) Permite cambiar implementaciones sin modificar el código que las usa
C) Hace el programa más rápido
D) Permite crear variables estáticas

✅ **Respuesta:** B

---

## 3

En la arquitectura de tu proyecto, ¿qué capa contiene la lógica de negocio?

A) Repository
B) Model
C) Service
D) Util

✅ **Respuesta:** C

---

## 4

¿Qué responsabilidad tiene la capa **Repository**?

A) Validar datos
B) Gestionar la interfaz de usuario
C) Acceder y almacenar datos
D) Crear menús

✅ **Respuesta:** C

---

## 5

¿Qué patrón de diseño representa:

```
IUserRepository
UserRepositoryImpl
```

A) Factory
B) Repository
C) Singleton
D) Observer

✅ **Respuesta:** B

---

## 6

¿Qué estructura de datos usaba tu proyecto para almacenar usuarios?

A) ArrayList
B) HashMap
C) HashSet
D) LinkedList

✅ **Respuesta:** C

---

## 7

¿Qué ventaja tiene `HashSet`?

A) Permite duplicados
B) Evita duplicados automáticamente
C) Ordena automáticamente
D) Es más lento que ArrayList

✅ **Respuesta:** B

---

## 8

¿Qué método se usa para comparar objetos en Java?

A) compare()
B) equals()
C) ==
D) match()

✅ **Respuesta:** B

---

## 9

¿Qué compara `==` entre objetos?

A) Contenido
B) Hash
C) Referencia en memoria
D) Campos

✅ **Respuesta:** C

---

## 10

¿Qué método debe implementarse junto a `equals()`?

A) compareTo()
B) hashCode()
C) clone()
D) toString()

✅ **Respuesta:** B

---

## 11

¿Qué principio de programación dice que una clase debe tener una sola responsabilidad?

A) Open/Closed
B) Single Responsibility
C) Dependency Injection
D) Encapsulation

✅ **Respuesta:** B

---

## 12

¿Qué significa encapsulación?

A) Heredar clases
B) Ocultar los datos y acceder mediante métodos
C) Usar interfaces
D) Crear objetos

✅ **Respuesta:** B

---

## 13

¿Qué significa herencia?

A) Una clase reutiliza atributos y métodos de otra
B) Copiar código
C) Crear múltiples clases
D) Usar interfaces

✅ **Respuesta:** A

---

## 14

¿Qué palabra clave se usa para herencia?

```
Usuario ___ Persona
```

A) extends
B) implements
C) inherit
D) super

✅ **Respuesta:** A

---

## 15

¿Qué palabra clave se usa para implementar una interfaz?

A) extends
B) implements
C) override
D) interface

✅ **Respuesta:** B

---

## 16

¿Qué hace `Optional<Usuario>`?

A) Permite devolver null
B) Evita errores de null
C) Es una lista
D) Es una excepción

✅ **Respuesta:** B

---

## 17

¿Qué clase contiene el punto de entrada del programa?

A) Persona
B) Usuario
C) Main
D) Service

✅ **Respuesta:** C

---

## 18

¿Qué patrón se usa cuando una clase recibe sus dependencias por el constructor?

A) Factory
B) Dependency Injection
C) Adapter
D) Observer

✅ **Respuesta:** B

---

## 19

¿Qué hace `Pattern.matches()`?

A) Convierte texto
B) Comprueba una expresión regular
C) Ordena texto
D) Busca en listas

✅ **Respuesta:** B

---

## 20

¿Qué significa desacoplamiento?

A) Clases independientes entre sí
B) Código duplicado
C) Métodos privados
D) Herencia múltiple

✅ **Respuesta:** A

---

# 2️⃣ Errores típicos que preguntan los profesores

### ❌ Error 1

Usar `==` para comparar Strings

Incorrecto:

```java
email == usuario.getEmail()
```

Correcto:

```java
email.equals(usuario.getEmail())
```

---

### ❌ Error 2

No implementar `hashCode()` cuando se usa `equals()`.

---

### ❌ Error 3

Meter lógica de negocio en `Main`.

Incorrecto:

```
Main valida password
Main guarda usuario
Main controla login
```

Correcto:

```
Main → Service → Repository
```

---

### ❌ Error 4

No validar datos.

Ejemplo:

```
email inválido
password débil
```

---

### ❌ Error 5

Crear dependencias dentro de clases.

Incorrecto:

```java
UserServiceImpl service = new UserServiceImpl();
```

Correcto:

```java
UserServiceImpl service = new UserServiceImpl(repository);
```

---

# 3️⃣ Cómo explicar la arquitectura en 2 minutos (respuesta perfecta)

Si te preguntan:

> “Explique la arquitectura del programa”

Puedes responder algo como esto:

---

El programa está organizado siguiendo una arquitectura por capas.

Primero tenemos la capa **model**, que contiene las entidades del dominio como `Persona` y `Usuario`. Estas clases representan los datos del sistema.

Después tenemos la capa **repository**, que se encarga del acceso a los datos. En este caso los usuarios se almacenan en memoria utilizando una colección `HashSet`.

Encima está la capa **service**, que contiene la lógica de negocio. Aquí se gestionan operaciones como registrar usuarios, realizar login o validar información.

Las clases service dependen de interfaces del repository, lo que permite desacoplar el sistema y cambiar implementaciones fácilmente.

También existe una clase **Validaciones** que centraliza las comprobaciones de datos como el formato del email o la seguridad de la contraseña.

Finalmente, la clase **Main** actúa como punto de entrada del programa y se encarga de la interacción con el usuario mediante un menú por consola.

Esta arquitectura permite separar responsabilidades, mejorar la mantenibilidad del código y facilitar futuras ampliaciones del sistema.

---

# 🎯 Consejo final para tu examen

Si te preguntan **por arquitectura**, menciona siempre:

```
interfaces
separación de capas
repository
service
validaciones
dependency injection
```

Eso demuestra que entiendes **arquitectura de software básica**.

---
