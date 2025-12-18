package com.docencia.composicion.ejercicio10;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 * @brief Clase gestor proyectos
 */
public class GestorProyectos {
    private final List<Proyecto> proyectos = new ArrayList<>();

    /**
     * Metodo para crear un proyecto
     * @param nombre del proyecyo
     */
    public Proyecto crearProyecto(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return null;
        }
        Proyecto p = new Proyecto(nombre);
        proyectos.add(p);
        return p;
    }
    /**
     * Metodo para anyadir una tarea al proyecto
     * @param nombreProyecto nombre del proyecto
     * @param descripcionTarea descripcion de la tarea
     * @return booleano
     */
    public boolean anadirTareaAProyecto(String nombreProyecto, String descripcionTarea) {
        if (nombreProyecto == null || nombreProyecto.isBlank()){
            return false;
        }
        if (descripcionTarea == null || descripcionTarea.isBlank()){
            return false;
        }
        nombreProyecto = nombreProyecto.trim().toLowerCase();
        descripcionTarea = descripcionTarea.trim().toLowerCase();
       
        for (Proyecto proyecto : proyectos) {
            if(nombreProyecto.equals(nombre)){
                return true;
            }
        }

        return false;
    }
    /**
     * metodo para contar las tareas pendientes
     * @param nombreProyecto nombre del proyecto
     * @return total de las tareas pendientes
     */
    public int contarTareasPendientes(String nombreProyecto) {
            int tamanyo = proyectos.size();
        return tamanyo;
    }
    /**
     * getters
     */
    public List<Proyecto> getProyectos() {
        return new ArrayList<>(proyectos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyectos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GestorProyectos other = (GestorProyectos) obj;
        return Objects.equals(proyectos, other.proyectos);
    }

    
}
