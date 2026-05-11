package com.docente.servicio;

import com.docente.modelo.AlumnoMatriculado;
import com.docente.persistencia.IAlumnoMatriculadoRepositorio;
import com.docente.persistencia.impl.AlumnoMatriculadoRepositorioCSV;

import java.util.ArrayList;
import java.util.List;


public class AlumnoMatriculadoService implements IAlumnoMatriculadoService {

    private final IAlumnoMatriculadoRepositorio alumnoRepositorio;
    private final IAsignaturaService asignaturaService;
    private final List<AlumnoMatriculado> alumnosMatriculados;

    public AlumnoMatriculadoService() {
        this(new AlumnoMatriculadoRepositorioCSV(), new AsignaturaService());
    }

    public AlumnoMatriculadoService(IAlumnoMatriculadoRepositorio alumnoRepositorio, IAsignaturaService asignaturaService) {
        this.alumnoRepositorio = alumnoRepositorio;
        this.asignaturaService = asignaturaService;
        this.alumnosMatriculados = new ArrayList<>(alumnoRepositorio.obtenerAlumnosMatriculados());
    }

    @Override
    public List<String> read() {
        // TODO implementar
        return new ArrayList<>();
    }

    public boolean updateLista() {
        // TODO implementar
        return false;
    }

    @Override
    public boolean crearAlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        // TODO implementar
        return false;
    }

    @Override
    public boolean actualizarAlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        // TODO implementar
        return false;
    }

    @Override
    public boolean deleteAlumnoMatriculado(String identificador) {
        // TODO implementar
        return false;
    }

    @Override
    public AlumnoMatriculado buscarAlumnoMatriculado(String identificador) {
        // TODO implementar
        return null;
    }

    @Override
    public boolean matricularAsignatura(String identificadorAlumno, String codigoAsignatura) {
        // TODO implementar
        return false;
    }

    @Override
    public boolean desmatricularAsignatura(String identificadorAlumno, String codigoAsignatura) {
        // TODO implementar
        return false;
    }

    @Override
    public int getNumeroAsignaturas(String identificadorAlumno) {
        // TODO implementar
        return -1;
    }

    @Override
    public boolean estaMatriculadoEn(String identificadorAlumno, String codigoAsignatura) {
        // TODO implementar
        return false;
    }
}
