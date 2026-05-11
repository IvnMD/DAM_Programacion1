package com.docente.servicio;

import java.util.List;
import com.docente.modelo.Asignatura;

public interface IAsignaturaService {
    List<String> read();
    boolean crearAsignatura(String codigo, String nombre, int horasSemanales);
    boolean actualizarAsignatura(String codigo, String nombre, int horasSemanales);
    boolean deleteAsignatura(String codigo);
    Asignatura buscarAsignatura(String codigo);
}
