package com.docencia.composicion.ejercicio11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Direccion extends Persona{
    private String calle;
    private String ciudad;
    private int codigoPostal;
    private List<Persona> persona;

    public Direccion(){};

    public Direccion(String calle, String ciudad, int codigoPostal){
        super();
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.persona = new ArrayList<>();
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<Persona> getPersona(){
        return persona;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, ciudad, codigoPostal);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Direccion other = (Direccion) obj;
        return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
                && codigoPostal == other.codigoPostal;
    }

    @Override
    public String toString() {
        return "la direccion: calle " + calle + ", en " + ciudad + " y con codigo postal " + codigoPostal;
    }

    
}
