package com.docencia.expresiones.ejercicio4;

import java.util.regex.Pattern;

public final class Ejercicio4 {


    public static boolean esFechaIsoConHoraOpcionalValida(String texto) {
        if (texto == null || texto.isBlank()){
            return false;
        }
        String dia = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
        String mes = "(0[1-9]|1[1-2])";
        String anyo = "[\\d]{4}";
        String hora = "(0[0-9]|1[0-9]|2[0-3]):";
        String minutos = "([0-5][0-9])";
        String reloj = "(\\s(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]){0,}$";
        String patron = "^" + anyo + "-" + mes  + "-" + dia +  reloj;

        return Pattern.matches(patron,texto);
    }

}
