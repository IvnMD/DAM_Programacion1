package com.docencia.composicion.ejercicio20;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 20 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí las clases de dominio, atributos, métodos y relaciones
 * de composición correspondientes al enunciado.
 */
public class Ejercicio20 {

    
    public static void main(String[] args) {
        Mascota mascota1 = new Mascota("Loro", "Paco");
        Mascota mascota2 = new Mascota("Perro", "Paco");
        Mascota mascota3 = new Mascota("Loro", "Pepe");

        Cita cita1 = new Cita("01/12/25", "Es madridista", mascota1);
        Cita cita2 = new Cita("01/12/25", "Ladra a los marroquis", mascota2);
        Cita cita3 = new Cita("25/12/25", "Ala rota", mascota3);
        Cita cita4 = new Cita("03/12/25", "Muerde a los caballos", mascota2);

        List<Cita> citas = new ArrayList<>();
        citas.add(cita1);
        citas.add(cita3);
        citas.add(cita2);
        citas.add(cita4);

        Clinica clinica = new Clinica(citas);

        System.out.println(clinica.obtenerCitasPorMascota(mascota2));
        System.out.println(clinica.obtenerCitasPorFecha("01/12/25"));
    }


}
