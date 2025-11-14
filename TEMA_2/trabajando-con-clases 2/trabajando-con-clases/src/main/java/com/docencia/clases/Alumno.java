package com.docencia.clases;

/**
 * Clase Alumno que hereda de la clase Persona.
 */
public class Alumno extends Persona{
    
    private String cursoEstudia;


    public String getCursoEstudia() {
        return this.cursoEstudia;
    }

    public void setCursoEstudia(String cursoEstudia) {
        this.cursoEstudia = cursoEstudia;
    }


    public Alumno(){
        super();
    }

    public Alumno (String identificador){
        super(identificador);
    }
    
    public Alumno (String identificador, String nombre, int edad, String cursoEstudia) {
        super(identificador, nombre, edad);
        this.cursoEstudia = cursoEstudia;
    }   

    @Override
    public String toString(){
        return "Soy el toString";
    }

    public static void main(String[] args) {
        Alumno alumno = new Alumno("99999999X", "Perro Sanche", 67, "ETS");
        System.out.println(alumno);
        
    }

}