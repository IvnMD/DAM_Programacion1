package com.docencia.clases.ejercicio10;
/**
 * @author IvnMd
 * @date 09/01/26
 * @version 1.0.0
 * @brief implementar equals/hashCode/toString en Mascota 
 *        usando chip como identificador unico.
 */
import java.util.Objects;
/**
 * Clase Mascota
 */
public class Mascota {
    private String chip;
    private String nombre;
    private String tipo;
    /**
     * Constructor vacio/por defecto
     */
    public Mascota() {
    }
    /**
     * Constructor por identificador unico
     * @param chip indentificador unico
     */
    public Mascota(String chip) {
        setChip(chip);
    }
    /**
     * Constructor parametrico
     * @param chip identificador unico
     * @param nombre nombre de la mascota
     * @param tipo tipo de mascota
     */
    public Mascota(String chip, String nombre, String tipo) {
        setChip(chip);
        setNombre(nombre);
        setTipo(tipo);
    }
    /**
     * Getters/Setters
     * 
     */
    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        if(chip == null || chip.isBlank()){
            throw new IllegalArgumentException();
        }
        this.chip = chip.trim().toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Funcion hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(chip);
    }
    /**
     * Funcion equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Mascota other = (Mascota) obj;
        return Objects.equals(chip, other.chip);
    }
    /**
     * Funcion toString()
     */
    @Override
    public String toString() {
        return "Mascota [chip=" + chip + ", nombre=" + nombre + ", tipo=" + tipo + "]";
    }
    
    
}
