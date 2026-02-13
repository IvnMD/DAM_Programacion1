package com.docencia.expresiones.ejercicio6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio6 {

    private Ejercicio6() {
    }

    public static LocalDateTime applyDeltaCommand(LocalDateTime base, String command) {
        if (base == null || command == null || command.isBlank()) {
            throw new IllegalArgumentException();
        }
        String patron = "^([\\+\\-])([0-9]+)([hdmyHDMY])$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(command);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        String signo = matcher.group(1);
        int cantidad = Integer.parseInt(matcher.group(2));
        char unidad = matcher.group(3).charAt(0);
        LocalDateTime resultado;
        switch (unidad) {
            case 'Y':
            case 'y':
                if (signo.equals("+")) {
                    return base.plus(Period.ofYears(cantidad));
                } else {
                    return base.minus(Period.ofYears(cantidad));
                }
            case 'd':
            case 'D':
                if (signo.equals("+")) {
                    return base.plus(Period.ofDays(cantidad));
                } else {
                    return base.minus(Period.ofDays(cantidad));
                }
            case 'h':
            case 'H':
                if (signo.equals("+")) {
                    return base.plus(Duration.ofHours(cantidad));
                } else {
                    return base.minus(Duration.ofHours(cantidad));
                }
            case 'm':
            case 'M':
                if (signo.equals("+")) {
                    return base.plus(Duration.ofMinutes(cantidad));
                } else {
                    return base.minus(Duration.ofMinutes(cantidad));
                }
            default:
                throw new IllegalArgumentException();

        }
    }
}
