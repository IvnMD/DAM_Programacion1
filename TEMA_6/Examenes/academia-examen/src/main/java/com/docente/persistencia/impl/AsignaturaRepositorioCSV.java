package com.docente.persistencia.impl;

import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;
import com.docente.ficheros.FicheroAbstract;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO alumnado:
 * Implementa la lectura y escritura en CSV de la entidad Asignatura.
 */
public class AsignaturaRepositorioCSV extends FicheroAbstract implements IAsignaturaRepositorio {

    private static final String path = "src/main/resources/asignaturas.csv";
    private  File file;

    public AsignaturaRepositorioCSV() {
        super(path);
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
