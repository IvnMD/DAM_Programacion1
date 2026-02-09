package com.docencia.clases.ejerciciosClases.Programa3;

public class Programa3 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("978-0-00-000000-1", "El primero");
        Libro libro2 = new Libro ("978-0-00-000000-1", "Otro título");
        System.out.println("Libro 1: " + libro1);
        System.out.println("Libro 2: " + libro2);

        System.out.println("Titulo 2: " + libro2.getTitulo());
        libro2.setTitulo("Titulo actualizado");
        System.out.println("Libro 2 (actualizado): " + libro2.getTitulo());
        if (libro1.equals(libro2)) {
            System.out.println("Los libros son iguales (mismo ISBN).");
        }

    }

}
