package com.docencia.fechas.ejercicio7;

import com.docencia.fechas.TimeUtils;

import java.time.LocalTime;

public final class Ejercicio7 {

    private Ejercicio7() {}

    public static boolean isOpenInclusive(LocalTime t, LocalTime open, LocalTime close) {
         if (t == null || open == null || close == null || close.isBefore(open)){
            throw new NullPointerException();
         }
         
        
        return false;
    }
}
