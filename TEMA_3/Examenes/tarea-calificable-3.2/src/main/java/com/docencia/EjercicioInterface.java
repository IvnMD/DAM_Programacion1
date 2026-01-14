package com.docencia;

import java.util.ArrayList;
import java.util.List;

public class EjercicioInterface {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        Loro jack = new Loro();
        Lagarta jotape = new Lagarta();
        Gata ari = new Gata();
        Perra laika = new Perra();

        animales.add(jack);
        animales.add(jotape);
        animales.add(ari);
        animales.add(laika);


        for (Animal animal : animales) {
            System.out.println(animal.comer());
        }
    }
}
