package com.docencia.herencia.ejercicio21;

/**
 * Ejercicio 21 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio21 {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(21);
        Triangulo triangulo = new Triangulo(10, 02);


        System.out.println(circulo.area());
        System.out.println(triangulo.area());

        Figura cuadrado = new Figura (5, 5);

        System.out.println(cuadrado.area());

        Figura rectangulo = new Figura (10, 5);

        System.out.println(rectangulo.area());
    }
}
