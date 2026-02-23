package com.docencia.logica.ejercicio2;

import java.time.LocalDate;

public final class Ejercicio2 {

    public static int calcularEdad(String nacimiento, LocalDate hoy) {
         if (nacimiento == null || nacimiento.isBlank()){
            throw new IllegalArgumentException();
         }
         String[] comparacion = nacimiento.split("/");
         
         
         
         return 0;

    }
    
}
