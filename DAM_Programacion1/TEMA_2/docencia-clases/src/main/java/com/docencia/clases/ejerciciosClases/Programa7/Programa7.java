package com.docencia.clases.ejerciciosClases.Programa7;

public class Programa7 {

    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Matrix", 1999);
        Pelicula pelicula2 = new Pelicula("Matrix", 1999);
        Pelicula pelicula3 = new Pelicula("Matrix", 2003);
        
        System.out.println("¿1=2?" + pelicula1.equals(pelicula2));
        System.out.println("¿1=3?" + pelicula1.equals(pelicula3));

        pelicula3.setAnyo(1999);
        System.out.println(pelicula3);
        System.out.println("¿1=3?" + pelicula1.equals(pelicula3));
    }

}
