package com.docencia.expresiones.ejercicio5;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio5 {

    private Ejercicio5() {}

    public static Instant parseLogInstant(String logLine) {
        if (logLine == null || logLine.isBlank()){
            throw new IllegalArgumentException();
        } 
        String anyo = "[0-9]{4}";
        String mes = "(0[1-9]|1[0-2])";
        String dia = "(0[1-9]|[12][0-9]|3[01])";
        String hora = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-9]{2}+[0-9]{2}:[0-9]{2}";
        
        return null;
    }
}
