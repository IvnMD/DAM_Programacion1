package com.docencia.expresiones.ejercicio2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio2 {

    private Ejercicio2() {}


    public static LocalTime extractFirstTime(String text) {
        if (text == null || text.isBlank()){
            throw new IllegalArgumentException();
        } 
        String patron = "(0[0-9]||1[0-9]||2[0-3]):[0-5][0-9]";

        // String[] respuesta = text.split(":");
        
        // int horas = Integer.parseInt(respuesta[0]); 
        // int minutos = Integer.parseInt(respuesta[1]);
        
        // return LocalTime.of(horas, minutos); 
    
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()){
            throw new IllegalArgumentException();
        }
        String hora = matcher.group(0);
        return LocalTime.parse(hora);
    }
}
