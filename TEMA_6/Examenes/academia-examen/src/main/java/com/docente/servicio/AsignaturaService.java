package com.docente.servicio;

import com.docente.modelo.Alumno;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;
import com.docente.persistencia.impl.AsignaturaRepositorioCSV;
import com.docente.validacion.Validaciones;

import java.util.ArrayList;
import java.util.List;


public class AsignaturaService implements IAsignaturaService {

    private final IAsignaturaRepositorio asignaturaRepositorio;
    private final List<Asignatura> asignaturas;

    public AsignaturaService() {
        this(new AsignaturaRepositorioCSV());
    }

    public AsignaturaService(IAsignaturaRepositorio asignaturaRepositorio) {
        this.asignaturaRepositorio = asignaturaRepositorio;
        this.asignaturas = new ArrayList<>(asignaturaRepositorio.obtenerAsignaturas());
    }

    @Override
    public List<String> read() {
        List<String> asignaturasStr = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            asignaturasStr.add(asignatura.toString());
        }
        return asignaturasStr ;
    }

    public boolean updateLista() {
        asignaturaRepositorio.guardarAsignaturas(asignaturas);
        return true;
    }

    @Override
    public boolean crearAsignatura(String codigo, String nombre, int horasSemanales) {
       if(!Validaciones.esCodigoAsignaturaValido(codigo)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esHorasSemanalesValidas(horasSemanales)) {
            return false;
            }
        Asignatura asignaturaNueva = new Asignatura(codigo, nombre, horasSemanales);
            if (asignaturas.contains(asignaturaNueva)) {
            return false;
        }
        asignaturas.add(asignaturaNueva);
        return updateLista();
    }

    @Override
    public boolean actualizarAsignatura(String codigo, String nombre, int horasSemanales) {
       if(!Validaciones.esCodigoAsignaturaValido(codigo)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esHorasSemanalesValidas(horasSemanales)) {
            return false;
            }
        Asignatura asignaturaNueva = new Asignatura(codigo, nombre, horasSemanales);
        if (!asignaturas.contains(asignaturaNueva)) {
            return false;
        }
        int posicion = asignaturas.indexOf(asignaturaNueva);
        asignaturas.set(posicion, asignaturaNueva);
        return updateLista();
    }

    @Override
    public boolean deleteAsignatura(String codigo) {
        if (!Validaciones.esCodigoAsignaturaValido(codigo)) {
            return false;
        }

        Asignatura asignaturaNueva = new Asignatura(codigo);
        if (!asignaturas.contains(asignaturaNueva)) {
            return false;
        }
        int posicion = asignaturas.indexOf(asignaturaNueva);
        asignaturas.remove(posicion);
        return updateLista();
    }

    @Override
    public Asignatura buscarAsignatura(String codigo) {
        if (!Validaciones.esCodigoAsignaturaValido(codigo)) {
            return null;
        }

        Asignatura asignaturaNueva = new Asignatura(codigo);
        if (!asignaturas.contains(asignaturaNueva)) {
            return null;
        }
        int indice = asignaturas.indexOf(asignaturaNueva);
        return asignaturas.get(indice);
    }
}
