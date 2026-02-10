package com.docencia.herencia.ejercicio23;

/**
 * Ejercicio 23 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio23 {

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Coche("1234ABC");
        Vehiculo avion = new Aero(2, "7894QWE");
        System.out.println(vehiculo1.descripcion()); // ! AQUI IMPRIME descripcion() DE LA CLASE COCHE SOBREESCRIBIENDO
                                                     // ! LA FUNCION
        System.out.println(avion);
        System.out.println(avion.descripcion());
    }

}
