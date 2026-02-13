package com.docencia.fechas.ejercicio12;

import com.docencia.fechas.EventComparison;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;

public final class Ejercicio12 {

    private Ejercicio12() {}

public static EventComparison compareEvents(ZonedDateTime a, ZonedDateTime b) {
    


    Instant instantA = a.toInstant();
    Instant instantB = b.toInstant();

    // 3. Determinar cuál ocurre primero
    ZonedDateTime first = instantA.isBefore(instantB) ? a : b;

    // 4. Calcular la diferencia absoluta (siempre positiva)
    Duration absoluteDiff = Duration.between(instantA, instantB).abs();

    // 5. Retornar el objeto de comparación
    // Asumiendo que el constructor de EventComparison es (ZonedDateTime primero, Duration diferencia)
    return new EventComparison(first, absoluteDiff);
}
}
