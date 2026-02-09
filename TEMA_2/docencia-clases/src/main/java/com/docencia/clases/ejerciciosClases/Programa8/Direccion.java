package com.docencia.clases.ejerciciosClases.Programa8;
import java.util.Objects;

/**
 * @author IvnMD
 * @since 24/10/25
 * @version 1.0
 * @brief Clase direccion ejercicio 8
 * @bugs sin bugs conocidos
 */

public class Direccion {

    private String calle;
    private int numero;
    private String ciudad;
    /**
     * Constructor vacio 
     */
    Direccion (){};
    /**
     * Constructor por parametros de la clase Direccion
     * @param calle 
     * @param numero
     * @param ciudad
     */
    Direccion(String calle, int numero, String ciudad){
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }


    // Getters y setters
    public String getCalle() {
        return this.calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    // toString legible
    @Override
    public String toString() {
        return "{" +
            " calle='" + getCalle() + "'" +
            ", numero='" + getNumero() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            "}";
    }
        // equals: ajusta los campos usados en la comparación
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Direccion)) {
            return false;
        }
        Direccion direccion = (Direccion) o;
        return Objects.equals(calle, direccion.calle) && numero == direccion.numero && Objects.equals(ciudad, direccion.ciudad);
    }


}
