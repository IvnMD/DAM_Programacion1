package com.docente.persistencia.impl;

import com.docente.modelo.AlumnoMatriculado;
import com.docente.persistencia.IAlumnoMatriculadoRepositorio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO alumnado:
 * Implementa la lectura y escritura en CSV de la entidad AlumnoMatriculado.
 */
public class AlumnoMatriculadoRepositorioCSV implements IAlumnoMatriculadoRepositorio {

    private static final String PATH = "src/main/resources/alumnos_matriculados.csv";
    private final File file;

    public AlumnoMatriculadoRepositorioCSV() {
        this(PATH);
    }

    public AlumnoMatriculadoRepositorioCSV(String path) {
        this.file = new File(path);
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new IllegalStateException("No se ha podido crear el fichero de alumnos matriculados", e);
        }
    }

    @Override
    public List<AlumnoMatriculado> obtenerAlumnosMatriculados() {
        // TODO implementar lectura real desde CSV
        return new ArrayList<>();
    }

    @Override
    public boolean guardarAlumnosMatriculados(List<AlumnoMatriculado> alumnosMatriculados) {
        // TODO implementar escritura real en CSV
        return true;
    }
}
