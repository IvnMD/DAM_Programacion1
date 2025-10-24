package com.docencia.ejercicio.clases.cuatro;

import java.time.Year;
import java.util.Objects;
/**
 * Clase Coche
 * @author Ivan Mesa Dominguez
 * @since 24/10/25
 * @version 1.0
 * @brief Declaracion de la clase coche
 */
public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private int anio;
    /**
     * Constructor vacio
     */
    public Coche() { }
    /**
     * Constructor parametrico del identificador principal
     * @param matricula
     */
    public Coche(String matricula) {
        this.matricula = matricula;

    }
    /**
     * Constructor parametrico con todos los atributos
     * @param matricula
     * @param marca
     * @param modelo
     * @param anio
     */
    public Coche(String matricula, String marca, String modelo, int anio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    /**
     * Setters/Getters 
     */
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Metodo equals para comparar entre instancias de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coche)) {
            return false;
        }
        Coche coche = (Coche) o;
        return Objects.equals(matricula.toLowerCase(), coche.matricula.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, marca, modelo, anio);
    }


    /**
     * Metodo toString() para poder imprimir el contenido de las clases y no su direccion de memoria. 
     */    
    @Override
    public String toString() {
        if (getMarca() == null){
            this.marca = "(Marca desconocida) ";
        }
        if (getModelo() == null){
            this.modelo = "(Modelo desconocido) ";
        }
        if (getAnio() == 0){
            System.out.println("((Año desconocido))");
        }
        if (getMatricula() == null){
            this.matricula = "- sin matrícula";
        }
        return getMarca() + " " + getModelo() + " (" + getAnio() + ")"+ getMatricula();

    }

    
}

