package com.docencia;

import java.time.LocalDate;
import java.time.Period;

public class UtilidadesFecha {
    /**
     * Funcion para calcular años bisiestos
     * @param fecha fecha a comprobar
     * @return true o false
     */
    static boolean isBisiesto(int anyo, int mes, int dia){
        try {
            LocalDate fecha = LocalDate.of(anyo, mes, dia);
        return fecha.isLeapYear();
        } catch (Exception e){
        return false;
        }
    }

    static int calcularEdad(LocalDate fechaNacimiento){
        int edad = 0;
        LocalDate hoy = LocalDate.now();
        edad = Period.between(fechaNacimiento, hoy).getYears();
        return edad;
    }

    public static void main(String[] args) {
        LocalDate fechaNacimiento = LocalDate.of(1194, 12, 02);
        LocalDate anioBisiesto = LocalDate.of(24, 2, 29);
        // LocalDate anioBisiesto28 = LocalDate.of(28, 2, 29);
        // LocalDate anioBisiesto26 = LocalDate.of(26, 2, 28);
        // System.out.println("Es bisiesto 2024? = " + isBisiesto(anioBisiesto));
        // System.out.println("Es bisiesto 2028? = " + isBisiesto(anioBisiesto28));
        // System.out.println("Es bisiesto 2026? = " + isBisiesto(anioBisiesto26));
        System.out.println("Es bisiesto? = " + isBisiesto(26,2,29));
        System.out.println("Es bisiesto? = " + isBisiesto(24,2,29));
        System.out.println("Que edad tiene? = " + calcularEdad(fechaNacimiento));
    }

}
