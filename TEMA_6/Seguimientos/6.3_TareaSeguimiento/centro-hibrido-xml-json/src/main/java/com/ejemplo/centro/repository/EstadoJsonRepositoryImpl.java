package com.ejemplo.centro.repository;

import com.ejemplo.centro.model.EstadoCentro;
import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.util.JsonManager;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoJsonRepositoryImpl implements EstadoJsonRepository {
    private final Path jsonPath;
    private final JsonManager jsonManager;
    List<Incidencia> incidencias;
    List<Evaluacion> evaluaciones;

    public EstadoJsonRepositoryImpl(Path jsonPath) {
        this(jsonPath, new JsonManager());
    }

    public EstadoJsonRepositoryImpl(Path jsonPath, JsonManager jsonManager) {
        this.jsonPath = jsonPath;
        this.jsonManager = jsonManager;
    }
    

    @Override
    public void saveEvaluacion(Evaluacion evaluacion) {
        if (evaluaciones.contains(evaluacion)){
           
        }
        
    }

    @Override
    public List<Evaluacion> findAllEvaluaciones() {
       return evaluaciones;
    }

    @Override
    public List<Evaluacion> findEvaluacionesByModuloId(String moduloId) {
        Evaluacion evaluacionBuscar = new Evaluacion(moduloId);
        int indice = evaluaciones.indexOf(evaluacionBuscar);
        List<Evaluacion> evaluacioneL
        return evaluaciones.get(indice);
    }

    @Override
    public void saveIncidencia(Incidencia incidencia) {
        if (incidencias.contains(incidencia)){
           throw new IllegalArgumentException("La incidencia ya existe en la lista");
        }
        incidencias.add(incidencia);
    }

    @Override
    public List<Incidencia> findAllIncidencias() {
        return incidencias;
    }

    @Override
    public List<Incidencia> findIncidenciasByProfesorId(String profesorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findIncidenciasByProfesorId'");
    }


    
    
}
