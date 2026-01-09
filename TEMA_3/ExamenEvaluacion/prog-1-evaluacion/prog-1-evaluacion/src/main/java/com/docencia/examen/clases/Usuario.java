package com.docencia.examen.clases;
import java.util.Objects;

/**
 * @author IvnMD
 * @date 10/12/25
 * @version 1.0.0
 * 
 * 
 */


/**
 * Clase usuario
 */
public class Usuario {

    protected String identificador;
    private String nombre;
    private String apellidos;

    /**
     * Constructor vacio/por defecto
     */
    public Usuario() {
    }

    
    /**
     * Constructor parametro
     * @param identificador identificador unico del usuario
     * @param nombre nombre del usuario
     * @param apellidos apellidos del usuario
     */
    public Usuario(String identificador, String nombre, String apellidos) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }


    /**
     * Constructor por parametro identificador unico
     * @param identificador identificador unico del usuario
     */
    public Usuario(String identificador){
        this.identificador = identificador;
    }


    /**
     * Setters y getters
     */
    public String getIdentificador() {
        return identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(identificador, usuario.identificador);
    }
    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return "{" +
            " identificador='" + getIdentificador() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            "}";
    }
    /**
     * Hash Code
     */
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    

}
