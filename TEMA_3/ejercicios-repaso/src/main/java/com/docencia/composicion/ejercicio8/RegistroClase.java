package com.docencia.composicion.ejercicio8;


import java.util.ArrayList;
import java.util.List;


public class RegistroClase {
    private final List<RegistroAsistencia> registros = new ArrayList<>();

    public void registrarAsistencia(String nombreAlumno, String dia, boolean presente) {
        // TODO: validar nombreAlumno y dia antes de registrar.
        if (nombreAlumno != null && dia != null) {
            registros.add(new RegistroAsistencia(new Alumno(nombreAlumno), dia, presente));
        }
    }

    public double porcentajeAsistencia(String nombreAlumno) {
        if(nombreAlumno == null || registros.isEmpty()) {
            return 0.0;
        }
        int totalClasesAlumno = 0;
        int totalAsistencias = 0;
        for (RegistroAsistencia registro : registros) {
            if (registro.getAlumno().getNombre().equals(nombreAlumno)){
                totalClasesAlumno++;
                if (registro.isPresente()) {
                    totalAsistencias++;
                }
            }
            if (totalClasesAlumno == 0){
             return 0.0;
            }

        }
        return (totalAsistencias/totalClasesAlumno)*100;
    }

    public List<RegistroAsistencia> getRegistros() {
        return new ArrayList<>(registros);
    }
}
