package com.docencia.expresiones.ejercicio4;

import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio4 {

    private Ejercicio4() {}


    public static ZoneId parseZoneCommand(String input) {
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException();
        }
        String patron = "^SET TZ=([a-zA-Z_]+/[a-zA-Z_]+)$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(input);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        

        String zonaHoraria = matcher.group(1);

        return ZoneId.of(zonaHoraria);
    }
}
