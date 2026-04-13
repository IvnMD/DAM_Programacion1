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
        EstadoCentro estado = jsonManager.read(jsonPath);
        this.evaluaciones = new ArrayList<>(estado.getEvaluaciones());
        this.incidencias = new ArrayList<>(estado.getIncidencias());
    }

    private void persistir() {
        jsonManager.write(jsonPath, new EstadoCentro(evaluaciones, incidencias));
    }

    @Override
    public void saveEvaluacion(Evaluacion evaluacion) {
        int indice = evaluaciones.indexOf(evaluacion);
        if (indice >= 0) {
            evaluaciones.set(indice, evaluacion); // sobreescribe (upsert)
        } else {
            evaluaciones.add(evaluacion);
        }
        persistir();
    }

    @Override
    public List<Evaluacion> findAllEvaluaciones() {
        return new ArrayList<>(evaluaciones);
    }

    @Override
    public List<Evaluacion> findEvaluacionesByModuloId(String moduloId) {
        List<Evaluacion> evaluacionesBuscar = new ArrayList<>();

        for (Evaluacion evaluacion : evaluaciones) {
            if(evaluacion.getModuloId().equals(moduloId)){
                evaluacionesBuscar.add(evaluacion);
            }
        }
                return evaluacionesBuscar;
    }

    @Override
    public void saveIncidencia(Incidencia incidencia) {
        if (!incidencias.contains(incidencia)) {
            incidencias.add(incidencia);
            persistir();
        }
    }

    @Override
    public List<Incidencia> findAllIncidencias() {
        return new ArrayList<>(incidencias);
    }

    @Override
    public List<Incidencia> findIncidenciasByProfesorId(String profesorId) {
        List<Incidencia> incidenciaBuscar = new ArrayList<>();

        for (Incidencia incidencia : incidencias) {
            if (incidencia.getProfesorId().equals(profesorId)) {
                incidenciaBuscar.add(incidencia);
            }
        }

        return incidenciaBuscar;
    }

}
