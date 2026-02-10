Cheat Sheet: Expresiones Regulares en Java
🎯 Conceptos Básicos
Formas de usar RegEx en Java
java// 1. String.matches() - Verificar si TODA la cadena coincide
boolean coincide = texto.matches("\\d+");  // true si todo son dígitos

// 2. Pattern y Matcher - Más control y funcionalidad
Pattern patron = Pattern.compile("\\d+");
Matcher matcher = patron.matcher(texto);

// 3. String.split() - Dividir texto
String[] partes = texto.split(",");

// 4. String.replaceAll() - Reemplazar ocurrencias
String nuevo = texto.replaceAll("\\d", "X");

// 5. String.replaceFirst() - Reemplazar primera ocurrencia
String nuevo = texto.replaceFirst("\\d", "X");

🔤 Metacaracteres Básicos
java.       // Cualquier carácter (excepto salto de línea)
\d      // Dígito [0-9]
\D      // No dígito [^0-9]
\w      // Palabra [a-zA-Z0-9_]
\W      // No palabra [^a-zA-Z0-9_]
\s      // Espacio en blanco [ \t\n\r\f]
\S      // No espacio en blanco
\b      // Límite de palabra
\B      // No límite de palabra

// Ejemplos
"abc123".matches("\\w+")      // true - letras y números
"  ".matches("\\s+")           // true - espacios
"123".matches("\\d{3}")        // true - 3 dígitos
"hola".matches("\\w{4}")       // true - 4 caracteres de palabra

📊 Cuantificadores
java*       // 0 o más veces
+       // 1 o más veces
?       // 0 o 1 vez (opcional)
{n}     // Exactamente n veces
{n,}    // n o más veces
{n,m}   // Entre n y m veces

// Ejemplos
"".matches("a*")               // true - 0 o más 'a'
"aaa".matches("a*")            // true
"aaa".matches("a+")            // true - 1 o más 'a'
"".matches("a+")               // false - requiere al menos 1

"color".matches("colou?r")     // true - 'u' opcional
"colour".matches("colou?r")    // true

"123".matches("\\d{3}")        // true - exactamente 3 dígitos
"1234".matches("\\d{3}")       // false

"12345".matches("\\d{3,}")     // true - 3 o más dígitos
"12".matches("\\d{3,}")        // false

"1234".matches("\\d{2,4}")     // true - entre 2 y 4 dígitos
"12345".matches("\\d{2,4}")    // false
Cuantificadores Greedy vs Reluctant vs Possessive
java// Greedy (por defecto) - toma el máximo posible
.*      // greedy
.+      // greedy
.?      // greedy

// Reluctant (perezoso) - toma el mínimo posible
.*?     // reluctant
.+?     // reluctant
.??     // reluctant

// Possessive - como greedy pero sin backtracking
.*+     // possessive
.++     // possessive
.?+     // possessive

// Ejemplo práctico
String html = "<div>Hola</div><div>Mundo</div>";

// Greedy: captura todo desde el primer < hasta el último >
html.replaceAll("<.*>", "X");  // "X"

// Reluctant: captura la menor cantidad posible
html.replaceAll("<.*?>", "X");  // "XXXXolasX/divX>XMundoX/divX>"

🎨 Clases de Caracteres
java[abc]       // a, b, o c
[^abc]      // Cualquiera excepto a, b, o c
[a-z]       // De a hasta z (minúsculas)
[A-Z]       // De A hasta Z (mayúsculas)
[a-zA-Z]    // Letras (mayúsculas o minúsculas)
[0-9]       // Dígitos
[a-zA-Z0-9] // Alfanumérico

// Ejemplos
"a".matches("[abc]")           // true
"d".matches("[abc]")           // false
"d".matches("[^abc]")          // true - cualquiera excepto a,b,c

"5".matches("[0-9]")           // true
"m".matches("[a-z]")           // true
"M".matches("[a-z]")           // false
"M".matches("[A-Z]")           // true

// Clases predefinidas
[a-zA-Z]    // Igual a (?i)[a-z] con flag CASE_INSENSITIVE
\p{Lower}   // Minúsculas
\p{Upper}   // Mayúsculas
\p{Alpha}   // Letras
\p{Digit}   // Dígitos
\p{Alnum}   // Alfanumérico
\p{Punct}   // Puntuación
\p{Space}   // Espacios

🚩 Anclas y Límites
java^       // Inicio de línea/cadena
$       // Fin de línea/cadena
\b      // Límite de palabra
\B      // No límite de palabra
\A      // Inicio de cadena (absoluto)
\Z      // Fin de cadena (absoluto)

// Ejemplos
"hola".matches("^hola$")       // true - inicio y fin
"hola mundo".matches("^hola$") // false - hay más texto

"hola".matches("hola")         // true - sin anclas también funciona
"ahola".matches("hola")        // false - hola no está al inicio

// Límites de palabra
"hola mundo".matches(".*\\bhola\\b.*")  // true - "hola" como palabra completa
"holaMundo".matches(".*\\bhola\\b.*")   // false - "hola" no es palabra completa

// Validar que TODA la cadena cumple un patrón
"12345".matches("^\\d+$")      // true
"12345".matches("\\d+")        // true (equivalente)

🔀 Alternancia y Agrupación
java|           // O (alternancia)
(...)       // Grupo de captura
(?:...)     // Grupo sin captura (non-capturing)
(?<name>...)// Grupo nombrado

// Alternancia
"gato".matches("gato|perro")   // true
"perro".matches("gato|perro")  // true
"pájaro".matches("gato|perro") // false

// Agrupación
"ababab".matches("(ab)+")      // true - repite "ab"
"gray".matches("gr(a|e)y")     // true
"grey".matches("gr(a|e)y")     // true

// Ejemplos de grupos
Pattern p = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");
Matcher m = p.matcher("15/03/2024");
if (m.matches()) {
    String dia = m.group(1);    // "15"
    String mes = m.group(2);    // "03"
    String año = m.group(3);    // "2024"
}

// Grupo sin captura (más eficiente si no necesitas extraer)
"color".matches("(?:color|colour)")  // true, pero no captura

// Grupo nombrado
Pattern p = Pattern.compile("(?<dia>\\d{2})/(?<mes>\\d{2})/(?<año>\\d{4})");
Matcher m = p.matcher("15/03/2024");
if (m.matches()) {
    String dia = m.group("dia");  // "15"
    String mes = m.group("mes");  // "03"
    String año = m.group("año");  // "2024"
}

🎭 Lookahead y Lookbehind
java(?=...)     // Positive lookahead - seguido por...
(?!...)     // Negative lookahead - NO seguido por...
(?<=...)    // Positive lookbehind - precedido por...
(?<!...)    // Negative lookbehind - NO precedido por...

// Positive lookahead - debe estar seguido por...
"abc123".matches("\\w+(?=\\d)")    // false - busca palabras seguidas de dígito
"abc".matches("\\w+(?=\\d)")       // false

Pattern p = Pattern.compile("\\w+(?=\\d)");
Matcher m = p.matcher("abc123");
if (m.find()) {
    System.out.println(m.group()); // "abc" (captura hasta antes del dígito)
}

// Negative lookahead - NO debe estar seguido por...
"abc".matches("\\w+(?!\\d)")       // true - palabra NO seguida de dígito
"abc123".matches("\\w+(?!\\d)")    // false

// Positive lookbehind - debe estar precedido por...
Pattern p = Pattern.compile("(?<=@)\\w+");
Matcher m = p.matcher("user@gmail");
if (m.find()) {
    System.out.println(m.group()); // "gmail" (después de @)
}

// Negative lookbehind - NO debe estar precedido por...
Pattern p = Pattern.compile("(?<!@)\\w+");
Matcher m = p.matcher("user@gmail");
if (m.find()) {
    System.out.println(m.group()); // "user" (no precedido de @)
}

// Ejemplo práctico: Validar contraseña con lookaheads
// Mínimo 8 caracteres, al menos 1 mayúscula, 1 minúscula, 1 número
String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
"Pass1234".matches(regex);  // true
"password".matches(regex);  // false - falta mayúscula y número

🛠️ Pattern y Matcher
Compilar y usar Pattern
java// Compilar patrón (reutilizable)
Pattern patron = Pattern.compile("\\d+");

// Con flags
Pattern patron = Pattern.compile("hola", Pattern.CASE_INSENSITIVE);
Pattern patron = Pattern.compile("^.*$", Pattern.MULTILINE);

// Múltiples flags
Pattern patron = Pattern.compile(
    "regex", 
    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
);
Flags comunes
javaPattern.CASE_INSENSITIVE     // Ignora mayúsculas/minúsculas
Pattern.MULTILINE            // ^ y $ funcionan en cada línea
Pattern.DOTALL               // . incluye saltos de línea
Pattern.UNICODE_CASE         // Case-insensitive Unicode
Pattern.COMMENTS             // Permite comentarios en regex

// En el regex mismo (embedded flags)
"(?i)hola"    // Case insensitive
"(?m)^texto"  // Multiline
"(?s).*"      // Dotall
"(?x)\\d + "  // Comments (ignora espacios)
Métodos de Matcher
javaPattern p = Pattern.compile("\\d+");
Matcher m = p.matcher("abc 123 def 456");

// matches() - Toda la cadena debe coincidir
boolean coincide = m.matches();

// find() - Buscar siguiente ocurrencia
while (m.find()) {
    System.out.println(m.group());  // "123", luego "456"
}

// lookingAt() - Coincide desde el inicio
m.lookingAt();  // false en este ejemplo ("abc" no es dígito)

// group() - Obtener coincidencia
String coincidencia = m.group();
String grupo1 = m.group(1);  // Primer grupo capturado

// start() y end() - Posiciones
int inicio = m.start();
int fin = m.end();

// replaceAll() y replaceFirst()
String resultado = m.replaceAll("X");      // "abc X def X"
String resultado = m.replaceFirst("X");    // "abc X def 456"

// reset() - Reiniciar matcher
m.reset();
m.reset("nuevo texto");  // Con nuevo texto

📋 Ejemplos Prácticos Comunes
Email
javaString emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
"user@example.com".matches(emailRegex);  // true
Teléfono
java// Formato español: 9 dígitos empezando por 6, 7, 8 o 9
String telefonoRegex = "^[6789]\\d{8}$";
"612345678".matches(telefonoRegex);  // true

// Con prefijo internacional opcional
String telRegex = "^(\\+34)?[6789]\\d{8}$";
"+34612345678".matches(telRegex);  // true
"612345678".matches(telRegex);     // true
DNI/NIF Español
javaString nifRegex = "^\\d{8}[A-Z]$";
"12345678Z".matches(nifRegex);  // true (solo formato)

// Validación completa con letra correcta
public static boolean validarNIF(String nif) {
    if (!nif.matches("^\\d{8}[A-Z]$")) return false;
    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    int numero = Integer.parseInt(nif.substring(0, 8));
    char letra = nif.charAt(8);
    return letra == letras.charAt(numero % 23);
}
URL
javaString urlRegex = "^https?://[\\w.-]+(:\\d+)?(/[\\w.-]*)*/?$";
"https://ejemplo.com/path".matches(urlRegex);  // true
Código Postal Español
javaString cpRegex = "^\\d{5}$";
"28001".matches(cpRegex);  // true
Tarjeta de Crédito
java// Visa, MasterCard, etc. (formato básico)
String tarjetaRegex = "^\\d{4}[- ]?\\d{4}[- ]?\\d{4}[- ]?\\d{4}$";
"1234 5678 9012 3456".matches(tarjetaRegex);  // true
"1234-5678-9012-3456".matches(tarjetaRegex);  // true
"1234567890123456".matches(tarjetaRegex);     // true
Contraseña Segura
java// Mínimo 8 caracteres, 1 mayúscula, 1 minúscula, 1 número, 1 especial
String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
"Pass123!".matches(passRegex);  // true
"password".matches(passRegex);  // false
Fecha DD/MM/YYYY
java// Formato básico (no valida días/meses válidos)
String fechaRegex = "^\\d{2}/\\d{2}/\\d{4}$";
"15/03/2024".matches(fechaRegex);  // true

// Más estricto (días 01-31, meses 01-12)
String fechaRegex2 = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
"15/03/2024".matches(fechaRegex2);  // true
"32/13/2024".matches(fechaRegex2);  // false
Hora HH:MM
javaString horaRegex = "^([01]\\d|2[0-3]):[0-5]\\d$";
"14:30".matches(horaRegex);  // true
"25:00".matches(horaRegex);  // false
IPv4
javaString ipRegex = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
"192.168.1.1".matches(ipRegex);  // true
"256.1.1.1".matches(ipRegex);    // false
Nombre de Usuario
java// 3-16 caracteres alfanuméricos, guiones y guiones bajos
String userRegex = "^[a-zA-Z0-9_-]{3,16}$";
"user_123".matches(userRegex);  // true
"us".matches(userRegex);        // false (muy corto)
Hexadecimal
javaString hexRegex = "^#?[0-9A-Fa-f]{6}$";
"#FF5733".matches(hexRegex);  // true
"FF5733".matches(hexRegex);   // true

🎯 Extraer Información
Encontrar todas las coincidencias
javaPattern p = Pattern.compile("\\d+");
Matcher m = p.matcher("Tengo 5 manzanas y 3 naranjas");

while (m.find()) {
    System.out.println(m.group());  // "5", "3"
}
Extraer grupos
javaPattern p = Pattern.compile("(\\w+)@(\\w+\\.\\w+)");
Matcher m = p.matcher("Contacto: user@example.com");

if (m.find()) {
    String completo = m.group(0);  // "user@example.com"
    String usuario = m.group(1);   // "user"
    String dominio = m.group(2);   // "example.com"
}
Reemplazar con referencia a grupos
javaString texto = "15/03/2024";
String resultado = texto.replaceAll(
    "(\\d{2})/(\\d{2})/(\\d{4})", 
    "$3-$2-$1"  // Referencia a grupos: $1, $2, $3
);
System.out.println(resultado);  // "2024-03-15"
Split avanzado
javaString texto = "apple,banana;orange:grape";
String[] frutas = texto.split("[,;:]");
// ["apple", "banana", "orange", "grape"]

// Mantener delimitadores
String[] partes = texto.split("(?=[,;:])");
// ["apple", ",banana", ";orange", ":grape"]

⚠️ Caracteres Especiales que Necesitan Escape
java// En Java necesitas doble backslash
\\ . * + ? ^ $ ( ) [ ] { } | /

// Ejemplos
"\\.".matches(".")       // false - busca punto literal
".".matches("\\.")       // true
"$100".matches("\\$\\d+") // true
"(abc)".matches("\\(\\w+\\)") // true

// Dentro de clases de caracteres [] algunos no necesitan escape
"[.]" // punto literal (no necesita escape dentro de [])
"[-]" // guion literal
"[^]" // circunflejo al inicio niega la clase

💡 Tips y Mejores Prácticas
1. Compilar patrones reutilizables
java// ❌ Ineficiente - compila cada vez
for (String email : emails) {
    if (email.matches("^[A-Za-z0-9+_.-]+@.*$")) {
        // ...
    }
}

// ✅ Eficiente - compila una vez
Pattern patron = Pattern.compile("^[A-Za-z0-9+_.-]+@.*$");
for (String email : emails) {
    if (patron.matcher(email).matches()) {
        // ...
    }
}
2. Usar grupos sin captura cuando no necesites extraer
java// ❌ Captura innecesaria
"(?:color|colour)"  // más eficiente

// ✅ Solo usa () cuando necesites extraer
"(color|colour)"
3. Anclar patrones para validación
java// ❌ Permite texto adicional
"\\d+".matches("abc123def")  // encuentra "123" pero no valida toda la cadena

// ✅ Valida toda la cadena
"^\\d+$".matches("123")  // true
"^\\d+$".matches("abc123")  // false
4. Usar Character Classes predefinidas
java// ❌ Menos legible
"[0-9]+".matches("123")

// ✅ Más claro
"\\d+".matches("123")
5. Comentar regex complejas
javaPattern p = Pattern.compile(
    "(?x)" +           // Modo comentarios
    "^" +              // Inicio
    "(?=.*[a-z])" +    // Al menos una minúscula
    "(?=.*[A-Z])" +    // Al menos una mayúscula
    "(?=.*\\d)" +      // Al menos un dígito
    ".{8,}" +          // Mínimo 8 caracteres
    "$"                // Fin
);

🚨 Errores Comunes
java// ❌ Olvidar escapar backslash
"\d+"  // Error: secuencia de escape inválida
"\\d+" // ✅ Correcto

// ❌ Usar matches() cuando quieres find()
"hola mundo".matches("hola")  // false (no coincide TODA la cadena)
Pattern.compile("hola").matcher("hola mundo").find()  // true

// ❌ No anclar cuando se necesita validación completa
"abc123".matches("\\d+")  // false (no valida toda la cadena)
"123".matches("\\d+")     // true

// ❌ Olvidar que matches() requiere coincidencia completa
"123abc".matches("\\d+")  // false
"123".matches("\\d+")     // true