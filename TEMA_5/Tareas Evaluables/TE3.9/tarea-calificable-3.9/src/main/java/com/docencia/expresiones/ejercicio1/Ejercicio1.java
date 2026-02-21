package com.docencia.expresiones.ejercicio1;

import java.util.regex.Pattern;

public final class Ejercicio1 {



    public static boolean esFechaDdMmAaaaValida(String texto) {
        if (texto == null || texto.isBlank()){
            return false;
        }
        String dia = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
        String mes = "(0[1-9]|1[1-2])";
        String anyo = "[\\d]{4}";
        String patron = "^" + dia + "/" + mes  + "/" + anyo + "$";
        
        return Pattern.matches(patron, texto);
    }

   
}
