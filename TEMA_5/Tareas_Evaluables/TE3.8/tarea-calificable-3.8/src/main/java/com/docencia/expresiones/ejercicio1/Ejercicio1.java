package com.docencia.expresiones.ejercicio1;

import java.time.LocalDate;
import java.util.regex.Pattern;

public final class Ejercicio1 {

    private Ejercicio1() {}

  

    public static LocalDate parseIsoDate(String input) {
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException();
        }
        String patron = "\\d{4}-\\d{2}-\\d{2}";
        boolean esFecha = Pattern.matches(patron, input);
        if (!esFecha){
            throw new IllegalArgumentException();
        }
        String[] fecha = input.split("-");
        return LocalDate.of(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]));
        
    }
}
