package com.docencia.herencia.ejercicio7;
/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Clase profesor que hereda de persona
 */
public class Profesor extends Persona {
        private final String especialidad;
        
        /**
        * Constructor vacio/por defecto. Inicializado por ser un atributo final
        */
        public Profesor(){
            especialidad = "";
        }
        /**
         * Constructor parametrico
         * @param nombre del profesor
         * @param especialidad del profesor
         */
        public Profesor(String nombre, String especialidad) {
            super(nombre);
            this.especialidad = especialidad;
        }
        /**
         * Getters
         */
        public String getEspecialidad() {
            return especialidad;
        }

        @Override
        public String descripcionRol() {
            
            return "Profesor " + getNombre() + " de " + getEspecialidad();
        }
    public static List<String> descripciones(List<Persona> personas) {
        if (personas == null || personas.isEmpty()){
            return new ArrayList<>();
        }
        List<String> descripciones = new ArrayList<>();
        

        for (int i = 0; i < personas.size(); i++) {
            descripciones.add(((Profesor) personas).descripcionRol());
            descripciones.add(((Estudiante) personas).descripcionRol());
        }
        return descripciones;
    }    
}

    
