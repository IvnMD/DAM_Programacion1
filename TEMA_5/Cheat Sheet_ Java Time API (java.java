Cheat Sheet: Java Time API (java.time)
📅 Clases Principales
LocalDate - Solo fecha (sin hora ni zona horaria)
java// Crear fechas
LocalDate hoy = LocalDate.now();
LocalDate fecha = LocalDate.of(2024, 3, 15);  // año, mes, día
LocalDate fecha2 = LocalDate.of(2024, Month.MARCH, 15);
LocalDate parsear = LocalDate.parse("2024-03-15");  // formato ISO

// Obtener componentes
int año = fecha.getYear();
int mes = fecha.getMonthValue();  // 1-12
Month mesEnum = fecha.getMonth();  // JANUARY, FEBRUARY...
int dia = fecha.getDayOfMonth();  // 1-31
DayOfWeek diaSemana = fecha.getDayOfWeek();  // MONDAY, TUESDAY...
int diaAño = fecha.getDayOfYear();  // 1-366

// Modificar (retorna nueva instancia, son inmutables)
LocalDate mañana = fecha.plusDays(1);
LocalDate proximoMes = fecha.plusMonths(1);
LocalDate proximoAño = fecha.plusYears(1);
LocalDate ayer = fecha.minusDays(1);
LocalDate inicioMes = fecha.withDayOfMonth(1);
LocalDate navidad = fecha.withMonth(12).withDayOfMonth(25);

// Comparaciones
boolean esAntes = fecha1.isBefore(fecha2);
boolean esDespues = fecha1.isAfter(fecha2);
boolean sonIguales = fecha1.isEqual(fecha2);
boolean esBisiesto = fecha.isLeapYear();

// Calcular períodos
Period periodo = Period.between(fecha1, fecha2);
long dias = ChronoUnit.DAYS.between(fecha1, fecha2);

LocalTime - Solo hora (sin fecha ni zona horaria)
java// Crear horas
LocalTime ahora = LocalTime.now();
LocalTime hora = LocalTime.of(14, 30);  // 14:30
LocalTime horaCompleta = LocalTime.of(14, 30, 45);  // 14:30:45
LocalTime conNanos = LocalTime.of(14, 30, 45, 123456789);
LocalTime parsear = LocalTime.parse("14:30:45");

// Obtener componentes
int hora24 = hora.getHour();  // 0-23
int minuto = hora.getMinute();  // 0-59
int segundo = hora.getSecond();  // 0-59
int nano = hora.getNano();  // 0-999,999,999

// Modificar
LocalTime masUnaHora = hora.plusHours(1);
LocalTime mas30Min = hora.plusMinutes(30);
LocalTime menos15Seg = hora.minusSeconds(15);
LocalTime mediodia = hora.withHour(12).withMinute(0);

// Comparaciones
boolean esAntes = hora1.isBefore(hora2);
boolean esDespues = hora1.isAfter(hora2);

// Calcular duraciones
Duration duracion = Duration.between(hora1, hora2);
long segundos = ChronoUnit.SECONDS.between(hora1, hora2);

LocalDateTime - Fecha + Hora (sin zona horaria)
java// Crear
LocalDateTime ahoraCompleto = LocalDateTime.now();
LocalDateTime fechaHora = LocalDateTime.of(2024, 3, 15, 14, 30);
LocalDateTime desde = LocalDateTime.of(fecha, hora);
LocalDateTime parsear = LocalDateTime.parse("2024-03-15T14:30:45");

// Obtener componentes (combina LocalDate + LocalTime)
LocalDate soloFecha = fechaHora.toLocalDate();
LocalTime soloHora = fechaHora.toLocalTime();
int año = fechaHora.getYear();
int hora = fechaHora.getHour();

// Modificar
LocalDateTime mañana = fechaHora.plusDays(1);
LocalDateTime masHoras = fechaHora.plusHours(2);
LocalDateTime truncado = fechaHora.truncatedTo(ChronoUnit.HOURS);  // 14:00:00

// Comparaciones
boolean esAntes = dt1.isBefore(dt2);
boolean esDespues = dt1.isAfter(dt2);

ZonedDateTime - Fecha + Hora + Zona Horaria
java// Crear
ZonedDateTime ahoraZona = ZonedDateTime.now();
ZonedDateTime enMadrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
ZonedDateTime desde = LocalDateTime.now().atZone(ZoneId.of("UTC"));

// Zonas horarias comunes
ZoneId utc = ZoneId.of("UTC");
ZoneId madrid = ZoneId.of("Europe/Madrid");
ZoneId newYork = ZoneId.of("America/New_York");
ZoneId tokyo = ZoneId.of("Asia/Tokyo");

// Convertir entre zonas
ZonedDateTime enNY = enMadrid.withZoneSameInstant(ZoneId.of("America/New_York"));

// Obtener zona
ZoneId zona = zdt.getZone();
ZoneOffset offset = zdt.getOffset();  // +01:00, -05:00, etc.

Instant - Timestamp UTC (nanosegundos desde epoch)
java// Crear
Instant ahora = Instant.now();
Instant epoch = Instant.ofEpochSecond(0);  // 1970-01-01T00:00:00Z
Instant desde = Instant.ofEpochMilli(System.currentTimeMillis());

// Convertir
long epochSegundos = instant.getEpochSecond();
long epochMilis = instant.toEpochMilli();
ZonedDateTime conZona = instant.atZone(ZoneId.of("Europe/Madrid"));

// Modificar
Instant mas1Hora = instant.plus(1, ChronoUnit.HOURS);
Instant menos5Min = instant.minus(Duration.ofMinutes(5));

// Comparaciones
boolean esAntes = instant1.isBefore(instant2);

⏱️ Períodos y Duraciones
Period - Para fechas (días, meses, años)
java// Crear
Period periodo = Period.of(1, 2, 3);  // 1 año, 2 meses, 3 días
Period unAño = Period.ofYears(1);
Period tresMeses = Period.ofMonths(3);
Period diezDias = Period.ofDays(10);

// Entre fechas
Period diferencia = Period.between(fecha1, fecha2);

// Obtener componentes
int años = periodo.getYears();
int meses = periodo.getMonths();
int dias = periodo.getDays();

// Usar
LocalDate futuro = LocalDate.now().plus(periodo);

Duration - Para tiempo (horas, minutos, segundos)
java// Crear
Duration duracion = Duration.of(5, ChronoUnit.HOURS);
Duration unaHora = Duration.ofHours(1);
Duration treintaMin = Duration.ofMinutes(30);
Duration diezSeg = Duration.ofSeconds(10);
Duration dosHorasMedia = Duration.ofHours(2).plusMinutes(30);

// Entre tiempos
Duration diferencia = Duration.between(hora1, hora2);
Duration difInstantes = Duration.between(instant1, instant2);

// Obtener componentes
long segundos = duracion.getSeconds();
long dias = duracion.toDays();
long horas = duracion.toHours();
long minutos = duracion.toMinutes();

// Usar
LocalTime futuro = LocalTime.now().plus(duracion);
Instant despues = Instant.now().plus(duracion);

🔧 ChronoUnit - Unidades de tiempo
java// Calcular diferencias en una unidad específica
long dias = ChronoUnit.DAYS.between(fecha1, fecha2);
long horas = ChronoUnit.HOURS.between(dt1, dt2);
long minutos = ChronoUnit.MINUTES.between(hora1, hora2);
long segundos = ChronoUnit.SECONDS.between(instant1, instant2);
long meses = ChronoUnit.MONTHS.between(fecha1, fecha2);
long años = ChronoUnit.YEARS.between(fecha1, fecha2);

// Unidades disponibles
ChronoUnit.NANOS
ChronoUnit.MICROS
ChronoUnit.MILLIS
ChronoUnit.SECONDS
ChronoUnit.MINUTES
ChronoUnit.HOURS
ChronoUnit.HALF_DAYS
ChronoUnit.DAYS
ChronoUnit.WEEKS
ChronoUnit.MONTHS
ChronoUnit.YEARS
ChronoUnit.DECADES
ChronoUnit.CENTURIES
ChronoUnit.MILLENNIA

// Truncar a una unidad
LocalDateTime truncado = dt.truncatedTo(ChronoUnit.HOURS);  // 14:00:00

📝 Formateo y Parseo
DateTimeFormatter - Formatear y parsear fechas/horas
java// Formateadores predefinidos
DateTimeFormatter iso = DateTimeFormatter.ISO_LOCAL_DATE;  // 2024-03-15
DateTimeFormatter isoTime = DateTimeFormatter.ISO_LOCAL_TIME;  // 14:30:45
DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

// Formateadores personalizados
DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy");

// Formatear (objeto -> String)
String textoFecha = fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
String textoCustom = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

// Parsear (String -> objeto)
LocalDate fecha = LocalDate.parse("2024-03-15");
LocalDate fechaCustom = LocalDate.parse("15/03/2024", 
    DateTimeFormatter.ofPattern("dd/MM/yyyy"));

// Patrones comunes
"yyyy-MM-dd"              // 2024-03-15
"dd/MM/yyyy"              // 15/03/2024
"dd-MM-yyyy HH:mm:ss"     // 15-03-2024 14:30:45
"yyyy-MM-dd'T'HH:mm:ss"   // 2024-03-15T14:30:45
"EEEE, MMMM d, yyyy"      // Friday, March 15, 2024
"dd MMM yyyy"             // 15 Mar 2024
"HH:mm:ss"                // 14:30:45
"hh:mm a"                 // 02:30 PM

// Símbolos de patrón
// y = año, M = mes, d = día
// H = hora 24h, h = hora 12h, m = minuto, s = segundo
// E = día de semana, a = AM/PM

🔄 Conversiones Comunes
java// LocalDate <-> LocalDateTime
LocalDateTime conHora = fecha.atTime(14, 30);
LocalDateTime conHoraCompleta = fecha.atTime(hora);
LocalDateTime inicioDelDia = fecha.atStartOfDay();
LocalDate soloFecha = dateTime.toLocalDate();

// LocalDateTime <-> ZonedDateTime
ZonedDateTime conZona = dateTime.atZone(ZoneId.of("Europe/Madrid"));
LocalDateTime sinZona = zonedDateTime.toLocalDateTime();

// LocalDateTime <-> Instant
Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
LocalDateTime dt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

// Date (legacy) <-> LocalDate/LocalDateTime
Date legacyDate = Date.from(instant);
Instant desde = legacyDate.toInstant();
LocalDate fecha = legacyDate.toInstant()
    .atZone(ZoneId.systemDefault())
    .toLocalDate();

// String <-> LocalDate
String texto = fecha.toString();  // 2024-03-15
LocalDate desde = LocalDate.parse(texto);

// Long timestamp <-> Instant
Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
long timestamp = instant.toEpochMilli();

🎯 Casos de Uso Comunes
Verificar si una fecha está en un rango
javapublic boolean estaEnRango(LocalDate fecha, LocalDate inicio, LocalDate fin) {
    return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
}
Calcular edad
javapublic int calcularEdad(LocalDate fechaNacimiento) {
    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
}
Obtener primer/último día del mes
javaLocalDate primerDia = fecha.withDayOfMonth(1);
LocalDate ultimoDia = fecha.withDayOfMonth(fecha.lengthOfMonth());
Verificar si es fin de semana
javapublic boolean esFinDeSemana(LocalDate fecha) {
    DayOfWeek dia = fecha.getDayOfWeek();
    return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
}
Sumar días laborables
javapublic LocalDate sumarDiasLaborables(LocalDate fecha, int dias) {
    LocalDate resultado = fecha;
    int diasSumados = 0;
    while (diasSumados < dias) {
        resultado = resultado.plusDays(1);
        if (resultado.getDayOfWeek() != DayOfWeek.SATURDAY && 
            resultado.getDayOfWeek() != DayOfWeek.SUNDAY) {
            diasSumados++;
        }
    }
    return resultado;
}

⚠️ Puntos Importantes

Inmutabilidad: Todos los objetos de java.time son inmutables y thread-safe
Métodos plus/minus: Siempre retornan nuevas instancias
ISO-8601: Formato por defecto para parseo/formateo
Zona horaria del sistema: ZoneId.systemDefault()
Comparaciones: Usar isBefore(), isAfter(), isEqual() en lugar de compareTo()
Period vs Duration: Period para fechas (días/meses/años), Duration para tiempo (horas/minutos/segundos)