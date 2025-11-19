package com.docencia.app;
import java.util.Objects;

public class Persona {
    private String identificador;
    private String nombre;
    private int edad;

    public Persona(){};

    public Persona(String identificador){
        this.identificador = identificador;
    }
    /**
     * Constructor parametrico
     * @param identificador
     * @param nombre
     * @param edad
     */
    public Persona(String identificador, String nombre, int edad){
        this.identificador= identificador;
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona identificador(String identificador) {
        setIdentificador(identificador);
        return this;
    }

    public Persona nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Persona edad(int edad) {
        setEdad(edad);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(identificador, other.identificador);
    }

    @Override
    public String toString() {
        return 
            "Identificador = '" + getIdentificador() + "'" +
            ", nombre = '" + getNombre() + "'" +
            ", edad = '" + getEdad() + "'";
    }
    
}
