package com.docencia.composicion.ejercicio3;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que almacena el paciente
 */
public class Paciente {
    private final String nombre;


    /**
     * Constructor vacio/ por defecto //!--> Inicializado debido al final
     */
    public Paciente(){
        nombre= "";
    };
    /**
     * Constructor parametrico
     * @param nombre identificador unico
     */
    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre.trim();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Paciente)) {
            return false;
        }
        Paciente paciente = (Paciente) o;
        return Objects.equals(nombre.toLowerCase()
        , paciente.nombre.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            "}";
    }
    
}
