package com.docencia.clases.ejerciciosClases.Programa1;
import java.util.Objects;

public class Persona1 {


    public String nombre;
    private int edad;
    /**
     * Constructor por vacio
     * @return 
     *      
     */
    public Persona1(){};
    /**
     * Constructor de la clase con propiedades
     * @param nombre Nombre de la persona1
     * @param edad Edad de la persona1
     */
    public Persona1(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
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

    /**
     * toString()
     */
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            "}";
    }
    /**
     * equals();
     */

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona1)) {
            return false;
        }
        Persona1 Persona1 = (Persona1) o;
        return Objects.equals(nombre, Persona1.nombre) && edad == Persona1.edad;
    }
}
    


