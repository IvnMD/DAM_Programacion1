package com.docencia.expresiones.ejercicio3;

import java.util.regex.Pattern;

public final class Ejercicio3 {

    public static boolean esContrasenaFuerteValida(String texto) {
        if( texto == null || texto.isBlank()){
            return false;
        }
        String patron = "[\\W]{10,}";
        // String patron = "(([(\\W)+([a-z])+([A-Z])+([0-9])+]){10,}||\\W{10,})";
        return Pattern.matches(patron,texto);

    }
}
