# Directory Structure
```
images/
  reservas-turisticas.png
src/
  main/
    java/
      com/
        docencia/
          ficheros/
            model/
              Cliente.java
              Hotel.java
              Reserva.java
              ReservaCompleta.java
            repo/
              interfaces/
                IClienteRepository.java
                IHotelRepository.java
                IReservaRepository.java
              ClienteRepositoryJson.java
              HotelRepositoryXml.java
              ReservaRepositoryCsv.java
            service/
              interfaces/
                IReservaService.java
              ReservaService.java
            util/
              FechaValidator.java
              ResourceUtils.java
          ficheros.zip
    resources/
      data/
        clientes.json
        hoteles.xml
        reservas-invalidas.csv
        reservas.csv
  test/
    java/
      com/
        docencia/
          ficheros/
            BaseTest.java
            ClienteRepositoryJsonTest.java
            FechaValidatorTest.java
            HotelRepositoryXmlTest.java
            ReservaRepositoryCsvTest.java
            ReservaServiceAgregadosTest.java
            ReservaServiceCalculosTest.java
            ReservaServiceReservasCompletasTest.java
tools/
  tests/
    test_calcular_nota.py
  calcular_nota.py
EXAMEN.pdf
pom.xml
README.md
```

# Files

## File: src/main/java/com/docencia/ficheros/model/Cliente.java
````java
public class Cliente {
⋮----
public int getId() { return id; }
public String getNombre() { return nombre; }
⋮----
public boolean equals(Object o) {
⋮----
public int hashCode() {
return Objects.hash(id);
````

## File: src/main/java/com/docencia/ficheros/model/Hotel.java
````java
public class Hotel {
⋮----
public int getId() { return id; }
public String getNombre() { return nombre; }
public double getPrecioNoche() { return precioNoche; }
⋮----
public boolean equals(Object o) {
⋮----
public int hashCode() {
return Objects.hash(id);
````

## File: src/main/java/com/docencia/ficheros/model/Reserva.java
````java
public class Reserva {
⋮----
FechaValidator.validarRango(fechaInicio, fechaFin);
⋮----
public int getId() { return id; }
public int getClienteId() { return clienteId; }
public int getHotelId() { return hotelId; }
public String getFechaInicio() { return fechaInicio; }
public String getFechaFin() { return fechaFin; }
⋮----
public long getNoches() {
return ChronoUnit.DAYS.between(FechaValidator.parse(fechaInicio), FechaValidator.parse(fechaFin));
⋮----
public boolean equals(Object o) {
⋮----
public int hashCode() {
return Objects.hash(id);
````

## File: src/main/java/com/docencia/ficheros/model/ReservaCompleta.java
````java

````

## File: src/main/java/com/docencia/ficheros/repo/interfaces/IClienteRepository.java
````java
public interface IClienteRepository {
public List<Cliente> findAll();
public Cliente findById(int id);
````

## File: src/main/java/com/docencia/ficheros/repo/interfaces/IHotelRepository.java
````java
public interface IHotelRepository {
⋮----
public List<Hotel> findAll();
public Hotel findById(int id) ;
````

## File: src/main/java/com/docencia/ficheros/repo/interfaces/IReservaRepository.java
````java
public interface IReservaRepository {
⋮----
public List<Reserva> findAll();
public Reserva findById(int id);
````

## File: src/main/java/com/docencia/ficheros/repo/ClienteRepositoryJson.java
````java
public class ClienteRepositoryJson implements IClienteRepository {
⋮----
public List<Cliente> findAll() {
// TODO Auto-generated method stub
throw new UnsupportedOperationException("Unimplemented method 'findAll'");
⋮----
public Cliente findById(int id) {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'findById'");
````

## File: src/main/java/com/docencia/ficheros/repo/HotelRepositoryXml.java
````java
public class HotelRepositoryXml implements IHotelRepository {
⋮----
public List<Hotel> findAll() {
// TODO Auto-generated method stub
throw new UnsupportedOperationException("Unimplemented method 'findAll'");
⋮----
public Hotel findById(int id) {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'findById'");
````

## File: src/main/java/com/docencia/ficheros/repo/ReservaRepositoryCsv.java
````java
public class ReservaRepositoryCsv implements IReservaRepository {
⋮----
public List<Reserva> findAll() {
// TODO Auto-generated method stub
throw new UnsupportedOperationException("Unimplemented method 'findAll'");
⋮----
public Reserva findById(int id) {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'findById'");
````

## File: src/main/java/com/docencia/ficheros/service/interfaces/IReservaService.java
````java
public interface IReservaService {
public List<ReservaCompleta> getReservasCompletas();
public ReservaCompleta getReservaCompletaById(int reservaId);
public double calcularPrecio(Reserva reserva);
public double totalGastadoPorCliente(int clienteId);
public Hotel hotelMasRentable();
public double totalIngresos();
public long contarNochesTotales();
public Reserva reservaMasLarga();
public long totalReservasPorHotel(int hotelId);
````

## File: src/main/java/com/docencia/ficheros/service/ReservaService.java
````java
public class ReservaService implements IReservaService {
⋮----
public List<ReservaCompleta> getReservasCompletas() {
return reservaRepository.findAll();
⋮----
public ReservaCompleta getReservaCompletaById(int reservaId) {
// TODO Auto-generated method stub
throw new UnsupportedOperationException("Unimplemented method 'getReservaCompletaById'");
⋮----
public double calcularPrecio(Reserva reserva) {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'calcularPrecio'");
⋮----
public double totalGastadoPorCliente(int clienteId) {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'totalGastadoPorCliente'");
⋮----
public Hotel hotelMasRentable() {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'hotelMasRentable'");
⋮----
public double totalIngresos() {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'totalIngresos'");
⋮----
public long contarNochesTotales() {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'contarNochesTotales'");
⋮----
public Reserva reservaMasLarga() {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'reservaMasLarga'");
⋮----
public long totalReservasPorHotel(int hotelId) {
⋮----
throw new UnsupportedOperationException("Unimplemented method 'totalReservasPorHotel'");
````

## File: src/main/java/com/docencia/ficheros/util/FechaValidator.java
````java
public final class FechaValidator {
⋮----
public static boolean isFechaValida(String fecha) {
⋮----
public static LocalDate parse(String fecha) {
if (!isFechaValida(fecha)) {
throw new IllegalArgumentException("Formato de fecha inválido: " + fecha + ". Se esperaba yyyy-MM-dd");
⋮----
return LocalDate.parse(fecha.trim(), FORMATTER);
⋮----
public static boolean isRangoValido(String fechaInicio, String fechaFin) {
if (!isFechaValida(fechaInicio) || !isFechaValida(fechaFin)) {
⋮----
LocalDate inicio = parse(fechaInicio);
LocalDate fin = parse(fechaFin);
return !fin.isBefore(inicio);
⋮----
public static void validarRango(String fechaInicio, String fechaFin) {
if (!isFechaValida(fechaInicio)) {
throw new IllegalArgumentException("Fecha de inicio inválida: " + fechaInicio);
⋮----
if (!isFechaValida(fechaFin)) {
throw new IllegalArgumentException("Fecha de fin inválida: " + fechaFin);
⋮----
if (!isRangoValido(fechaInicio, fechaFin)) {
throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
````

## File: src/main/java/com/docencia/ficheros/util/ResourceUtils.java
````java
public final class ResourceUtils {
⋮----
public static InputStream getResourceAsStream(String path) {
InputStream in = ResourceUtils.class.getClassLoader().getResourceAsStream(path);
⋮----
throw new IllegalArgumentException("No se encuentra el recurso: " + path);
````

## File: src/main/resources/data/clientes.json
````json
[
  { "id": 101, "nombre": "Ana" },
  { "id": 102, "nombre": "Luis" },
  { "id": 103, "nombre": "Marta" },
  { "id": 104, "nombre": "Carlos" }
]
````

## File: src/main/resources/data/hoteles.xml
````xml
<hoteles>
    <hotel>
        <id>201</id>
        <nombre>Hotel Sol</nombre>
        <precioNoche>80.0</precioNoche>
    </hotel>
    <hotel>
        <id>202</id>
        <nombre>Hotel Mar</nombre>
        <precioNoche>120.0</precioNoche>
    </hotel>
    <hotel>
        <id>203</id>
        <nombre>Hotel Sierra</nombre>
        <precioNoche>100.0</precioNoche>
    </hotel>
</hoteles>
````

## File: src/main/resources/data/reservas-invalidas.csv
````
id,clienteId,hotelId,fechaInicio,fechaFin
1,101,201,2026-03-10,2026-03-05
````

## File: src/main/resources/data/reservas.csv
````
id,clienteId,hotelId,fechaInicio,fechaFin
1,101,201,2026-03-01,2026-03-05
2,102,202,2026-03-02,2026-03-04
3,101,202,2026-03-10,2026-03-12
4,103,203,2026-03-15,2026-03-20
5,104,201,2026-03-18,2026-03-19
6,102,203,2026-03-21,2026-03-25
````

## File: src/test/java/com/docencia/ficheros/BaseTest.java
````java
public abstract class BaseTest {
protected final IReservaRepository reservaRepository = new ReservaRepositoryCsv("data/reservas.csv");
protected final IClienteRepository clienteRepository = new ClienteRepositoryJson("data/clientes.json");
protected final IHotelRepository hotelRepository = new HotelRepositoryXml("data/hoteles.xml");
protected final ReservaService service = new ReservaService(reservaRepository, clienteRepository, hotelRepository);
````

## File: src/test/java/com/docencia/ficheros/ClienteRepositoryJsonTest.java
````java
class ClienteRepositoryJsonTest extends BaseTest {
⋮----
void jsonFindAllSizeTest() {
assertEquals(4, clienteRepository.findAll().size());
⋮----
void jsonFindByIdExistingTest() {
assertNotNull(clienteRepository.findById(101));
⋮----
void jsonFindByIdMissingTest() {
assertNull(clienteRepository.findById(999));
⋮----
void jsonNombreAnaTest() {
assertEquals("Ana", clienteRepository.findById(101).getNombre());
⋮----
void jsonNombreLuisTest() {
assertEquals("Luis", clienteRepository.findById(102).getNombre());
⋮----
void jsonNombreMartaTest() {
assertEquals("Marta", clienteRepository.findById(103).getNombre());
⋮----
void jsonNombreCarlosTest() {
assertEquals("Carlos", clienteRepository.findById(104).getNombre());
⋮----
void jsonContainsCliente101Test() {
assertTrue(clienteRepository.findAll().stream().anyMatch(c -> c.getId() == 101));
⋮----
void jsonContainsCliente104Test() {
assertTrue(clienteRepository.findAll().stream().anyMatch(c -> c.getId() == 104));
⋮----
void jsonNotContainsCliente999Test() {
assertFalse(clienteRepository.findAll().stream().anyMatch(c -> c.getId() == 999));
````

## File: src/test/java/com/docencia/ficheros/FechaValidatorTest.java
````java
class FechaValidatorTest {
⋮----
void fechaValidaFormatoIsoTest() {
assertTrue(FechaValidator.isFechaValida("2026-03-15"));
⋮----
void fechaInvalidaMesIncorrectoTest() {
assertFalse(FechaValidator.isFechaValida("2026-13-15"));
⋮----
void fechaInvalidaTextoLibreTest() {
assertFalse(FechaValidator.isFechaValida("15/03/2026"));
⋮----
void rangoValidoMismoDiaTest() {
assertTrue(FechaValidator.isRangoValido("2026-03-15", "2026-03-15"));
⋮----
void rangoInvalidoFechaFinAnteriorTest() {
assertFalse(FechaValidator.isRangoValido("2026-03-20", "2026-03-15"));
⋮----
void validarRangoLanzaExcepcionSiFechaInicioEsInvalidaTest() {
IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
() -> FechaValidator.validarRango("2026/03/20", "2026-03-25"));
assertTrue(ex.getMessage().contains("Fecha de inicio inválida"));
⋮----
void validarRangoLanzaExcepcionSiFechaFinEsAnteriorTest() {
⋮----
() -> FechaValidator.validarRango("2026-03-20", "2026-03-19"));
assertTrue(ex.getMessage().contains("La fecha fin no puede ser anterior"));
⋮----
void reservaConFechasTextoCalculaNochesCorrectamenteTest() {
Reserva reserva = new Reserva(99, 101, 201, "2026-04-01", "2026-04-05");
assertEquals(4, reserva.getNoches());
assertEquals("2026-04-01", reserva.getFechaInicio());
assertEquals("2026-04-05", reserva.getFechaFin());
````

## File: src/test/java/com/docencia/ficheros/HotelRepositoryXmlTest.java
````java
class HotelRepositoryXmlTest extends BaseTest {
⋮----
void xmlFindAllSizeTest() {
assertEquals(3, hotelRepository.findAll().size());
⋮----
void xmlFindByIdExistingTest() {
assertNotNull(hotelRepository.findById(201));
⋮----
void xmlFindByIdMissingTest() {
assertNull(hotelRepository.findById(999));
⋮----
void xmlNombreHotel201Test() {
assertEquals("Hotel Sol", hotelRepository.findById(201).getNombre());
⋮----
void xmlNombreHotel202Test() {
assertEquals("Hotel Mar", hotelRepository.findById(202).getNombre());
⋮----
void xmlNombreHotel203Test() {
assertEquals("Hotel Sierra", hotelRepository.findById(203).getNombre());
⋮----
void xmlPrecioHotel201Test() {
assertEquals(80.0, hotelRepository.findById(201).getPrecioNoche());
⋮----
void xmlPrecioHotel202Test() {
assertEquals(120.0, hotelRepository.findById(202).getPrecioNoche());
⋮----
void xmlPrecioHotel203Test() {
assertEquals(100.0, hotelRepository.findById(203).getPrecioNoche());
⋮----
void xmlContainsHotel203Test() {
assertTrue(hotelRepository.findAll().stream().anyMatch(h -> h.getId() == 203));
````

## File: src/test/java/com/docencia/ficheros/ReservaRepositoryCsvTest.java
````java
class ReservaRepositoryCsvTest extends BaseTest {
⋮----
void csvFindAllSizeTest() {
assertEquals(6, reservaRepository.findAll().size());
⋮----
void csvFirstIdTest() {
assertEquals(1, reservaRepository.findAll().get(0).getId());
⋮----
void csvFindByIdExistingTest() {
assertNotNull(reservaRepository.findById(1));
⋮----
void csvFindByIdMissingTest() {
assertNull(reservaRepository.findById(999));
⋮----
void csvClienteIdReserva1Test() {
assertEquals(101, reservaRepository.findById(1).getClienteId());
⋮----
void csvHotelIdReserva2Test() {
assertEquals(202, reservaRepository.findById(2).getHotelId());
⋮----
void csvNochesReserva1Test() {
assertEquals(4, reservaRepository.findById(1).getNoches());
⋮----
void csvNochesReserva5Test() {
assertEquals(1, reservaRepository.findById(5).getNoches());
⋮----
void csvFechaInicioReserva3Test() {
assertEquals("2026-03-10", reservaRepository.findById(3).getFechaInicio());
⋮----
void csvFechaFinReserva4Test() {
assertEquals("2026-03-20", reservaRepository.findById(4).getFechaFin());
⋮----
void csvInvalidoFechaFinAnteriorTest() {
IllegalStateException ex = assertThrows(IllegalStateException.class,
() -> new ReservaRepositoryCsv("data/reservas-invalidas.csv"));
assertTrue(ex.getCause().getMessage().contains("La fecha fin no puede ser anterior"));
````

## File: src/test/java/com/docencia/ficheros/ReservaServiceAgregadosTest.java
````java
class ReservaServiceAgregadosTest extends BaseTest {
⋮----
void totalGastadoCliente101Test() {
assertEquals(560.0, service.totalGastadoPorCliente(101));
⋮----
void totalGastadoCliente102Test() {
assertEquals(640.0, service.totalGastadoPorCliente(102));
⋮----
void totalGastadoCliente103Test() {
assertEquals(500.0, service.totalGastadoPorCliente(103));
⋮----
void totalGastadoCliente104Test() {
assertEquals(80.0, service.totalGastadoPorCliente(104));
⋮----
void totalGastadoClienteMissingThrowsTest() {
assertThrows(IllegalArgumentException.class, () -> service.totalGastadoPorCliente(999));
⋮----
void hotelMasRentableIdTest() {
assertEquals(203, service.hotelMasRentable().getId());
⋮----
void hotelMasRentableNombreTest() {
assertEquals("Hotel Sierra", service.hotelMasRentable().getNombre());
⋮----
void totalReservasPorHotel201Test() {
assertEquals(2, service.totalReservasPorHotel(201));
⋮----
void totalReservasPorHotel202Test() {
assertEquals(2, service.totalReservasPorHotel(202));
⋮----
void totalReservasPorHotel203Test() {
assertEquals(2, service.totalReservasPorHotel(203));
````

## File: src/test/java/com/docencia/ficheros/ReservaServiceCalculosTest.java
````java
class ReservaServiceCalculosTest extends BaseTest {
⋮----
void calcularPrecioReserva1Test() {
assertEquals(320.0, service.calcularPrecio(reservaRepository.findById(1)));
⋮----
void calcularPrecioReserva2Test() {
assertEquals(240.0, service.calcularPrecio(reservaRepository.findById(2)));
⋮----
void calcularPrecioReserva3Test() {
assertEquals(240.0, service.calcularPrecio(reservaRepository.findById(3)));
⋮----
void calcularPrecioReserva4Test() {
assertEquals(500.0, service.calcularPrecio(reservaRepository.findById(4)));
⋮----
void calcularPrecioReserva5Test() {
assertEquals(80.0, service.calcularPrecio(reservaRepository.findById(5)));
⋮----
void calcularPrecioReserva6Test() {
assertEquals(400.0, service.calcularPrecio(reservaRepository.findById(6)));
⋮----
void calcularPrecioNullThrowsTest() {
assertThrows(IllegalArgumentException.class, () -> service.calcularPrecio((Reserva) null));
⋮----
void totalIngresosTest() {
assertEquals(1780.0, service.totalIngresos());
⋮----
void contarNochesTotalesTest() {
assertEquals(18, service.contarNochesTotales());
⋮----
void reservaMasLargaTest() {
assertEquals(5, service.reservaMasLarga().getNoches());
````

## File: src/test/java/com/docencia/ficheros/ReservaServiceReservasCompletasTest.java
````java
class ReservaServiceReservasCompletasTest extends BaseTest {
⋮----
void reservasCompletasListSizeTest() {
assertEquals(6, service.getReservasCompletas().size());
⋮----
void reservaCompleta1ClienteNombreTest() {
assertEquals("Ana", service.getReservaCompletaById(1).clienteNombre());
⋮----
void reservaCompleta1HotelNombreTest() {
assertEquals("Hotel Sol", service.getReservaCompletaById(1).hotelNombre());
⋮----
void reservaCompleta2ClienteNombreTest() {
assertEquals("Luis", service.getReservaCompletaById(2).clienteNombre());
⋮----
void reservaCompleta4HotelNombreTest() {
assertEquals("Hotel Sierra", service.getReservaCompletaById(4).hotelNombre());
⋮----
void reservaCompleta1NochesTest() {
assertEquals(4, service.getReservaCompletaById(1).noches());
⋮----
void reservaCompleta2PrecioTotalTest() {
assertEquals(240.0, service.getReservaCompletaById(2).precioTotal());
⋮----
void reservaCompleta5PrecioTotalTest() {
assertEquals(80.0, service.getReservaCompletaById(5).precioTotal());
⋮----
void reservaCompletaIdMissingThrowsTest() {
assertThrows(IllegalArgumentException.class, () -> service.getReservaCompletaById(999));
⋮----
void reservasCompletasContainsHotelMarTest() {
List<ReservaCompleta> reservasCompletas = service.getReservasCompletas();
assertTrue(reservasCompletas.stream().anyMatch(d -> d.hotelNombre().equals("Hotel Mar")));
````

## File: tools/tests/test_calcular_nota.py
````python
# Permite importar calcular_nota.py desde tools/
CURRENT_DIR = Path(__file__).resolve().parent
TOOLS_DIR = CURRENT_DIR.parent
⋮----
def test_normalizar_documentacion_con_uno()
⋮----
def test_normalizar_documentacion_con_decimal()
⋮----
def test_normalizar_documentacion_con_coma()
⋮----
def test_normalizar_documentacion_limita_maximo()
⋮----
def test_normalizar_documentacion_limita_minimo()
⋮----
def test_normalizar_documentacion_invalida()
⋮----
def test_leer_documentacion_desde_fichero_existente(tmp_path: Path)
⋮----
fichero = tmp_path / "documentacion_api.txt"
⋮----
def test_leer_documentacion_desde_fichero_medio_punto(tmp_path: Path)
⋮----
def test_leer_documentacion_desde_fichero_inexistente(tmp_path: Path)
⋮----
def test_leer_documentacion_desde_fichero_invalido(tmp_path: Path)
````

## File: tools/calcular_nota.py
````python
ROOT = Path(__file__).resolve().parent.parent
REPORTS = ROOT / "target" / "surefire-reports"
⋮----
# Pesos máximos por capa sobre 10
PESOS = {
⋮----
# Punto reservado para documentación de API
PUNTOS_DOCUMENTACION = 1.0
⋮----
def detectar_capa(nombre_clase: str) -> str
⋮----
nombre = nombre_clase.lower()
⋮----
def normalizar_puntuacion_documentacion(valor: str) -> float
⋮----
puntos = float(valor.strip().replace(",", "."))
⋮----
def leer_documentacion_api_desde_ruta(ruta: Path) -> float
⋮----
def leer_documentacion_api() -> float
⋮----
valor_env = os.getenv("DOCUMENTACION_API")
⋮----
ruta = ROOT / "target" / "documentacion_api.txt"
⋮----
def calcular_resumen_desde_reportes(report_files)
⋮----
resumen = {}
total_global = 0
passed_global = 0
failed_global = 0
⋮----
root = ET.parse(file).getroot()
⋮----
suite_name = root.attrib.get("name", "desconocido")
capa = detectar_capa(suite_name)
⋮----
tests = int(root.attrib.get("tests", 0))
failures = int(root.attrib.get("failures", 0))
errors = int(root.attrib.get("errors", 0))
skipped = int(root.attrib.get("skipped", 0))
⋮----
failed = failures + errors + skipped
passed = max(0, tests - failed)
⋮----
def main()
⋮----
files = list(REPORTS.glob("TEST-*.xml"))
⋮----
nota_global_tests = 0.0 if total_global == 0 else round(10 * passed_global / total_global, 2)
⋮----
detalle_capas = []
nota_total_capas = 0.0
⋮----
total = resumen[capa]["total"]
passed = resumen[capa]["passed"]
failed = resumen[capa]["failed"]
⋮----
ratio = 0.0 if total == 0 else passed / total
nota_sobre_10 = round(10 * ratio, 2)
⋮----
peso_maximo = PESOS.get(capa, 0.0)
nota_ponderada = round(ratio * peso_maximo, 2)
⋮----
puntos_documentacion = leer_documentacion_api()
nota_final = round(nota_total_capas + puntos_documentacion, 2)
⋮----
out = ROOT / "target" / "nota.txt"
⋮----
lineas = []
⋮----
texto = (
````

## File: pom.xml
````xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.docencia</groupId>
    <artifactId>com.docencia.ficheros</artifactId>
    <version>1.0.0</version>
    <properties>
        <maven.compiler.release>17</maven.compiler.release>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.10.2</junit.version>
        <jackson.version>2.17.2</jackson.version>
        <maven.test.failure.ignore>true</maven.test.failure.ignore>
        <documentacion.api>1</documentacion.api>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
    </dependencies>
    <build>
  <plugins>
    <plugin>
      <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.12</version>
      <executions>
        <execution>
          <id>prepare-agent</id>
          <goals>
            <goal>prepare-agent</goal>
          </goals>
        </execution>
        <execution>
          <id>report</id>
          <phase>verify</phase>
          <goals>
            <goal>report</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.2.5</version>
      <configuration>
        <useModulePath>false</useModulePath>
        <testFailureIgnore>${maven.test.failure.ignore}</testFailureIgnore>
      </configuration>
    </plugin>
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>exec-maven-plugin</artifactId>
      <version>3.3.0</version>
      <executions>
        <execution>
          <id>calcular-nota</id>
          <phase>verify</phase>
          <goals>
            <goal>exec</goal>
          </goals>
          <configuration>
            <executable>python3</executable>
            <arguments>
              <argument>${project.basedir}/tools/calcular_nota.py</argument>
            </arguments>
            <environmentVariables>
              <DOCUMENTACION_API>${documentacion.api}</DOCUMENTACION_API>
            </environmentVariables>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
<profiles>
  <profile>
    <id>calificar</id>
    <properties>
      <maven.test.failure.ignore>true</maven.test.failure.ignore>
      <documentacion.api>1</documentacion.api>
    </properties>
  </profile>
</profiles>
</project>
````

## File: README.md
````markdown
# Plataforma de Reservas Turísticas

Proyecto Java para la gestión de reservas turísticas con lectura de datos desde CSV, JSON y XML, orientado a docencia y evaluación automática.

## Objetivo del proyecto

El sistema permite trabajar con reservas, clientes y hoteles a partir de distintos formatos de fichero, manteniendo una estructura sencilla por capas.

Se mantiene la lógica de negocio principal, incluyendo:

- cálculo de importe de reservas
- validación de fechas
- agregaciones como total gastado por cliente
- hotel más rentable
- tests automáticos
- cálculo de nota automática a partir de los resultados de test

## Diagrama del sistema

![Plataforma de Reservas](./images/reservas-turisticas.png)


## Casos de uso

Los casos de uso que debe cubrir el proyecto son:

1. **Reservas completas**
   - integración de datos de reservas, clientes y hoteles

2. **Calcular precio**
   - cálculo del coste total de una reserva

3. **Total gastado por cliente**
   - suma de importes agrupados por cliente

4. **Hotel más rentable**
   - identificación del hotel con mayor facturación

5. **Validación de fechas**
   - comprobación de formato y coherencia entre fecha de inicio y fecha de fin

## Estructura 

```text
src/main/java/com/docencia/ficheros/
├── model/
├── service/
├── util/
├── validator/ opcional
└── reader/ opcional

src/test/java/com/docencia/ficheros/
```

## 1. reservas.csv

```csv
idReserva,idCliente,idHotel,fechaInicio,fechaFin
1,101,201,2024-01-01,2024-01-03
2,101,202,2024-02-10,2024-02-12
3,102,201,2024-03-05,2024-03-06
4,103,203,2024-04-01,2024-04-05
5,102,202,2024-05-10,2024-05-15
```

### 💡 Descripción
- Cada fila representa una reserva
- Fechas en formato `yyyy-MM-dd`
- Relación con clientes y hoteles mediante IDs

### 🧠 Ejemplos
- Reserva 1 → 2 noches
- Cliente 101 → 2 reservas

---

## 2. clientes.json

```json
[
  {
    "id": 101,
    "nombre": "Juan Pérez",
    "email": "juan@example.com"
  },
  {
    "id": 102,
    "nombre": "Ana García",
    "email": "ana@example.com"
  },
  {
    "id": 103,
    "nombre": "Luis Martínez",
    "email": "luis@example.com"
  }
]
```

### 💡 Descripción
- Lista de clientes
- Se relacionan con reservas mediante `id`

---

## 3. hoteles.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<hoteles>
    <hotel>
        <id>201</id>
        <nombre>Hotel Sol</nombre>
        <ciudad>Madrid</ciudad>
        <precioPorNoche>100.0</precioPorNoche>
    </hotel>

    <hotel>
        <id>202</id>
        <nombre>Hotel Luna</nombre>
        <ciudad>Barcelona</ciudad>
        <precioPorNoche>120.0</precioPorNoche>
    </hotel>

    <hotel>
        <id>203</id>
        <nombre>Hotel Estrella</nombre>
        <ciudad>Valencia</ciudad>
        <precioPorNoche>90.0</precioPorNoche>
    </hotel>
</hoteles>
```

### Descripción
- Contiene información de hoteles
- Incluye precio por noche
- Relación con reservas mediante `id`


## 1. Modelo

Resuelve primero las clases base del dominio:

- `Cliente`
- `Hotel`
- `Reserva`

### Qué dejar hecho
- atributos correctos
- constructores
- getters y setters
- fechas como `String`
- `toString()` si lo usas en depuración
- `equals()` y `hashCode()` solo si el proyecto los necesitaç

### Qué comprobar
- que los objetos se construyen bien
- que los campos se guardan correctamente
- que las fechas se mantienen como texto

## 2. Validador de fechas

Antes de meterte en la lógica de negocio, crea el validador:

- `com.docencia.ficheros.validator.FechaValidator`

### Qué resolver

- validar formato `yyyy-MM-dd`
- validar rango de fechas
- parsear a `LocalDate` de forma controlada

### Métodos sugeridos

- `esFormatoValido(String fecha)`
- `esRangoValido(String inicio, String fin)`
- `parse(String fecha)`

> **Importante**: existe código dentro de FechaValidator que te puede aydar.


## 3. Repositorio o lector de reservas CSV

Resuelve la lectura del fichero CSV de reservas.

### Qué resolver

- lectura de `reservas.csv`
- conversión a objetos `Reserva`
- control de errores básicos si una línea viene mal

### Qué comprobar

- número correcto de reservas
- ids correctos
- fechas correctas
- relación correcta de campos
- comportamiento con CSV inválido

### Recomendación

Aquí no metas lógica de negocio. Solo lectura y transformación.

## 4. Repositorio o lector de clientes JSON

Resuelve la lectura del JSON de clientes.

### Qué resolver
- lectura de `clientes.json`
- conversión a objetos `Cliente`

### Qué comprobar
- total de clientes
- ids correctos
- nombres correctos
- recuperación correcta de datos
- comportamiento con JSON inválido, si lo contemplas

---

## 5. Repositorio o lector de hoteles XML

Resuelve la lectura del XML de hoteles.

### Qué resolver
- lectura de `hoteles.xml`
- conversión a objetos `Hotel`

### Qué comprobar
- número de hoteles
- nombre correcto
- ciudad correcta
- precio o categoría correctos
- comportamiento con XML inválido

---

## 6. Función para el cálculo de precio

Una vez que la lectura de datos funciona, resuelve el cálculo del precio.

### Qué resolver
- cálculo del coste de la reserva
- noches por precio, o la regla concreta del ejercicio

### Dependencias esperadas
- `Reserva`
- `Hotel`
- `FechaValidator`

### Qué comprobar
- cálculo correcto para una reserva simple
- una noche
- varias noches
- fechas inválidas
- hotel no encontrado, si aplica

---

## 7. Función para el total gastado por cliente

Después del cálculo unitario, resuelve la agregación por cliente.

### Qué resolver
- suma del gasto total de un cliente
- agrupación de reservas por cliente

### Qué comprobar
- cliente con varias reservas
- cliente con una reserva
- cliente sin reservas
- cliente inexistente

---

## 8. Función para el hotel más rentable

Ahora implementa la operación agregada por hotel.

### Qué resolver
- agrupación por hotel
- suma de ingresos
- selección del hotel con mayor facturación

### Qué comprobar

- hotel con mayor facturación
- empate, si el ejercicio lo contempla
- caso sin reservas

---

## 9. Función para las reservas completas

Cuando todo lo anterior funcione por separado, resuelve la integración final.

### Qué resolver
- unir `Reserva`, `Cliente` y `Hotel`
- construir la estructura final pedida por el ejercicio


### Qué comprobar
- unión correcta por ids
- datos completos
- comportamiento cuando falta cliente
- comportamiento cuando falta hotel

---

## Calificación automática

La calificación automática se ejecuta en la fase `verify` de Maven.

```bash
mvn clean verify -Pcalificar
```

## Ejemplo de salida esperada

```text
=== CALIFICACION AUTOMATICA POR CAPA ===

GLOBAL TESTS -> tests totales: 69, pasados: 69, fallados: 0, nota: 10.00/10

=== DESGLOSE POR CAPA ===

DATOS -> tests totales: 31, pasados: 31, fallados: 0, nota tests: 10.00/10, peso maximo: 4.00, aportacion: 4.00
SERVICIO -> tests totales: 30, pasados: 30, fallados: 0, nota tests: 10.00/10, peso maximo: 4.00, aportacion: 4.00
VALIDACION -> tests totales: 8, pasados: 8, fallados: 0, nota tests: 10.00/10, peso maximo: 1.00, aportacion: 1.00

=== DOCUMENTACION API ===
Puntos documentacion API: 1.00/1.00

=== NOTA FINAL ===
Nota por capas: 9.00/9.00
Nota final: 10.00/10
```

## ¿Qué necesitas para aprobar esta parte?

- Sacar la lectura de ficheros
- Que las clases del modelo funcionen correctamente
- Funcione correctamente la validación

## ¿Qué necesitas para sacar buena nota?

> Todo lo anterior y saber trabajar en los casos de uso del servicio Reserva Service que utiliza los repositoris
````
