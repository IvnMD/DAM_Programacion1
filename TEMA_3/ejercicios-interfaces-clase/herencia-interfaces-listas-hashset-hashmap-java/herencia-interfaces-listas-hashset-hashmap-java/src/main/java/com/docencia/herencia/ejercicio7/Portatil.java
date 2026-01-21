package com.docencia.herencia.ejercicio7;

import java.util.UUID;

public class Portatil extends Dispositivo {

    private double pulgadas;

    public Portatil(UUID id, String fabricante, double pulgadas) {
        super(id, fabricante);
        setPulgadas(pulgadas);
}

    public double getPulgadas() { return pulgadas; }

    

    @Override
    public String tipo() {
        return "Portatil";
    }

    
    

    @Override
    public String toString() {
        return "Portatil [getPulgadas()=" + getPulgadas() + ", id=" + getId() + "]";
    }

    public void setPulgadas(double pulgadas) {
        if (pulgadas <= 0) {
            throw new IllegalArgumentException();
        }
        this.pulgadas = pulgadas;
    }
}
