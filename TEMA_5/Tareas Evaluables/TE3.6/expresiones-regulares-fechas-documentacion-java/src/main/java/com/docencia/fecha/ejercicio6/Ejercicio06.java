package com.docencia.fecha.ejercicio6;

import java.time.Duration;
import java.time.LocalTime;

/**
 * EJERCICIO 6) Descanso mínimo entre turnos
 *
 * Dados finTurno e inicioSiguiente, determina si entre ambos hay al menos
 * minDescansoHoras horas.
 * El inicio del siguiente turno puede ser el mismo día o el día siguiente
 * (cruce de medianoche).
 *
 * Interpretación:
 * - Si inicioSiguiente es anterior a finTurno, se asume que inicioSiguiente es
 * al día siguiente.
 *
 * Programación defensiva:
 * - Si finTurno o inicioSiguiente son null, lanza IllegalArgumentException.
 * - Si minDescansoHoras <= 0 o minDescansoHoras > 24, lanza
 * IllegalArgumentException.
 *
 * Ejemplos (minDescansoHoras=12):
 * - fin=20:00, inicio=08:00 => true
 * - fin=20:00, inicio=06:00 => false
 */
public class Ejercicio06 {
    
    public static boolean cumpleDescanso(LocalTime finTurno, LocalTime inicioSiguiente, int minDescansoHoras) {
        // Validaciones
        if (finTurno == null || inicioSiguiente == null) {
            throw new IllegalArgumentException();
        }
        if (minDescansoHoras <= 0 || minDescansoHoras > 24) {
            throw new IllegalArgumentException();
        }
        // Calcular la diferencia en minutos
        Duration diferencia = Duration.between(finTurno, inicioSiguiente);
        long minutosDescanso = diferencia.toMinutes();

        if (minutosDescanso < 0) {
            minutosDescanso += 24 * 60;  // 1440 minutos = 24h
        }
        
    
        long minutosMinimoRequerido = minDescansoHoras * 60;
    
        return minutosDescanso >= minutosMinimoRequerido;
    }
}
