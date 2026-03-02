package com.docencia.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Objects;
import com.docencia.util.Validaciones;

abstract public class Persona {
    private final int id;
    private String nombre;
    private String documento;
    private String email;
    private LocalDate fechaNacimiento;
    private final LocalDate fechaRegistro = LocalDate.now();
    
    /**
     * Constructor por defecto/vacio
     */
    public Persona() {
        this.id = 0;
    };
    /**
     * Constructor por identificador unico
     * @param id
     */
    public Persona(int id){
        this.id = id;
    }
    /**
     * Constructor de la clase persona
     * @param id identificador unico
     * @param nombre de la persona
     * @param documento Documento de identificacion fisica
     * @param email correo electronico de la persona
     * @param fechaNacimiento de la persona
     * @param fechaRegistro en el sistema 
     */
    public Persona(int id, String nombre, String documento, String email, LocalDate fechaNacimiento, LocalDate fechaRegistro) {
        this.id = 0;
        getId(id);
        setNombre(nombre);
        setDocumento(documento);
        setEmail(email);
        setFechaNacimiento(fechaNacimiento);
        getFechaRegistro(fechaRegistro);
    }
    // Getters y setters

    public int getId(int id) {
        if (id <= 0){
            throw new IllegalArgumentException("ID no valido <= 0");
        }
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException( "Nombre nulo");
        }
        if (nombre.length()>= 2) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
        nombre = nombre.trim();
        this.nombre = nombre;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        if (!Validaciones.validacionDocumento(documento)){
            throw new IllegalArgumentException("Documento no valido");
        }
        this.documento = documento.trim().toUpperCase();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!Validaciones.validacionEmail(email.trim().toLowerCase())){
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fecha == null || fechaNacimiento.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Fecha de nacimiento no valida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad(LocalDate fechaRegistro, LocalDate fechaNacimiento){
        Period resultado = Period.between(fechaNacimiento, fechaRegistro); 
        return resultado.getYears();
    }

    public LocalDate getFechaRegistro(LocalDate fechaRegistro) {
        if (fechaRegistro == null || fechaRegistro.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Fecha de registro no valida");
        }
        return this.fechaRegistro;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", email='" + getEmail() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", edad='" + getEdad() + 
            "}";
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
    public String getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }

    
    

}