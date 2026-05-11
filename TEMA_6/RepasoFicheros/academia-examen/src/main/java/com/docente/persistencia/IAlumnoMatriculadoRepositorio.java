package com.docente.persistencia;

import java.util.List;
import com.docente.modelo.AlumnoMatriculado;

public interface IAlumnoMatriculadoRepositorio {
    List<AlumnoMatriculado> obtenerAlumnosMatriculados();
    boolean guardarAlumnosMatriculados(List<AlumnoMatriculado> alumnosMatriculados);
}
