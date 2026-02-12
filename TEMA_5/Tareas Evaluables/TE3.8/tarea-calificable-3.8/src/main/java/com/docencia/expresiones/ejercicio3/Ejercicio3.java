package com.docencia.expresiones.ejercicio3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio3 {

    private Ejercicio3() {
    }

    public static LocalDateTime parseFlexibleLocalDateTime(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        String patronNumerico = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])(T|\\s)(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]";
        String patronFormato = "^(\\d{4}-\\d{2}-\\d{2})(T|\\s)(\\d{2}:\\d{2})$";

        if(!Pattern.matches(patronFormato, input)){
            
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches(patronNumerico, input)) {
            throw new DateTimeException(input);
        }

        return LocalDateTime.parse(input.replace(" ", "T"));
    }
}