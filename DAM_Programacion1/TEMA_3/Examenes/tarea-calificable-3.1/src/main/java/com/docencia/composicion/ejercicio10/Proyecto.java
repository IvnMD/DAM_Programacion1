package com.docencia.composicion.ejercicio10;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 * @brief Clase gproyecto
 */
public class Proyecto {
    private final String nombre;
    private final List<Tarea> tareas = new ArrayList<>();

    /**
     * Constructor vacio/por defecto
     */
    public Proyecto() {
        this.nombre = "";
    }
    /**
     * Constructor por identificador unico
     * @param nombre nombre del proyecto
     */
    public Proyecto(String nombre) {
        this.nombre = nombre.trim();
    }
    /**
     * Constructor parametrico
     * @param nombre del proyecto
     * @param tareas que componen el proyecto
     */
    public Proyecto(String nombre, List<Tarea> tareas){
        this.nombre = nombre.trim();
    }

    /**
     * Getters
     */
    public String getNombre() {
        if(nombre == null || nombre.isBlank()){
            return null;
        }
        return nombre.trim();
    }

    public List<Tarea> getTareas() {
        return new ArrayList<>(tareas);
    }

    void anadirTarea(Tarea t) {
        tareas.add(t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Proyecto other = (Proyecto) obj;
        return Objects.equals(nombre.toLowerCase(), other.nombre.toLowerCase());
    }

    
}
