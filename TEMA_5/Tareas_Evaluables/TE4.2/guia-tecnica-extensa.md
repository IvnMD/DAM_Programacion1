# 📚 Guía Técnica Extensa: Gestión de Personas de un Centro Educativo en Java

> **Propósito de esta guía:** Que entiendas el *por qué* y el *cómo* de cada sistema antes de escribir una sola línea. No hay código completo. Sí hay explicaciones técnicas detalladas, advertencias, recordatorios y razonamientos que necesitas interiorizar para construir el programa correctamente por ti mismo.

---

## 📋 Índice General

1. [Organización del proyecto: paquetes y responsabilidades](#paquetes)
2. [Clases en Java: anatomía y reglas](#clases)
3. [Constructores: qué son, tipos y reglas de escritura](#constructores)
4. [Encapsulación: por qué private y cómo funcionan getters/setters](#encapsulacion)
5. [Clases Abstractas: qué implican y cómo se diseñan](#abstractas)
6. [Herencia con extends: cómo se conectan Persona, Alumno y Profesor](#herencia)
7. [super(): la llamada obligatoria al padre](#super)
8. [Sobreescritura de métodos: @Override y polimorfismo](#override)
9. [instanceof y cast: cómo trabajar con tipos en una lista mixta](#instanceof)
10. [Dónde poner las validaciones y por qué](#donde-validar)
11. [IllegalArgumentException: filosofía, cuándo usarla y cómo escribirla](#excepciones)
12. [Expresiones Regulares (RegEx): fundamentos técnicos completos](#regex)
13. [La clase Validaciones: diseño de métodos estáticos utilitarios](#validaciones-clase)
14. [Fechas con java.time: LocalDate, Period y cálculo de edad](#fechas)
15. [Colecciones: ArrayList, Set, HashSet y cuándo usar cada una](#colecciones)
16. [El método equals() y hashCode(): por qué son inseparables](#equals)
17. [Comparar Strings: el error más común en Java](#comparar-strings)
18. [Normalización de datos: trim(), toUpperCase() y cuándo aplicarlos](#normalizacion)
19. [La clase CentroEducativo: diseño como servicio y sus invariantes](#centro)
20. [Recursividad: cómo pensar en ella y cómo escribir buscarPorPrefijo](#recursividad)
21. [Llamar métodos entre clases: cómo se comunican los objetos](#comunicacion)
22. [El menú (Main): lectura de datos con Scanner y manejo de errores](#main)
23. [toString(): cómo construir representaciones textuales útiles](#tostring)
24. [final: cuándo y por qué hacer atributos o métodos inmutables](#final)
25. [Orden recomendado de construcción del proyecto](#orden)
26. [Checklist de errores comunes](#errores)

---

## 1. 🗂️ Organización del proyecto: paquetes y responsabilidades {#paquetes}

Un paquete en Java es simplemente una carpeta que agrupa clases que tienen una relación lógica. La declaración de paquete (`package com.docencia.model;`) va siempre en la **primera línea** del archivo, antes que cualquier otra cosa, incluyendo los imports.

La estructura que pide el proyecto sigue un patrón clásico de separación por capas:

**La capa `model`** contiene las representaciones del mundo real: qué es una Persona, qué es un Alumno, qué es un Profesor. Estas clases solo saben de sí mismas. No saben que existe una lista, ni un menú, ni un sistema de gestión.

**La capa `service`** contiene la lógica de negocio: qué operaciones se pueden hacer sobre los datos (registrar, buscar, listar). `CentroEducativo` sabe que existen personas y sabe gestionarlas, pero no sabe nada de cómo se muestra la información por pantalla.

**La capa `util`** contiene herramientas reutilizables sin estado: la clase `Validaciones` no guarda datos propios, simplemente ofrece funciones auxiliares que cualquier otra clase puede usar.

**La capa `app`** contiene el punto de entrada (`Main`) y la lógica de interacción con el usuario: pedir datos por teclado, mostrar menús, llamar al servicio.

Esta separación importa porque si el día de mañana cambias cómo se valida un email (en `Validaciones`), no tienes que tocar ni `Alumno`, ni `CentroEducativo`, ni `Main`. Cada capa tiene una única razón para cambiar.

**Sobre los imports:** Cuando una clase de un paquete necesita usar una clase de otro paquete, debes importarla. Los imports van después de la declaración de paquete y antes de la declaración de clase. Java importa automáticamente solo las clases del paquete `java.lang` (como `String`, `Integer`, `Math`). Todo lo demás, incluyendo `java.util.ArrayList`, `java.time.LocalDate` o tus propias clases de otros paquetes, necesita ser importado explícitamente.

---

## 2. 🏗️ Clases en Java: anatomía y reglas {#clases}

Una clase es el molde a partir del cual se crean objetos. Define qué datos tiene ese objeto (atributos) y qué puede hacer (métodos). Cuando escribas una clase, piensa siempre en términos de responsabilidad: **¿de qué es responsable esta clase? ¿qué sabe sobre sí misma? ¿qué puede hacer?**

La declaración de una clase tiene la forma: `modificador_acceso [abstract] class NombreClase [extends Padre]`. El modificador de acceso más habitual para clases de primer nivel es `public`. Una clase `public` debe estar en un archivo cuyo nombre coincida exactamente con el nombre de la clase, incluyendo mayúsculas.

**Atributos vs variables locales:** Los atributos se declaran dentro de la clase pero fuera de cualquier método. Pertenecen al objeto y viven mientras el objeto existe. Las variables locales se declaran dentro de un método y solo existen mientras ese método se ejecuta. Los atributos de un objeto deben declararse siempre como `private` (encapsulación), con rarísimas excepciones.

**Sobre el orden de declaración dentro de una clase:** Aunque Java no obliga a ningún orden concreto, la convención ampliamente aceptada es: primero las constantes estáticas (`static final`), luego los atributos de instancia, luego los constructores, luego los métodos (getters y setters primero, luego métodos de lógica, luego `toString`). Seguir esta convención hace que tu código sea predecible y fácil de leer.

---

## 3. 🔨 Constructores: qué son, tipos y reglas de escritura {#constructores}

Un constructor es un bloque especial de código que se ejecuta cuando se crea un objeto con `new`. Su propósito es dejar el objeto en un estado válido desde el primer instante. Si el objeto no puede crearse correctamente (porque algún dato es inválido), el constructor debe **lanzar una excepción** y el objeto nunca llega a existir.

**Características técnicas del constructor:**
- Tiene el mismo nombre que la clase, exactamente igual en mayúsculas y minúsculas.
- No tiene tipo de retorno (ni siquiera `void`).
- Puede haber múltiples constructores en la misma clase siempre que tengan diferentes parámetros (esto se llama **sobrecarga de constructores**).

**El orden de operaciones dentro de un constructor es crítico:** Primero llamas a `super()` si es una subclase (siempre primera línea, sin excepciones). Luego validas cada parámetro recibido. Si algo falla, lanzas la excepción antes de asignar nada. Si todo es válido, normalizas los valores (trim, toUpperCase, etc.) y los asignas a los atributos. Nunca asignes antes de validar: si asignas y luego lanzas una excepción, el objeto queda en un estado inconsistente (aunque en la práctica el constructor interrumpido no devuelve objeto utilizable, es un mal hábito).

**El constructor con solo `id`:** El README pide un constructor simplificado que solo recibe el `id`. Este constructor está pensado para crear personas "vacías" que luego se rellenan con setters, o para uso en testing. En este constructor, solo validas el `id` (que sea > 0) y fijas `fechaRegistro` como `LocalDate.now()`. El resto de atributos quedarán en sus valores por defecto (`null` para objetos, `0` para primitivos). Ten en cuenta que si usas este constructor y luego intentas llamar a `getEdad()` sin haber establecido `fechaNacimiento`, obtendrás un `NullPointerException`.

**Constructor privado o protegido:** En este proyecto no lo necesitas, pero conviene saber que un constructor puede ser `private` (nadie puede crear la clase desde fuera, útil en el patrón Singleton) o `protected` (solo las subclases y clases del mismo paquete pueden usarlo).

---

## 4. 🔒 Encapsulación: por qué private y cómo funcionan los getters/setters {#encapsulacion}

La encapsulación significa que el estado interno de un objeto solo es accesible y modificable a través de métodos controlados. El objeto es responsable de mantener su propio estado coherente.

**Por qué todos los atributos deben ser `private`:** Si un atributo es `public`, cualquier clase en cualquier parte del programa puede modificarlo directamente, sin pasar por ninguna validación. Esto significa que podrías tener una `Persona` con `id = -5` o con un email completamente malformado, y el objeto nunca se enteraría. Con atributos `private`, la única forma de modificar el valor es a través del setter, que siempre valida.

**Getters:** Son métodos que simplemente devuelven el valor de un atributo. No hacen ninguna validación (el valor ya es correcto, fue validado cuando se estableció). No modifican nada. Su firma es `public TipoDato getNombreAtributo()`. Para atributos booleanos, la convención es usar `is` en lugar de `get` (`isActivo()` en lugar de `getActivo()`). Los getters de atributos `final` pueden declararse también como `final` para impedir que las subclases los sobreescriban.

**Setters:** Son métodos que modifican el valor de un atributo. **Siempre deben validar antes de asignar.** Su firma es `public void setNombreAtributo(TipoDato valor)`. Si la validación falla, lanzan `IllegalArgumentException` y el atributo mantiene su valor anterior. Esta garantía es fundamental: un setter correcto garantiza que, si no lanza excepción, el nuevo valor es válido.

**Atributos sin setter:** Algunos atributos son inmutables después de la creación. `id` y `fechaRegistro` están marcados como `final` en el README precisamente por esto. Un atributo `final` de instancia debe inicializarse en el constructor y ya nunca puede cambiar. No tiene setter. Si alguien intenta asignarle otro valor desde fuera, el compilador lo impide.

**La diferencia entre `private` y `protected`:** Un atributo `protected` es accesible desde la propia clase, desde sus subclases y desde otras clases del mismo paquete. Si usaras `protected` para los atributos de `Persona`, `Alumno` podría acceder a `nombre` directamente sin pasar por el setter, lo que rompe la encapsulación. Por eso los atributos deben ser `private` y las subclases acceden a ellos a través de los getters y setters del padre.

---

## 5. 🔷 Clases Abstractas: qué implican y cómo se diseñan {#abstractas}

Una clase abstracta es una clase que existe para ser extendida, no para ser instanciada directamente. Representa un concepto general que por sí solo está incompleto. En este proyecto, `Persona` es abstracta porque no existe una "persona genérica" en el centro: todas las personas son o alumnos o profesores.

**La palabra clave `abstract` en la clase:** Al escribir `public abstract class Persona`, le dices al compilador dos cosas: primero, que nadie puede hacer `new Persona(...)` directamente; segundo, que esta clase puede tener métodos abstractos.

**Métodos abstractos:** Un método abstracto se declara en la clase abstracta con la palabra `abstract` y sin cuerpo (sin llaves, solo la firma seguida de `;`). Su propósito es definir un contrato que todas las subclases concretas deben cumplir obligatoriamente. Si una subclase no implementa todos los métodos abstractos del padre, el compilador dará error, a menos que la subclase también sea abstracta.

En este proyecto, `getTipo()` es el método abstracto. `Persona` lo declara pero no lo implementa, porque `Persona` no sabe si es un alumno o un profesor. `Alumno` lo implementa devolviendo `"ALUMNO"` y `Profesor` devolviendo `"PROFESOR"`. El compilador garantiza que ninguna subclase concreta de `Persona` pueda existir sin implementar `getTipo()`.

**La distinción entre abstracto y concreto dentro de la misma clase abstracta:** Una clase abstracta puede (y normalmente debe) tener tanto métodos abstractos como métodos concretos completamente implementados. En `Persona`, `getEdad()` es un método concreto: tiene implementación y todas las subclases lo heredan sin necesidad de redefinirlo. `getTipo()` es abstracto: no tiene implementación y cada subclase debe definirla.

**¿Puede una clase abstracta tener constructor?** Sí, y debe tenerlo. Aunque no puedes hacer `new Persona(...)` directamente, cuando creas `new Alumno(...)` el constructor de `Persona` se ejecuta (llamado mediante `super()`). El constructor de la clase abstracta se encarga de validar e inicializar los atributos comunes.

---

## 6. 🧬 Herencia con extends: cómo se conectan Persona, Alumno y Profesor {#herencia}

La herencia es el mecanismo por el que una clase hija adquiere todos los miembros (atributos y métodos) de su clase padre. La relación fundamental es "es un": un `Alumno` **es una** `Persona`. Esto no es solo semántico: tiene consecuencias técnicas directas.

**Lo que hereda la subclase y lo que no:**
- Hereda todos los métodos `public` y `protected` del padre: puede llamarlos directamente como si fueran suyos.
- Hereda los atributos `private` del padre, pero no puede acceder a ellos directamente: solo a través de los getters y setters que el padre expone.
- Los constructores del padre **no se heredan**: deben invocarse explícitamente con `super()`.

**El efecto práctico en este proyecto:** Cuando tienes un objeto `Alumno`, puedes llamar `alumno.getNombre()` aunque `getNombre()` esté definido en `Persona`. El método existe en el objeto porque fue heredado. De igual forma, `alumno.getEdad()` funciona porque `Alumno` hereda de `Persona` la lógica de cálculo de edad.

**Java solo permite herencia simple:** Una clase solo puede extender una única clase padre. `Alumno` puede extender `Persona`, pero no puede extender `Persona` y otra clase a la vez. Esta restricción existe para evitar el problema del diamante (ambigüedad cuando dos padres tienen el mismo método). Para compensar, Java tiene interfaces (que permiten "implementar" múltiples contratos), aunque en este proyecto no se requieren interfaces explícitas.

**La cadena de herencia y `Object`:** En Java, todas las clases heredan implícitamente de `Object` si no especifican otro padre. Por eso todos los objetos tienen métodos como `toString()`, `equals()` y `hashCode()`: vienen de `Object`. Cuando sobreescribes `toString()` en `Persona`, estás redefiniendo el comportamiento que heredaste de `Object`.

**Añadir atributos propios en la subclase:** `Alumno` tiene `curso` y `modulos`, atributos que `Persona` no tiene y que son específicos de los alumnos. Estos atributos se declaran en `Alumno` como `private`, con sus propios getters y setters. El sistema es: los atributos comunes viven en `Persona`, los específicos viven en cada subclase.

---

## 7. 🔗 super(): la llamada obligatoria al padre {#super}

`super` es una referencia al padre de la clase actual. En el contexto de los constructores, `super(argumentos)` invoca al constructor del padre. Esta llamada es el mecanismo por el que los atributos de la clase padre se inicializan cuando creas un objeto de la subclase.

**Regla absoluta e inflexible:** `super()` o `super(argumentos)` debe ser **siempre la primera instrucción** dentro del constructor de la subclase. El compilador de Java lo exige. No puedes escribir ninguna otra instrucción antes. Si intentas poner una validación o una asignación antes de `super()`, el compilador te dará error.

**¿Por qué esta restricción existe?** Porque Java necesita garantizar que el "núcleo" del objeto (la parte que viene del padre) esté completamente inicializado antes de que la subclase empiece a trabajar con él. Si pudieras ejecutar código antes de `super()`, podrías intentar usar métodos del padre sobre un estado sin inicializar.

**¿Qué pasa si no escribes super() explícitamente?** Java intenta insertar automáticamente una llamada a `super()` sin argumentos (el constructor vacío del padre). Si el padre no tiene un constructor sin argumentos (como en este proyecto, donde `Persona` tiene constructores con parámetros), el compilador dará error. Por eso en `Alumno` y `Profesor` debes escribir explícitamente `super(id, nombre, documento, email, fechaNacimiento, fechaRegistro)`.

**super() para llamar a métodos del padre (no solo constructores):** Fuera del contexto de constructores, `super.nombreMetodo()` se usa para llamar a la versión del método que está en el padre, en lugar de la versión sobreescrita en la subclase. El caso más común en este proyecto es en `toString()`: cuando sobreescribes `toString()` en `Alumno`, querrás incluir la información de la persona base. Puedes hacer esto llamando a `super.toString()` para obtener la representación del padre y luego concatenar los campos propios de `Alumno`.

---

## 8. 🔄 Sobreescritura de métodos: @Override y polimorfismo {#override}

Sobreescribir un método significa proporcionar en la subclase una nueva implementación de un método que ya existe en el padre. La subclase "reemplaza" el comportamiento heredado con el suyo propio.

**La anotación @Override:** Es una anotación que le dices al compilador "este método pretende sobreescribir un método del padre". No es obligatoria para que el código funcione, pero debes usarla siempre. Su utilidad es protectora: si cometes un error de tipografía (por ejemplo escribes `getTiipo()` en lugar de `getTipo()`), sin `@Override` Java simplemente crearía un nuevo método diferente y nunca te diría que cometiste un error. Con `@Override`, el compilador detecta que no existe ningún `getTiipo()` en el padre y te avisa del error inmediatamente.

**Reglas de sobreescritura:**
- El nombre del método debe ser idéntico al del padre.
- Los parámetros deben ser exactamente los mismos (en número, tipo y orden).
- El tipo de retorno debe ser el mismo o un subtipo del original (covarianza).
- No puede reducir la visibilidad: si el padre tiene `public`, la subclase no puede sobreescribirlo como `protected` o `private`.
- No puede lanzar excepciones checked nuevas que el padre no declare (aunque `IllegalArgumentException` es unchecked, así que no hay problema).

**Polimorfismo: el poder de la sobreescritura:** Cuando tienes una lista de tipo `List<Persona>` que contiene mezcla de `Alumno` y `Profesor`, y llamas `p.getTipo()` sobre cada elemento, Java en tiempo de ejecución determina el tipo real del objeto y llama al método correspondiente. No necesitas preguntar si es alumno o profesor: el objeto sabe qué es y responde en consecuencia. Esto es polimorfismo en acción, y es una de las razones más poderosas para usar herencia.

**Métodos que no se pueden sobreescribir:** Los métodos declarados como `final` no pueden sobreescribirse. En `Persona`, `getId()` y `getFechaRegistro()` deberían ser `final` porque representan datos inmutables que no tiene sentido redefinir en ninguna subclase. El compilador impide la sobreescritura de métodos `final`.

---

## 9. 🔍 instanceof y cast: cómo trabajar con tipos en una lista mixta {#instanceof}

Cuando guardas objetos de tipo `Alumno` y `Profesor` en una `List<Persona>`, la lista los trata a todos como `Persona`. Puedes llamar a cualquier método definido en `Persona`, pero no a los métodos específicos de `Alumno` (como `getCurso()`) sin antes hacer una comprobación y conversión de tipo.

**El operador instanceof:** Evalúa si un objeto es una instancia de una clase determinada (o de alguna de sus subclases). Devuelve `true` o `false`. Antes de hacer un cast, siempre debes verificar con `instanceof` para evitar una `ClassCastException` en tiempo de ejecución. La forma correcta es: preguntar con `instanceof`, luego convertir, luego usar.

**El cast (conversión de tipo):** Es la forma de decirle a Java "sé que este objeto, aunque está guardado como `Persona`, en realidad es un `Alumno`, trátalo como tal". La sintaxis es `(TipoDestino) objeto`. Si el objeto realmente no es del tipo indicado, lanzará `ClassCastException`. Por eso siempre va precedido de `instanceof`.

**Cuándo necesitas instanceof y cuándo no:** Si el método que quieres llamar está definido en `Persona` (como `getNombre()`, `getEdad()`, `getTipo()`), no necesitas `instanceof` ni cast: el polimorfismo se encarga. Solo necesitas `instanceof` y cast cuando quieres acceder a métodos que están en la subclase específica (`getCurso()`, `getDepartamento()`, `addModulo()`).

**El caso de listarAlumnos() y listarProfesores():** En `CentroEducativo`, cuando implementas estos métodos, recorres la lista de personas, usas `instanceof` para identificar el tipo, haces el cast, y añades el objeto convertido a la lista resultado. La lista resultado tiene el tipo específico (`List<Alumno>` o `List<Profesor>`), no el genérico.

---

## 10. 📍 Dónde poner las validaciones y por qué {#donde-validar}

Las validaciones son las comprobaciones que aseguran que los datos son coherentes y correctos. Ponerlas en el lugar equivocado es uno de los errores de diseño más comunes.

**En el constructor:** Las validaciones del constructor son la primera línea de defensa. Ningún objeto inválido debe poder crearse. Si el `id` es negativo o el email malformado, la excepción se lanza durante la construcción y el objeto nunca existe. Esta garantía es muy valiosa: si tienes un objeto `Persona`, sabes que en el momento de su creación todos sus datos eran válidos.

**En los setters:** Los setters son la segunda línea de defensa. Después de crear el objeto, si alguien intenta cambiar el nombre a una cadena vacía mediante `setNombre("")`, el setter valida y lanza la excepción. El atributo `nombre` mantiene el valor anterior.

**En los métodos de servicio (CentroEducativo):** Aquí se validan las condiciones que dependen del estado del sistema, no del objeto en sí. La unicidad de `id`, `documento` y `email` no puede validarse en el constructor de `Persona` porque en ese momento `Persona` no sabe que existe un `CentroEducativo` ni cuántas personas hay registradas. Este tipo de validación de integridad pertenece al método `registrarPersona()`.

**En los getters:** Nunca. Un getter devuelve el valor tal cual. La validación ya ocurrió cuando se estableció el valor.

**En el Main (interfaz de usuario):** El Main captura las excepciones que lanzan las capas inferiores y las convierte en mensajes comprensibles para el usuario. No repite las validaciones de negocio, pero sí valida el formato de la entrada: que un número introducido por teclado sea realmente un número, que una fecha tenga el formato correcto, que el texto tenga longitud mínima antes de intentar crear el objeto.

**Principio DRY (Don't Repeat Yourself):** La lógica de validación debe vivir en un único lugar. Si la regla "el email debe cumplir tal patrón RegEx" está en el constructor, en el setter y en el Main, tendrás tres lugares que mantener sincronizados cuando la regla cambie. La solución es centralizar en `Validaciones.emailValido()` y llamarla desde el constructor y el setter. Si cambia la regla, cambias solo `Validaciones`.

---

## 11. 🚨 IllegalArgumentException: filosofía, cuándo usarla y cómo escribirla {#excepciones}

`IllegalArgumentException` es una excepción de tipo **unchecked** (no verificada en compilación). Hereda de `RuntimeException`. Se usa para indicar que un argumento pasado a un método viola sus precondiciones.

**Excepción checked vs unchecked:** Las excepciones checked deben declararse en la firma del método con `throws` y quien llama al método está obligado a manejarlas con `try-catch` o declarar que él también las propaga. Las unchecked (como `IllegalArgumentException`) no requieren nada de eso. Se lanzan y se propagan hacia arriba por la pila de llamadas hasta que alguien las captura o el programa termina. Para errores de programación o datos inválidos, las unchecked son la elección correcta.

**La instrucción throw:** Para lanzar una excepción, usas `throw new NombreExcepcion("mensaje")`. Es una instrucción que interrumpe el flujo normal del método inmediatamente: no se ejecuta nada después del `throw`. Por eso en los constructores y setters, el `throw` actúa como una "barrera": si se ejecuta, el código siguiente no se alcanza.

**El mensaje de la excepción:** El mensaje debe ser descriptivo y útil para quien intente depurar el problema. Incluye siempre: qué regla se violó, y si es posible, qué valor se recibió. Un mensaje como `"El id debe ser mayor que 0"` es mediocre. Uno como `"El id debe ser mayor que 0, pero se recibió: -3"` es útil porque permite identificar el origen del error sin necesidad de poner un punto de ruptura en el debugger.

**Cómo capturar la excepción en Main:** Usas un bloque `try-catch`. El código que puede lanzar la excepción va dentro del `try`. Si se lanza, el flujo salta al `catch` correspondiente. El objeto de excepción capturado tiene el método `getMessage()` que devuelve el mensaje que escribiste al lanzarla. En el Main, mostrarás ese mensaje al usuario y podrás pedirle que corrija los datos.

**Cuándo NO usar IllegalArgumentException:** No la uses para errores de lógica interna que no dependen de datos externos (para eso existe `IllegalStateException`), ni para indicar que no se encontró un resultado en una búsqueda (para eso devuelves `null` o usas `Optional`). `IllegalArgumentException` es específicamente para: "los argumentos que me pasaste no cumplen las precondiciones de este método".

---

## 12. 🔍 Expresiones Regulares (RegEx): fundamentos técnicos completos {#regex}

Una expresión regular es un patrón de texto que describe un conjunto de cadenas de caracteres. En Java, el paquete `java.util.regex` proporciona las herramientas para trabajar con ellas.

**Metacaracteres fundamentales que necesitas:**

El punto `.` coincide con cualquier carácter excepto salto de línea. Usado sin escapar, es muy permisivo; rara vez lo quieres como "cualquier cosa".

El acento circunflejo `^` al inicio del patrón ancla la coincidencia al inicio de la cadena. Sin él, el patrón puede coincidir en cualquier posición de la cadena.

El signo de dólar `$` al final del patrón ancla la coincidencia al final de la cadena. Usar `^` y `$` juntos significa "la cadena entera debe coincidir con este patrón".

Los corchetes `[...]` definen una clase de caracteres: cualquiera de los caracteres listados. `[aeiou]` coincide con cualquier vocal. `[a-z]` coincide con cualquier letra minúscula. `[A-Z]` con cualquier mayúscula. `[0-9]` con cualquier dígito. `[a-zA-Z0-9]` con cualquier letra o dígito. Dentro de corchetes, el acento circunflejo `[^...]` niega la clase: coincide con cualquier carácter que NO sea el listado.

Las llaves `{n}` indican exactamente `n` repeticiones del elemento anterior. `{n,m}` indica entre `n` y `m` repeticiones. `{n,}` indica al menos `n` repeticiones.

El signo más `+` indica una o más repeticiones del elemento anterior. El asterisco `*` indica cero o más repeticiones. La interrogación `?` indica cero o una repetición (el elemento es opcional).

El punto escapado `\\.` (en Java, como String, la barra invertida se dobla) coincide con un punto literal. En RegEx el punto sin escapar es metacarácter; para coincidir con un punto real necesitas escaparlo.

El `\\d` es un shortcut para `[0-9]` (cualquier dígito). El `\\w` coincide con letras, dígitos y guion bajo.

**El patrón para un email básico:** Necesita contemplar: una parte local (letras, dígitos, puntos, guiones, etc.), el símbolo arroba, el dominio (letras y dígitos separados por puntos), y la extensión (2 o más letras). La parte local admite varios caracteres especiales (`.`, `_`, `%`, `+`, `-`). El dominio puede tener subdominios separados por puntos. La extensión debe tener al menos 2 caracteres. Piensa en cada parte del email y tradúcela a los metacaracteres que la describen.

**El patrón para un DNI:** Un DNI español tiene 8 dígitos seguidos de una letra. Necesitas especificar: exactamente 8 dígitos (usando el cuantificador `{8}` sobre la clase de dígitos), seguidos de exactamente una letra (clase `[A-Za-z]`). Si quieres ser estricto con las letras válidas de DNI, existe un conjunto específico de letras permitidas, pero para la práctica la validación básica es suficiente.

**Cómo Java usa los patrones: Pattern y Matcher:**

La clase `Pattern` representa un patrón compilado. La compilación de un patrón es costosa computacionalmente, por eso si vas a usar el mismo patrón múltiples veces, debes compilarlo una vez y guardarlo como constante estática de clase. Usas `Pattern.compile("tu_patron")` para obtener el objeto `Pattern`.

La clase `Matcher` aplica un patrón compilado sobre una cadena concreta. Para obtener un `Matcher`, llamas al método `matcher(cadena)` sobre el objeto `Pattern`. Una vez tienes el `Matcher`, el método `matches()` devuelve `true` si la cadena entera coincide con el patrón (equivalente a rodear el patrón con `^` y `$`).

Existe un atajo `cadena.matches("patron")` directamente sobre el String, pero este método compila el patrón cada vez que se llama, lo que es ineficiente si se llama repetidamente. En `Validaciones`, donde validarás muchos emails y documentos, usa siempre el `Pattern` compilado como constante.

**Sobre el escape de la barra invertida en Java:** En una cadena de texto Java, la barra invertida `\` es un carácter de escape para el propio lenguaje (`\n` es salto de línea, `\t` es tabulador). Para incluir una barra invertida literal en el String, necesitas doblarla: `\\`. Así, el metacarácter RegEx `\d` (un dígito), que en un archivo de texto sería `\d`, en una cadena Java debe escribirse como `"\\d"`. Un punto escapado RegEx `\.` en Java se escribe `"\\."`.

---

## 13. 🛠️ La clase Validaciones: diseño de métodos estáticos utilitarios {#validaciones-clase}

`Validaciones` es una clase de utilidad pura. No tiene estado (no tiene atributos de instancia con valores distintos para cada objeto). Solo ofrece funciones reutilizables. Este tipo de clase se diseña con métodos estáticos.

**Métodos estáticos:** Un método `static` pertenece a la clase, no a un objeto concreto. Se llama con `NombreClase.nombreMetodo(argumentos)`, sin necesidad de crear un objeto. No puede acceder a atributos de instancia (porque no hay instancia). En `Validaciones`, tanto `emailValido` como `documentoValido` son estáticos porque su resultado solo depende del argumento recibido, no de ningún estado guardado en un objeto.

**Las constantes Pattern como estáticas y finales:** Los objetos `Pattern` compilados deben declararse como `private static final`. `static` porque son de la clase (no de cada instancia). `final` porque una vez asignados no deben cambiar. El nombre en MAYÚSCULAS_CON_GUIONES_BAJOS es la convención para constantes en Java.

**Precondición de null:** Antes de intentar aplicar cualquier RegEx a una cadena, debes comprobar que no es `null`. Si intentas llamar a `.matcher(null)` o `null.trim()`, obtendrás `NullPointerException`. La validación de null es siempre la primera comprobación en estos métodos utilitarios.

**Normalización antes de validar:** El contrato dice que debes normalizar (eliminar espacios y uniformizar mayúsculas/minúsculas) antes de aplicar el patrón. Para el documento: `trim()` para quitar espacios y `toUpperCase()` para uniformizar letras. Para el email: `trim()` para quitar espacios. Si el patrón de email usa `[a-zA-Z]`, la normalización de mayúsculas es menos crítica, pero para el documento que termina en letra, el `toUpperCase()` es esencial para que `"12345678a"` y `"12345678A"` sean igualmente válidos.

**¿Puede Validaciones ser instanciada?** En sentido estricto, si defines `Validaciones` con un constructor público por defecto (que Java crea automáticamente si no defines ninguno), alguien podría crear `new Validaciones()`. Para expresar la intención de que esta clase no debe instanciarse, puedes declarar el constructor como `private`. Es un detalle de diseño defensivo.

---

## 14. 📅 Fechas con java.time: LocalDate, Period y cálculo de edad {#fechas}

La API `java.time` fue introducida en Java 8 para reemplazar las problemáticas clases `Date` y `Calendar`. Es inmutable (los objetos no se modifican, los métodos devuelven nuevos objetos) y mucho más expresiva.

**LocalDate:** Representa una fecha (año, mes, día) sin información de hora ni zona horaria. Para crear una fecha de hoy: `LocalDate.now()`. Para crear una fecha específica: `LocalDate.of(año, mes, día)`, donde el mes es un entero del 1 al 12 (también puedes usar la enumeración `Month.JANUARY`, etc.). También existe `LocalDate.parse(string)` para parsear fechas en formato ISO (YYYY-MM-DD), o `LocalDate.parse(string, formateador)` para otros formatos.

**Métodos de comparación en LocalDate:**
- `fecha.isBefore(otraFecha)`: devuelve `true` si `fecha` es anterior a `otraFecha`. Para la validación de `fechaNacimiento`, necesitas que sea `isBefore(LocalDate.now())`.
- `fecha.isAfter(otraFecha)`: devuelve `true` si `fecha` es posterior a `otraFecha`. Para `fechaRegistro`, necesitas que `!isAfter(LocalDate.now())` (puede ser hoy o antes).
- `fecha.isEqual(otraFecha)`: devuelve `true` si son la misma fecha.
- `fecha.compareTo(otraFecha)`: devuelve negativo, cero o positivo, como un comparador general.

**Inmutabilidad:** `LocalDate.now()` en dos llamadas distintas puede devolver valores diferentes si el día cambió. Para el `fechaRegistro` que se fija en el constructor y no debe cambiar nunca, es buena práctica capturar `LocalDate.now()` una sola vez en el constructor y asignarlo al atributo `final`. De esta forma, aunque el objeto viva días o semanas, su `fechaRegistro` siempre reflejará el momento de creación.

**Period:** Representa una cantidad de tiempo en términos de años, meses y días. Se obtiene con `Period.between(fechaInicio, fechaFin)`. Para calcular la edad, usas `Period.between(fechaNacimiento, LocalDate.now())` y luego llamas `.getYears()` sobre el `Period` resultante. Este método tiene en cuenta si el cumpleaños del año actual ya pasó o no, calculando correctamente los años cumplidos.

**Por qué no restar años directamente:** Podría parecer que `LocalDate.now().getYear() - fechaNacimiento.getYear()` es suficiente para calcular la edad, pero esto da resultados incorrectos: si hoy es 15 de enero de 2025 y alguien nació el 20 de enero de 2000, ese cálculo devolvería 25, pero la persona aún no ha cumplido los 25. `Period.between().getYears()` lo calcula correctamente.

**Parseo de fechas en el Main:** Cuando el usuario introduce una fecha como texto (ej: `"15/03/2000"`), debes convertirla a `LocalDate`. Usas `DateTimeFormatter` para especificar el formato: `DateTimeFormatter.ofPattern("dd/MM/yyyy")`. Luego `LocalDate.parse(textoIntroducido, formateador)`. Este método lanza `DateTimeParseException` si el formato no coincide, lo que debes capturar en el Main para pedir al usuario que reintroduzca la fecha.

---

## 15. 📦 Colecciones: ArrayList, Set, HashSet y cuándo usar cada una {#colecciones}

El framework de colecciones de Java proporciona estructuras de datos listas para usar. Importa siempre desde `java.util`.

**ArrayList:** Es una lista basada en un array dinámico que crece automáticamente. Mantiene el orden de inserción. Permite elementos duplicados. Permite acceso por índice en tiempo constante O(1). La búsqueda de un elemento (sin índice) es O(n): recorre toda la lista hasta encontrarlo. Es la colección adecuada para guardar la lista principal de personas en `CentroEducativo`, ya que necesitas mantener el orden, acceder por posición en la recursión, y no necesitas unicidad (ya la controlas con los Sets).

**Declarar con la interfaz, instanciar con la implementación:** La convención en Java es declarar el tipo de la variable usando la interfaz (`List<Persona>`) pero instanciarla con la implementación concreta (`new ArrayList<>()`). Esto permite cambiar la implementación en el futuro sin afectar al resto del código. Si luego decides usar `LinkedList` en lugar de `ArrayList`, solo cambias la línea de instanciación.

**Set:** Es una colección que no permite duplicados. Cuando intentas añadir un elemento que ya existe (según `equals()` y `hashCode()`), `add()` devuelve `false` y el elemento no se añade. No garantiza ningún orden concreto (en `HashSet`). No permite acceso por índice. La operación `contains()` es O(1) en `HashSet`.

**HashSet:** La implementación más común de `Set`. Usa una tabla hash internamente para organizar los elementos, lo que hace que `add()`, `contains()` y `remove()` sean O(1) en el caso promedio. Esto es dramáticamente más rápido que buscar en una `ArrayList` para n grande.

**Por qué usar Sets para documentos y emails en CentroEducativo:** Cuando registras una nueva persona, necesitas comprobar que su documento y email no estén ya registrados. Si usaras la lista de personas para esta comprobación, tendrías que recorrerla entera (O(n)). Con un `HashSet<String>` de documentos registrados, la comprobación `documentosRegistrados.contains(documento)` es O(1). Además, el `Set` de Strings es más simple que buscar en objetos `Persona` completos.

**Set de módulos en Alumno:** El `Set<String>` para módulos asegura que un alumno no pueda tener el mismo módulo dos veces. El método `add()` del Set ya gestiona la unicidad: devuelve `true` si el elemento era nuevo y fue añadido, `false` si ya existía. Puedes usar directamente este valor de retorno en `addModulo()`.

**Proteger las colecciones internas:** Cuando un getter devuelve una colección, si devuelves la referencia directa a la colección interna, quien la reciba puede modificarla externamente sin pasar por los métodos de la clase. Para protegerte, devuelve siempre una copia: `new ArrayList<>(listaInterna)` o `new HashSet<>(setInterno)`. Es una pequeña penalización de rendimiento a cambio de una garantía muy importante de encapsulación.

**Iterar sobre colecciones:** El bucle for-each (`for (Persona p : personas)`) funciona con cualquier clase que implemente la interfaz `Iterable`, que incluye todas las colecciones de Java. Es la forma más limpia de recorrer. Si necesitas el índice durante la iteración, usa el bucle for clásico con índice y `lista.get(i)`. Para la recursión, necesitarás el índice explícito.

---

## 16. ⚖️ El método equals() y hashCode(): por qué son inseparables {#equals}

Por defecto, todos los objetos Java heredan `equals()` de la clase `Object`, que simplemente compara referencias de memoria (si ambas variables apuntan exactamente al mismo objeto). Esto significa que dos objetos `Persona` distintos con los mismos datos serán considerados no iguales por `equals()` por defecto.

**Cuándo necesitas sobreescribir equals():** Siempre que quieras que la "igualdad" de tus objetos se base en sus datos y no en su identidad de memoria. En este proyecto, dos personas son iguales si tienen el mismo `id` (o el mismo `documento`, dependiendo de tu criterio de negocio). Si usas `personas.contains(p)` o `personas.indexOf(p)`, Java llamará internamente a `equals()` para la comparación.

**El contrato de equals():** Un `equals()` correcto debe ser: reflexivo (un objeto es igual a sí mismo), simétrico (si a.equals(b), entonces b.equals(a)), transitivo (si a.equals(b) y b.equals(c), entonces a.equals(c)), y consistente (repetidas llamadas devuelven el mismo resultado mientras los datos no cambien). Además, `equals(null)` siempre debe devolver `false`.

**La estructura estándar de equals():** Primero compruebas si el argumento es el mismo objeto (`this == obj`): si sí, devuelves `true` directamente. Luego compruebas si el argumento es `null`: si sí, devuelves `false`. Luego compruebas si el argumento es del tipo correcto con `instanceof`: si no lo es, devuelves `false`. Si supera todas las comprobaciones, haces el cast y comparas los campos relevantes.

**hashCode() obligatorio:** El contrato Java establece que si `a.equals(b)` es `true`, entonces `a.hashCode()` y `b.hashCode()` deben devolver el mismo valor. Los `HashSet` y `HashMap` usan `hashCode()` para organizar los elementos en "cubetas". Si sobreescribes `equals()` pero no `hashCode()`, dos objetos iguales según tu `equals()` podrían tener hashCodes distintos y el `HashSet` los trataría como objetos diferentes, rompiendo el comportamiento esperado. En este proyecto, como el Set de personas no es de tipo `Set<Persona>` sino `Set<String>` (documentos y emails), el problema no es inmediato, pero es una buena práctica siempre sobreescribir ambos.

---

## 17. ⚠️ Comparar Strings: el error más común en Java {#comparar-strings}

El operador `==` entre objetos compara referencias (si apuntan al mismo objeto en memoria), no contenido. Con Strings, esto lleva a resultados confusos porque Java tiene un pool de literales: dos variables con el mismo literal de String pueden compartir referencia o no, dependiendo de cómo fueron creadas.

**La regla absoluta:** Para comparar el contenido de dos Strings, usa siempre `equals()`. Nunca uses `==` para Strings. Sin excepciones.

**El problema del NullPointerException en comparaciones:** Si escribes `variable.equals("valor")` y `variable` es `null`, obtendrás `NullPointerException`. La forma segura es poner el literal primero: `"valor".equals(variable)`. Un literal String nunca es `null`, así que esta forma es segura independientemente del valor de `variable`. Si ambas variables pueden ser `null`, usa `Objects.equals(a, b)` del paquete `java.util`, que maneja nulos correctamente.

**equalsIgnoreCase():** Para comparar Strings ignorando mayúsculas y minúsculas, usa `equalsIgnoreCase()`. Sin embargo, si has normalizado correctamente tus datos (siempre `toUpperCase()` para documentos, siempre `trim()` para todos), las comparaciones con `equals()` normal deberían funcionar. La normalización consistente es mejor que depender de `equalsIgnoreCase()` en cada comparación.

**startsWith() y endsWith():** `String.startsWith(prefijo)` devuelve `true` si la cadena comienza con el prefijo dado. Es sensible a mayúsculas/minúsculas. Para la búsqueda por prefijo, antes de llamar a `startsWith()` convierte tanto el nombre del objeto como el prefijo buscado a minúsculas (o ambos a mayúsculas): `nombre.toLowerCase().startsWith(prefijo.toLowerCase())`.

---

## 18. 🧹 Normalización de datos: trim(), toUpperCase() y cuándo aplicarlos {#normalizacion}

La normalización consiste en transformar los datos a un formato estándar antes de guardarlos o compararlos. Sin normalización, `" 12345678A "`, `"12345678a"` y `"12345678A"` serían tres valores distintos cuando semánticamente son el mismo documento.

**trim():** Elimina los espacios (y otros caracteres de espacio en blanco como tabuladores) del inicio y el final de un String. No elimina espacios en el interior de la cadena. Debes aplicarlo siempre que recibes un String del exterior (del usuario, de un archivo, de otro sistema), porque los espacios accidentales son muy comunes.

**toUpperCase() y toLowerCase():** Convierten todos los caracteres de la cadena a mayúsculas o minúsculas respectivamente. Para el documento, el README especifica `toUpperCase()`. Para el email, el README deja abierta la opción, pero si decides normalizar a minúsculas, debes hacerlo siempre de forma consistente tanto al guardar como al buscar.

**Cuándo aplicar la normalización:** En los setters y en el constructor, justo antes de asignar el valor al atributo, después de validar. El orden correcto es: recibir → validar (sobre el valor bruto o sobre el normalizado, dependiendo del caso) → normalizar → asignar. Para documentos, normaliza antes de validar (el patrón RegEx puede esperar mayúsculas). Para emails, puedes validar el patrón antes o después según cómo escribas el patrón.

**Normalización en búsquedas:** Cuando buscas por documento en `CentroEducativo`, el documento que recibes como parámetro debe normalizarse antes de comparar, igual que se normalizó al guardar. Si guardas siempre en mayúsculas y cuando buscas no normalizas, `"12345678a"` no encontrará a la persona que fue guardada como `"12345678A"`.

---

## 19. 🏫 La clase CentroEducativo: diseño como servicio y sus invariantes {#centro}

`CentroEducativo` es la clase de servicio que gestiona la colección de personas. Es el "punto de coordinación" entre los datos y el exterior.

**El concepto de invariante de clase:** Una invariante es una condición que debe ser verdadera en todo momento para que el estado del objeto sea coherente. Las invariantes de `CentroEducativo` son: no puede haber dos personas con el mismo `id`; no puede haber dos personas con el mismo `documento`; no puede haber dos personas con el mismo `email`. Cada método que modifica el estado (actualmente solo `registrarPersona`) debe mantener estas invariantes. Si una operación violaría una invariante, debe lanzar excepción y no realizar ningún cambio.

**La relación entre la lista y los Sets:** La lista `personas` es la fuente de verdad: contiene todos los datos de cada persona. Los Sets `documentosRegistrados` y `emailsRegistrados` son estructuras auxiliares de búsqueda rápida: solo almacenan los Strings de documentos y emails para poder comprobar unicidad eficientemente. Deben estar siempre sincronizados con la lista: cuando añades una persona a la lista, añades su documento y email a los Sets; si en algún momento eliminaras una persona (no pedido en la práctica), también eliminarías su documento y email de los Sets.

**Atomicidad de operaciones:** Cuando `registrarPersona` va a añadir una persona, hace primero todas las comprobaciones y solo si todas pasan realiza las tres añadiduras (a la lista y a ambos Sets). No añades a la lista y luego compruebas los Sets: si algo falla a mitad, el estado del objeto quedaría inconsistente. Valida todo primero, actúa después.

**El método buscarPorId() en el contexto de registrarPersona():** Cuando en `registrarPersona` necesitas verificar que el `id` no está repetido, puedes reutilizar `buscarPorId()` internamente. Si devuelve algo distinto de `null`, el id ya existe. Esta reutilización es buena práctica: evita duplicar la lógica de búsqueda.

**Devolver copias vs referencias:** `listarPersonas()` debería devolver una copia de la lista, no la lista interna directamente. Si devuelves la lista interna, el código que la recibe podría añadir o eliminar personas sin pasar por `registrarPersona()`, saltándose todas las validaciones e invariantes. Al devolver `new ArrayList<>(personas)`, quien recibe la lista puede hacer lo que quiera con esa copia, pero la lista interna permanece intacta.

---

## 20. 🔄 Recursividad: cómo pensar en ella y cómo construir buscarPorPrefijo {#recursividad}

La recursividad es una técnica de programación donde un método se resuelve en términos de una versión "más pequeña" del mismo problema, hasta llegar a un caso tan pequeño que se puede resolver directamente sin más recursión.

**La mentalidad recursiva:** En lugar de pensar "voy a recorrer todos los elementos de la lista", piensa: "voy a procesar el elemento en la posición actual, y luego resolveré el mismo problema para el resto de la lista (desde la siguiente posición)". Cada llamada recursiva trabaja sobre una lista efectivamente más pequeña (al avanzar el índice, queda menos lista por procesar).

**Los dos componentes obligatorios de cualquier recursión:**

El **caso base** es la condición que detiene la recursión. Sin caso base, el método se llamaría a sí mismo infinitamente hasta provocar un `StackOverflowError`. En `buscarRec`, el caso base es cuando el índice supera o iguala el tamaño de la lista: ya no hay más elementos que procesar, la función termina (hace `return` sin más).

El **caso recursivo** es la parte donde el método se llama a sí mismo con parámetros que acercan al caso base. En `buscarRec`, el índice incrementa en cada llamada recursiva. Puesto que el índice crece hacia el tamaño de la lista, inevitablemente alcanzará el caso base.

**El método auxiliar privado:** El README sugiere un método auxiliar `buscarRec(int index, String prefijo, ArrayList<Persona> resultado)`. Este patrón es común en recursión: el método público que conoce el exterior llama al método recursivo privado pasándole el estado inicial. El método público también hace las validaciones previas (comprobar que el prefijo no es nulo o vacío). El auxiliar privado solo se ocupa de la lógica recursiva, sin preocuparse por validaciones.

**El ArrayList de resultado como parámetro:** Una forma común de acumular resultados en recursión es pasar la colección resultado como parámetro. Cada llamada recursiva añade a esa misma colección. La alternativa sería que cada llamada devuelva su propia lista y las vaya concatenando, pero es más complicada. Pasar el resultado como parámetro es más eficiente y simple.

**La pila de llamadas:** Cuando `buscarRec` se llama a sí mismo, Java crea un nuevo marco de pila (stack frame) para cada llamada, guardando el estado local de esa invocación (el índice, la referencia al prefijo, la referencia al resultado). Cuando una llamada termina (llega al `return`), su marco se descarta y la ejecución vuelve a la llamada anterior. Para una lista de `n` personas, habrá `n+1` marcos simultáneos en la pila en el peor caso. Con miles de personas esto podría ser un problema (StackOverflow), pero para una práctica académica es perfectamente aceptable.

**Por qué no hay bucles:** La restricción "sin bucles" existe para obligarte a practicar la recursión. Todo lo que se puede hacer con un bucle se puede hacer con recursión y viceversa. La recursión es especialmente natural para estructuras de árbol o grafos; para listas es menos eficiente pero didácticamente valioso.

---

## 21. 📞 Llamar métodos entre clases: cómo se comunican los objetos {#comunicacion}

En un programa orientado a objetos, los objetos colaboran llamándose métodos unos a otros. La clave es entender qué objeto sabe qué y quién tiene que pedir información a quién.

**Acceder a métodos de otra clase:** Para llamar a un método de otro objeto, necesitas una referencia a ese objeto y llamas al método con el operador punto. En `CentroEducativo`, cuando tienes un objeto de tipo `Persona` (llamémoslo `p`), puedes llamar `p.getNombre()`, `p.getId()`, `p.getTipo()`, etc. Solo puedes llamar métodos que sean `public` o `protected` (si estás en la misma jerarquía de herencia o paquete).

**Métodos estáticos: llamada sin objeto:** Para `Validaciones.emailValido(email)`, no necesitas crear un objeto `Validaciones`. El método es `static`, pertenece a la clase, y se llama usando el nombre de la clase directamente. Desde cualquier clase del proyecto, en cualquier momento, puedes llamar `Validaciones.documentoValido(algun_string)`.

**La cadena de responsabilidades en este proyecto:** Cuando el usuario registra un alumno en `Main`, el flujo es: Main recoge los datos del teclado → Main crea un objeto `Alumno` (el constructor de `Alumno` llama al constructor de `Persona` via `super()`, y ambos usan `Validaciones` para validar) → Main llama a `centro.registrarPersona(alumno)` → `CentroEducativo` valida la unicidad y añade a sus colecciones. Cada capa hace solo lo que le corresponde.

**El objeto `Scanner` en Main:** Para leer datos del teclado, usas un objeto `Scanner` inicializado con `System.in`. En `Main`, es conveniente declararlo como atributo estático de la clase para que todos los métodos de `Main` puedan usarlo sin pasarlo como parámetro. Igualmente para el objeto `CentroEducativo`. Esto es una excepción al principio de "no usar estado global", justificada por ser el punto de entrada del programa.

---

## 22. 💻 El menú (Main): lectura de datos con Scanner y manejo de errores {#main}

El `Main` tiene una única responsabilidad: gestionar la interacción con el usuario. Lee datos, llama al servicio, muestra resultados y mensajes.

**El bucle del menú:** El menú principal es un bucle `do-while` o `while` que se repite hasta que el usuario elige "Salir". Dentro, muestras las opciones, lees la elección y ejecutas la acción correspondiente con un `switch`. Con Java moderno (Java 14+) puedes usar el `switch` con flechas (`case 1 -> metodo()`), que es más limpio y no requiere `break`.

**Leer enteros de forma robusta:** `Scanner.nextInt()` lee un entero pero falla con `InputMismatchException` si el usuario escribe letras. La forma robusta es leer siempre como String con `nextLine()` y luego intentar convertir con `Integer.parseInt(cadena)`, capturando la `NumberFormatException`. Así puedes mostrar un mensaje útil y pedir al usuario que lo vuelva a intentar, en lugar de que el programa explote.

**El problema de nextLine() después de nextInt():** Si en algún momento usas `nextInt()` directamente, este método no consume el carácter de salto de línea `\n` final que el usuario pulsó con Enter. El siguiente `nextLine()` leerá esa cadena vacía en lugar del texto que el usuario escriba. La solución es evitar `nextInt()` y leer siempre con `nextLine()`, o bien llamar a un `nextLine()` extra después de cada `nextInt()` para consumir el salto de línea pendiente.

**Crear métodos auxiliares de lectura:** En lugar de repetir el mismo código de validación de entrada en cada opción del menú, extrae métodos privados en `Main`: uno para leer enteros en un rango, otro para leer Strings con longitud mínima, otro para leer fechas. Estos métodos implementan el bucle de "pide dato → si es inválido → muestra error → vuelve a pedir". Reducen la duplicación de código y hacen el código del menú mucho más limpio.

**Separar el registro de alumno y de profesor:** Aunque los datos son similares, es más limpio tener métodos separados `registrarAlumno()` y `registrarProfesor()` que un solo método con condicionales. Cada uno sabe qué datos pedir (el de alumno pide curso; el de profesor pide departamento) y crea el tipo correcto de objeto.

**Mostrar el resultado de búsquedas:** Cuando un método de búsqueda devuelve `null` (no encontrado), muestra un mensaje informativo. Cuando devuelve una lista, comprueba si está vacía antes de iterar. Cuando devuelve un objeto, muestra su `toString()`.

---

## 23. 📝 toString(): cómo construir representaciones textuales útiles {#tostring}

`toString()` es el método que Java llama automáticamente cuando intentas usar un objeto donde se espera un String, por ejemplo en `System.out.println(persona)` o en concatenación con `+`.

**Sobreescribir toString() en Persona:** El `toString()` de `Persona` debe incluir todos los atributos relevantes: tipo (llamando a `getTipo()` que cada subclase implementa), id, nombre, documento, email, fecha de nacimiento, fecha de registro, y edad (calculada llamando a `getEdad()`). Usa `String.format()` para construir el string de forma ordenada, especificando cada campo con marcadores de posición `%s`, `%d`, `%tF` (para fechas), etc.

**Sobreescribir toString() en las subclases:** En `Alumno`, quieres incluir el `toString()` de `Persona` más los campos propios (`curso`, y los módulos si los hay). La forma elegante es llamar a `super.toString()` para obtener la parte del padre y luego concatenar o formatear los campos adicionales.

**String.format() vs concatenación:** Para strings complejos con muchos campos, `String.format()` es más legible que la concatenación con `+`. Los marcadores de posición `%s` insertan el valor de `toString()` del argumento, `%d` para enteros, `%tF` para fechas en formato ISO, `%n` para salto de línea (equivalente al carácter de salto de línea del sistema operativo, más portable que `"\n"`).

---

## 24. 🔐 final: cuándo y por qué hacer atributos o métodos inmutables {#final}

La palabra clave `final` aplicada a diferentes elementos tiene significados relacionados pero distintos.

**Atributo final de instancia:** Un atributo declarado como `final` en una clase debe inicializarse exactamente una vez: en la declaración, en un bloque inicializador, o en el constructor. Después de eso, su valor no puede cambiar. Si intentas asignarle otro valor, el compilador da error. En `Persona`, `id` y `fechaRegistro` son `final` porque una vez que una persona existe, su identificador y su fecha de registro no deberían cambiar nunca. El compilador te ayuda a garantizar esta invariante.

**Atributo final estático (constante):** Un atributo `static final` es una constante de clase. Por convención se nombra en MAYÚSCULAS_CON_GUIONES. Los `Pattern` en `Validaciones` son el ejemplo típico: se compilan una vez cuando la clase se carga y nunca cambian.

**Método final:** Un método declarado `final` no puede ser sobreescrito por ninguna subclase. En `Persona`, `getId()` y `getFechaRegistro()` tienen sentido como `final`: aunque `Alumno` hereda estos métodos, no tiene sentido que `Alumno` redefina cómo se obtiene el id o la fecha de registro. El `final` en el método es una documentación de la intención de diseño además de una protección técnica.

**Clase final:** Una clase `final` no puede ser extendida. No aplica directamente en este proyecto, pero es útil saberlo: `String` en Java es `final`, por eso no puedes crear una subclase de `String`.

---

## 25. 📐 Orden recomendado de construcción del proyecto {#orden}

Construir en el orden correcto evita dependencias no resueltas y te permite probar cada pieza antes de añadir la siguiente.

**Paso 1 — Clase Validaciones:** Empieza aquí porque es independiente de todo lo demás. Puedes escribir los métodos `emailValido()` y `documentoValido()` con sus patrones RegEx y probarlos inmediatamente con un `main` temporal, pasando diferentes cadenas y verificando que devuelven `true` o `false` como esperas. No avances hasta que las validaciones sean correctas.

**Paso 2 — Clase abstracta Persona:** Crea los atributos, el constructor completo con todas las validaciones llamando a `Validaciones`, los getters y setters (también con validaciones), el método concreto `getEdad()` usando `Period`, y declara `getTipo()` como abstracto. No puedes probar `Persona` directamente (es abstracta), pero el compilador te dirá si hay errores.

**Paso 3 — Clase Alumno:** Extiende `Persona`. Añade el atributo `curso` y su validación. Implementa `getTipo()`. Sobreescribe `toString()` incluyendo `super.toString()`. Añade el `Set<String>` de módulos y los métodos `addModulo`, `removeModulo`, `getModulos`. Ahora sí puedes crear instancias de `Alumno` y probar que todo funciona.

**Paso 4 — Clase Profesor:** Similar a `Alumno` pero con `departamento`. Es más simple (no tiene Set de módulos). Una vez que dominas `Alumno`, `Profesor` debería ser rápido.

**Paso 5 — Clase CentroEducativo:** Con los modelos funcionando, implementa el servicio. Primero el constructor y la estructura de datos. Luego `registrarPersona` con todas las validaciones de unicidad. Luego `buscarPorId` y `buscarPorDocumento` (necesarios para las validaciones de `registrarPersona`). Luego `listarPersonas`, `listarAlumnos`, `listarProfesores`. Finalmente la recursión `buscarPorPrefijo`.

**Paso 6 — Main:** Ahora tienes todo para construir la interfaz. Empieza con el bucle del menú y una opción simple (listar personas, que inicialmente devuelve lista vacía). Ve añadiendo una opción a la vez. Los métodos auxiliares de lectura (enteros, fechas, texto) redúcelos primero y luego reutilízalos en cada opción del menú.

---

## 26. ✅ Checklist de errores comunes {#errores}

Antes de dar por terminado el proyecto, revisa cada uno de estos puntos:

**Sobre constructores y herencia:**
- ¿Es `super(...)` la primera línea de cada constructor de `Alumno` y `Profesor`? Si tienes cualquier otra instrucción antes, el compilador te dará error.
- ¿Has definido todos los constructores que pide el README en cada clase?
- ¿Los constructores de las subclases validan sus propios atributos DESPUÉS de llamar a `super()`?

**Sobre validaciones:**
- ¿Estás normalizando (`trim()`, `toUpperCase()`) antes de guardar en TODOS los constructores y setters?
- ¿Estás normalizando también en las BÚSQUEDAS para que la comparación sea correcta?
- ¿Cada `IllegalArgumentException` tiene un mensaje descriptivo que incluye el valor que causó el error?
- ¿Está la validación de `null` como primera comprobación en todos los métodos que reciben objetos o Strings?

**Sobre comparaciones:**
- ¿Estás usando `equals()` y nunca `==` para comparar Strings?
- ¿El `startsWith()` de la búsqueda por prefijo normaliza a minúsculas (o mayúsculas) tanto el nombre como el prefijo?

**Sobre colecciones:**
- ¿Los getters de colecciones devuelven copias y no referencias directas?
- ¿Se actualizan los Sets `documentosRegistrados` y `emailsRegistrados` cada vez que añades una persona?

**Sobre la recursión:**
- ¿Existe claramente un caso base que detiene la recursión cuando el índice supera el tamaño de la lista?
- ¿El índice crece en cada llamada recursiva, garantizando que inevitablemente se alcanza el caso base?
- ¿No hay ningún bucle `for`, `while` o `do-while` dentro de los métodos de búsqueda recursiva?

**Sobre la estructura del proyecto:**
- ¿Cada archivo tiene la declaración de paquete correcta como primera línea?
- ¿Los imports están completos? (`java.util.ArrayList`, `java.util.List`, `java.util.Set`, `java.util.HashSet`, `java.time.LocalDate`, `java.time.Period`, `java.util.regex.Pattern`)
- ¿`getTipo()` está sobreescrito con `@Override` en tanto `Alumno` como `Profesor`?
- ¿`toString()` está sobreescrito con `@Override` en `Persona`, `Alumno` y `Profesor`?

**Sobre el Main:**
- ¿El programa no explota si el usuario introduce un texto cuando se espera un número?
- ¿El programa no explota si el usuario introduce una fecha con formato incorrecto?
- ¿Cada operación que puede lanzar `IllegalArgumentException` está dentro de un `try-catch`?
- ¿Los mensajes de error son comprensibles para un usuario no técnico?
- ¿El menú vuelve a mostrarse correctamente después de un error?

---

*Guía técnica de referencia — Práctica de Gestión de Personas de un Centro Educativo — Java SE 8+*
