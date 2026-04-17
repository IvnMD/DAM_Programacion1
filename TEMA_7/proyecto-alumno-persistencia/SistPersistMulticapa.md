# Sistema de Persistencia Multicapa: Explicación Profunda

## Arquitectura General

El proyecto sigue un patrón de capas bien definido:

```
App (Main) → Service → Repository → Fichero/BD
```

Cada capa tiene una responsabilidad única: la **capa de servicio** valida y aplica reglas de negocio, la **capa de repositorio** accede a los datos, y los **modelos** representan la información.

---

## 1. CRUD con XML (usando Jackson XmlMapper)

### ¿Qué es XmlMapper?

`XmlMapper` es una extensión de `ObjectMapper` de Jackson que serializa y deserializa objetos Java hacia/desde XML. Pertenece a la dependencia `jackson-dataformat-xml`.

### El problema del XML con listas

XML no tiene una forma nativa de representar arrays planos como JSON. Si quisieras guardar una lista de clientes directamente, Jackson no sabría qué etiqueta raíz usar. Por eso el proyecto introduce **clases contenedoras** (wrappers):

```java
// Clientes.java
@JacksonXmlRootElement(localName = "clientes")  // etiqueta raíz del XML
public class Clientes {

    @JacksonXmlProperty(localName = "cliente")       // cada elemento se llama "cliente"
    @JacksonXmlElementWrapper(useWrapping = false)   // NO añadir etiqueta intermedia extra
    private List<Cliente> items = new ArrayList<>();
}
```

Esto produce un XML como:
```xml
<clientes>
    <cliente><id>1</id><nombre>Ana</nombre>...</cliente>
    <cliente><id>2</id><nombre>Luis</nombre>...</cliente>
</clientes>
```

Sin `useWrapping = false`, Jackson generaría una etiqueta `<items>` extra, lo que no queremos.

### Flujo completo de ClienteXmlRepository

```java
public class ClienteXmlRepository implements IClienteRepository {

    private Path path;      // ruta al fichero .xml
    private XmlMapper xmlMapper;  // motor de serialización XML
```

#### Inicialización defensiva del Path

```java
private Path inicializarPath(String ruta) {
    try {
        Path path = Path.of(ruta);           // convierte String → Path
        crearCarpetasSiNoExisten(path);      // mkdir -p de las carpetas padre
        comprobarQueNoEsDirectorio(path, ruta); // seguridad: la ruta no puede ser una carpeta
        crearFicheroSiNoExiste(path);        // touch del fichero si no existe
        return path;
    } catch (IOException e) {
        throw new RuntimeException("No se pudo preparar el fichero XML: " + ruta, e);
    }
}
```

Este patrón se repite en JSON y CSV. La idea es que el repositorio sea **autocontenido**: si el fichero o carpeta no existen, los crea él mismo sin que el usuario tenga que preocuparse.

#### findAll() — Leer todos

```java
public List<Cliente> findAll() {
    try {
        // Comprobación doble: fichero existe Y no está vacío
        if (!Files.exists(path) || Files.size(path) == 0L) {
            return new ArrayList<>();   // devuelve lista vacía, nunca null
        }
        
        // XmlMapper lee el fichero y lo convierte en el wrapper Clientes
        Clientes wrapper = xmlMapper.readValue(path.toFile(), Clientes.class);
        
        List<Cliente> clientes = wrapper.getItems();
        
        // Protección contra null: si el XML estaba vacío o malformado
        return clientes == null ? new ArrayList<>() : clientes;
        
    } catch (Exception e) {
        throw new RuntimeException("No se pudo leer el fichero XML de clientes", e);
    }
}
```

`xmlMapper.readValue(path.toFile(), Clientes.class)` hace todo el trabajo pesado: parsea el XML, mapea cada etiqueta `<cliente>` a un objeto `Cliente`, y los mete en la lista `items` del wrapper.

#### create() — Insertar

```java
public boolean create(Cliente cliente) {
    // Validación triple: no null, tiene id, y no existe ya
    if (cliente == null || cliente.getId() == null || findById(cliente.getId()) != null) {
        return false;
    }
    
    List<Cliente> clientes = findAll();   // lee el estado actual
    clientes.add(cliente);                // añade el nuevo
    writeAll(clientes);                   // sobreescribe el fichero completo
    return true;
}
```

**Punto clave**: el repositorio XML hace un **read-modify-write** completo. No existe un `INSERT` parcial: siempre se lee todo, se modifica la lista en memoria, y se reescribe el fichero entero. Esto es más lento que una BD, pero es lo natural para ficheros.

#### writeAll() — Guardar la lista completa

```java
private void writeAll(List<Cliente> clientes) {
    try {
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());  // crea carpetas si faltan
        }
        
        Clientes wrapper = new Clientes();
        wrapper.setItems(clientes);  // envuelve la lista en el contenedor XML
        
        // writerWithDefaultPrettyPrinter() añade sangría al XML resultante
        xmlMapper.writerWithDefaultPrettyPrinter()
                 .writeValue(path.toFile(), wrapper);
                 
    } catch (Exception e) {
        throw new RuntimeException("No se pudo escribir el fichero XML de clientes", e);
    }
}
```

`writerWithDefaultPrettyPrinter()` produce XML legible con indentación en lugar de una sola línea plana.

#### update() y deleteById()

```java
public boolean update(Cliente clienteActualizado) {
    List<Cliente> clientes = findAll();
    for (int i = 0; i < clientes.size(); i++) {
        if (clientes.get(i).getId().equals(clienteActualizado.getId())) {
            clientes.set(i, clienteActualizado);  // reemplaza en la posición i
            writeAll(clientes);                   // guarda todo
            return true;
        }
    }
    return false;  // no encontrado
}

public boolean deleteById(Long id) {
    List<Cliente> clientes = findAll();
    // removeIf recorre la lista y elimina los elementos que cumplen la condición
    boolean eliminado = clientes.removeIf(cliente -> cliente.getId().equals(id));
    if (eliminado) {
        writeAll(clientes);
    }
    return eliminado;
}
```

`removeIf` con lambda es equivalente a iterar con `Iterator` y llamar `iterator.remove()`, pero más conciso. Devuelve `true` si eliminó al menos un elemento.

---

## 2. CRUD con JSON (usando ObjectMapper)

### ¿Qué es ObjectMapper?

`ObjectMapper` de Jackson convierte objetos Java a JSON y viceversa. A diferencia de XML, JSON representa listas de forma nativa con `[]`, por lo que **no se necesitan clases contenedoras**.

### Cómo debería implementarse ClienteJsonRepository

El esqueleto que el alumno debe completar sería:

```java
public class ClienteJsonRepository implements IClienteRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public ClienteJsonRepository(String ruta) {
        this.path = inicializarPath(ruta);
        this.objectMapper = new ObjectMapper();
    }
```

#### findAll() con TypeReference

El reto de JSON es que `objectMapper.readValue()` necesita saber el tipo exacto. Para listas genéricas se usa `TypeReference`:

```java
public List<Cliente> findAll() {
    try {
        if (!Files.exists(path) || Files.size(path) == 0L) {
            return new ArrayList<>();
        }
        
        // TypeReference informa a Jackson del tipo List<Cliente>
        // Sin esto, Jackson devolvería List<LinkedHashMap> en lugar de List<Cliente>
        JavaType type = objectMapper.getTypeFactory()
                                    .constructCollectionType(List.class, Cliente.class);
        
        return objectMapper.readValue(path.toFile(), type);
        
    } catch (Exception e) {
        throw new RuntimeException("Error leyendo JSON de clientes", e);
    }
}
```

También se puede usar `TypeReference` directamente:
```java
List<Cliente> clientes = objectMapper.readValue(
    path.toFile(), 
    new TypeReference<List<Cliente>>() {}
);
```

#### writeAll() en JSON

```java
private void writeAll(List<Cliente> clientes) {
    try {
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        // Serializa la lista directamente sin wrapper
        // writerWithDefaultPrettyPrinter produce JSON indentado
        objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(path.toFile(), clientes);
    } catch (Exception e) {
        throw new RuntimeException("Error escribiendo JSON de clientes", e);
    }
}
```

El JSON resultante es un array plano:
```json
[
  {"id": 1, "nombre": "Ana", ...},
  {"id": 2, "nombre": "Luis", ...}
]
```

### Diferencia clave JSON vs XML

| Aspecto | JSON | XML |
|---|---|---|
| Listas | Array nativo `[]` | Necesita wrapper class |
| Anotaciones modelo | Ninguna extra | `@JacksonXmlRootElement`, `@JacksonXmlProperty` |
| Clase del mapper | `ObjectMapper` | `XmlMapper` (extiende ObjectMapper) |
| Dependencia Maven | `jackson-databind` | `jackson-dataformat-xml` |

---

## 3. CRUD con CSV (lectura manual con BufferedReader)

### ¿Por qué manual y no con una librería?

El proyecto implementa la lectura CSV desde cero para que el alumno entienda el proceso. La clase abstracta `CsvReaderAbstract` centraliza la lógica:

```java
abstract class CsvReaderAbstract {

    public List<String[]> read(Path path, String separatorRegex, boolean skipHeader) 
            throws IOException {
        
        List<String[]> rows = new ArrayList<>();

        if (!Files.exists(path)) {
            return rows;  // devuelve vacío si el fichero no existe
        }

        // try-with-resources: cierra el BufferedReader automáticamente al salir
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                
                // Si skipHeader=true, salta la primera línea (cabecera)
                if (firstLine && skipHeader) {
                    firstLine = false;
                    continue;  // pasa a la siguiente iteración sin procesar
                }
                firstLine = false;

                if (line.trim().isEmpty()) {
                    continue;  // ignora líneas en blanco
                }

                // split con -1 preserva campos vacíos al final de la línea
                // "ana;;madrid" con -1 → ["ana", "", "madrid"]
                // "ana;;madrid" sin -1 → ["ana"] (los vacíos del final se pierden)
                rows.add(line.split(separatorRegex, -1));
            }
        }

        return rows;
    }
}
```

**`Files.newBufferedReader(path)`** es preferible a `new FileReader(path)` porque usa la codificación del sistema (UTF-8 en la mayoría de casos) y tiene buffer interno que mejora el rendimiento.

### Por qué el separador es una regex

El separador se pasa como expresión regular porque diferentes CSV usan diferentes delimitadores. El pipe `|` y el punto `.` tienen significado especial en regex, por lo que hay que escaparlos:

```java
// En clientes.csv: separador ";"
ClienteCsvRepository repo = new ClienteCsvRepository(ruta, ";", ";");

// En proveedores.csv: separador "|" (escapado para regex como "\\|")
ProveedorCsvRepository repo = new ProveedorCsvRepository(ruta, "\\|", "|");

// En inventarios.csv: separador tabulador
InventarioCsvRepository repo = new InventarioCsvRepository(ruta, "\\t", "\t");
```

- `separatorRegex` → para `String.split()` (lectura)
- `separatorWrite` → para la escritura con `BufferedWriter`

### findAll() en un repositorio CSV (implementación completa)

```java
public List<Cliente> findAll() {
    List<Cliente> clientes = new ArrayList<>();
    try {
        // Llama al método heredado de CsvReaderAbstract
        List<String[]> filas = read(path, separatorRegex, true); // true = saltar cabecera
        
        for (String[] campos : filas) {
            // Cada campo viene como String, hay que convertir los tipos
            Long id = Long.parseLong(campos[0].trim());
            String nif = campos[1].trim();
            String nombre = campos[2].trim();
            String email = campos[3].trim();
            String telefono = campos[4].trim();
            String ciudad = campos[5].trim();
            String pais = campos[6].trim();
            boolean activo = Boolean.parseBoolean(campos[7].trim());
            
            clientes.add(new Cliente(id, nif, nombre, email, telefono, ciudad, pais, activo));
        }
    } catch (IOException e) {
        throw new RuntimeException("Error leyendo CSV de clientes", e);
    }
    return clientes;
}
```

### create() con append en CSV

```java
public boolean create(Cliente cliente) {
    if (cliente == null || cliente.getId() == null) return false;
    if (findById(cliente.getId()) != null) return false;  // no duplicados
    
    try (BufferedWriter bw = Files.newBufferedWriter(path, 
             StandardOpenOption.APPEND,       // añadir al final, no sobreescribir
             StandardOpenOption.CREATE)) {    // crear si no existe
        
        // Si el fichero está vacío, escribir cabecera primero
        if (Files.size(path) == 0) {
            bw.write("id;nif;nombre;email;telefono;ciudad;pais;activo");
            bw.newLine();
        }
        
        // Construir la línea CSV con los valores del objeto
        bw.write(cliente.getId() + separatorWrite +
                 cliente.getNif() + separatorWrite +
                 cliente.getNombre() + separatorWrite +
                 cliente.getEmail() + separatorWrite +
                 cliente.getTelefono() + separatorWrite +
                 cliente.getCiudad() + separatorWrite +
                 cliente.getPais() + separatorWrite +
                 cliente.isActivo());
        bw.newLine();
        
    } catch (IOException e) {
        return false;
    }
    return true;
}
```

### update() y deleteById() en CSV (read-modify-write con fichero temporal)

Para modificar o eliminar en CSV no se puede editar en medio del fichero directamente (los ficheros de texto no son bases de datos). La técnica estándar es:

```java
public boolean update(Cliente clienteActualizado) {
    List<Cliente> todos = findAll();         // 1. Lee todo
    boolean encontrado = false;
    
    for (int i = 0; i < todos.size(); i++) {
        if (todos.get(i).getId().equals(clienteActualizado.getId())) {
            todos.set(i, clienteActualizado);  // 2. Modifica en memoria
            encontrado = true;
            break;
        }
    }
    
    if (encontrado) {
        writeAll(todos);  // 3. Reescribe el fichero completo
    }
    return encontrado;
}

private void writeAll(List<Cliente> clientes) throws IOException {
    // StandardOpenOption.TRUNCATE_EXISTING borra el contenido anterior
    try (BufferedWriter bw = Files.newBufferedWriter(path,
             StandardOpenOption.WRITE,
             StandardOpenOption.TRUNCATE_EXISTING,
             StandardOpenOption.CREATE)) {
        
        // Siempre escribe la cabecera primero
        bw.write("id;nif;nombre;email;telefono;ciudad;pais;activo");
        bw.newLine();
        
        for (Cliente c : clientes) {
            bw.write(c.getId() + ";" + c.getNif() + ";" + c.getNombre() + ";" +
                     c.getEmail() + ";" + c.getTelefono() + ";" + c.getCiudad() + ";" +
                     c.getPais() + ";" + c.isActivo());
            bw.newLine();
        }
    }
}
```

---

## 4. CRUD con SQLite (usando JDBC)

### La cadena de conexión y SQLiteConnectionManager

```java
public abstract class SQLiteConnectionManager {

    public static String rutaDB = "src/main/resources/data/sqlite/demo.db";
    private String url;

    SQLiteConnectionManager(String rutaDB) {
        try {
            File file = new File(rutaDB);
            if (!file.exists()) {
                file.createNewFile();  // crea el fichero .db si no existe
            }
        } catch (Exception e) { /* manejo de error */ }
        
        // JDBC siempre necesita el prefijo del protocolo
        // "jdbc:sqlite:" le dice al DriverManager qué driver usar
        this.url = "jdbc:sqlite:" + rutaDB;
    }

    public Connection getConnection() throws SQLException {
        // DriverManager busca automáticamente el driver SQLite en el classpath
        // (la dependencia org.xerial:sqlite-jdbc registra el driver al cargarse)
        return DriverManager.getConnection(url);
    }
```

### El esquema: SchemaRepository

Antes de hacer cualquier CRUD, las tablas deben existir. `SchemaRepository` las crea con `CREATE TABLE IF NOT EXISTS`:

```java
public boolean createSchema() throws Exception {
    // try-with-resources cierra la Connection y el Statement automáticamente
    try (Connection connection = connectionManager.getConnection();
         Statement statement = connection.createStatement()) {

        statement.executeUpdate("""
            CREATE TABLE IF NOT EXISTS cliente (
                id INTEGER PRIMARY KEY,
                nif TEXT NOT NULL,
                nombre TEXT NOT NULL,
                email TEXT,
                telefono TEXT,
                ciudad TEXT,
                pais TEXT,
                activo INTEGER NOT NULL   -- SQLite no tiene BOOLEAN, usa 0/1
            )
        """);
        // ... más tablas
        return true;
    }
}
```

`IF NOT EXISTS` es crucial: evita error si la tabla ya existe, lo que permite llamar a `createSchema()` en cada arranque sin miedo.

### create() con PreparedStatement

```java
public boolean create(Cliente cliente) {
    Connection connection = null;
    try {
        connection = this.getConnection();
        
        // PreparedStatement previene SQL Injection y maneja tipos correctamente
        // Los ? son placeholders que se rellenan con setXxx()
        PreparedStatement sentencia = connection.prepareStatement(
            "INSERT INTO cliente(id, nif, nombre, email, telefono, ciudad, pais, activo)" +
            " values(?,?,?,?,?,?,?,?)"
        );
        
        // Los índices empiezan en 1 (no en 0 como los arrays Java)
        sentencia.setLong(1, cliente.getId());
        sentencia.setString(2, cliente.getNif());
        sentencia.setString(3, cliente.getNombre());
        sentencia.setString(4, cliente.getEmail());
        sentencia.setString(5, cliente.getTelefono());
        sentencia.setString(6, cliente.getCiudad());
        sentencia.setString(7, cliente.getPais());
        sentencia.setBoolean(8, cliente.isActivo());  // JDBC convierte boolean a 0/1

        sentencia.execute();  // execute() para INSERT/UPDATE/DELETE
        
    } catch (Exception e) {
        System.err.println("No se ha podido almacenar el cliente " + cliente.getId());
        return false;
    } finally {
        // El bloque finally SIEMPRE se ejecuta, aunque haya excepción
        // Es fundamental cerrar la conexión para liberar recursos
        this.closseConnection(connection);
    }
    return true;
}
```

**¿Por qué `PreparedStatement` en lugar de concatenar el SQL?**

Sin PreparedStatement:
```java
// PELIGROSO: SQL Injection
String sql = "INSERT INTO cliente (nombre) VALUES ('" + nombre + "')";
// Si nombre = "'; DROP TABLE cliente; --" → destruye la BD
```

Con PreparedStatement los valores se escapan automáticamente y nunca se interpretan como SQL.

### findAll() con ResultSet

```java
public List<Cliente> findAll() {
    Connection connection = null;
    ArrayList<Cliente> clientes = new ArrayList<>();
    try {
        connection = this.getConnection();
        PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente");
        
        // executeQuery() para SELECT (devuelve ResultSet)
        // execute() y executeUpdate() para INSERT/UPDATE/DELETE
        ResultSet resultado = sentencia.executeQuery();
        
        // ResultSet es un cursor: empieza antes del primer registro
        // next() avanza al siguiente y devuelve false cuando no hay más
        while (resultado.next()) {
            
            // getInt/getString/getBoolean extraen el valor de la columna actual
            // Se puede referenciar por nombre de columna o por índice (1-based)
            int id = resultado.getInt("id");
            long miId = Long.valueOf(id);  // int → long
            String nif = resultado.getString("nif");
            String nombre = resultado.getString("nombre");
            String email = resultado.getString("email");
            String telefono = resultado.getString("telefono");
            String ciudad = resultado.getString("ciudad");
            String pais = resultado.getString("pais");
            int activo = resultado.getInt("activo");  // SQLite devuelve 0/1
            boolean miActivo = Boolean.valueOf(String.valueOf(activo));  // 0/1 → false/true
            
            Cliente cliente = new Cliente(miId, nif, nombre, email, telefono, ciudad, pais, miActivo);
            clientes.add(cliente);
        }
    } catch (Exception e) {
        System.err.println("No se han podido obtener elementos");
        return new ArrayList<>();
    } finally {
        this.closseConnection(connection);
    }
    return clientes;
}
```

### deleteById() centralizado en la clase abstracta

```java
// En SQLiteConnectionManager (clase abstracta padre)
public boolean deleteById(String sql) {
    Connection connection = null;
    try {
        connection = this.getConnection();
        PreparedStatement sentencia = connection.prepareStatement(sql);
        // executeUpdate() devuelve el número de filas afectadas
        return sentencia.executeUpdate() > 0;  // true si borró al menos 1
    } catch (Exception e) {
        System.err.println("No se han podido eliminar");
        return false;
    }
    // NOTA: falta finally con closseConnection → bug en el código original
}

// En cada repositorio concreto:
public boolean deleteById(Long id) {
    String sql = "DELETE FROM cliente WHERE id = " + id;
    return super.deleteById(sql);  // delega al método padre
}
```

**Nota importante**: el código original tiene un bug en `deleteById` de la clase abstracta — no cierra la conexión en un bloque `finally`. La versión correcta debería ser:

```java
public boolean deleteById(String sql) {
    Connection connection = null;
    try {
        connection = this.getConnection();
        PreparedStatement sentencia = connection.prepareStatement(sql);
        return sentencia.executeUpdate() > 0;
    } catch (Exception e) {
        return false;
    } finally {
        this.closseConnection(connection);  // esto falta en el original
    }
}
```

### closseConnection() — liberación de recursos

```java
public boolean closseConnection(Connection connection) {
    try {
        if (connection != null) {
            if (!connection.isClosed()) {  // verificación doble
                connection.close();
            }
        }
    } catch (Exception e) {
        System.err.println("Se ha producido un error cerrando la conexión");
        return false;
    }
    return true;
}
```

Cerrar la conexión es **obligatorio**. SQLite tiene un límite de conexiones simultáneas y un fichero `.db` puede corromperse si no se cierran las conexiones correctamente.

---

## 5. La capa de Servicio: validación y lógica de negocio

Los servicios son independientes del tipo de persistencia gracias a las interfaces:

```java
public class ClienteService {

    // La dependencia es con la INTERFAZ, no con una implementación concreta
    // Esto permite cambiar de CSV a JSON a SQLite sin tocar el servicio
    private IClienteRepository repository;

    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public boolean crear(Cliente entity) {
        // El servicio valida ANTES de llamar al repositorio
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    private boolean validar(Cliente entity) {
        return entity != null 
            && entity.getId() != null 
            && entity.getNombre() != null 
            && !entity.getNombre().trim().isEmpty();  // nombre no puede ser solo espacios
    }

    // Métodos de negocio que el repositorio no necesita conocer
    public List<Cliente> listarActivos() {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente item : repository.findAll()) {
            if (item.isActivo()) {
                resultado.add(item);
            }
        }
        return resultado;
    }
}
```

---

## 6. El equals() y hashCode() en los modelos

Todos los modelos implementan `equals` y `hashCode` basándose solo en el `id`:

```java
// En Cliente.java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;       // misma referencia → iguales
    if (obj == null || getClass() != obj.getClass()) return false;
    Cliente other = (Cliente) obj;
    return Objects.equals(id, other.id); // igualdad solo por id
}

@Override
public int hashCode() {
    return Objects.hash(id);
}
```

Esto permite usar `clientes.contains(cliente)` y `clientes.indexOf(cliente)` comparando solo por `id`, no por todos los campos. Es fundamental para `update()` y `deleteById()` con `removeIf`.

---

## 7. Resumen comparativo

| Aspecto | CSV | JSON | XML | SQLite |
|---|---|---|---|---|
| **Librería** | Java puro (`BufferedReader/Writer`) | Jackson `ObjectMapper` | Jackson `XmlMapper` | JDBC + driver SQLite |
| **Formato listas** | Una línea por registro | Array `[]` nativo | Necesita wrapper class | Tabla con filas |
| **Read** | `readLine()` + `split()` | `readValue()` con `TypeReference` | `readValue()` con clase wrapper | `executeQuery()` + `ResultSet` |
| **Write** | `BufferedWriter.write()` | `writeValue()` | `writeValue()` con wrapper | `PreparedStatement.execute()` |
| **Update/Delete** | Read-Modify-Write completo | Read-Modify-Write completo | Read-Modify-Write completo | SQL UPDATE/DELETE directo |
| **Concurrencia** | No seguro | No seguro | No seguro | Seguro (ACID básico) |
| **Rendimiento** | Lento para grandes volúmenes | Medio | Medio | Rápido con índices |
| **Tipos de datos** | Todo String, conversión manual | Automática (Jackson) | Automática (Jackson) | Nativa JDBC (`setLong`, `setString`) |