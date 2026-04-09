package com.ejemplo.centro.repository;

import com.ejemplo.centro.model.CentroData;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import com.ejemplo.centro.util.XmlManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CentroXmlRepositoryImpl implements CentroXmlRepository {
    private final Path xmlPath;
    private final XmlManager xmlManager;
    List <Modulo> modulos;
    List<Profesor> profesores;

    public CentroXmlRepositoryImpl(Path xmlPath) {
        this(xmlPath, new XmlManager());
    }

    public CentroXmlRepositoryImpl(Path xmlPath, XmlManager xmlManager) {
        this.xmlPath = xmlPath;
        this.xmlManager = xmlManager;
    }

    public CentroXmlRepositoryImpl(Path xmlPath, XmlManager xmlManager, List<Profesor> profesores){
        this.xmlPath = xmlPath;
        this.xmlManager = xmlManager;
        this.profesores = profesores;

    }

    @Override
    public List<Profesor> findAllProfesores() {
        return profesores;
        
    }

    @Override
    public List<Modulo> findAllModulos() {
        return modulos;
    }

    @Override
    public Profesor findProfesorById(String id) {
        Profesor profesorBuscar = new Profesor(id);
        int posicion = profesores.indexOf(profesorBuscar);
        if (posicion < 0) {
            return null;
        }
        return profesores.get(posicion);
    }

    @Override
    public Modulo findModuloById(String id) {
        Modulo moduloBuscar = new Modulo(id);
        int posicion = modulos.indexOf(moduloBuscar);
        if (posicion < 0){
            return null;
        }
        return modulos.get(posicion);
    }


    
}
