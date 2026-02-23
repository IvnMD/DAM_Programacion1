package com.docencia.herencia.ejercicio1;


import java.util.UUID;

public class Alumno extends Persona {
    private String matricula;

    
    
    private Alumno() {
        
    }

    public Alumno(UUID id) {
        super(id);
        
    }

    public Alumno(UUID id, String nombre, int edad, String matricula) {
        super(id, nombre, edad);
        setMatricula(matricula);
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

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.isBlank()){
            throw new IllegalArgumentException();
        }
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
        }
    
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Alumno)){
            return false;
        }
        return super.equals(obj);
    }
}
