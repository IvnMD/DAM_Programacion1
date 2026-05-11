package com.docente.persistencia.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.docente.ficheros.FicheroAbstract;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;

/**
 * TODO alumnado:
 * Implementa la lectura y escritura en CSV de la entidad Asignatura.
 */
public class AsignaturaRepositorioCSV extends FicheroAbstract implements IAsignaturaRepositorio {

    private static final String PATH = "src/main/resources/asignaturas.csv";
    private final File file;

    public AsignaturaRepositorioCSV() {
        this(PATH);
    }

    public AsignaturaRepositorioCSV(String path) {
        super(path);
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
            throw new IllegalStateException("No se ha podido crear el fichero de asignaturas", e);
        }
    }

    @Override
    public List<Asignatura> obtenerAsignaturas() {
        return readAsignatura();

    }

    

    @Override
    public boolean guardarAsignaturas(List<Asignatura> asignaturas) {
        updateFicheroAsignatura(asignaturas);
        return true;
    }
}
