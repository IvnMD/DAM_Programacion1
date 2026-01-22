package com.docencia.herencia.ejercicio3;

import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Empleado {

    private UUID id;
    private String nombre;
    private double salarioBase;

    protected Empleado(UUID id, String nombre, double salarioBase) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public Empleado(UUID id) {
       
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalarioBase() { return salarioBase; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract double calcularBonus();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", salarioBase=" + salarioBase + "]";
    }

    
}
