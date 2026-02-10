package com.docencia;
import java.util.Objects;

public class Animal {
        
    String chip;
    String nombre;

    /**
     * Constructor vacio o por defecto
     */
    public Animal() {
    }
    /**
     * Constructor parametrico
     * @param chip Identificador unico
     * @param nombre Nombre de la mastoca
     */
    public Animal(String chip, String nombre) {
        this.chip = chip;
        this.nombre = nombre;
    }
    /**
     * Getters y setters
     */
    public String getChip() {
        return this.chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Animal chip(String chip) {
        setChip(chip);
        return this;
    }

    public Animal nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(chip, animal.chip);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chip);
    }

    @Override
    public String toString() {
        return "{" +
            " chip='" + getChip() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }
    

}