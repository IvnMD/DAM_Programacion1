package com.docente.servicio;

import java.util.ArrayList;
import java.util.List;

import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;
import com.docente.persistencia.impl.AsignaturaRepositorioCSV;
import com.docente.validacion.Validaciones;

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
        return asignaturasStr;
    }

    public boolean updateLista() {
        asignaturaRepositorio.guardarAsignaturas(asignaturas);
        return true;
    }

    @Override
    public boolean crearAsignatura(String codigo, String nombre, int horasSemanales) {
        if (!Validaciones.esCodigoAsignaturaValido(codigo)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esHorasSemanalesValidas(horasSemanales)) {
            return false;
        }

        Asignatura asignaturaNuevo = new Asignatura(codigo, nombre, horasSemanales);
        if (asignaturas.contains(asignaturaNuevo)) {
            return false;
        }
        asignaturas.add(asignaturaNuevo);
        return updateLista();
    }

    @Override
    public boolean actualizarAsignatura(String codigo, String nombre, int horasSemanales) {
        if (!Validaciones.esCodigoAsignaturaValido(codigo)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esHorasSemanalesValidas(horasSemanales)) {
            return false;
        }

        Asignatura asignaturaNuevo = new Asignatura(codigo, nombre, horasSemanales);
        if (!asignaturas.contains(asignaturaNuevo)) {
            return false;
        }
        int posicion = asignaturas.indexOf(asignaturaNuevo);
        asignaturas.set(posicion, asignaturaNuevo);
        return updateLista();
    }

    @Override
    public boolean deleteAsignatura(String codigo) {
        if (!Validaciones.esCodigoAsignaturaValido(codigo)) {
            return false;
        }

        Asignatura asignaturaNuevo = new Asignatura(codigo);
        if (!asignaturas.contains(asignaturaNuevo)) {
            return false;
        }
        int posicion = asignaturas.indexOf(asignaturaNuevo);
        asignaturas.remove(posicion);
        return updateLista();
    }

    @Override
    public Asignatura buscarAsignatura(String codigo) {
       if (!Validaciones.esCodigoAsignaturaValido(codigo)) {
            return null;
        }
        Asignatura asignaturaBusqueda = new Asignatura(codigo);
        if (!asignaturas.contains(asignaturaBusqueda)) {
            return null;
        }
        int indice = asignaturas.indexOf(asignaturaBusqueda);
        return asignaturas.get(indice);
    }
}
