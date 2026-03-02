package com.docencia.service;

import com.docencia.model.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.docencia.util.Validaciones;

public class CentroEducativo {
    // Aqui esta el grueso del ejercicio y el razonamiento al que quiero que llegues
    private final List<Persona> personas;
    private final Set<String> documentosRegistrados;
    private final Set<String> emailsRegistrados;

    public CentroEducativo() {
        // Que debes de inicializar aquí
    }

    public boolean registrarPersona(Persona persona) { // ! Cambiado void por boolean
        if (persona == null || persona.getId() <= 0) {
            return false;
        }
        if (personas.contains(persona)) {
            return false;
        }
        if (documentosRegistrados.contains(persona.getDocumento())) {
            return false;
        }
        if (emailsRegistrados.contains(persona.getEmail())) {
            return false;
        }
        if (!Validaciones.validacionDocumento(persona.getDocumento())) {
            throw new IllegalArgumentException("El documento tiene un formato invalido");
        }
        if (!Validaciones.validacionEmail(persona.getEmail())) {
            throw new IllegalArgumentException("El Email tiene un formato invalido");
        }
        documentosRegistrados.add(persona.getDocumento());
        emailsRegistrados.add(persona.getEmail());
        return personas.add(persona);
    }

    // Paso 1: Programación defensiva
    // Paso 2: Evita elementos duplicados por el id. Con lo cual debes de buscar
    // dentro de lista
    // Paso 3: Evita que se pueda introducir un email con un formato o documento
    // incorrecto
    // Paso 4: Evita elementos duplicados por documento y email en los Set
    // Paso 5: Incluye el documecto dentro del set de documentos
    // Paso 6: Incluye el email en el set de emails
    // Paso 7: Incluye la persona dentro de la lista de personas
    public List<Persona> listarPersonas() {
        // Retorna la lista de personas
        return null;
    }

    public Persona buscarPorId(int id) {
        // Busca una persona por su id
        // Se inteligente y reutiliza esta funcion
        return null;
    }

    public Persona buscarPorDocumento(String documento) {
        if (documento == null || documento.isBlank()){
            return null;
        }
        if (!documentosRegistrados.contains(documento)){
            return null;
        }
        // Busca una persona por su id
        // Se inteligente y reutiliza esta funcion

        //! HACER UN FOR Y COMPARAR CON EQUALS
        return null;
    }

public List<Alumno> listarAlumnos() {
List<Alumno> alumnos = new ArrayList<>();
    for (Persona persona : personas){
        if (persona instanceof Alumno){
            alumnos.add(persona);
    }
return alumnos; 
}

    public List<Profesor> listarProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getTipo() == "PROFESOR") {
                profesores.add(Profesor);
            }
        }

        return profesores;
    }

    public List<Persona> buscarPorPrefijo(String prefijo) {
        // Función recursiva. Lee el README inicla para saber como implementar
        return null;
    }
}