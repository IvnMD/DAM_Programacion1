package com.docencia.fechas.ejercicio6;

import com.docencia.fechas.BusinessCalendar;

import java.time.LocalDate;

public final class Ejercicio6 {

    private Ejercicio6() {}

    public static LocalDate addBusinessDays(LocalDate start, int n) {
        if (start == null) {
            throw new NullPointerException();
        }
        if (n < 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            if (start.getDayOfWeek().getValue() > 5) {
            start.plusDays(2);
         } else {
            start.plusDays(1);
         }
         

        }
        // LocalDate resultado = start.plusDays(n);
        return start;
    }
}
