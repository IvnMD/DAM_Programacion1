package com.docencia.herencia.ejercicio1;


import java.util.UUID;

public class Alumno extends Persona {
    private String matricula;
    
    public Alumno(UUID id, String nombre, int edad, String matricula) {
        super(id, nombre, edad);
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("La matrícula no puede ser nula o vacía");
        }
        this.matricula = matricula;
    }
    
    public String getMatricula() { 
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException();
        }
        return matricula; 
    }
    
    @Override
    public String rol() {
        return "Alumno";
    }
    
    @Override
    public String toString() {
        // El test espera ver "id=" en el toString
        return "Alumno{matricula=" + matricula + 
               ", id=" + getId() + 
               ", nombre=" + getNombre() + 
               ", edad=" + getEdad() + "}";
    }
}
