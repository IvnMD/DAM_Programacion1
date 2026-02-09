package com.docencia.herencia.ejercicio2;

import java.util.UUID;

public class Coche extends Vehiculo {

    private int puertas;

    public Coche(UUID id) {
        super(id);
    }

    public Coche(UUID id, String marca, String modelo, int puertas) {
        super(id, marca, modelo);
        if (puertas <= 0) {
            throw new IllegalArgumentException("Un coche debe tener al menos una puerta.");
        }
        this.puertas = puertas;
    }


    public int getPuertas() { 
        return puertas; 
    }

    @Override
    public int ruedas() {
        return 4;
    }

    @Override
    public String toString() {
        return "Coche [puertas=" + puertas + ", id=" + getId() + 
               ", marca=" + getMarca() + ", modelo=" + getModelo() + "]";
    }
}
