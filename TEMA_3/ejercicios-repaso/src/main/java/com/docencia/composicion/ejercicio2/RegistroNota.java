package com.docencia.composicion.ejercicio2;


import java.util.ArrayList;
import java.util.List;


public class RegistroNota {
    private final Alumno alumno;
    private final String asignatura;
    private final double nota;

    public RegistroNota(Alumno alumno, String asignatura, double nota) {
        this.alumno = alumno;
        this.asignatura = asignatura.trim();
        this.nota = nota;
    }

    public Alumno getAlumno() {
        if(alumno == null) {
            return new Alumno();
        }
        return alumno;
    }

    public String getAsignatura() {
        if (asignatura == null || asignatura.isEmpty()) {
            return "";
        }
        return asignatura;
    }

    public double getNota() {
        if (nota < 0.0 || nota > 10.0) {
            return 0.0;
        }
        return nota;
    }


}
