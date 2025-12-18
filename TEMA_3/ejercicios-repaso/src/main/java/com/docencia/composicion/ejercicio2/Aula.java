package com.docencia.composicion.ejercicio2;


import java.util.ArrayList;
import java.util.List;


public class Aula {
    private final List<RegistroNota> registros = new ArrayList<>();

    public void registrarNota(String nombreAlumno, String asignatura, double nota) {
        // TODO: validar campos y rango de nota según enunciado.
        if (nombreAlumno != null && asignatura != null) {
            registros.add(new RegistroNota(new Alumno(nombreAlumno), asignatura, nota));
        }
    }

    public double mediaAlumno(String nombreAlumno) {
        double media = 0.0;
        int contador = 0;    
        for (RegistroNota registroNota : registros) {
                media += registroNota.getNota();
                contador++;
            }
        return contador == 0 ? 0.0 : media / contador;
    }

    public List<RegistroNota> getRegistros() {
        return new ArrayList<>(registros);
    }
}
