package com.docencia.expresiones.ejercicio5;

import java.util.regex.Pattern;



public final class Ejercicio5 {


    public static boolean esFechaHora12hAmPmValida(String texto) {
        if (texto ==null || texto.isBlank()){
            return false;
        }
        String dia = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
        String mes = "(0[1-9]|1[1-2])";
        String anyo = "[\\d]{4}";
        String reloj = "\\s([0-9]|0[1-9]|1[0-2]):([0-5][0-9])\\s(AM|PM)";
        String patron = "^" + dia + "/" + mes  + "/" + anyo +  reloj + "$";


        return Pattern.matches(patron, texto);
    }

}
