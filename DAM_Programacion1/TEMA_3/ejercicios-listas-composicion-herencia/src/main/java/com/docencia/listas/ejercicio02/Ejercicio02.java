package com.docencia.listas.ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio02 {

    private Ejercicio02() {
    }

    public static class GestorTareas {
        private final List<String> tareas = new ArrayList<>();

        public void agregarTarea(String tarea) {
            if (tarea == null || tarea.isBlank()|| tareas.contains(tarea)){
                return;
            }

            tareas.add(tarea);
        }

        public List<String> getTareas() {
            return tareas;
        }

        public String completarTarea(int indice) {
            if (indice < 0 || indice > tareas.size()-1){
                return null;
            }
            String tarea = tareas.get(indice); //!Lo recupero
            tareas.remove(indice);            //! Lo elimino
            return tarea;                    //! Lo devuelvo
        }

        public void borrarTodas() {
            // tareas.removeAll(tareas); //! No tan eficiente
            tareas.clear();
        }
    }
}
