package com.docencia.clases.ejerciciosClases.Programa5;

import java.util.Objects;

/**
 * @author IvnMD
 * @date 24/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Clase Coche: Clase que representa un coche
 */

public class Coche {

    private String marca;
    private String modelo;
    private String matricula;

    /**
     * Constructor por defecto
     */
    public Coche(){};
    /**
     * Constructor con parametros
     * @param marca Marca del coche
     * @param modelo Modelo del coche
     * @param matricula Matricula del coche
     */
    public Coche(String marca, String modelo, String matricula){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    @Override
    public String toString() {
        return "{" +
            " marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", matricula='" + getMatricula() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coche)) {
            return false;
        }
        Coche coche = (Coche) o;
        return  Objects.equals(matricula, coche.matricula);
    }

}
