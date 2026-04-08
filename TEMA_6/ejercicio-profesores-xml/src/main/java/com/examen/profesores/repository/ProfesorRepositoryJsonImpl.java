package com.examen.profesores.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.print.DocFlavor.INPUT_STREAM;

import com.examen.profesores.model.Profesor;
import com.examen.profesores.model.Profesores;
import com.examen.profesores.util.XmlManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ProfesorRepositoryJsonImpl implements ProfesorRepository {
    private final ObjectMapper objectMapper;
    Path path;
    List<Profesor> profesores;

    public ProfesorRepositoryJsonImpl() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.path = Path.of("data", "profesores.json");
        profesores = read().getProfesores();

    }

    @Override
    public boolean save(Profesor profesor) {
        if (profesores.contains(profesor)){
            return false;
        }
        profesores.add(profesor);
        return write();
    }

    @Override
    public Profesor findById(String id) {
        Profesor profesorBuscar = new Profesor(id);
        int posicion = profesores.indexOf(profesorBuscar);
        if (posicion < 0) {
            return null;
        }
        return profesores.get(posicion);
    }

    @Override
    public List<Profesor> findAll() {
        return profesores;
    }

    @Override
    public boolean existsById(String id) {
        Profesor profesorBuscar = new Profesor(id);
        return profesores.contains(profesorBuscar);
    }

    @Override
    public boolean deleteById(String id) {
        Profesor profesorBuscar = new Profesor(id);
        int posicion = profesores.indexOf(profesorBuscar);
        if (posicion < 0) {
            return false;
        }
         profesores.remove(profesorBuscar);
         return write();
        //return profesores.remove(id); //! FUNCIONA PERO SOLO SI LA API DEVUELVE BOOLEAN EN REMOVE(ID)
    }

    @Override
    public boolean updateDepartamento(String id, String nuevoDepartamento) {
        Profesor profesorComparar = new Profesor(id);
        for (Profesor profesor : profesores) {
            if (profesor.equals(profesorComparar)) {
                profesor.setDepartamento(nuevoDepartamento);
                write();
                return true;
            }
        }
        return false;
    }

    /**
     * Funcion que lee todos los elementos del fichero json
     * 
     * @return lista de profesores
     */
    private Profesores read() {
        try {
            if (Files.notExists(path) || Files.size(path) == 0) {
                return new Profesores();
            }
            return objectMapper.readValue(path.toFile(), Profesores.class);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer el JSON", e);
        }
    }

    /**
     * Funcion que escribe los elementos en el fichero Json
     */
    private boolean write() {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            objectMapper.writeValue(path.toFile(), profesores);
            return true;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo escribir el Json", e);
        }
    }

}
