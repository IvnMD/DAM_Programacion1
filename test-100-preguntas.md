# 📝 Examen Tipo Test — 100 Preguntas
## Java · POO · Arquitectura · Colecciones · RegEx · Fechas · Recursividad · JDBC

> **Instrucciones:** Una sola respuesta correcta por pregunta. Las respuestas están al final. Cronométrate: en un examen real tendrías 90 minutos para 100 preguntas.

---

## 🔵 BLOQUE A — Fundamentos de Java (preguntas 1–15)

**1.** ¿Cuál es el tipo de dato correcto para almacenar un número entero en Java?

A) `float`
B) `double`
C) `int`
D) `char`

---

**2.** ¿Qué imprime el siguiente código?
```
int x = 5;
int y = 2;
System.out.println(x / y);
```

A) `2.5`
B) `2`
C) `3`
D) Error de compilación

---

**3.** ¿Cuál de estas declaraciones de variable es INCORRECTA en Java?

A) `int numero = 10;`
B) `String texto = "hola";`
C) `int 1numero = 5;`
D) `boolean activo = true;`

---

**4.** ¿Qué hace el operador `%` en Java?

A) División entera
B) Potencia
C) Resto de la división
D) Raíz cuadrada

---

**5.** ¿Cuál es la diferencia entre `while` y `do-while`?

A) No hay diferencia
B) `do-while` ejecuta el cuerpo al menos una vez; `while` puede no ejecutarlo nunca
C) `while` ejecuta el cuerpo al menos una vez; `do-while` puede no ejecutarlo nunca
D) `do-while` solo funciona con números

---

**6.** ¿Qué estructura de control es más adecuada cuando tienes múltiples casos discretos para una variable?

A) `if-else if` anidado siempre
B) `for`
C) `switch`
D) `while`

---

**7.** En Java, ¿qué valor tiene por defecto una variable de instancia de tipo `int` no inicializada?

A) `null`
B) `1`
C) `-1`
D) `0`

---

**8.** ¿Cuál de estos tipos de datos es un tipo primitivo en Java?

A) `String`
B) `Integer`
C) `boolean`
D) `ArrayList`

---

**9.** ¿Qué hace `Integer.parseInt("42")`?

A) Convierte el número 42 a String
B) Convierte el String `"42"` al entero `42`
C) Comprueba si `"42"` es un número válido
D) Lanza siempre una excepción

---

**10.** ¿Qué excepción lanza `Integer.parseInt("abc")`?

A) `IllegalArgumentException`
B) `NullPointerException`
C) `NumberFormatException`
D) `ArithmeticException`

---

**11.** ¿Cuál es la forma correcta de leer una línea completa de texto con Scanner?

A) `scanner.next()`
B) `scanner.nextLine()`
C) `scanner.read()`
D) `scanner.readLine()`

---

**12.** ¿Qué problema ocurre al mezclar `nextInt()` con `nextLine()` en Scanner?

A) Ninguno, funcionan perfectamente juntos
B) `nextInt()` no consume el salto de línea, y el siguiente `nextLine()` lee una cadena vacía
C) `nextLine()` siempre lanza excepción después de `nextInt()`
D) El Scanner se cierra automáticamente

---

**13.** ¿Qué imprime este código?
```
for (int i = 0; i < 3; i++) {
    System.out.print(i + " ");
}
```

A) `1 2 3`
B) `0 1 2 3`
C) `0 1 2`
D) `1 2`

---

**14.** ¿Qué significa que Java sea un lenguaje fuertemente tipado?

A) Que el código se compila rápidamente
B) Que cada variable tiene un tipo fijo y no puede cambiar
C) Que solo acepta tipos numéricos
D) Que no permite la conversión entre tipos

---

**15.** ¿Qué es `System.out.println()` en Java?

A) Un método de la clase `Scanner`
B) Un método estático que imprime texto y añade un salto de línea
C) Una clase del paquete `java.io`
D) Un método que devuelve un String

---

## 🟢 BLOQUE B — Programación Orientada a Objetos (preguntas 16–35)

**16.** ¿Qué es un objeto en Java?

A) Una variable primitiva
B) Una instancia de una clase
C) Un método estático
D) Un tipo de bucle

---

**17.** ¿Qué es encapsulación?

A) Crear múltiples clases en un mismo archivo
B) Heredar métodos del padre
C) Ocultar los atributos de una clase y acceder a ellos solo mediante métodos
D) Implementar una interfaz

---

**18.** ¿Cuál es el modificador de acceso más restrictivo en Java?

A) `public`
B) `protected`
C) `default` (sin modificador)
D) `private`

---

**19.** ¿Qué ocurre cuando se llama a `new Persona(...)` siendo `Persona` una clase abstracta?

A) Se crea el objeto normalmente
B) Error en tiempo de ejecución
C) Error de compilación
D) Se crea un objeto vacío

---

**20.** ¿Qué palabra clave indica que una clase hereda de otra?

A) `implements`
B) `inherits`
C) `extends`
D) `super`

---

**21.** ¿Qué hace `super()` en el constructor de una subclase?

A) Llama al método `toString()` del padre
B) Crea una copia del objeto padre
C) Invoca al constructor del padre
D) Destruye el objeto padre

---

**22.** ¿En qué posición del constructor de la subclase debe ir `super(...)`?

A) Al final
B) En cualquier posición
C) En la segunda línea
D) Siempre en la primera línea

---

**23.** ¿Qué significa `@Override`?

A) Que el método no puede ser llamado
B) Que el método sobreescribe uno del padre; el compilador verifica que exista
C) Que el método es estático
D) Que el método devuelve un valor distinto al del padre

---

**24.** ¿Cuántas clases puede extender una clase en Java?

A) Sin límite
B) Máximo 2
C) Solo 1
D) Máximo 3

---

**25.** ¿Cuántas interfaces puede implementar una clase en Java?

A) Solo 1
B) Solo 2
C) Sin límite
D) Máximo 5

---

**26.** ¿Qué es polimorfismo?

A) Tener múltiples constructores
B) Que el mismo método se comporte diferente según el tipo real del objeto
C) Heredar de múltiples clases
D) Declarar variables del mismo tipo

---

**27.** Dado `Persona p = new Alumno(...)`, ¿qué método se llama con `p.getTipo()`?

A) El de `Persona`
B) El de `Object`
C) El de `Alumno`
D) Depende del compilador

---

**28.** ¿Qué es necesario hacer antes de llamar a `alumno.getCurso()` si la variable está declarada como `Persona p`?

A) Nada, se puede llamar directamente
B) Llamar a `p.toString()`
C) Verificar con `instanceof` y hacer un cast a `Alumno`
D) Declarar un nuevo objeto

---

**29.** ¿Qué devuelve `p instanceof Alumno` si `p` es un objeto de tipo `Profesor`?

A) `true`
B) `false`
C) Lanza `ClassCastException`
D) Depende de la implementación de `equals()`

---

**30.** ¿Qué es la sobrecarga de constructores?

A) Tener un constructor con demasiados parámetros
B) Tener varios constructores en la misma clase con diferentes parámetros
C) Llamar al constructor del padre desde la subclase
D) Crear constructores privados

---

**31.** ¿Qué significa que un atributo sea `final` en Java?

A) Que es público
B) Que solo puede usarse en métodos estáticos
C) Que debe inicializarse y no puede cambiar después
D) Que se comparte entre todos los objetos de la clase

---

**32.** ¿Cuál de estos NO es un pilar de la POO?

A) Herencia
B) Encapsulación
C) Compilación
D) Polimorfismo

---

**33.** ¿Qué hace un setter con validación correctamente implementado?

A) Asigna el valor sin comprobar nada
B) Valida el valor antes de asignarlo y lanza excepción si es inválido
C) Devuelve el valor actual del atributo
D) Crea una copia del objeto

---

**34.** ¿Qué método de `Object` se llama implícitamente cuando usas `System.out.println(objeto)`?

A) `getClass()`
B) `hashCode()`
C) `toString()`
D) `equals()`

---

**35.** ¿Qué es la agregación en POO?

A) Suma de atributos numéricos
B) Una clase contiene una referencia a otra, pero ambas pueden existir de forma independiente
C) Una clase hereda de otra
D) Una clase implementa una interfaz

---

## 🟡 BLOQUE C — Interfaces y Clases Abstractas (preguntas 36–50)

**36.** ¿Cuál de estas afirmaciones sobre interfaces es CORRECTA?

A) Una interfaz puede tener atributos de instancia con estado
B) Una interfaz puede tener constructores
C) Una interfaz define firmas de métodos que las clases implementadoras deben cumplir
D) Una clase solo puede implementar una interfaz

---

**37.** ¿Cuál es la principal diferencia entre una interfaz y una clase abstracta?

A) La interfaz puede instanciarse; la abstracta no
B) La abstracta puede tener atributos, constructores y métodos con implementación; la interfaz define solo contratos
C) No hay diferencia
D) La interfaz usa `extends`; la abstracta usa `implements`

---

**38.** ¿Qué palabra clave usa una clase para implementar una interfaz?

A) `extends`
B) `inherits`
C) `implements`
D) `override`

---

**39.** Si una clase `implements` una interfaz pero no implementa todos sus métodos, ¿qué ocurre?

A) El programa lanza excepción en ejecución
B) Los métodos no implementados se heredan de `Object`
C) Error de compilación
D) Los métodos quedan vacíos automáticamente

---

**40.** ¿Puede una interfaz extender otra interfaz en Java?

A) No, solo las clases pueden extenderse
B) Sí, usando `extends`
C) Sí, usando `implements`
D) Solo en Java 11+

---

**41.** ¿Qué es un método `default` en una interfaz (Java 8+)?

A) Un método abstracto sin implementación
B) Un método con implementación dentro de la interfaz
C) Un método privado de la interfaz
D) Un método que no puede sobreescribirse

---

**42.** En el proyecto de autenticación, ¿por qué `UserServiceImpl` recibe `IUserRepository` en el constructor en lugar de `UserRepositoryImpl`?

A) Porque `UserRepositoryImpl` no existe todavía
B) Para reducir el número de líneas de código
C) Para desacoplar el servicio de la implementación concreta y permitir cambiarla sin modificar el servicio
D) Porque Java no permite usar implementaciones concretas en constructores

---

**43.** ¿Qué patrón de diseño representa la relación `IUserRepository → UserRepositoryImpl`?

A) Singleton
B) Factory
C) Repository Pattern
D) Observer

---

**44.** ¿Qué ventaja tiene la inyección de dependencias por constructor?

A) Hace el código más lento
B) Elimina la necesidad de interfaces
C) Permite pasar implementaciones distintas (incluyendo mocks para tests) sin cambiar la clase
D) Obliga a usar clases abstractas

---

**45.** En el proyecto del centro educativo, `getTipo()` es un método abstracto en `Persona`. ¿Qué ocurre si `Alumno` no lo implementa?

A) `Alumno` hereda la implementación de `Object`
B) `getTipo()` devuelve null por defecto
C) Error de compilación, a menos que `Alumno` también sea abstracta
D) Se ejecuta la versión de `Persona`

---

**46.** ¿Puede una clase abstracta tener métodos NO abstractos (con implementación)?

A) No, todos sus métodos deben ser abstractos
B) Sí, puede tener tanto métodos abstractos como concretos
C) Solo si implementa una interfaz
D) Solo métodos estáticos pueden tener implementación

---

**47.** ¿Cuál de estas clases NO puede instanciarse directamente?

A) `ArrayList`
B) `String`
C) Una clase declarada `abstract`
D) Una clase con constructor `public`

---

**48.** ¿Qué es el desacoplamiento en el contexto de interfaces?

A) Separar los atributos de los métodos
B) Que las clases no dependan directamente de implementaciones concretas sino de contratos (interfaces)
C) Eliminar la herencia del código
D) Poner cada clase en su propio paquete

---

**49.** Según el principio Single Responsibility Principle, ¿cuántas razones para cambiar debería tener una clase?

A) Las que sean necesarias
B) Ninguna
C) Solo una
D) Máximo tres

---

**50.** En el proyecto de autenticación, ¿qué capa NO debe contener lógica de negocio según la arquitectura?

A) `service`
B) `repository`
C) `model`
D) `app (Main)`

---

## 🟠 BLOQUE D — Colecciones (preguntas 51–62)

**51.** ¿Cuál es la diferencia principal entre `ArrayList` y `HashSet`?

A) `ArrayList` es más rápido en todas las operaciones
B) `ArrayList` permite duplicados y mantiene orden; `HashSet` no permite duplicados y no garantiza orden
C) `HashSet` permite duplicados; `ArrayList` no
D) No hay diferencia funcional

---

**52.** ¿Qué devuelve `hashSet.add(elemento)` si el elemento ya existe en el Set?

A) Lanza `DuplicateException`
B) `true`
C) `false`
D) Sobreescribe el elemento

---

**53.** ¿Cuál es la complejidad temporal de `HashSet.contains()` en el caso promedio?

A) O(n)
B) O(log n)
C) O(1)
D) O(n²)

---

**54.** Si `equals()` de `Usuario` está basado en email y añades dos usuarios con el mismo email a un `HashSet<Usuario>`, ¿cuántos habrá en el Set?

A) 2
B) 0
C) 1
D) Lanza excepción

---

**55.** ¿Por qué si sobreescribes `equals()` debes sobreescribir también `hashCode()`?

A) Porque el compilador lo exige
B) Porque el contrato Java exige que si `a.equals(b)` es true entonces `a.hashCode() == b.hashCode()`, necesario para que `HashSet` y `HashMap` funcionen correctamente
C) Porque `hashCode()` controla el garbage collector
D) No es necesario sobreescribir `hashCode()`

---

**56.** ¿Qué estructura es más eficiente para buscar por email si tienes muchos usuarios?

A) `ArrayList<Usuario>` recorrida con for-each
B) `HashMap<String, Usuario>` con el email como clave
C) `LinkedList<Usuario>`
D) Un array de `Usuario[]`

---

**57.** ¿Qué hace `Collections.unmodifiableList(lista)`?

A) Ordena la lista
B) Devuelve una vista de la lista que lanza excepción si se intenta modificar
C) Crea una copia de la lista
D) Elimina los duplicados de la lista

---

**58.** ¿Cuál es la forma correcta de iterar sobre un `Set<String>` llamado `emails`?

A) `for (int i = 0; i < emails.length; i++)`
B) `for (String e : emails)`
C) `emails.forEach(i -> emails.get(i))`
D) `while (emails.hasNext())`

---

**59.** Si tienes `List<Persona>` con alumnos y profesores mezclados, ¿cómo filtras solo los alumnos?

A) Llamando a `lista.filter(Alumno.class)`
B) Iterando con for-each, comprobando con `instanceof Alumno` y haciendo cast
C) Llamando a `lista.getAlumnos()`
D) No es posible con `List<Persona>`

---

**60.** ¿Qué ocurre si devuelves la referencia directa a la lista interna de un objeto desde un getter?

A) Nada, es una práctica normal
B) Quien la recibe puede modificar la lista interna sin pasar por los métodos de control del objeto
C) Java crea automáticamente una copia
D) El objeto queda bloqueado

---

**61.** ¿Qué método de `Map` comprueba si una clave existe?

A) `map.exists(clave)`
B) `map.hasKey(clave)`
C) `map.containsKey(clave)`
D) `map.includes(clave)`

---

**62.** ¿Cuál de estas afirmaciones sobre `HashMap` es CORRECTA?

A) Mantiene el orden de inserción siempre
B) No permite claves duplicadas; si insertas la misma clave dos veces, sobreescribe el valor
C) Permite claves duplicadas pero no valores duplicados
D) Es más lento que `ArrayList` en todas las operaciones

---

## 🔴 BLOQUE E — Excepciones, Validaciones y RegEx (preguntas 63–75)

**63.** ¿Cuál es la diferencia entre una excepción `checked` y una `unchecked`?

A) Las `checked` son más graves que las `unchecked`
B) Las `checked` deben declararse o capturarse obligatoriamente; las `unchecked` no requieren declaración
C) Las `unchecked` deben declararse con `throws`; las `checked` no
D) No hay diferencia en Java moderno

---

**64.** `IllegalArgumentException` es una excepción de tipo:

A) `checked`
B) `unchecked` (hereda de `RuntimeException`)
C) `Error`
D) `IOException`

---

**65.** ¿Dónde debe lanzarse `IllegalArgumentException` según las buenas prácticas?

A) Solo en la clase `Main`
B) Solo en el repositorio
C) En constructores y setters cuando los argumentos violan las precondiciones
D) Solo en métodos estáticos

---

**66.** ¿Qué hace el metacarácter `^` al inicio de un patrón RegEx?

A) Niega todo el patrón
B) Ancla el patrón al inicio de la cadena
C) Indica que el carácter es opcional
D) Significa "cualquier carácter"

---

**67.** ¿Qué significa `\\d` en un patrón RegEx de Java?

A) Cualquier carácter
B) El carácter `d` literal
C) Cualquier dígito (equivalente a `[0-9]`)
D) El carácter barra invertida seguido de d

---

**68.** ¿Por qué se escribe `\\.` en Java para representar un punto literal en RegEx?

A) Es un error, debería escribirse solo `.`
B) Porque en Java los Strings requieren doblar la barra invertida (`\\`), y en RegEx `\.` es punto literal
C) Porque `.` en Java siempre es un punto literal
D) Para compatibilidad con versiones antiguas

---

**69.** ¿Cuál es la ventaja de compilar un `Pattern` como constante estática en lugar de usar `String.matches()` en cada llamada?

A) Ninguna, son idénticos en rendimiento
B) El `Pattern` compilado puede reutilizarse, evitando recompilar el patrón en cada llamada
C) `String.matches()` es más preciso
D) Solo funciona para emails

---

**70.** ¿Qué comprueba el patrón `^\\d{8}[A-Za-z]$`?

A) Cualquier cadena con números
B) Exactamente 8 dígitos seguidos de exactamente una letra
C) Al menos 8 dígitos
D) 8 dígitos seguidos de cualquier carácter

---

**71.** ¿Qué hace `email.trim()` en Java?

A) Convierte el email a minúsculas
B) Elimina todos los espacios del String
C) Elimina los espacios al inicio y al final del String
D) Valida que el email tenga formato correcto

---

**72.** Un bloque `try-catch` en el `Main` captura `IllegalArgumentException`. ¿Cómo se obtiene el mensaje de la excepción?

A) `exception.toString()`
B) `exception.getMessage()`
C) `exception.getError()`
D) `exception.getCause()`

---

**73.** ¿Qué ocurre si lanzas una excepción dentro de un constructor?

A) El objeto se crea con estado incompleto
B) El constructor continúa ejecutándose
C) La excepción se ignora
D) El objeto nunca llega a crearse; la excepción se propaga al llamador

---

**74.** ¿Cuál es el propósito de tener métodos `validarEmail()` (que lanza excepción) y `emailValido()` (que devuelve boolean) en `Validaciones`?

A) Es redundante, solo se necesita uno
B) El boolean sirve para comprobaciones condicionales; el que lanza excepción sirve para uso directo en constructores/setters donde quieres propagar el error
C) El boolean es para tests; el de excepción para producción
D) Son exactamente iguales en comportamiento

---

**75.** ¿Qué excepción se lanza al intentar parsear una fecha con formato incorrecto usando `LocalDate.parse()`?

A) `IllegalArgumentException`
B) `NumberFormatException`
C) `DateTimeParseException`
D) `FormatException`

---

## 🟣 BLOQUE F — Fechas, Optional y Recursividad (preguntas 76–87)

**76.** ¿Qué clase de `java.time` representa una fecha sin hora ni zona horaria?

A) `Date`
B) `DateTime`
C) `LocalDate`
D) `Calendar`

---

**77.** ¿Cómo se obtiene la fecha actual con la API `java.time`?

A) `new LocalDate()`
B) `LocalDate.today()`
C) `LocalDate.now()`
D) `Date.now()`

---

**78.** ¿Qué calcula `Period.between(fechaNacimiento, LocalDate.now()).getYears()`?

A) El año de nacimiento
B) La diferencia en días
C) Los años cumplidos correctamente, teniendo en cuenta si el cumpleaños ya pasó este año
D) El número total de meses

---

**79.** ¿Por qué NO es correcto calcular la edad como `LocalDate.now().getYear() - fechaNacimiento.getYear()`?

A) Es correcto, ese es el método recomendado
B) Porque puede dar un año de más si el cumpleaños de este año todavía no ha pasado
C) Porque `getYear()` devuelve el mes
D) Porque no funciona en años bisiestos

---

**80.** ¿Qué devuelve `fechaNacimiento.isBefore(LocalDate.now())` si la fecha es anterior a hoy?

A) `false`
B) `null`
C) `0`
D) `true`

---

**81.** ¿Qué es `Optional<T>` en Java?

A) Una lista que puede estar vacía
B) Un contenedor que representa un valor que puede estar presente o ausente, alternativa más segura a `null`
C) Un tipo especial de excepción
D) Una interfaz genérica de Java

---

**82.** ¿Qué lanza `Optional.get()` si el Optional está vacío?

A) `NullPointerException`
B) `IllegalStateException`
C) `NoSuchElementException`
D) `EmptyOptionalException`

---

**83.** ¿Cuál es la forma más segura de usar un `Optional`?

A) Llamar directamente a `.get()`
B) Usar `orElse()` o comprobar `isPresent()` antes de `get()`
C) Convertirlo a `null` con `orElse(null)`
D) Ignorar si está vacío

---

**84.** En la recursividad, ¿qué es el caso base?

A) El primer método que se llama
B) La condición que detiene la recursión para evitar llamadas infinitas
C) El último parámetro del método
D) El objeto que se pasa entre llamadas

---

**85.** En el método `buscarPorPrefijo` del proyecto del centro educativo, ¿qué representa el parámetro `index` en la llamada recursiva?

A) El número de resultados encontrados hasta ahora
B) La posición actual en la lista que se está evaluando
C) El tamaño del prefijo buscado
D) El número de personas en el centro

---

**86.** ¿Qué error en tiempo de ejecución indica que la recursión no tiene caso base o no lo alcanza?

A) `NullPointerException`
B) `ArrayIndexOutOfBoundsException`
C) `StackOverflowError`
D) `RecursionException`

---

**87.** ¿Por qué en `buscarRec` se pasa el `ArrayList<Persona> resultado` como parámetro en lugar de devolverlo?

A) Porque ArrayList no puede devolverse desde métodos recursivos
B) Para acumular resultados en la misma colección en todas las llamadas recursivas, evitando crear listas intermedias
C) Porque es obligatorio en Java
D) Para mayor claridad del código únicamente

---

## ⚪ BLOQUE G — Arquitectura, Maven, JDBC y temas avanzados (preguntas 88–100)

**88.** En la arquitectura por capas del proyecto de autenticación, ¿qué capa solo conoce las interfaces y nunca las implementaciones concretas?

A) `repository`
B) `service`
C) `app (Main)` durante el uso; solo `Main` en la inicialización conoce las implementaciones concretas
D) `model`

---

**89.** ¿Qué es Maven?

A) Un IDE para Java
B) Una herramienta de construcción y gestión de dependencias para proyectos Java
C) Un framework de testing
D) Una base de datos embebida

---

**90.** ¿Qué contiene el archivo `pom.xml` de un proyecto Maven?

A) El código fuente principal
B) La configuración del proyecto: dependencias, versión de Java, plugins y metadatos
C) Los tests unitarios
D) Los archivos de recursos estáticos

---

**91.** ¿Qué hace el comando `mvn clean test`?

A) Solo elimina los archivos compilados
B) Compila el proyecto y abre el IDE
C) Elimina los compilados anteriores, recompila y ejecuta los tests
D) Despliega el proyecto en un servidor

---

**92.** En JDBC, ¿qué es un `PreparedStatement`?

A) Un objeto que establece la conexión con la base de datos
B) Una consulta SQL precompilada que acepta parámetros de forma segura, evitando SQL injection
C) El resultado de una consulta SELECT
D) Un objeto para cerrar la conexión

---

**93.** ¿Qué devuelve `ResultSet.next()` en JDBC?

A) El siguiente registro como objeto Java
B) `true` si hay más filas, `false` si se agotaron
C) El número total de filas
D) La columna siguiente del registro actual

---

**94.** ¿Por qué se usa `PreparedStatement` en lugar de concatenar la SQL con los parámetros directamente?

A) `PreparedStatement` es más corto de escribir
B) Para prevenir inyección SQL y mejorar el rendimiento con consultas repetidas
C) Porque `Statement` no puede ejecutar UPDATE
D) No hay diferencia en seguridad

---

**95.** ¿Qué significa CRUD?

A) Create, Read, Update, Delete
B) Compile, Run, Update, Deploy
C) Class, Repository, Util, Domain
D) Connect, Request, Upload, Download

---

**96.** En el proyecto de autenticación, ¿cuál es el orden correcto de instanciación en `Main`?

A) `AuthServiceImpl` → `UserServiceImpl` → `UserRepositoryImpl`
B) `UserRepositoryImpl` → `UserServiceImpl` → `AuthServiceImpl`
C) `UserServiceImpl` → `UserRepositoryImpl` → `AuthServiceImpl`
D) El orden no importa

---

**97.** ¿Qué patrón de diseño se aplica cuando `AuthServiceImpl` recibe `IUserRepository` en su constructor en lugar de crearlo internamente?

A) Singleton
B) Factory Method
C) Dependency Injection
D) Decorator

---

**98.** ¿Cuál de estas afirmaciones sobre `LocalDate` es CORRECTA?

A) `LocalDate` es mutable: sus métodos modifican el objeto
B) `LocalDate` es inmutable: sus métodos devuelven nuevos objetos sin modificar el original
C) `LocalDate` incluye información de hora y zona horaria
D) `LocalDate` solo existe en Java 11+

---

**99.** En el ejemplo de JDBC del repositorio, ¿cuál es la responsabilidad de `DbOperations.java`?

A) Mostrar menús al usuario
B) Contener la lógica de negocio del sistema
C) Encapsular las operaciones SQL (insert, update, delete, select) sobre la base de datos
D) Validar los datos de entrada

---

**100.** ¿Cuál de estos enunciados describe correctamente la ventaja de la arquitectura por capas?

A) Hace el código más corto
B) Permite cambiar una capa sin afectar a las demás, facilitando mantenimiento, testing y escalabilidad
C) Elimina la necesidad de interfaces
D) Solo es útil en aplicaciones con base de datos

---

---

# ✅ RESPUESTAS COMPLETAS

---

## Bloque A — Fundamentos

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 1  | C    | `int` es el tipo primitivo entero básico |
| 2  | B    | División entera en Java: `5/2 = 2` (no 2.5) |
| 3  | C    | Los nombres de variable no pueden empezar por número |
| 4  | C    | `%` es el operador módulo (resto) |
| 5  | B    | `do-while` ejecuta al menos una vez antes de comprobar la condición |
| 6  | C    | `switch` es más limpio para casos discretos conocidos |
| 7  | D    | Variables de instancia `int` se inicializan a `0` por defecto |
| 8  | C    | `boolean` es primitivo; los demás son clases (referencia) |
| 9  | B    | `parseInt` convierte String a int primitivo |
| 10 | C    | `NumberFormatException` cuando el String no es un número válido |
| 11 | B    | `nextLine()` lee toda la línea hasta el intro |
| 12 | B    | `nextInt()` deja el `\n` en el buffer; el siguiente `nextLine()` lo consume como vacío |
| 13 | C    | El bucle va de 0 a 2 inclusive |
| 14 | B    | Fuertemente tipado: cada variable tiene un tipo fijo declarado |
| 15 | B    | Es un método estático de `PrintStream` que imprime y añade `\n` |

---

## Bloque B — POO

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 16 | B    | Objeto = instancia de una clase |
| 17 | C    | Encapsulación = atributos `private` + getters/setters controlados |
| 18 | D    | `private` es el más restrictivo |
| 19 | C    | No se puede instanciar una clase abstracta — error de compilación |
| 20 | C    | `extends` para herencia de clases |
| 21 | C    | `super()` invoca al constructor del padre |
| 22 | D    | `super()` debe ser siempre la primera instrucción |
| 23 | B    | `@Override` le dice al compilador que se sobreescribe un método del padre |
| 24 | C    | Herencia simple en Java: solo una clase padre |
| 25 | C    | Una clase puede implementar múltiples interfaces |
| 26 | B    | Polimorfismo: el mismo método se comporta diferente según el tipo real |
| 27 | C    | El compilador en tiempo de ejecución llama al método de `Alumno` |
| 28 | C    | Necesitas `instanceof` + cast para acceder a métodos de la subclase |
| 29 | B    | Un `Profesor` no es `instanceof Alumno` |
| 30 | B    | Sobrecarga = varios constructores con distintos parámetros |
| 31 | C    | `final` = se inicializa una vez y no puede cambiar |
| 32 | C    | Compilación no es un pilar de la POO |
| 33 | B    | El setter valida antes de asignar |
| 34 | C    | `println(objeto)` llama implícitamente a `toString()` |
| 35 | B    | Agregación: relación "tiene un" con independencia de ciclo de vida |

---

## Bloque C — Interfaces y Abstractas

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 36 | C    | Las interfaces definen contratos de métodos |
| 37 | B    | La abstracta puede tener implementación; la interfaz (pre-Java 8) no |
| 38 | C    | `implements` para interfaces |
| 39 | C    | Error de compilación si no se implementan todos los métodos |
| 40 | B    | Una interfaz extiende otra con `extends` |
| 41 | B    | Método `default`: tiene implementación dentro de la interfaz (Java 8+) |
| 42 | C    | Desacoplamiento: el servicio no depende de la implementación concreta |
| 43 | C    | Repository Pattern: abstrae el acceso a datos |
| 44 | C    | Permite pasar mocks en tests y cambiar implementaciones fácilmente |
| 45 | C    | Error de compilación si la subclase concreta no implementa métodos abstractos |
| 46 | B    | Una clase abstracta puede tener métodos concretos y abstractos |
| 47 | C    | Las clases `abstract` no pueden instanciarse directamente |
| 48 | B    | Desacoplamiento = no depender de implementaciones concretas |
| 49 | C    | SRP: una única razón para cambiar |
| 50 | D    | `Main` no debe tener lógica de negocio |

---

## Bloque D — Colecciones

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 51 | B    | `ArrayList`: duplicados y orden; `HashSet`: sin duplicados, sin orden garantizado |
| 52 | C    | `add()` en Set devuelve `false` si ya existe |
| 53 | C    | `HashSet.contains()` es O(1) con hash table |
| 54 | C    | `equals/hashCode` por email: dos con mismo email = mismo elemento para el Set |
| 55 | B    | Contrato Java: `equals` true → mismo `hashCode`; necesario para hash structures |
| 56 | B    | `HashMap<String, Usuario>` con email como clave: búsqueda O(1) |
| 57 | B    | Devuelve vista inmutable que lanza excepción al modificar |
| 58 | B    | For-each funciona con cualquier `Iterable`, incluyendo `Set` |
| 59 | B    | `instanceof` + cast para filtrar por tipo concreto |
| 60 | B    | Rompe encapsulación: el externo puede modificar estado interno |
| 61 | C    | `containsKey()` en Map |
| 62 | B    | `HashMap` no permite claves duplicadas; sobreescribe el valor |

---

## Bloque E — Excepciones, Validaciones y RegEx

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 63 | B    | `checked`: deben declararse/capturarse; `unchecked`: no obligatorio |
| 64 | B    | `IllegalArgumentException extends RuntimeException` → unchecked |
| 65 | C    | Se lanza en constructores y setters cuando los argumentos son inválidos |
| 66 | B    | `^` ancla el patrón al inicio de la cadena |
| 67 | C    | `\\d` en Java String = `\d` en RegEx = cualquier dígito |
| 68 | B    | En Java Strings, `\\` es una barra invertida; `\\.` en RegEx es punto literal |
| 69 | B    | Compilar una vez y reutilizar evita el coste de recompilación en cada llamada |
| 70 | B    | `{8}` = exactamente 8; `[A-Za-z]` = una letra; `^...$` = cadena completa |
| 71 | C    | `trim()` elimina espacios al inicio y al final |
| 72 | B    | `exception.getMessage()` devuelve el mensaje pasado al constructor de la excepción |
| 73 | D    | Si el constructor lanza excepción, el objeto no se crea |
| 74 | B    | Boolean para condicionales; el que lanza excepción para propagación directa |
| 75 | C    | `DateTimeParseException` cuando el formato de fecha no coincide |

---

## Bloque F — Fechas, Optional y Recursividad

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 76 | C    | `LocalDate` = fecha sin hora ni zona horaria |
| 77 | C    | `LocalDate.now()` devuelve la fecha actual del sistema |
| 78 | C    | `Period.between().getYears()` calcula años cumplidos correctamente |
| 79 | B    | La resta de años puede dar un año de más si el cumpleaños aún no llegó |
| 80 | D    | `isBefore` devuelve `true` si la fecha es anterior a la referencia |
| 81 | B    | `Optional`: contenedor para un valor que puede existir o no |
| 82 | C    | `NoSuchElementException` cuando `Optional` vacío y se llama `get()` |
| 83 | B    | Comprobar `isPresent()` o usar `orElse()` es la forma segura |
| 84 | B    | El caso base detiene la recursión |
| 85 | B    | `index` es la posición actual en la lista que se evalúa |
| 86 | C    | `StackOverflowError` cuando la pila de llamadas recursivas se agota |
| 87 | B    | Pasar la colección acumula resultados sin crear listas intermedias |

---

## Bloque G — Arquitectura, Maven, JDBC y avanzado

| Nº | Resp | Justificación clave |
|----|------|---------------------|
| 88 | C    | Solo `Main` conoce las implementaciones concretas (en la inicialización) |
| 89 | B    | Maven: herramienta de build y gestión de dependencias |
| 90 | B    | `pom.xml`: configuración del proyecto Maven |
| 91 | C    | `clean test`: limpia compilados, recompila y ejecuta tests |
| 92 | B    | `PreparedStatement`: SQL precompilada con parámetros seguros |
| 93 | B    | `ResultSet.next()`: avanza al siguiente registro, devuelve false si no hay más |
| 94 | B    | Prevención de SQL injection y mejor rendimiento |
| 95 | A    | CRUD: Create, Read, Update, Delete |
| 96 | B    | Orden: primero el repositorio, luego el servicio que lo recibe, luego el auth |
| 97 | C    | Dependency Injection: las dependencias se reciben, no se crean internamente |
| 98 | B    | `LocalDate` es inmutable (Java 8+); sus métodos devuelven nuevos objetos |
| 99 | C    | `DbOperations` encapsula las operaciones SQL sobre la base de datos |
| 100| B    | La arquitectura por capas permite cambios aislados y facilita el mantenimiento |

---

## 📊 Tabla de puntuación

| Aciertos | Nota orientativa |
|----------|-----------------|
| 90–100   | Sobresaliente — dominio completo |
| 75–89    | Notable — buen nivel |
| 60–74    | Bien — conceptos base sólidos |
| 45–59    | Suficiente — repasar bloques fallidos |
| < 45     | Suspendido — revisar la guía técnica |

---

## 🎯 Distribución por tema

| Bloque | Tema | Preguntas |
|--------|------|-----------|
| A | Fundamentos Java (tipos, bucles, Scanner) | 1–15 |
| B | POO (herencia, encapsulación, polimorfismo) | 16–35 |
| C | Interfaces y clases abstractas | 36–50 |
| D | Colecciones (ArrayList, HashSet, Map) | 51–62 |
| E | Excepciones, validaciones y RegEx | 63–75 |
| F | Fechas, Optional y recursividad | 76–87 |
| G | Arquitectura, Maven, JDBC y avanzado | 88–100 |

---

*Examen generado a partir del repositorio del curso, las prácticas de Centro Educativo y Sistema de Autenticación, y todos los materiales de las unidades 1–7.*
