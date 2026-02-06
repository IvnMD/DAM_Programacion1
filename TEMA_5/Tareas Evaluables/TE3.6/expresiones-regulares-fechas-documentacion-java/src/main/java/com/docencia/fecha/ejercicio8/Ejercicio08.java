package com.docencia.fecha.ejercicio8;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * EJERCICIO 8B) NORMALIZAR FRANJA HORARIA (PUEDE CRUZAR MEDIANOCHE)
 *
 * Dada una franja en formato String: "HH:mm-HH:mm" (ej. "22:00-06:00"),
 * devuelve un String normalizado con el mismo formato (siempre 2 dígitos),
 * y además indica si la franja es válida según estas reglas:
 *
 * Reglas de validez:
 * - Debe cumplir exactamente el patrón: ^\d{2}:\d{2}-\d{2}:\d{2}$
 * - Las horas deben estar en 00..23 y los minutos en 00..59
 * - Si inicio == fin, se considera franja VACÍA (inválida) y debe lanzar excepción.
 *
 * Normalización:
 * - Debe devolver "HH:mm-HH:mm" con ceros a la izquierda.
 * - Si el input ya está normalizado, debe devolverlo igual.
 *
 * Cruce de medianoche:
 * - Si inicio > fin, la franja cruza medianoche y se considera válida.
 *
 * Programación defensiva:
 * - Si franja es null o blank, lanza IllegalArgumentException.
 * - Si el formato o el rango es incorrecto, lanza IllegalArgumentException.
 * - Si inicio.equals(fin), lanza IllegalArgumentException (franja vacía).
 *
 * Ejemplos válidos:
 * - "09:30-12:15"  -> "09:30-12:15"
 * - "22:00-06:00"  -> "22:00-06:00"
 *
 * Ejemplos inválidos:
 * - "9:30-12:15"   (no cumple exactamente 2 dígitos)
 * - "24:00-06:00"  (hora fuera de rango)
 * - "10:60-12:00"  (minutos fuera de rango)
 * - "10:00-10:00"  (franja vacía)
 * - "1030-1215"    (formato incorrecto).
 */
public class Ejercicio08 {
    private static final String patron = "^\\d{2}:\\d{2}-\\d{2}:\\d{2}$";
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

    public static String normalizarFranja(String franja) {
        if (franja == null || franja.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (!franja.matches(patron)) {
            throw new IllegalArgumentException();
        }

        String[] partes = franja.split("-");
        if (partes.length != 2) {
            throw new IllegalArgumentException();
        }

        String inicioStr = partes[0];
        String finStr = partes[1];

        validarHoraMinuto(inicioStr);
        validarHoraMinuto(finStr);

        LocalTime inicio = LocalTime.parse(inicioStr, formato);
        LocalTime fin = LocalTime.parse(finStr, formato);

        if (inicio.equals(fin)) {
            throw new IllegalArgumentException();
        }

        String inicioNormalizado = inicio.format(formato);
        String finNormalizado = fin.format(formato);

        return inicioNormalizado + "-" + finNormalizado;
    }

    private static void validarHoraMinuto(String horaStr) {
        String[] partes = horaStr.split(":");

        int hora = Integer.parseInt(partes[0]);
        int minuto = Integer.parseInt(partes[1]);

        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException();
        }

        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException();
        }
    }
}
