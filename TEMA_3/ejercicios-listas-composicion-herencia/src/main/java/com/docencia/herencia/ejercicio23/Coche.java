package com.docencia.herencia.ejercicio23;

public class Coche extends Vehiculo {

    public Coche() {

    }

    public Coche(String matricula) {
        super(matricula);
    }

    public Coche(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
    }

    @Override
    public String toString() {
        return "Coche" + super.toString();
    }

    @Override
    String descripcion() {
        return "Yo soy un coche tejinero de corazon";
    }

}
