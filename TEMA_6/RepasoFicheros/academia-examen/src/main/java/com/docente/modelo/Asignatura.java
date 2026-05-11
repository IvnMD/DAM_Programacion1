package com.docente.modelo;

/**
 * TODO alumnado:
 * Implementa esta clase completa a partir del enunciado del README.
 *
 * Requisitos mínimos:
 * - atributos: codigo, nombre, horasSemanales
 * - constructores
 * - getters y setters
 * - equals y hashCode por codigo
 * - toString
 * - toCsv
 */
public class Asignatura {

    private String codigo;
    private String nombre;
    private int horasSemanales;

    public Asignatura(String codigo) {
        this.codigo = codigo;
    }

    public Asignatura(String codigo, String nombre, int horasSemanales) {
        // TODO implementar
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
    }

    public Asignatura() {
    }

    public Asignatura codigo(String codigo) {
        setCodigo(codigo);
        return this;
    }

    public Asignatura nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Asignatura horasSemanales(int horasSemanales) {
        setHorasSemanales(horasSemanales);
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public String toCsv() {
        // TODO implementar correctamente
        return codigo + ";" + nombre + ";" + horasSemanales;
    }

    @Override
    public String toString() {
        // TODO mejorar formato si lo consideras necesario
        return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + ", horasSemanales=" + horasSemanales + "]";
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Asignatura other = (Asignatura) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
}
