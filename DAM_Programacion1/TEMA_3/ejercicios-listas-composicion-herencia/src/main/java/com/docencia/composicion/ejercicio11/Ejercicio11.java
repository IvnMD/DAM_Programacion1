package com.docencia.composicion.ejercicio11;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 11 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí las clases de dominio, atributos, métodos y relaciones
 * de composición correspondientes al enunciado.
 */
public class Ejercicio11 {

    
    public static void main(String[] args) {

        Direccion direccion1 = new Direccion("Concha Espina, 3", "Madrid", 39400);
        Direccion direccion2 = new Direccion("Simon Bolivar, 17", "Caracas", 1312);
        Persona persona1 = new Persona( "Serresiete", 40, direccion1);
        Persona persona2 = new Persona( "Janis", 12, direccion2);
        Persona persona3 = new Persona( "Marmarques", 93, direccion1);

        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);


        Persona personaEncontrada = encontrarPersonaPorCiudad(personas, "Madrid");
        List<Persona> personasEcontradas = encontrarPersonasPorCiudad(personas, "Madrid");
        System.out.println(personaEncontrada);
        System.out.println(personasEcontradas); //! SIEMPRE VA A IMPRIMIR CON [...] AL TRATARSE DE UNA LISTA
        System.out.println("-------------AHORA USANDO EL METODO EN SOUT ----------------");
        System.out.println(encontrarPersonaPorCiudad(personas, "Madrid"));
        System.out.println(encontrarPersonaPorCiudad(personas,"Caracas"));
        System.out.println(encontrarPersonasPorCiudad(personas, "Madrid")); //! SIEMPRE VA A IMPRIMIR CON [...] AL TRATARSE DE UNA LISTA
        

    }

    public static Persona encontrarPersonaPorCiudad (List<Persona> personas, String ciudad){
        if (personas == null || ciudad == null || ciudad.isBlank()){
            return null;
        }
        
        for (Persona persona : personas) {
            if (persona.getDireccion() != null && 
                    persona.getDireccion().getCiudad() != null 
                        && persona.getDireccion().getCiudad().equals(ciudad)) {
                return persona;
            }
        }
        
        return null;
    }

    public static List<Persona> encontrarPersonasPorCiudad (List<Persona> personas, String ciudad){
        List<Persona> personasEcontradas = new ArrayList<>();
                if (personas == null || ciudad == null || ciudad.isBlank()){
            return null;
        }
        
        for (Persona persona : personas) {
            if (persona.getDireccion() != null && 
                    persona.getDireccion().getCiudad() != null 
                        && persona.getDireccion().getCiudad().equals(ciudad)) {
                personasEcontradas.add(persona);
            }
        }
        return personasEcontradas;
    }
}
