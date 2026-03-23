# 📝 Simulacro de Examen Completo
## Sistema de Autenticación de Usuarios — Java con Arquitectura por Capas

> **Instrucciones:** Este examen cubre teoría de POO, arquitectura por capas, interfaces, colecciones, validaciones y flujos de ejecución. Las respuestas están al final de cada sección. Intenta responder antes de mirarlas.

---

# 🅰️ BLOQUE 1 — Tipo Test (30 preguntas)
*Una sola respuesta correcta por pregunta.*

---

**1.** ¿Cuál de las siguientes afirmaciones sobre una interfaz en Java es CORRECTA?

A) Puede tener constructores  
B) Puede tener atributos de instancia con estado  
C) Define firmas de métodos sin implementación  
D) Solo puede ser implementada por una clase a la vez  

---

**2.** En el proyecto, `UserServiceImpl` recibe `IUserRepository` en su constructor en lugar de `UserRepositoryImpl`. ¿Qué principio de diseño representa esto?

A) Herencia simple  
B) Encapsulación de atributos  
C) Inversión de dependencias / Inyección de dependencias  
D) Polimorfismo de sobrecarga  

---

**3.** ¿Qué ocurre si una clase declara `implements IUserRepository` pero no implementa uno de sus métodos?

A) El programa compila y lanza excepción en ejecución  
B) El compilador da error  
C) El método se hereda automáticamente de Object  
D) El método se ignora  

---

**4.** En el diagrama de flujo del login, ¿en qué orden se comprueban las condiciones?

A) Contraseña → Existencia → Bloqueo  
B) Bloqueo → Existencia → Contraseña  
C) Existencia → Bloqueo → Contraseña  
D) Existencia → Contraseña → Bloqueo  

---

**5.** ¿Qué devuelve `repo.findByEmail(email)` cuando el email no existe en el sistema?

A) `null`  
B) Un `Usuario` vacío  
C) Un `Optional` vacío  
D) Lanza `IllegalArgumentException`  

---

**6.** ¿Cuál es la diferencia entre `optional.get()` y `optional.orElse(valor)`?

A) No hay diferencia, son sinónimos  
B) `get()` lanza excepción si el Optional está vacío; `orElse()` devuelve el valor alternativo  
C) `orElse()` lanza excepción si el Optional está vacío; `get()` devuelve null  
D) `get()` solo funciona con Strings  

---

**7.** En `AuthServiceImpl`, ¿quién toma la decisión de bloquear al usuario tras 3 intentos fallidos?

A) El modelo `Usuario` internamente en `incrementarIntentosFallidos()`  
B) El repositorio `UserRepositoryImpl`  
C) El servicio `AuthServiceImpl`  
D) La clase `Main`  

---

**8.** ¿Por qué `equals()` de `Usuario` se basa en el email y no en el `id`?

A) Porque el id puede ser negativo  
B) Porque el email es el identificador único de negocio y permite que el Set detecte duplicados correctamente  
C) Porque el id no está disponible en Usuario  
D) Porque el email es un campo final  

---

**9.** Si tienes un `HashSet<Usuario>` y dos objetos `Usuario` distintos con el mismo email pero diferente id, ¿cuántos elementos habrá en el Set si `equals/hashCode` están basados en email?

A) 2, porque tienen distinto id  
B) 1, porque equals basado en email los considera iguales  
C) 0, porque el Set lanza excepción con duplicados  
D) Depende del orden de inserción  

---

**10.** ¿Qué hace `Validaciones.normalizarEmail("  Ana@EJEMPLO.COM  ")`?

A) Devuelve `"  Ana@EJEMPLO.COM  "` sin cambios  
B) Devuelve `"ana@ejemplo.com"`  
C) Devuelve `"ANA@EJEMPLO.COM"`  
D) Lanza excepción porque tiene espacios  

---

**11.** ¿En qué capa del proyecto se encuentra la lógica de "bloquear tras 3 intentos"?

A) model  
B) util  
C) repository  
D) service  

---

**12.** ¿Cuál de estas afirmaciones sobre `Persona` es CORRECTA?

A) Puede instanciarse directamente con `new Persona(...)`  
B) Es una clase abstracta que no puede instanciarse directamente  
C) Es una interfaz  
D) No puede tener constructores  

---

**13.** ¿Qué ocurre si el constructor de `Usuario` recibe un email con formato inválido?

A) El objeto se crea con email vacío  
B) Se lanza `IllegalArgumentException` y el objeto no se crea  
C) El objeto se crea pero `getEmail()` devuelve null  
D) El repositorio rechaza el usuario más tarde  

---

**14.** ¿Qué es el acoplamiento en el contexto de la arquitectura de este proyecto?

A) La capacidad de una clase de heredar de otra  
B) El grado en que una clase depende directamente de otra clase concreta  
C) El número de métodos que tiene una clase  
D) La cantidad de parámetros de un constructor  

---

**15.** ¿Cuál es la responsabilidad de `Main` según la arquitectura del proyecto?

A) Validar emails con RegEx  
B) Gestionar la colección de usuarios  
C) Gestionar la interacción con el usuario: menú, lectura y mensajes  
D) Aplicar las reglas de bloqueo  

---

**16.** En Java, ¿cuántas interfaces puede implementar una clase?

A) Solo una  
B) Máximo dos  
C) Máximo el número de clases que extienda  
D) Sin límite  

---

**17.** ¿Qué significa que `fechaRegistro` sea `final` en `Usuario`?

A) Que solo puede asignarse en métodos estáticos  
B) Que debe inicializarse en el constructor y no puede cambiar después  
C) Que es visible desde todas las clases  
D) Que su valor se comparte entre todos los objetos Usuario  

---

**18.** En el patrón Repository, ¿qué ocurriría si cambias la implementación de `UserRepositoryImpl` por una que guarda en base de datos?

A) Habría que cambiar `UserServiceImpl` y `AuthServiceImpl`  
B) No habría que cambiar nada en las capas superiores si mantiene el contrato de `IUserRepository`  
C) Habría que cambiar el modelo `Usuario`  
D) Habría que reescribir `Main`  

---

**19.** ¿Qué estructura de datos es más eficiente para comprobar si un email ya está registrado?

A) `ArrayList<String>` — búsqueda O(n)  
B) `HashSet<String>` — búsqueda O(1)  
C) Ambas son igual de eficientes  
D) `LinkedList<String>` — búsqueda O(log n)  

---

**20.** ¿Qué pasa si sobreescribes `equals()` en `Usuario` pero NO sobreescribes `hashCode()`?

A) El código compila y funciona perfectamente  
B) El `HashSet` puede almacenar dos usuarios con el mismo email porque los considera objetos diferentes  
C) El compilador da error  
D) `equals()` deja de funcionar  

---

**21.** ¿Qué significa `@Override` antes de un método?

A) Que el método no puede ser llamado desde fuera  
B) Que el método es estático  
C) Que el método sobreescribe uno del padre y el compilador verifica que exista  
D) Que el método solo puede usarse en tests  

---

**22.** En el constructor de `Usuario`, ¿cuál debe ser la primera instrucción?

A) Asignar el email  
B) Validar la contraseña  
C) Llamar al constructor de `Persona` con `super(...)`  
D) Inicializar `intentosFallidos = 0`  

---

**23.** ¿Qué hace `Period.between(fechaNacimiento, LocalDate.now()).getYears()`?

A) Devuelve el año de nacimiento  
B) Devuelve los meses transcurridos  
C) Devuelve los años cumplidos correctamente  
D) Devuelve la diferencia en días  

---

**24.** ¿Por qué `Validaciones` tiene métodos `static`?

A) Para poder heredad de ella más fácilmente  
B) Porque no tiene estado propio y sus funciones son herramientas puras reutilizables sin instanciar la clase  
C) Para poder sobreescribir sus métodos  
D) Porque Java exige que las clases utilitarias sean estáticas  

---

**25.** ¿Cuál de los siguientes NO es un método del contrato `IUserRepository`?

A) `save(Usuario usuario)`  
B) `findByEmail(String email)`  
C) `login(String email, String password)`  
D) `deleteByEmail(String email)`  

---

**26.** ¿Qué ocurre si usas `==` para comparar dos objetos `String` en Java?

A) Compara el contenido de los Strings siempre correctamente  
B) Compara las referencias de memoria, pudiendo dar `false` aunque el contenido sea idéntico  
C) Lanza `NullPointerException`  
D) Es equivalente a `equalsIgnoreCase()`  

---

**27.** ¿Cuál es el propósito del método `resetearIntentosFallidos()` en `Usuario`?

A) Eliminar al usuario del sistema  
B) Poner `intentosFallidos` a 0 tras un login exitoso  
C) Desbloquear automáticamente al usuario  
D) Validar que la contraseña es correcta  

---

**28.** En la arquitectura del proyecto, ¿qué capa puede llamar directamente a `Validaciones`?

A) Solo `Main`  
B) Solo `service`  
C) Cualquier capa que necesite validar datos  
D) Solo `repository`  

---

**29.** ¿Qué devuelve `Pattern.compile("^\\d{8}[A-Za-z]$").matcher("12345678A").matches()`?

A) `false`, porque el patrón no es correcto  
B) `true`, porque la cadena cumple el patrón de 8 dígitos seguidos de una letra  
C) `true`, porque `.matches()` siempre devuelve true  
D) Lanza excepción porque el patrón tiene caracteres especiales  

---

**30.** ¿Cuál es la diferencia correcta entre `extends` e `implements`?

A) `extends` es para interfaces, `implements` es para clases abstractas  
B) `extends` hereda de una clase; `implements` firma el contrato de una interfaz  
C) Son sinónimos en Java moderno  
D) `implements` hereda de una clase; `extends` firma el contrato de una interfaz  

---

### ✅ Respuestas Bloque 1

| Nº | Resp | Nº | Resp | Nº | Resp |
|----|------|----|------|----|------|
| 1  | C    | 11 | D    | 21 | C    |
| 2  | C    | 12 | B    | 22 | C    |
| 3  | B    | 13 | B    | 23 | C    |
| 4  | C    | 14 | B    | 24 | B    |
| 5  | C    | 15 | C    | 25 | C    |
| 6  | B    | 16 | D    | 26 | B    |
| 7  | C    | 17 | B    | 27 | B    |
| 8  | B    | 18 | B    | 28 | C    |
| 9  | B    | 19 | B    | 29 | B    |
| 10 | B    | 20 | B    | 30 | B    |

---

---

# 🅱️ BLOQUE 2 — Verdadero o Falso (20 preguntas)
*Indica si la afirmación es Verdadera (V) o Falsa (F) y justifica brevemente.*

---

**1.** Una clase puede implementar varias interfaces simultáneamente en Java.

---

**2.** `Main` puede acceder directamente a la colección `HashSet<Usuario>` del repositorio para mayor eficiencia.

---

**3.** Si `equals()` considera iguales a dos objetos, sus `hashCode()` pueden ser diferentes sin problema.

---

**4.** Un método declarado en una interfaz puede tener cuerpo (implementación) en Java.

---

**5.** `Optional.get()` es completamente seguro de llamar en cualquier momento sin comprobaciones previas.

---

**6.** La clase `Persona` puede tener un constructor aunque sea abstracta.

---

**7.** `LocalDate.now()` devuelve el mismo valor en todas las llamadas dentro de un mismo programa.

---

**8.** El repositorio debe contener la lógica de "bloquear al usuario tras 3 intentos".

---

**9.** Normalizar el email significa aplicar `trim()` y `toLowerCase()` para que comparaciones y búsquedas sean consistentes.

---

**10.** Si `UserRepositoryImpl` usa un `Map<String, Usuario>`, dos llamadas a `save()` con el mismo email sobreescriben silenciosamente el usuario anterior (sin configuración adicional).

---

**11.** El método `getTipo()` abstracto en `Persona` obliga a todas las subclases concretas a implementarlo.

---

**12.** Un atributo `private final` en Java puede modificarse mediante un setter si este usa reflexión.

---

**13.** `AuthServiceImpl` y `UserServiceImpl` son clases distintas porque tienen responsabilidades distintas: una gestiona autenticación y la otra gestiona el CRUD de usuarios.

---

**14.** En un `HashSet<Usuario>` con `equals/hashCode` basados en email, intentar añadir dos usuarios con el mismo email añadirá ambos porque tienen distinto `id`.

---

**15.** El patrón Repository permite cambiar la fuente de datos (de memoria a base de datos) sin modificar la capa service.

---

**16.** `String.matches(patron)` y usar `Pattern.compile(patron).matcher(cadena).matches()` son equivalentes en resultado, pero la segunda es más eficiente cuando se usa el mismo patrón muchas veces.

---

**17.** Una interfaz en Java puede extender otra interfaz.

---

**18.** La inyección de dependencias por constructor dificulta el testing porque no puedes controlar qué implementación se usa.

---

**19.** `toString()` de `Usuario` debería mostrar la contraseña para facilitar la depuración.

---

**20.** En el flujo de login, si el usuario no existe en el sistema, `AuthServiceImpl` debería lanzar una excepción con el mensaje "usuario no encontrado" para informar claramente al cliente.

---

### ✅ Respuestas Bloque 2

**1. V** — Java permite implementar múltiples interfaces (`class A implements B, C, D`).

**2. F** — Main no debe conocer ni tocar colecciones. Solo llama a la capa service.

**3. F** — El contrato Java exige que si `a.equals(b)` es true, entonces `a.hashCode() == b.hashCode()`. Romperlo causa comportamientos incorrectos en HashSet/HashMap.

**4. V** — Desde Java 8 existen los métodos `default` en interfaces, que sí tienen implementación. Sin embargo, los métodos normales de interfaz siguen sin cuerpo.

**5. F** — `Optional.get()` lanza `NoSuchElementException` si el Optional está vacío. Siempre hay que comprobar `isPresent()` o usar `orElse()` antes.

**6. V** — Las clases abstractas pueden (y normalmente deben) tener constructores. Se invocan desde las subclases con `super()`.

**7. F** — `LocalDate.now()` devuelve la fecha actual en el momento de llamarse. Si el programa se ejecuta en diferentes días, devolverá valores distintos.

**8. F** — El repositorio solo almacena y recupera datos. La lógica de bloqueo pertenece a la capa service (`AuthServiceImpl`).

**9. V** — Sin normalización, `"Ana@EJEMPLO.COM"` y `"ana@ejemplo.com"` serían tratados como emails distintos.

**10. V** — `HashMap.put()` con clave ya existente sobreescribe el valor. Por eso `save()` debe comprobar con `containsKey()` antes y lanzar excepción si ya existe.

**11. V** — Un método abstracto debe ser implementado por todas las subclases concretas. Si una subclase no lo implementa, también debe declararse abstracta.

**12. F** — Aunque técnicamente la reflexión puede saltarse restricciones de acceso, para los propósitos del examen un campo `final` no puede modificarse. Es inmutable por diseño y por compilador en uso normal.

**13. V** — Separación de responsabilidades: cada clase tiene una única razón para cambiar (Single Responsibility Principle).

**14. F** — Con `equals/hashCode` basados en email, el Set los considera el mismo elemento y rechaza el segundo. Solo habrá 1 elemento.

**15. V** — Esta es precisamente la ventaja del patrón Repository: abstraer el mecanismo de persistencia.

**16. V** — Compilar un `Pattern` es costoso. Reutilizar el patrón compilado como constante es mucho más eficiente que compilar en cada llamada.

**17. V** — Una interfaz puede extender otra con `extends`: `interface IAuthService extends IBaseService`.

**18. F** — La inyección de dependencias por constructor FACILITA el testing: puedes pasar una implementación simulada (mock) en lugar de la real.

**19. F** — Nunca se debe exponer la contraseña en `toString()`. Es una práctica de seguridad básica.

**20. F** — Por seguridad, no se debe informar de si el usuario existe o no. Solo se devuelve `false` genérico. Informar sobre la existencia del email facilita ataques de enumeración de usuarios.

---

---

# 🅲 BLOQUE 3 — Relacionar columnas (3 ejercicios)

---

## Ejercicio 3.1 — Clase con su responsabilidad

Relaciona cada clase/interfaz con su responsabilidad principal:

| # | Clase/Interfaz      |   | Responsabilidad                                    |
|---|---------------------|---|----------------------------------------------------|
| 1 | `Main`              | A | Contrato CRUD: guardar, buscar, eliminar usuarios  |
| 2 | `Persona`           | B | Reglas de negocio: login, bloqueo, registro        |
| 3 | `Usuario`           | C | Herramienta: validar email, password, normalizar   |
| 4 | `Validaciones`      | D | Interfaz de usuario: menú, teclado, mensajes       |
| 5 | `IUserRepository`   | E | Modelo base abstracto: id y nombre comunes         |
| 6 | `UserRepositoryImpl`| F | Entidad concreta: email, password, estado sesión   |
| 7 | `AuthServiceImpl`   | G | Implementación en memoria del almacenamiento       |
| 8 | `UserServiceImpl`   | H | Gestión de usuarios: crear, listar, buscar, borrar |

### ✅ Respuesta 3.1
1→D, 2→E, 3→F, 4→C, 5→A, 6→G, 7→B, 8→H

---

## Ejercicio 3.2 — Concepto con su definición

| # | Concepto                  |   | Definición                                                                 |
|---|---------------------------|---|----------------------------------------------------------------------------|
| 1 | Encapsulación             | A | Una clase recibe sus dependencias desde fuera en lugar de crearlas         |
| 2 | Herencia                  | B | Atributos privados, acceso solo mediante métodos controlados               |
| 3 | Polimorfismo              | C | El grado en que una clase depende directamente de otra concreta            |
| 4 | Interfaz                  | D | Una clase reutiliza código de otra mediante `extends`                      |
| 5 | Inyección de dependencias | E | Contrato de métodos que deben implementarse, sin implementación propia     |
| 6 | Acoplamiento              | F | El mismo método se comporta diferente según el tipo real del objeto        |
| 7 | Optional                  | G | Contenedor que representa un valor que puede estar presente o no           |
| 8 | Patrón Repository         | H | Separa la lógica de acceso a datos del resto de la aplicación              |

### ✅ Respuesta 3.2
1→B, 2→D, 3→F, 4→E, 5→A, 6→C, 7→G, 8→H

---

## Ejercicio 3.3 — Situación con la capa correcta

¿En qué capa pertenece cada responsabilidad?

| # | Responsabilidad                                        |   | Capa            |
|---|--------------------------------------------------------|---|-----------------|
| 1 | Mostrar "Login correcto" por pantalla                  | A | `model`         |
| 2 | Comprobar que el email tiene formato válido (RegEx)    | B | `util`          |
| 3 | Guardar un usuario en el HashSet                       | C | `repository`    |
| 4 | Verificar que el email no está ya registrado           | D | `service`       |
| 5 | Leer la contraseña con Scanner                         | E | `app (Main)`    |
| 6 | Incrementar el contador de intentos fallidos           | A | `model`         |
| 7 | Llamar a bloquear() tras el tercer intento             | D | `service`       |
| 8 | Guardar la fecha de registro en construcción           | A | `model`         |

### ✅ Respuesta 3.3
1→E, 2→B, 3→C, 4→D, 5→E, 6→A, 7→D, 8→A

---

---

# 🅳 BLOQUE 4 — Preguntas de desarrollo corto
*Responde en 3-6 líneas. Evalúa comprensión real.*

---

**1.** Explica por qué `Main` no debe contener lógica de negocio. ¿Qué ocurriría si la contuviera?

**2.** Describe el flujo completo que ocurre desde que el usuario pulsa "Login" en el menú hasta que el sistema responde "Acceso denegado — usuario bloqueado". Nombra qué clase actúa en cada paso.

**3.** ¿Por qué se usa `Optional<Usuario>` en lugar de devolver `null` en las búsquedas? Da un ejemplo de cómo forzaría al programador a gestionar el caso de "no encontrado".

**4.** Explica la diferencia entre validar formato de email (en `Validaciones`) y validar que el email no está duplicado (en el servicio). ¿Por qué cada una pertenece a su capa?

**5.** Un compañero te dice: "¿Para qué crear `IUserRepository` si solo vas a tener una implementación `UserRepositoryImpl`? Es trabajo innecesario." ¿Cómo le responderías?

**6.** Explica qué es el Single Responsibility Principle y señala dos ejemplos concretos de cómo se aplica en este proyecto.

**7.** ¿Qué consecuencia tiene normalizar el email en el constructor de `Usuario` pero NO normalizarlo en `findByEmail()` del repositorio?

**8.** Explica en tus propias palabras qué significa que el acoplamiento entre capas sea bajo y por qué es una ventaja.

---

### ✅ Guía de respuestas Bloque 4

**1.** Si Main tiene lógica de negocio, cualquier cambio en las reglas (número de intentos, reglas de contraseña) obliga a modificar Main. Además, si se añade otra interfaz (web, móvil), esa lógica no es reutilizable y habría que duplicarla. La lógica en la capa service es reutilizable por cualquier interfaz y testeable de forma independiente.

**2.** Main lee email y password con Scanner → llama a `authService.login(email, password)` → `AuthServiceImpl` normaliza el email → llama a `repo.findByEmail(email)` → el repositorio devuelve `Optional<Usuario>` con el usuario → `AuthServiceImpl` comprueba `usuario.isBloqueado()` → como está bloqueado, devuelve `false` → Main recibe `false` y muestra el mensaje al usuario.

**3.** Si se devuelve `null`, el programador puede olvidar comprobarlo y obtendrá `NullPointerException` en tiempo de ejecución. Con `Optional`, el API te obliga a pensar en el caso vacío: `optional.isPresent()` antes de `optional.get()`, o usar `optional.orElseThrow()`. El compilador no da error por usar Optional sin comprobar, pero el diseño es más explícito e intencional.

**4.** La validación de formato (RegEx) depende solo del propio String: es una regla matemática/sintáctica que no requiere conocer el estado del sistema. Pertenece a `Validaciones` porque es una herramienta reutilizable y sin contexto. La validación de unicidad requiere consultar el repositorio para saber qué hay guardado: es una regla de negocio que depende del estado del sistema, por eso pertenece al servicio.

**5.** La interfaz no es trabajo innecesario porque: (a) permite cambiar a otra implementación (base de datos, fichero) sin tocar el servicio; (b) facilita el testing, ya que en los tests puedes pasar una implementación falsa (mock) que no acceda a datos reales; (c) documenta el contrato de qué operaciones se esperan del repositorio. Si el sistema crece o cambia, la interfaz ya está ahí.

**6.** SRP dice que cada clase tiene una única razón para cambiar. Ejemplos: `Validaciones` solo cambia si cambian las reglas de formato. `UserRepositoryImpl` solo cambia si cambia cómo se almacenan los datos. `AuthServiceImpl` solo cambia si cambian las reglas de autenticación. `Main` solo cambia si cambia la interfaz de usuario.

**7.** Si el email se guarda normalizado (`"ana@ejemplo.com"`) pero la búsqueda no normaliza el parámetro recibido, una búsqueda con `"Ana@Ejemplo.COM"` no encontraría al usuario aunque exista. La inconsistencia entre cómo se guarda y cómo se busca produce bugs difíciles de detectar.

**8.** Bajo acoplamiento significa que cambiar la implementación de una clase no obliga a cambiar otras clases. En este proyecto, si cambias `UserRepositoryImpl` por una implementación con base de datos, `UserServiceImpl` y `AuthServiceImpl` no cambian porque dependen de la interfaz `IUserRepository`, no de la implementación concreta. Es una ventaja de mantenibilidad, escalabilidad y testabilidad.

---

---

# 🅴 BLOQUE 5 — Análisis de código incorrecto
*Identifica el error, explica por qué es incorrecto y cómo corregirlo.*

---

**Fragmento 1:**
```
// En AuthServiceImpl.login()
if (usuario.getPassword() == password) {
    return true;
}
```
¿Qué error hay? ¿Cómo se corrige?

---

**Fragmento 2:**
```
// En Main
if (email.contains("@") && email.contains(".")) {
    // email válido, continuar
}
```
¿Qué error de arquitectura hay?

---

**Fragmento 3:**
```
// En Usuario.java
public void incrementarIntentosFallidos() {
    intentosFallidos++;
    if (intentosFallidos >= 3) {
        bloqueado = true;
    }
}
```
¿Qué problema de diseño tiene este código aunque funcione?

---

**Fragmento 4:**
```
// En UserServiceImpl
public UserServiceImpl() {
    this.repo = new UserRepositoryImpl();
}
```
¿Qué principio viola? ¿Cómo se corrige?

---

**Fragmento 5:**
```
// En UserRepositoryImpl
public Optional<Usuario> findByEmail(String email) {
    for (Usuario u : usuarios) {
        if (u.getEmail() == email) {
            return Optional.of(u);
        }
    }
    return Optional.empty();
}
```
¿Cuántos errores encuentras?

---

**Fragmento 6:**
```
// En Main
IUserRepository repo = new UserRepositoryImpl();
IUserService userService = new UserServiceImpl(repo);
IAuthService authService = new AuthServiceImpl(repo);

// Opción de menú "Listar usuarios":
for (Usuario u : repo.findAll()) {
    System.out.println(u);
}
```
¿Qué error de arquitectura hay en las últimas líneas?

---

**Fragmento 7:**
```
// En Persona.java
public class Persona {
    public int id;
    public String nombre;
}
```
¿Qué principio fundamental de POO viola? ¿Cómo se corrige?

---

### ✅ Respuestas Bloque 5

**Fragmento 1:** Usa `==` para comparar Strings, que compara referencias de memoria, no contenido. Dos Strings con el mismo texto pero diferentes referencias darán `false`. Corrección: `usuario.getPassword().equals(password)`.

**Fragmento 2:** Main está validando el formato del email con lógica propia. Esa responsabilidad pertenece exclusivamente a `Validaciones.emailValido()`. Además, la validación es incompleta (un email como `"@."` pasaría). Corrección: llamar a `Validaciones.emailValido(email)` en lugar de hacer la comprobación en Main.

**Fragmento 3:** Funciona, pero viola la separación de responsabilidades. El modelo decide cuándo bloquear, pero esa es una regla de negocio que debería vivir en `AuthServiceImpl`. Si la regla cambia (bloquear al 5º intento, o avisar por email al 2º), hay que modificar el modelo. Al tener la lógica en el servicio, el modelo solo expone `incrementarIntentosFallidos()` y `bloquear()` como operaciones separadas, y el servicio decide cuándo llamar a cada una.

**Fragmento 4:** Viola la inyección de dependencias. El servicio crea su propia dependencia internamente, acoplándose a `UserRepositoryImpl` concretamente. Corrección: `public UserServiceImpl(IUserRepository repo) { this.repo = repo; }`. Así quien construya el servicio decide qué implementación de repositorio usar.

**Fragmento 5:** Dos errores. Primero: usa `==` para comparar el email (debe ser `.equals()`). Segundo: no normaliza el email del parámetro antes de buscar, por lo que `"Ana@Ejemplo.COM"` no encontraría al usuario guardado como `"ana@ejemplo.com"`. Corrección: normalizar el parámetro con `Validaciones.normalizarEmail(email)` y comparar con `.equals()`.

**Fragmento 6:** Main accede directamente al repositorio (`repo.findAll()`) para listar usuarios. Main solo debe comunicarse con la capa service. Corrección: llamar a `userService.listarUsuarios()` y que sea el servicio quien delegue en el repositorio.

**Fragmento 7:** Viola la encapsulación. Los atributos son `public`, accesibles y modificables desde cualquier clase sin ningún control. Corrección: declarar los atributos como `private` y proporcionar `getId()`, `getNombre()`, y `setNombre()` con validación. El `id` debería ser `final` si es inmutable.

---

---

# 🅵 BLOQUE 6 — Ordena el flujo
*Ordena los pasos numerándolos del 1 al N.*

---

## Ejercicio 6.1 — Flujo de REGISTRO de un nuevo usuario

Ordena estos pasos en el orden correcto de ejecución:

☐ El repositorio comprueba si el email ya existe  
☐ Main llama a `authService.register(id, nombre, email, password)`  
☐ Se crea `new Usuario(id, nombre, email, password)`  
☐ El usuario queda guardado en el HashSet/Map  
☐ El constructor de `Usuario` llama a `super(id, nombre)`  
☐ Main recoge nombre, email y password con Scanner  
☐ El servicio llama a `repo.save(usuario)`  
☐ `Validaciones.validarEmail()` lanza excepción si el formato es inválido  
☐ El constructor normaliza el email con `Validaciones.normalizarEmail()`  
☐ Main muestra "Usuario registrado" o captura la excepción y muestra el error  

### ✅ Respuesta 6.1
1. Main recoge nombre, email y password con Scanner
2. Main llama a `authService.register(id, nombre, email, password)`
3. Se crea `new Usuario(id, nombre, email, password)`
4. El constructor de `Usuario` llama a `super(id, nombre)`
5. `Validaciones.validarEmail()` lanza excepción si el formato es inválido
6. El constructor normaliza el email con `Validaciones.normalizarEmail()`
7. El repositorio comprueba si el email ya existe
8. El servicio llama a `repo.save(usuario)`
9. El usuario queda guardado en el HashSet/Map
10. Main muestra "Usuario registrado" o captura la excepción y muestra el error

---

## Ejercicio 6.2 — Flujo de LOGIN fallido (tercer intento, bloqueo)

☐ `usuario.bloquear()` se ejecuta  
☐ Main llama a `authService.login(email, password)`  
☐ `AuthServiceImpl` comprueba si `isBloqueado()` → no bloqueado aún  
☐ `AuthServiceImpl` normaliza el email  
☐ `AuthServiceImpl` comprueba `intentosFallidos >= 3` → sí  
☐ La contraseña no coincide  
☐ Main muestra "Acceso denegado"  
☐ `repo.findByEmail(email)` devuelve el usuario  
☐ `usuario.incrementarIntentosFallidos()` se ejecuta  
☐ `authService.login()` devuelve `false`  

### ✅ Respuesta 6.2
1. Main llama a `authService.login(email, password)`
2. `AuthServiceImpl` normaliza el email
3. `repo.findByEmail(email)` devuelve el usuario
4. `AuthServiceImpl` comprueba si `isBloqueado()` → no bloqueado aún
5. La contraseña no coincide
6. `usuario.incrementarIntentosFallidos()` se ejecuta
7. `AuthServiceImpl` comprueba `intentosFallidos >= 3` → sí
8. `usuario.bloquear()` se ejecuta
9. `authService.login()` devuelve `false`
10. Main muestra "Acceso denegado"

---

---

# 🅶 BLOQUE 7 — Preguntas de reflexión y defensa
*Las más habituales en exámenes orales o escritos de comprensión profunda.*

---

**1.** Tu proyecto usa `HashSet<Usuario>` para almacenar usuarios. Un compañero propone usar `ArrayList<Usuario>`. ¿Cuál elegiría y por qué? ¿Qué ventajas e inconvenientes tiene cada uno?

**Respuesta esperada:** El `HashSet` es mejor para este caso porque: (a) evita duplicados automáticamente si `equals/hashCode` están bien implementados; (b) las operaciones `contains`, `add` y `remove` son O(1) frente a O(n) del ArrayList. El `ArrayList` es mejor cuando necesitas acceso por índice o mantener el orden de inserción. Para un repositorio de usuarios donde la unicidad es crítica, el `HashSet` es la elección correcta. La alternativa `Map<String, Usuario>` sería aún más eficiente para búsquedas por email.

---

**2.** ¿Por qué `fechaRegistro` se inicializa dentro del constructor de `Usuario` y no se pasa como parámetro desde fuera?

**Respuesta esperada:** Porque `fechaRegistro` es un dato que el sistema debe controlar, no el usuario del programa. Si se pasara como parámetro, alguien podría registrar un usuario con fecha del pasado o del futuro. Al inicializarlo con `LocalDate.now()` dentro del constructor y declararlo `final`, se garantiza que siempre refleja el momento real de creación y que nunca puede modificarse externamente.

---

**3.** En el flujo de login, cuando el usuario no existe, ¿por qué se devuelve `false` genérico en lugar de un mensaje más informativo como "este email no está registrado"?

**Respuesta esperada:** Por seguridad. Si el sistema informa de que un email no existe, un atacante puede deducir qué emails están registrados en el sistema (ataque de enumeración de usuarios) y luego concentrar sus intentos solo en los emails válidos. El mensaje genérico "credenciales incorrectas" da la misma información útil al usuario legítimo pero no ayuda al atacante.

---

**4.** ¿Qué pasaría en el sistema si dos hilos de ejecución (threads) intentaran registrar el mismo email simultáneamente? ¿Cómo afecta a la arquitectura actual?

**Respuesta esperada:** Con la implementación actual (sin sincronización), ambos hilos podrían pasar la comprobación `existsByEmail` a la vez (ambos ven que el email no existe), y ambos ejecutarían `save()`, resultando en dos usuarios con el mismo email. La arquitectura actual no es thread-safe. Para resolverlo se necesitaría sincronización (bloques `synchronized`) o estructuras de datos concurrentes (`ConcurrentHashMap`). Esto es una limitación de la implementación actual que en un sistema real habría que abordar.

---

**5.** ¿Por qué `getPassword()` existe en `Usuario` si nunca debería mostrarse al usuario del sistema?

**Respuesta esperada:** `getPassword()` existe para uso interno del sistema, específicamente para la comparación en el login (`usuario.getPassword().equals(passwordIntroducida)`). El problema no es que exista el getter, sino que no se use en contextos de visualización. El `toString()` tiene la responsabilidad de no incluirlo. Una mejora sería no exponer el getter públicamente y en su lugar tener un método `verificarPassword(String candidata)` que haga la comparación internamente, sin exponer nunca el valor real de la contraseña. Esto es un diseño más seguro pero más avanzado.

---

---

# 📊 Resumen de puntuación sugerida

| Bloque | Tipo                        | Preguntas | Peso sugerido |
|--------|-----------------------------|-----------|---------------|
| 1      | Tipo test                   | 30        | 30%           |
| 2      | Verdadero/Falso con justif. | 20        | 20%           |
| 3      | Relacionar columnas         | 3 grupos  | 10%           |
| 4      | Desarrollo corto            | 8         | 20%           |
| 5      | Análisis de errores         | 7         | 10%           |
| 6      | Ordenar flujo               | 2         | 5%            |
| 7      | Reflexión profunda          | 5         | 5%            |

---

*Simulacro preparado específicamente para el proyecto de Sistema de Autenticación de Usuarios — Java 17 + Maven + Arquitectura por capas*
