package com.docencia.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import com.docencia.util.Validaciones;
/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief Clase persona
 */
abstract public class Persona {
    private final int id;
    private String nombre;
    private String documento;
    private String email;
    private LocalDate fechaNacimiento;
    private final LocalDate fechaRegistro;

    /**
     * Constructor por identificador unico/ atributos final
     * 
     * @param id
     */
    public Persona(int id, LocalDate fechaRegistro) {
        if (id <= 0)
            throw new IllegalArgumentException("ID invalido");
        this.id = id;
        if (fechaRegistro == null ||
                fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de registro invalida");
        }
        this.fechaRegistro = LocalDate.now();
    }

    /**
     * Constructor de la clase persona
     * 
     * @param id              identificador unico
     * @param nombre          de la persona
     * @param documento       Documento de identificacion fisica
     * @param email           correo electronico de la persona
     * @param fechaNacimiento de la persona
     * @param fechaRegistro   en el sistema
     */
    public Persona(int id, String nombre, String documento, String email, LocalDate fechaNacimiento,
            LocalDate fechaRegistro) {
        if (id <= 0)
            throw new IllegalArgumentException("ID invalido");
        this.id = id;
        setNombre(nombre);
        setDocumento(documento);
        setEmail(email);
        setFechaNacimiento(fechaNacimiento);
        if (fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de registro invalida");
        }
        this.fechaRegistro = LocalDate.now();
    }

    // Getters y setters

    public final int getId() {
        return id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre nulo");
        }
        nombre = nombre.trim();
        if (nombre.length() < 2) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
        this.nombre = nombre;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        if (!Validaciones.validacionDocumento(documento.trim().toLowerCase())) {
            throw new IllegalArgumentException("Documento no valido");
        }
        this.documento = documento.trim().toUpperCase();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!Validaciones.validacionEmail(email.trim().toLowerCase())) {
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null || !fechaNacimiento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento no valida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula la edad de nacimiento haciendo Period entre fecha de nacimiento y
     * registro
     * 
     * @return edad de la persona
     */
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public final LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    /**
     * Metodos toString, HashCode y qeuals
     */
    @Override
    public String toString() {
        return getTipo() + ";" +
                getId() + ";" +
                getNombre() + ";" +
                getDocumento() + ";" +
                getEmail() + ";" +
                getFechaNacimiento() + ";" +
                getFechaRegistro();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return id == other.id;
    }
    /**
     * Metodo abstracto
     */
    abstract public String getTipo();

}