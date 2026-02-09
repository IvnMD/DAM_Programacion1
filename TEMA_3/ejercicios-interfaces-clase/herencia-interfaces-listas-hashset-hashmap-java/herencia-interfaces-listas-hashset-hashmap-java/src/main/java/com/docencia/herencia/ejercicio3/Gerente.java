package com.docencia.herencia.ejercicio3;

import java.util.UUID;

public class Gerente extends Empleado {

    private int numReportes;

    public Gerente(UUID id){
        super(id);
    }

    public Gerente(UUID id, String nombre, double salarioBase, int numReportes) {
        super(id, nombre, salarioBase);
        if (numReportes < 0) { 
            throw new IllegalArgumentException("El número de reportes no puede ser negativo.");
        }
        this.numReportes = numReportes;
    }



    public int getNumReportes() { 
        return numReportes; 
    }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.20;
    }

    @Override
    public String toString() {
        return "Gerente [numReportes=" + numReportes + 
               ", id=" + getId() + 
               ", nombre=" + getNombre() + 
               ", salario total=" + (getSalarioBase() + calcularBonus()) + "]";
    }
}