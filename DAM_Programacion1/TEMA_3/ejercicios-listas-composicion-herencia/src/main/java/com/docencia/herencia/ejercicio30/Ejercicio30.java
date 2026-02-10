package com.docencia.herencia.ejercicio30;

import java.util.ArrayList;
import java.util.List;

import com.docencia.herencia.ejercicio21.Circulo;
import com.docencia.herencia.ejercicio21.Triangulo;
import com.docencia.herencia.ejercicio21.Figura;

/**
 * Ejercicio 30 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio30 {  //! Pregunta examen

    public static void main(String[] args) {
        Figura triangulo1 = new Triangulo(10,2 );
        Figura circulo1 = new Circulo(2);
        Figura circulo2 = new Circulo(4);
        Figura cuadrado1 = new Figura(5,5);

        List<Figura> figuras = new ArrayList<>();
        figuras.add(cuadrado1);
        figuras.add(triangulo1);
        figuras.add(circulo1);
        figuras.add(circulo2);

        GrupoFiguras grupoFiguras = new GrupoFiguras(figuras);
        System.out.println("Area total = " + grupoFiguras.areaTotal());
        System.out.println("Area circulo = " + grupoFiguras.areaTotalCirculo());
        System.out.println("Area figuras diferentes a circulo y triangulo = " + grupoFiguras.areaTotalOtros());
        System.out.println("Area triangulo = " + grupoFiguras.areaTotalTriangulo());
    }
}
