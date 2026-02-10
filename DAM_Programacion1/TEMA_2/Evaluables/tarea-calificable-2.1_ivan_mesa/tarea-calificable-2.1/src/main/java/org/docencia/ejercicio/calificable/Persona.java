package org.docencia.ejercicio.calificable;
/**
 * @author IvnMD
 * @since 07/11/25
 * @version 1.0.0
 * @brief Clase Persona: Implementar constructores, encapsulamiento, equals/hasCode y ToString
 */
import java.util.Objects;

/**
 * Clase que define a una persona por su numero de identificacion, nombre y edad.
 */
public class Persona {
    private String id;
    private String nombre;
    private int edad;
    /**
     * Constructor por vacio (por defecto)
     */
    public Persona() {
    }
    /**
     * Constructor parametrico
     * @param id Numero de identificacion de la persona
     * @param nombre Nombre de la persona
     * @param edad Edad de la persona
     */
    public Persona(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getId() {
        return this.id;
    }

    public String getNombre() {
        if (nombre == null || nombre.isEmpty()){
            return nombre;
        }
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        if (id == null){
            return false;
        }
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Persona = {" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            "}";
    }



}
