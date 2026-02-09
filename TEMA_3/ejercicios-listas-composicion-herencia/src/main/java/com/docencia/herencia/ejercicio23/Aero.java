package com.docencia.herencia.ejercicio23;

import java.util.Objects;

public class Aero extends Vehiculo {

    final int alas;

    public Aero() {
        alas = 2; // ! Defines que algo que vuela tiene dos alas
    }

    public Aero(int alas, String matricula) {
        super(matricula);
        this.alas = alas; // ! Aqui alas puede variar en cantidad
    }

        public Aero(int alas, String matricula, String modelo) {
            super(matricula, null, modelo);
            this.alas = alas;
        }


    public Aero(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.alas = 2; // ! En este constructor, alas va a ser dos si o si

    }

    public Aero(int alas, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.alas = alas; // ! Aqui podemos crear el objeto por completo
    }

    @Override
    String descripcion() {

        return "No se como, pero vuelo";
    }

    @Override
    public String toString() {
        return "Avion" + super.toString();
    }

}
