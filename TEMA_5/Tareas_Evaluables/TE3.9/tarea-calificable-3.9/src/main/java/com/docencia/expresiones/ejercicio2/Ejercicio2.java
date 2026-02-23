package com.docencia.expresiones.ejercicio2;

import java.util.regex.Pattern;


public final class Ejercicio2 {


    public static boolean esUrlHttpValida(String texto) {
        if(texto == null || texto.isBlank()){
            return false;
        }
        String http = "(http|https)";
        String subdominio = "(api.){0,}";
        String dominio = "[a-z]{1,}";
        String com = "(.com)";
        String ruta = "(/{0,}[a-z]{0,})";
        String patron = "^" + http +"://" + subdominio + dominio + com + ruta + ruta + "(/{0,1})" + "$";

        return Pattern.matches(patron, texto);
    }

}
