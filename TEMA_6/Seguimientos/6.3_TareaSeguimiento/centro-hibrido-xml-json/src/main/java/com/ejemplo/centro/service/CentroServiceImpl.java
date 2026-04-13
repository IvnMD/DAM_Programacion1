package com.ejemplo.centro.service;

import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import com.ejemplo.centro.repository.CentroXmlRepository;
import com.ejemplo.centro.repository.EstadoJsonRepository;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CentroServiceImpl implements CentroService {

    private final CentroXmlRepository xmlRepository;
    private final EstadoJsonRepository jsonRepository;

    public CentroServiceImpl(CentroXmlRepository xmlRepository, EstadoJsonRepository jsonRepository) {
        this.xmlRepository = Objects.requireNonNull(xmlRepository);
        this.jsonRepository = Objects.requireNonNull(jsonRepository);
        
    }

    @Override
    public Profesor buscarProfesor(String profesorId) {
        return xmlRepository.findProfesorById(profesorId);
        
    }

    @Override
    public Modulo buscarModulo(String moduloId) {
        return xmlRepository.findModuloById(moduloId);
    }

    @Override
    public List<Modulo> listarModulosDeProfesor(String profesorId) {
        return xmlRepository.findAllModulos();
    }

    @Override
    public Evaluacion registrarEvaluacion(String alumno, String moduloId, double nota) {
        Evaluacion evaluacionGuardar = new Evaluacion(alumno, moduloId, nota);
        jsonRepository.saveEvaluacion(evaluacionGuardar);
        return evaluacionGuardar;
    }

    @Override
    public List<Evaluacion> listarEvaluacionesDeModulo(String moduloId) {
        return jsonRepository.findEvaluacionesByModuloId(moduloId);
    }

    @Override
    public double calcularMediaDeModulo(String moduloId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMediaDeModulo'");
    }

    @Override
    public double calcularMediaDeProfesor(String profesorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMediaDeProfesor'");
    }

    @Override
    public Incidencia registrarIncidencia(String profesorId, String descripcion, String fecha) {
        Incidencia incidenciaGuardar = new Incidencia(profesorId, descripcion, fecha);
        jsonRepository.saveIncidencia(incidenciaGuardar);
        return incidenciaGuardar;
    }

    @Override
    public List<Incidencia> listarIncidenciasDeProfesor(String profesorId) {
        return jsonRepository.findIncidenciasByProfesorId(profesorId);
    }

    
}
