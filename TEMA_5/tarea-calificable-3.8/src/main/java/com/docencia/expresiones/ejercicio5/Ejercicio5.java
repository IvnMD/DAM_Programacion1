package com.docencia.expresiones.ejercicio5;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio5 {

    private Ejercicio5() {
    }

    public static Instant parseLogInstant(String logLine) {
        if (logLine == null || logLine.isBlank()) {
            throw new IllegalArgumentException();
        }

        Pattern pattern = Pattern.compile("\\[(.+?)\\]"); //!  Busca la fehca dentro de los corchetes
        Matcher matcher = pattern.matcher(logLine);

        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }

        String fecha = matcher.group(1);
        OffsetDateTime respuesta = OffsetDateTime.parse(fecha);
        return respuesta.toInstant();
    }
}
