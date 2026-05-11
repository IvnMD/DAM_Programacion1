package com.docente.persistencia;

import java.util.List;
import com.docente.modelo.Asignatura;

public interface IAsignaturaRepositorio {
    List<Asignatura> obtenerAsignaturas();
    boolean guardarAsignaturas(List<Asignatura> asignaturas);
}
