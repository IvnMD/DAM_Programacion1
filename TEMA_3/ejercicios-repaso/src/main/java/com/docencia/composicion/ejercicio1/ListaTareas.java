package com.docencia.composicion.ejercicio1;


import java.util.ArrayList;
import java.util.List;


public class ListaTareas {
    private final List<Tarea> tareas = new ArrayList<>();


    public void anadirTarea(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            return;
        }
        tareas.add(new Tarea(descripcion));
    }


    public boolean marcarComoCompletada(String descripcion) {
        if (descripcion == null) return false;
        String buscada = descripcion.trim().toLowerCase();
        for (Tarea tarea : tareas) {
            if (tarea.getDescripcion().equals(buscada)) {
                tarea.marcarCompletada();
                return true;
            }
        }
        return false;
    }


    public List<Tarea> obtenerPendientes() {
        List<Tarea> pendientes = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletada()) {
                pendientes.add(tarea);
            }
        }
        return pendientes;
    }
}
