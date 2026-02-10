package com.docencia.herencia.ejercicio23;

import java.util.Objects;

public abstract class Vehiculo { // ! AL SER ABSTRACT, LA CLASE VEHICULO NO SE PUEDE INSTANCIAR
    
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo() {

    }

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculo(String matricula, String marca){
        this.matricula = matricula;
        this.marca = marca;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
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
        if (modelo== null || modelo.isBlank()) {
            throw new IllegalArgumentException("Parametro incorrecto");
        }
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    public Vehiculo matricula(String matricula) {
        setMatricula(matricula);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "{" +
                " matricula='" + getMatricula() + "'" +
                ", marca='" + marca + "'" +
                ", modelo='" + getModelo() + "'" +
                "}";
    }

    abstract String descripcion(); // ! FUERZO A CALQUIER HIJO A CAMBIAR SU DECORADOR (SOBReESCRIBIRLO)

}
