package com.docencia.expresiones.ejercicio7;

import com.docencia.expresiones.DateRangeResult;
import com.docencia.fechas.BusinessCalendar;
import java.time.Duration;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio7 {
    
    private Ejercicio7() {}
    
    public static DateRangeResult parseDateRange(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        
        Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})\\.\\.(\\d{4}-\\d{2}-\\d{2})");
        Matcher matcher = pattern.matcher(input);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        
        LocalDate start = LocalDate.parse(matcher.group(1));
        LocalDate end = LocalDate.parse(matcher.group(2));
        
        if (end.isBefore(start)) {
            throw new IllegalArgumentException();
        }
        
        long totalDays = Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays() + 1;
        DateRangeResult resultado = 
        
        return resultado;
    }
}