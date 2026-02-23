package com.docencia.logica.ejercicio1;


import java.time.LocalTime;

public final class Ejercicio1 {

    public static boolean estaDentroHorario(String hora, LocalTime inicio, LocalTime fin) {
        if(hora == null || hora.isBlank()){ 
            return false;
        }
        if(fin.isAfter(inicio) || inicio == null || fin == null){
            return false;
        }
        
        return true;
    }
    
}
