package com.docencia.herencia.ejercicio3;

import java.util.UUID;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;

    public Desarrollador(UUID id, String nombre, double salarioBase, String lenguajePrincipal) {
        super(id, nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
}

    public Desarrollador(UUID id) {
        super(id);
    }

    public String getLenguajePrincipal() { 
        if (lenguajePrincipal == null || lenguajePrincipal.isBlank()){
            throw new IllegalStateException();
        }
        return lenguajePrincipal; }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.10;
    }

    @Override
    public String toString() {
        return "Desarrollador [getLenguajePrincipal()=" + getLenguajePrincipal() + ", id=" + getId()
                + ", getNombre()=" + getNombre() + ", getSalarioBase()=" + getSalarioBase() + "]";
    }

    

    
}
