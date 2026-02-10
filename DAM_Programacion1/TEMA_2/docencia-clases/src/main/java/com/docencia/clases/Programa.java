package com.docencia.clases;

public class Programa {
    public static void main(String[] args) {
        Persona persona1;
        persona1 = new Persona("433855377-Y");
        persona1.setFechaNacimiento("01/01/1990");
        persona1.setNombre("Ivan");
        System.out.println("valor" + persona1);

        Persona persona2;
        persona2 = new Persona("433855377-x");
        if (persona1.equals(persona2)){
            System.out.println("Somos la misma persona");
        }

        Persona persona3;
        persona3 = new Persona("433855377-w");
        if (persona1.equals(persona3)){
            System.out.println("Somos la misma persona");
        }
    }
}
