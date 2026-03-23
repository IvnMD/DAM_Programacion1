# 🎓 Guía de Examen: Sistema de Autenticación de Usuarios en Java
### Análisis completo de arquitectura, flujo, interfaces, validaciones y login

---

## 📋 Índice

1. [Visión global del sistema](#vision-global)
2. [La arquitectura por capas: qué es y por qué existe](#arquitectura)
3. [Las interfaces: el concepto más importante para el examen](#interfaces)
4. [El modelo de datos: Persona y Usuario](#modelo)
5. [Dónde y cómo se valida cada dato](#validaciones)
6. [Cómo se guardan los usuarios: el Repository](#repository)
7. [La capa Service: dónde vive la lógica de negocio](#service)
8. [El flujo de registro paso a paso](#flujo-registro)
9. [El flujo de login paso a paso](#flujo-login)
10. [La regla de los 3 intentos y el bloqueo](#bloqueo)
11. [Optional: por qué se usa y qué significa](#optional)
12. [equals() y hashCode() en Usuario: por qué son críticos](#equals)
13. [El Main: qué hace y qué NO hace](#main)
14. [Maven y el pom.xml: qué aporta al proyecto](#maven)
15. [Qué está bien diseñado y qué podrías cuestionar](#critica)
16. [Preguntas tipo examen con respuestas](#preguntas)

---

## 1. 🗺️ Visión global del sistema {#vision-global}

Este proyecto es una aplicación de consola que simula un sistema de autenticación: registro de usuarios, inicio de sesión con control de intentos fallidos y bloqueo. Técnicamente no hay base de datos: todo vive en memoria mientras el programa está corriendo.

Lo verdaderamente importante de este proyecto no es lo que hace (es simple), sino **cómo está organizado**. La arquitectura es una versión didáctica de los patrones que se usan en aplicaciones profesionales reales: Spring Boot, sistemas bancarios, aplicaciones empresariales. Aprende la estructura aquí y la reconocerás en cualquier proyecto Java profesional.

**Las piezas del sistema y su relación:**

```
USUARIO (por teclado)
       │
       ▼
   Main.java  ←── solo habla con interfaces de servicio
       │
       ├──▶ IAuthService ──▶ AuthServiceImpl
       │                          │
       └──▶ IUserService ──▶ UserServiceImpl
                                  │
                                  ▼
                         IUserRepository ──▶ UserRepositoryImpl
                                                    │
                                                    ▼
                                           Map/Set en memoria
```

**Fíjate en algo fundamental:** las flechas apuntan siempre de capas "externas" hacia capas "internas", y siempre apuntan a INTERFACES (no a implementaciones concretas). Esto es el núcleo del diseño.

---

## 2. 🏗️ La arquitectura por capas: qué es y por qué existe {#arquitectura}

Una arquitectura por capas divide el sistema en zonas con responsabilidades bien delimitadas. Cada capa solo puede comunicarse con la capa inmediatamente inferior. Ninguna capa "salta" capas.

### Las capas de este proyecto

**app (Main):** Es la capa más externa. La única que interactúa con el usuario humano. Lee texto del teclado, muestra mensajes por pantalla. No contiene ninguna lógica de negocio. No sabe qué es una colección, no sabe cómo se valida un email, no sabe cuántos intentos de login se permiten. Solo llama a servicios.

**model (Persona, Usuario):** Representa las entidades del mundo real. Define qué datos tiene un usuario y las reglas básicas de coherencia de esos datos (que el email tenga formato válido, que la contraseña tenga longitud mínima). No sabe que existe un menú, ni un repositorio, ni reglas de negocio complejas.

**util (Validaciones):** Herramientas transversales que cualquier capa puede usar. Métodos estáticos puros: entran datos, salen resultados. No tienen estado, no dependen de nada.

**repository (IUserRepository + impl):** Responsable de almacenar y recuperar datos. Es el único que sabe cómo están guardados los usuarios (en un Map, en un Set, en una base de datos...). Ni sabe qué es el login ni qué es el bloqueo. Solo hace CRUD: guardar, buscar, eliminar.

**service (IAuthService, IUserService + impls):** Es el cerebro. Aquí viven las reglas de negocio: qué pasa cuando el login falla tres veces, cómo se registra un usuario, cómo se busca. Usa el repositorio para acceder a datos y util para validar. No sabe nada del menú ni de cómo se muestran los datos por pantalla.

### Por qué esta separación importa

Si cambias cómo se guardan los usuarios (de memoria a base de datos), solo tocas `UserRepositoryImpl`. Las capas superiores no se enteran.

Si cambias las reglas del login (de 3 intentos a 5), solo tocas `AuthServiceImpl`. El resto del código no cambia.

Si cambias el menú (de consola a interfaz gráfica), solo tocas `Main`. Las capas inferiores no cambian.

Esta propiedad se llama **bajo acoplamiento** y es uno de los principios de diseño más importantes en ingeniería del software.

---

## 3. 🔌 Las interfaces: el concepto más importante para el examen {#interfaces}

Este proyecto introduce las interfaces, que no estaban en la práctica anterior del centro educativo. Son el concepto central de esta arquitectura y probablemente lo que más se pregunte en el examen.

### ¿Qué es una interfaz?

Una interfaz es un **contrato**. Define qué métodos deben existir, pero no cómo están implementados. Es una lista de firmas de métodos sin cuerpo.

La diferencia fundamental con una clase abstracta:
- Una clase abstracta puede tener atributos, constructores, y métodos con implementación parcial. Representa una relación "es un tipo de".
- Una interfaz solo tiene firmas de métodos (y constantes). Representa una capacidad o un contrato: "quien implemente esto, garantiza poder hacer estas cosas".

En Java, una clase puede extender solo UNA clase (herencia simple), pero puede implementar MÚLTIPLES interfaces.

### Las interfaces de este proyecto

**IUserRepository:** Define el contrato de almacenamiento. Quien lo implemente debe poder guardar usuarios, buscar por email, comprobar si existe, listar todos y eliminar. No dice nada sobre cómo hacerlo.

**IUserService:** Define el contrato de gestión de usuarios. Quien lo implemente debe poder crear usuarios, listarlos, buscar por email, eliminar y opcionalmente cambiar datos.

**IAuthService:** Define el contrato de autenticación. Quien lo implemente debe poder registrar usuarios y gestionar el login con sus reglas de seguridad.

### implements: cómo una clase "firma" el contrato

Cuando una clase escribe `implements IUserRepository`, está diciendo: "yo me comprometo a proporcionar una implementación real de todos los métodos que IUserRepository declara". Si olvidas implementar aunque sea un método de la interfaz, el compilador te da error.

### La inyección de dependencias por constructor

Este patrón es fundamental para entender el proyecto. `UserServiceImpl` necesita un repositorio para funcionar, pero no crea uno internamente. Lo recibe en su constructor:

```
UserServiceImpl tiene un campo: private final IUserRepository repo;
Su constructor recibe un IUserRepository y lo asigna a ese campo.
```

¿Por qué recibe la interfaz y no la implementación concreta (`UserRepositoryImpl`)? Porque así `UserServiceImpl` no sabe (ni le importa) si el repositorio guarda en memoria, en una base de datos, en un archivo o en la nube. Solo sabe que el objeto que recibe cumple el contrato de `IUserRepository`. Mañana podrías crear `DatabaseRepositoryImpl` que guarde en MySQL, pasárselo al servicio en el constructor, y el servicio funcionaría sin cambiar una sola línea.

### El momento de "conectar las piezas" ocurre en Main

Es el único lugar donde se crean las implementaciones concretas y se conectan:

```
Se crea UserRepositoryImpl concreto
Se pasa al constructor de UserServiceImpl
Se pasa al constructor de AuthServiceImpl
Ambos servicios se usan en el menú
```

Todo el resto del código trabaja con interfaces. Solo Main conoce las implementaciones concretas. Esto se llama **inversión de dependencias**.

### Diferencia entre interfaz y clase abstracta en este proyecto

`Persona` es clase abstracta: tiene atributos reales (`id`, `nombre`), constructor que inicializa esos atributos, y métodos concretos como `getId()`. Representa una entidad parcialmente implementada.

`IUserRepository` es interfaz: solo declara firmas de métodos. No tiene estado ni implementación. Representa un contrato de comportamiento.

Podrías preguntarte: ¿por qué `IAuthService` es interfaz y no clase abstracta? Porque el objetivo no es compartir código, sino definir un contrato que distintas implementaciones puedan cumplir de formas diferentes. Si en el futuro quisieras tener `AuthServiceOAuth2Impl` para autenticación con Google, o `AuthServiceLDAPImpl` para autenticación corporativa, ambas implementarían `IAuthService` y el resto del sistema las trataría igual.

---

## 4. 👤 El modelo de datos: Persona y Usuario {#modelo}

### Persona (clase abstracta)

Es la base común. Contiene solo lo verdaderamente genérico: `id` y `nombre`. Estos campos podrían pertenecer a cualquier entidad del sistema (un empleado, un cliente, un alumno). Persona no sabe nada de emails, passwords ni bloqueos: eso es específico de los usuarios de autenticación.

Sus campos son `protected` (no `private`), lo que significa que la subclase `Usuario` puede acceder a ellos directamente. Esto es una decisión de diseño discutible pero práctica en contextos educativos.

Tiene constructores que validan las precondiciones básicas: el `id` debe ser positivo, el `nombre` debe tener al menos 5 caracteres. Tiene `getId()`, `getNombre()`, `setNombre()` con validación, y `toString()` abstracto o concreto.

No se puede instanciar directamente: `new Persona(...)` daría error de compilación.

### Usuario (extiende Persona)

Añade todo lo específico de la autenticación:

`email` es `final`: una vez creado el usuario, su email no cambia. Es el identificador único del usuario en el sistema. Por eso `equals()` y `hashCode()` se basan en el email.

`password` no es `final`: se puede cambiar. El setter valida que cumpla las reglas mínimas.

`intentosFallidos` y `bloqueado` son el estado de seguridad del usuario. El modelo los tiene, pero la lógica de cuándo incrementar o cuándo bloquear NO está en el modelo: está en el servicio. El modelo solo expone operaciones atómicas: `incrementarIntentosFallidos()`, `resetearIntentosFallidos()`, `bloquear()`. Decidir cuándo llamar a esas operaciones es responsabilidad del servicio.

`fechaRegistro` es `final` e inmutable: se fija en el constructor como `LocalDate.now()` y nunca cambia.

### Una decisión de diseño importante: dónde va el equals()

El README dice explícitamente que reflexiones en qué clase usas `id` para `equals/hashCode` y en cuál `email`. La respuesta que propone el documento:

En `Persona` podrías basar `equals/hashCode` en `id` (dos personas son iguales si tienen el mismo id).
En `Usuario` sobreescribes `equals/hashCode` para basarlo en `email` (dos usuarios son iguales si tienen el mismo email).

¿Por qué email en Usuario? Porque el repositorio usa `Set<Usuario>` o `Map<String, Usuario>`. Si dos usuarios con diferente `id` pero el mismo `email` se considerasen distintos por el `equals` basado en `id`, podrías meter dos usuarios con el mismo email en el Set, violando la unicidad del email. Al basar el `equals` de `Usuario` en el email, el `Set` automáticamente rechaza duplicados por email.

### toString() sin password

El `toString()` de `Usuario` NO debe mostrar la contraseña. En los listados del menú, ver la contraseña de un usuario sería una brecha de seguridad gravísima incluso en una aplicación de prácticas. Muestra: id, nombre, email, estado (bloqueado o no), intentos fallidos, fecha de registro.

---

## 5. ✅ Dónde y cómo se valida cada dato {#validaciones}

La validación en este sistema ocurre en tres niveles distintos y complementarios. Entender dónde ocurre cada tipo de validación es fundamental.

### Nivel 1: Validaciones.java (util)

Es la capa más baja de validación. Solo comprueba reglas de formato independientes del contexto. No sabe si el email ya existe en el sistema, no sabe si el usuario está bloqueado. Solo sabe si un String tiene el formato correcto.

`emailValido(String email)`: aplica un patrón RegEx. Devuelve `boolean`.
`passwordValida(String password)`: comprueba longitud mínima. Devuelve `boolean`.
`normalizarEmail(String email)`: aplica `trim()` y `toLowerCase()`. Devuelve el String normalizado.
`validarNombre(String nombre)`: si el nombre es inválido, lanza `IllegalArgumentException`. No devuelve nada.
`validarEmail(String email)`: si el email es inválido, lanza `IllegalArgumentException`.
`validarPassword(String password)`: si la password es inválida, lanza `IllegalArgumentException`.

La distinción entre los métodos que devuelven `boolean` y los que lanzan excepción es intencional y elegante: los `boolean` sirven para hacer comprobaciones condicionales, los que lanzan excepción sirven para usarlos directamente en constructores y setters donde quieres que la excepción se propague si algo falla.

### Nivel 2: Constructores y setters de Usuario

El constructor de `Usuario` llama a los métodos `validar...` de `Validaciones`. Si cualquier validación falla, la excepción se propaga y el objeto `Usuario` nunca llega a existir. Adicionalmente, el constructor normaliza el email antes de guardarlo.

Los setters (`setPassword`, `setNombre`) también validan antes de asignar.

### Nivel 3: Métodos de servicio

Aquí se validan las reglas que dependen del estado del sistema, no solo del formato de los datos:

En `UserServiceImpl.crearUsuario()`: después de validar el formato (ya lo haría el constructor de Usuario al crearlo), llama al repositorio para comprobar si el email ya existe. Si existe, lanza excepción. Esta validación no puede estar en el constructor de `Usuario` porque `Usuario` no sabe nada del repositorio.

En `AuthServiceImpl.login()`: valida que el usuario exista, que no esté bloqueado, y que la contraseña sea correcta. Estas son reglas de negocio que pertenecen al servicio de autenticación.

### La cadena completa de validación para un registro

```
Main recoge email del teclado (String crudo)
  │
  ▼
Main llama a authService.register(id, nombre, email, password)
  │
  ▼
AuthServiceImpl llama a userService.crearUsuario(...)
  │                  o directamente crea Usuario y llama a repo.save()
  ▼
Se intenta crear new Usuario(id, nombre, email, password)
  │  El constructor llama a Validaciones.validarEmail(email) → ¿formato?
  │  El constructor llama a Validaciones.validarPassword(password) → ¿longitud?
  │  El constructor llama a Validaciones.validarNombre(nombre) → ¿longitud?
  │  Si algo falla → IllegalArgumentException se propaga hacia arriba
  ▼
Si el objeto se crea bien, el servicio llama a repo.existsByEmail(email)
  │  Si ya existe → IllegalArgumentException: email duplicado
  ▼
Si no existe, repo.save(usuario)
  │
  ▼
El usuario queda guardado en memoria
```

---

## 6. 🗄️ Cómo se guardan los usuarios: el Repository {#repository}

### La interfaz IUserRepository

Define el contrato sin decir nada sobre la implementación:

`void save(Usuario usuario)`: almacena un usuario. Si el email ya existe, lanza excepción.
`Optional<Usuario> findByEmail(String email)`: busca por email. Devuelve Optional porque el usuario puede no existir.
`boolean existsByEmail(String email)`: comprobación de existencia rápida.
`Set<Usuario> findAll()`: devuelve todos los usuarios.
`boolean deleteByEmail(String email)`: elimina y devuelve si encontró algo que eliminar.

Importante: todos los métodos que reciben un email deben normalizarlo internamente antes de usarlo, porque quien llama puede pasar el email con espacios o mayúsculas.

### UserRepositoryImpl: la implementación en memoria

**Opción A con Map:** `Map<String, Usuario>` donde la clave es el email normalizado.

Esta es la opción más eficiente y clara. `save` hace `put(email, usuario)`. `findByEmail` hace `get(email)`. `existsByEmail` hace `containsKey(email)`. `deleteByEmail` hace `remove(email)`. Todas estas operaciones son O(1) en un `HashMap`. La unicidad de email está garantizada automáticamente porque las claves de un Map son únicas: si haces `put` con la misma clave dos veces, el segundo sobreescribe al primero (por eso `save` debe comprobar primero con `existsByEmail` y lanzar excepción si ya existe).

**Opción B con Set:** `Set<Usuario>` donde la unicidad se basa en `equals/hashCode` de `Usuario` (que están basados en email).

Más elegante conceptualmente pero menos eficiente: buscar en un `HashSet` por email requiere crear un objeto `Usuario` "ficticio" solo para la búsqueda (o iterar). Por eso el Map es la opción preferida en la práctica.

### Por qué el repositorio no tiene lógica de negocio

El repositorio es intencionalmente "tonto". Si mañana decides guardar los usuarios en una base de datos MySQL, creas `MySQLUserRepositoryImpl` y lo conectas en Main. El servicio no cambia porque el servicio habla con la interfaz `IUserRepository`, no con la implementación concreta.

Si el repositorio tuviera lógica de negocio (reglas de bloqueo, gestión de intentos), tendrías que replicar esa lógica en cada implementación. Al mantener el repositorio limpio, la lógica vive solo en el servicio y se aplica independientemente de dónde se guarden los datos.

---

## 7. ⚙️ La capa Service: dónde vive la lógica de negocio {#service}

### IUserService y UserServiceImpl: gestión de usuarios (CRUD)

`UserServiceImpl` recibe un `IUserRepository` en su constructor y lo guarda como campo `final`. Todos sus métodos delegan en el repositorio después de aplicar validaciones o transformaciones.

`crearUsuario`: crea el objeto `Usuario` (lo que dispara las validaciones del constructor), verifica unicidad de email en el repo, y guarda. Este método es el punto de entrada para el registro de usuarios desde el servicio de autenticación.

`listarUsuarios`: simplemente llama a `repo.findAll()`.

`buscarPorEmail`: llama a `repo.findByEmail()`. Devuelve `Optional<Usuario>`.

`eliminarPorEmail`: llama a `repo.deleteByEmail()`. Devuelve boolean.

### IAuthService y AuthServiceImpl: lógica de autenticación

`AuthServiceImpl` es la clase más "inteligente" del sistema. Aquí viven las reglas de negocio complejas.

`register`: puede delegar completamente en `userService.crearUsuario()` si tiene `IUserService` inyectado, o puede usar el repo directamente si tiene `IUserRepository`. La primera opción es más pura arquitectónicamente (no duplica la lógica de creación), la segunda es más simple de implementar.

`login`: contiene la lógica más compleja del sistema. Se explica en detalle en la sección de flujo de login.

### La pregunta de qué depende AuthServiceImpl

El documento ofrece dos opciones:
- Que `AuthServiceImpl` dependa de `IUserRepository` directamente.
- Que dependa de `IUserService`.

La segunda opción es más correcta arquitectónicamente: la gestión de usuarios (CRUD) ya está encapsulada en `IUserService`, y el servicio de autenticación debería usar esa abstracción en lugar de ir directamente al repositorio. Sin embargo, para el login necesita acceder al objeto `Usuario` y modificar su estado (incrementar intentos, bloquear), lo que es más natural con acceso al repositorio. En la práctica educativa, ambas opciones son aceptables.

---

## 8. 📝 El flujo de registro paso a paso {#flujo-registro}

Vamos a trazar exactamente qué ocurre cuando el usuario del programa elige "Registrar" en el menú:

**1.** Main llama a `registrar(authService)`.

**2.** `registrar()` en Main pide por teclado: nombre, email, password. Lee con `Scanner.nextLine()`.

**3.** Main llama a `authService.register(id, nombre, email, password)`. El `id` puede ser generado automáticamente (un contador estático, o basado en el tamaño del repositorio) o pedido al usuario.

**4.** `AuthServiceImpl.register()` recibe los datos crudos. Puede normalizar el email aquí, o confiar en que el constructor de `Usuario` lo hará. Lo recomendable es que la normalización ocurra en `Validaciones.normalizarEmail()` y se aplique en el constructor de `Usuario`.

**5.** `AuthServiceImpl` intenta crear `new Usuario(id, nombre, email, password)`. El constructor de `Usuario` llama a `super(id, nombre)` que valida id y nombre. Luego valida email con `Validaciones.validarEmail()` y password con `Validaciones.validarPassword()`. Si cualquier validación falla, se lanza `IllegalArgumentException` y la ejecución vuelve hasta el `try-catch` en Main.

**6.** Si el objeto `Usuario` se creó correctamente, `AuthServiceImpl` llama a `userService.crearUsuario()` o directamente a `repo.existsByEmail(email)`. Si el email ya existe, lanza `IllegalArgumentException("Email ya registrado")`.

**7.** Si no existe, llama a `repo.save(usuario)`. El repositorio guarda el usuario en el Map o Set.

**8.** El método devuelve el `Usuario` creado (o `void`, según implementación).

**9.** Main captura el resultado y muestra "Usuario registrado correctamente" o, si hubo excepción, muestra el mensaje de error y vuelve al menú.

---

## 9. 🔑 El flujo de login paso a paso {#flujo-login}

Este es el flujo más importante y el que más probabilidades tiene de aparecer en el examen.

**1.** Main llama a `login(authService)`.

**2.** `login()` en Main pide email y password por teclado.

**3.** Main llama a `authService.login(email, password)`.

**4.** `AuthServiceImpl.login()` comienza:

**4.1.** Normaliza el email: `Validaciones.normalizarEmail(email)`.

**4.2.** Busca el usuario en el repositorio: `repo.findByEmail(emailNormalizado)`. Esto devuelve un `Optional<Usuario>`.

**4.3.** Si el Optional está vacío (usuario no existe): devuelve `false` sin más. No da información de si el email existe o no por razones de seguridad.

**4.4.** Si el usuario existe, extrae el objeto: `usuario = optional.get()`.

**4.5.** Comprueba si está bloqueado: `usuario.isBloqueado()`. Si está bloqueado, devuelve `false` inmediatamente (y podría lanzar una excepción o devolver un mensaje indicando que está bloqueado).

**4.6.** Compara la contraseña: `usuario.getPassword().equals(password)`.

**4.7.** Si la contraseña es INCORRECTA:
- Llama a `usuario.incrementarIntentosFallidos()`.
- Comprueba si ahora los intentos son >= 3: `usuario.getIntentosFallidos() >= 3`.
- Si es así, llama a `usuario.bloquear()`.
- Actualiza el usuario en el repositorio (en el Map, el objeto se modifica por referencia, así que no hace falta actualizar explícitamente si modificas el objeto directamente; si usas `Set`, puede necesitar remove + add).
- Devuelve `false`.

**4.8.** Si la contraseña es CORRECTA:
- Llama a `usuario.resetearIntentosFallidos()`.
- Devuelve `true`.

**5.** Main recibe `true` o `false` y muestra el mensaje correspondiente.

### Una sutileza importante sobre el Map vs Set en el login

Con `Map<String, Usuario>`: cuando obtienes el usuario con `map.get(email)`, tienes una referencia directa al objeto guardado en el Map. Cuando llamas `usuario.incrementarIntentosFallidos()`, estás modificando el objeto que está guardado en el Map. Los cambios persisten automáticamente sin tener que volver a hacer `put`.

Con `Set<Usuario>`: similar, obtienes referencia directa al objeto del Set. Los cambios en el objeto se reflejan en el Set. Sin embargo, hay una trampa: si modificas un campo que forma parte del `hashCode()` (el email), el objeto puede "perderse" en el Set. Como el login no modifica el email, esto no es un problema aquí.

---

## 10. 🔒 La regla de los 3 intentos y el bloqueo {#bloqueo}

Esta regla es un ejemplo perfecto de por qué la lógica de negocio está en el servicio y no en el modelo.

### Quién hace qué

**El modelo (Usuario)** expone operaciones atómicas simples:
- `incrementarIntentosFallidos()`: suma 1 al contador. No decide cuándo bloquear.
- `resetearIntentosFallidos()`: pone el contador a 0. No decide cuándo llamarse.
- `bloquear()`: pone `bloqueado = true`. No decide cuándo bloquearse.
- `isBloqueado()`: devuelve el estado. No toma decisiones.

El modelo es intencionalmente "pasivo" en este aspecto: expone los botones pero no decide cuándo pulsarlos.

**El servicio (AuthServiceImpl)** aplica la regla de negocio:
- Tras un fallo, incrementa el contador llamando al método del modelo.
- Tras incrementar, evalúa si el contador llegó a 3.
- Si llegó a 3, llama al método `bloquear()` del modelo.

¿Por qué esta separación? Si la regla estuviera en el modelo (`incrementarIntentosFallidos()` bloqueara automáticamente al tercer intento), sería imposible tener diferentes reglas para diferentes tipos de sistemas. En un sistema bancario podrías querer bloquear al segundo intento. En otro sistema podrías querer mandar un email de aviso al segundo intento y bloquear al quinto. Con la lógica en el servicio, cambias la regla en un único lugar sin tocar el modelo.

### Estados posibles de un usuario

Un usuario puede estar en uno de estos estados:
- **Normal:** `intentosFallidos = 0`, `bloqueado = false`. Puede hacer login.
- **Con intentos fallidos:** `intentosFallidos entre 1 y 2`, `bloqueado = false`. Puede hacer login pero está "en alerta".
- **Bloqueado:** `bloqueado = true`. No puede hacer login independientemente de los intentos y de que la contraseña sea correcta.
- **Bloqueado con reset:** si se implementa el desbloqueo manual, `bloqueado = false`, `intentosFallidos = 0`. Puede volver a hacer login.

---

## 11. 📦 Optional: por qué se usa y qué significa {#optional}

`Optional<T>` es una clase de Java 8+ que representa un valor que puede estar presente o no. Es una alternativa más explícita y segura a devolver `null`.

### Por qué findByEmail devuelve Optional y no null

Si `findByEmail` devolviera `Usuario` directamente y devolviera `null` cuando no encuentra, quien llame al método podría olvidar comprobar el null y obtener `NullPointerException`. Con `Optional`, el compilador no te deja usar el valor sin comprobarlo primero (o al menos, te lo hace explícito).

### Métodos útiles de Optional

`optional.isPresent()`: devuelve `true` si hay valor, `false` si está vacío.
`optional.isEmpty()`: lo contrario (Java 11+).
`optional.get()`: devuelve el valor. Lanza excepción si está vacío. Nunca uses `get()` sin comprobar antes `isPresent()`.
`optional.orElse(valorPorDefecto)`: devuelve el valor si existe, o el valor por defecto si no.
`optional.orElseThrow(() -> new ExcepcionPersonalizada())`: devuelve el valor o lanza la excepción que especifiques.

### En el flujo de login

```
Optional<Usuario> optUsuario = repo.findByEmail(email);
if (optUsuario.isEmpty()) {
    return false;  // usuario no existe
}
Usuario usuario = optUsuario.get();  // seguro: ya comprobamos que existe
```

---

## 12. ⚖️ equals() y hashCode() en Usuario: por qué son críticos {#equals}

### La relación con el Set y el Map

Si usas `Set<Usuario>` para almacenar usuarios, Java necesita saber cuándo dos objetos `Usuario` son "el mismo usuario". Para eso usa `equals()`. Y para organizar los objetos eficientemente en la estructura hash, usa `hashCode()`.

Si no sobreescribes `equals()`, Java usa la implementación por defecto de `Object`, que compara referencias de memoria: dos objetos distintos con los mismos datos serían "diferentes". Esto significaría que podrías registrar el mismo email dos veces en el Set, porque Java no detectaría que son "el mismo usuario".

### La decisión: igualdad basada en email

En `Usuario`, dos usuarios son "el mismo" si tienen el mismo email normalizado. El email es el identificador único de negocio. Por eso:

`equals()` compara los emails normalizados de ambos objetos.
`hashCode()` genera un hash basado en el email normalizado.

### El contrato Java obligatorio

Si `a.equals(b)` es `true`, entonces `a.hashCode() == b.hashCode()` debe ser `true`. Si rompes este contrato, el `HashSet` y el `HashMap` se comportan de forma completamente incorrecta y muy difícil de depurar.

### En Persona vs en Usuario

`Persona` podría basar su `equals` en `id`. Tiene sentido: en el mundo abstracto, dos personas con el mismo id son la misma persona.

`Usuario` sobreescribe ese `equals` con su propio criterio: el email. Esto es polimorfismo de `equals`: el mismo método se comporta diferente según el tipo real del objeto.

---

## 13. 💻 El Main: qué hace y qué NO hace {#main}

### Lo que Main SÍ hace

Gestionar el Scanner para leer del teclado. Mostrar el menú y las opciones. Llamar a los métodos del servicio con los datos recogidos. Capturar excepciones y mostrar mensajes de error al usuario. Controlar el bucle del menú hasta que el usuario elige salir.

### Lo que Main NO hace nunca

NO valida con RegEx. No escribe `Pattern.compile(...)` ni `.matches(...)`. Eso es de `Validaciones`.

NO accede a colecciones. Nunca toca el `Map` o el `Set` de usuarios directamente. Solo llama a servicios.

NO crea objetos `Usuario` directamente con `new Usuario(...)`. Eso lo hace el servicio.

NO implementa reglas de negocio. No tiene lógica de "si 3 intentos entonces bloquear". Eso es de `AuthServiceImpl`.

NO conoce las implementaciones concretas de los servicios excepto en el momento de inicialización, donde crea los objetos y los conecta.

### La inicialización en Main

```
Al arrancar la aplicación:
1. new UserRepositoryImpl() → implementación concreta del repositorio
2. new UserServiceImpl(repo) → servicio de usuarios con el repo inyectado
3. new AuthServiceImpl(repo o userService) → servicio de auth con sus dependencias
4. El menú usa IAuthService y IUserService (las interfaces, no las implementaciones)
```

---

## 14. 📦 Maven y el pom.xml: qué aporta al proyecto {#maven}

Maven es una herramienta de construcción y gestión de dependencias para proyectos Java. El `pom.xml` (Project Object Model) es su archivo de configuración.

### Lo que dice el pom.xml de este proyecto

`groupId: com.docencia`: el identificador de la organización. Coincide con el paquete raíz del código.

`artifactId: tarea-calificacble-4-3`: el nombre único del proyecto.

`version: 1.0.0`: la versión del proyecto.

`maven.compiler.source/target: 17`: el proyecto usa Java 17. Esto es importante: características como `switch` con flechas y métodos de `Optional` como `isEmpty()` requieren Java 11+.

`junit-jupiter: 5.10.2`: JUnit 5 está incluido como dependencia de test. Esto significa que el proyecto tiene (o puede tener) tests automatizados. `mvn clean test` ejecuta todos los tests.

`maven-surefire-plugin`: plugin que Maven usa para ejecutar los tests. La configuración `useModulePath: false` desactiva el sistema de módulos de Java, lo que simplifica la configuración para proyectos educativos.

### El ciclo de vida de Maven

`mvn clean`: borra los archivos compilados anteriores (carpeta `target`).
`mvn compile`: compila el código fuente.
`mvn test`: ejecuta los tests.
`mvn clean test`: la combinación habitual: borra compilados anteriores y vuelve a compilar y testar desde cero.
`mvn package`: empaqueta el proyecto en un JAR ejecutable.

---

## 15. 🔍 Qué está bien diseñado y qué podrías cuestionar {#critica}

### Lo que está muy bien diseñado

La separación de interfaces e implementaciones es correcta y coherente. Cada capa tiene una responsabilidad clara. La distinción entre métodos `boolean` y métodos `void validar...` en `Validaciones` es elegante. La decisión de que el modelo solo exponga operaciones atómicas (incrementar, resetear, bloquear) y que el servicio decida cuándo usarlas es arquitectónicamente correcta. El uso de `Optional` en lugar de `null` en las búsquedas es una buena práctica moderna.

### Puntos que podrías cuestionar o mejorar

**La clase Persona tiene campos `protected` en lugar de `private`:** Esto permite que `Usuario` los acceda directamente sin pasar por los getters. Funciona, pero viola estrictamente la encapsulación. La versión más pura sería `private` con acceso solo mediante getters.

**El `id` se pasa como parámetro desde fuera:** En una aplicación real, el id lo generaría el repositorio o la base de datos automáticamente. Dejar que Main lo pida al usuario o que el servicio lo gestione con un contador son opciones razonables para una práctica educativa.

**AuthServiceImpl podría depender de IUserService o de IUserRepository:** Ambas opciones son válidas pero tienen implicaciones diferentes. Si depende de `IUserService`, hay mayor separación de capas. Si depende de `IUserRepository` directamente, hay acceso más directo para modificar el estado del usuario (necesario en el login).

**No hay gestión de sesión real:** El sistema no mantiene "quién está logueado" entre operaciones del menú. En un sistema real habría un objeto de sesión o un token. Para una práctica educativa es aceptable.

---

## 16. 📝 Preguntas tipo examen con respuestas {#preguntas}

**P: ¿Qué es una interfaz y en qué se diferencia de una clase abstracta?**

R: Una interfaz define un contrato de métodos sin implementación (solo firmas). Una clase abstracta puede tener atributos, constructores, y métodos con implementación parcial. Una clase puede implementar múltiples interfaces pero solo puede extender una clase. Las interfaces representan capacidades o contratos; las clases abstractas representan entidades parcialmente definidas.

**P: ¿Por qué Main no accede directamente al repositorio?**

R: Porque Main es la capa de presentación y no debe conocer los detalles de almacenamiento. Solo conoce los contratos de servicio (interfaces). Esto permite cambiar la implementación de almacenamiento sin modificar Main.

**P: ¿Por qué equals() y hashCode() de Usuario se basan en el email y no en el id?**

R: Porque el email es el identificador único de negocio del usuario. Si el Set o Map usa equals basado en id, dos usuarios con diferente id pero el mismo email serían considerados diferentes, permitiendo registrar el mismo email dos veces.

**P: ¿Quién decide bloquear al usuario tras 3 intentos, el modelo o el servicio?**

R: El servicio (AuthServiceImpl). El modelo solo expone `incrementarIntentosFallidos()` y `bloquear()` como operaciones atómicas. El servicio evalúa la condición (intentos >= 3) y llama a `bloquear()` cuando corresponde. Esto permite cambiar la regla (ej: bloquear al 5º intento) sin tocar el modelo.

**P: ¿Qué devuelve findByEmail y por qué usa Optional?**

R: Devuelve `Optional<Usuario>`. Usa Optional porque el usuario puede no existir, y Optional obliga a quien llama a gestionar explícitamente ese caso, evitando NullPointerException. Si devolviera null, el programador podría olvidar comprobar el null.

**P: ¿En qué se diferencia UserServiceImpl de AuthServiceImpl?**

R: UserServiceImpl gestiona el CRUD de usuarios (crear, listar, buscar, eliminar). No tiene reglas de autenticación. AuthServiceImpl gestiona el acceso al sistema: registro (puede delegar en UserService) y login con reglas de seguridad (intentos fallidos, bloqueo). Son responsabilidades distintas separadas en clases distintas.

**P: ¿Qué es la inyección de dependencias y cómo se aplica en este proyecto?**

R: Es el patrón por el que un objeto no crea sus dependencias sino que las recibe del exterior (normalmente en el constructor). En este proyecto, UserServiceImpl recibe un IUserRepository en su constructor en lugar de crear un UserRepositoryImpl internamente. Esto desacopla la implementación: el servicio no sabe qué implementación concreta de repositorio tiene, solo sabe que cumple el contrato de IUserRepository.

**P: ¿Por qué Validaciones tiene métodos estáticos?**

R: Porque no tiene estado propio (no guarda datos entre llamadas) y sus funciones son herramientas puramente funcionales: entran datos, sale un resultado. No tiene sentido crear instancias de una clase así. Los métodos estáticos se llaman directamente con el nombre de la clase sin crear objetos.

**P: ¿Qué pasaría si AuthServiceImpl creara directamente un UserRepositoryImpl en lugar de recibirlo por constructor?**

R: Se crearía un acoplamiento fuerte. AuthServiceImpl sabría exactamente qué implementación de repositorio usar y no podría cambiarse por otra. Los tests serían más difíciles porque no podrías pasar un repositorio "simulado" (mock). Recibirlo por constructor (inyección de dependencias) mantiene el código flexible y testeable.

**P: ¿Puede Persona instanciarse directamente?**

R: No. Está declarada como `abstract`. Intentar `new Persona(...)` daría error de compilación. Solo puede instanciarse a través de sus subclases concretas, como `Usuario`.

**P: ¿Dónde se normaliza el email y por qué es importante?**

R: En el constructor de Usuario (llamando a `Validaciones.normalizarEmail()`) y en todos los métodos del repositorio que reciben un email como parámetro. Es importante porque sin normalización, `"Ana@EJEMPLO.COM"`, `" ana@ejemplo.com"` y `"ana@ejemplo.com"` serían considerados emails diferentes, permitiendo registrar el mismo email múltiples veces con variantes de capitalización o espacios.

---

## 🎯 Resumen visual de responsabilidades

```
┌─────────────────────────────────────────────────────────────────┐
│ CAPA          │ CLASE               │ RESPONSABILIDAD            │
├─────────────────────────────────────────────────────────────────┤
│ app           │ Main                │ Menú, Scanner, mensajes    │
├─────────────────────────────────────────────────────────────────┤
│ model         │ Persona             │ id, nombre, reglas básicas │
│               │ Usuario             │ email, password, bloqueo   │
├─────────────────────────────────────────────────────────────────┤
│ util          │ Validaciones        │ RegEx, formato, normalizar │
├─────────────────────────────────────────────────────────────────┤
│ repository    │ IUserRepository     │ Contrato de almacenamiento │
│               │ UserRepositoryImpl  │ Map/Set en memoria         │
├─────────────────────────────────────────────────────────────────┤
│ service       │ IUserService        │ Contrato CRUD usuarios     │
│               │ UserServiceImpl     │ CRUD usando repo           │
│               │ IAuthService        │ Contrato autenticación     │
│               │ AuthServiceImpl     │ Login, bloqueo, registro   │
└─────────────────────────────────────────────────────────────────┘
```

```
┌─────────────────────────────────────────────────────────────────┐
│ VALIDACIÓN     │ TIPO                │ DÓNDE                     │
├─────────────────────────────────────────────────────────────────┤
│ Formato email  │ RegEx               │ Validaciones.emailValido  │
│ Longitud pass  │ Longitud String     │ Validaciones.passwordVal. │
│ Longitud nombre│ Longitud String     │ Validaciones.validarNomb. │
│ Obj no nulo    │ null check          │ Constructores y setters   │
│ Email único    │ Estado del sistema  │ UserServiceImpl / repo    │
│ Usuario existe │ Estado del sistema  │ AuthServiceImpl (login)   │
│ No bloqueado   │ Estado del usuario  │ AuthServiceImpl (login)   │
└─────────────────────────────────────────────────────────────────┘
```

---

*Guía preparada para examen de teoría — Sistema de Autenticación de Usuarios — Java 17 + Maven*
