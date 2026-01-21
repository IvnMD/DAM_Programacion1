package com.docencia.herencia.ejercicio1;
import java.util.UUID;

public class Profesor extends Persona {
    private String departamento;
    
    public Profesor(UUID id, String nombre, int edad, String departamento) {
        super(id, nombre, edad);
        
        // Validar departamento
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException("El departamento no puede ser nulo o vacío");
        }
        
        this.departamento = departamento;
    }
    
    public String getDepartamento() {
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException();
        }
        return departamento;
    }
    
    @Override
    public String rol() {
        return "Profesor";
    }
    
    @Override
    public String toString() {
        return "Profesor [Departamento=" + getDepartamento() + ", id=" + getId() + ", Nombre ="
                + getNombre() + ", getEdad()=" + getEdad() + "]";
    }


        @Override
    public int hashCode() {
        return super.hashCode();
        }
    
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Profesor)){
            return false;
        }
        return super.equals(obj);
    }
}