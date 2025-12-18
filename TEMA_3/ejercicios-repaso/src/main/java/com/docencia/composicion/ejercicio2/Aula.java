package com.docencia.composicion.ejercicio2;


import java.util.ArrayList;
import java.util.List;


public class Aula {
    private final List<RegistroNota> registros = new ArrayList<>();

    public void registrarNota(String nombreAlumno, String asignatura, double nota) {
        if (nombreAlumno != null && asignatura != null  && nota > 0.0 && nota < 10.0) {
            registros.add(new RegistroNota(new Alumno(nombreAlumno), asignatura, nota));
        }
    }

    public double mediaAlumno(String nombreAlumno) {
        
        double media = 0.0;
        int contador = 0;    
        for (RegistroNota registroNota : registros) {
                media += registroNota.getNota();
                if (registroNota != null){
                contador++;
                }
            }
        if (contador == 0 ){
            return 0.0;
        } else {
            return media / contador;
        }
    }

    public List<RegistroNota> getRegistros() {
        return new ArrayList<>(registros);
    }
}
