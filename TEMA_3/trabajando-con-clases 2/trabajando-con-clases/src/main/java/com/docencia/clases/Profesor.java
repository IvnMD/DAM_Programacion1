package com.docencia.clases;

/**
 * Clase Profesor que hereda de la Clase Alumno
 */
public class Profesor extends Alumno{
    
    private String cursoImparte;

    public Profesor (String identificador, String nombre, 
                    int edad, String cursoEstudia, String cursoImparte){
        super(identificador, nombre, edad, cursoEstudia);
        this.cursoImparte = cursoImparte;
    }

    public static void main(String[] args) {
        Profesor profesor = new Profesor(null, null, 0, null, null);
        System.out.println(profesor.getEdad());
    }

}
