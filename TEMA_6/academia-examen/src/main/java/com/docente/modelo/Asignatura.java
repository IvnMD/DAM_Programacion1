package com.docente.modelo;

import java.util.Objects;
import static com.docente.utils.Utilidades.CSV_DELIMITER;

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
        //? TODO implementar
        setCodigo(codigo);
        setNombre(nombre);
        setHorasSemanales(horasSemanales);
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
        return String.format("%s" + CSV_DELIMITER + "%s" + CSV_DELIMITER + "%d",
                getCodigo(), getNombre(), getHorasSemanales());
    }

    @Override
    public String toString() {
        // TODO mejorar formato si lo consideras necesario
        return "Asignatura [codigo=" + getCodigo() + ", nombre=" + getNombre() + ", horasSemanales=" + getHorasSemanales() + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        Asignatura other = (Asignatura) obj;
        if (codigo == null || other.getCodigo() == null) {
            return false;
        }
        return codigo.equals(other.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}
