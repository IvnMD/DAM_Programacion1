package com.docencia;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date; //jkd8__________ Deprecated

public class Fecha {
    public static void main(String[] args) {
        Date fecha = new Date();
        LocalDate fechaActual = LocalDate.now();
        System.out.println(fecha);
        System.out.println("-----------");
        System.out.println(fechaActual);
        //! ^[0-9]{4}-[0-9]{2}-[0-9]{2} -- Expresion regulador para comprobar fechaActual
        System.out.println("-----------");
        fecha.setDate(3); //! Cambiamos el dia en fecha
        System.out.println(fecha);
        System.out.println("-----------");
        System.out.println(fechaActual.plusDays(3)); //! Suma 3 dias
        System.out.println("-----------");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("DD-MM-YYYY");  //! La M debe ser mayuscula, lo demas puede o no ir en mayuscula
        System.out.println(fechaActual.format(dateFormat));
        System.out.println(fechaActual.plusYears(40).format(dateFormat));
        LocalDate fechaFutura = LocalDate.now();
        if (fechaActual.isBefore(fechaFutura.plusYears(40))) {
            System.out.println("Actual es anterior");
        }   
        if (fechaActual.isAfter(fechaFutura.plusYears(40))) {
            System.out.println("Actual no es posterior");
        }   

        // Duration tiempo = Duration.between(fechaFutura, fechaFutura.plusYears(1));
        // System.out.println(tiempo);
        LocalDate lasNueve = LocalDate.of(9, 1, 1);
        System.out.println(lasNueve);
    }
}
