package com.docencia.herencia.ejercicio23;

public class Avion extends Aero {

    public Avion() {
        super(); // ! Esto te lleva al constructor vacio de aero, por lo que tiene 2 alas
    }

    public Avion(int alas, String matricula, String marca, String modelo) {
        super(alas, matricula, marca, modelo);
    }

    @Override
    public String descripcion() {
        return "Soy un avion";
    }

}
