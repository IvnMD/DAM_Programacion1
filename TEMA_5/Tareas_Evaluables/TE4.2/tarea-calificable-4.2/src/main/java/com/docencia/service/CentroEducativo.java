package com.docencia.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.docencia.model.Alumno;
import com.docencia.model.Persona;
import com.docencia.model.Profesor;
import com.docencia.util.Validaciones;
/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief Clase centro educativo
 */
public class CentroEducativo {
    // Aqui esta el grueso del ejercicio y el razonamiento al que quiero que llegues
    private final List<Persona> personas;
    private final Set<String> documentosRegistrados;
    private final Set<String> emailsRegistrados;

    public CentroEducativo() {
        this.personas = new ArrayList<>();
        this.documentosRegistrados = new HashSet<>();
        this.emailsRegistrados = new HashSet<>();

    }

    // Paso 1: Programacion defensiva
    // Paso 2: Evita elementos duplicados por el id. Con lo cual debes de buscar
    // dentro de lista
    // Paso 3: Evita que se pueda introducir un email con un formato o documento
    // incorrecto
    // Paso 4: Evita elementos duplicados por documento y email en los Set
    // Paso 5: Incluye el documecto dentro del set de documentos
    // Paso 6: Incluye el email en el set de emails
    // Paso 7: Incluye la persona dentro de la lista de personas
    public boolean registrarPersona(Persona persona) { // ! Cambiado void por boolean
        if (persona == null || persona.getId() <= 0) {
            return false;
        }
        if (!Validaciones.validacionDocumento(persona.getDocumento())) {
            throw new IllegalArgumentException("El documento tiene un formato invalido");
        }
        if (!Validaciones.validacionEmail(persona.getEmail())) {
            throw new IllegalArgumentException("El Email tiene un formato invalido");
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
        documentosRegistrados.add(persona.getDocumento());
        emailsRegistrados.add(persona.getEmail());
        return personas.add(persona);
    }

    public List<Persona> listarPersonas() {
        return new ArrayList<>(personas);
    }

    public Persona buscarPorId(int id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    public Persona buscarPorDocumento(String documento) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento invalido");
        }
        if (!documentosRegistrados.contains(documento)) {
            throw new IllegalArgumentException("Documento no registrado en el sistema");
        }
        // Busca una persona por su documento (en el README dice id pero supongo que
        // será un error)
        // Se inteligente y reutiliza esta funcion
        // ! HACER UN FOR Y COMPARAR CON EQUALS
        for (Persona persona : personas) {
            if (persona.getDocumento().equals(documento)) {
                return persona;
            }
        }

        return null;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        for (Persona persona : personas) {
            if ((persona instanceof Alumno)) {
                alumnos.add((Alumno) persona);
            }
        }
        return alumnos;
    }

    public List<Profesor> listarProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Persona persona : personas) {
            if ((persona instanceof Profesor)) {
                profesores.add((Profesor) persona);
            }
        }
        return profesores;

    }

    public List<Persona> buscarPorPrefijo(String prefijo) {
        if (prefijo == null || prefijo.isBlank()) {
            throw new IllegalArgumentException("Prefijo invalido");
        }
        List<Persona> resultado = new ArrayList<>();
        buscarRecursivo(prefijo, 0, resultado);
        return resultado;
    }

    private void buscarRecursivo(String prefijo, int indice, List<Persona> resultado) {
        if (indice == personas.size()) {
            return;
        }
        Persona persona = personas.get(indice);
        String nombre = persona.getNombre();
        String nombreMinusculas = nombre.toLowerCase();
        String prefijoMinusculas = prefijo.toLowerCase();
        if (nombreMinusculas.startsWith(prefijoMinusculas)) {
            resultado.add(persona);
        }
        buscarRecursivo(prefijo, indice + 1, resultado);
    }
}