package com.docencia.fechas.ejercicio5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class Ejercicio5 {

    private Ejercicio5() {}

    public static int ageYears(LocalDate birth, LocalDate today) {
        if (today == null || birth==null){
            throw new NullPointerException();
        }
        if (today.isBefore(birth)){
            throw new IllegalArgumentException();
        }
        // Period resultado = Period.between(birth, today);  //! Tambien funciona
        // return resultado.getYears();
        int anyos = today.getYear() - birth.getYear();
         return anyos;
    }
}
