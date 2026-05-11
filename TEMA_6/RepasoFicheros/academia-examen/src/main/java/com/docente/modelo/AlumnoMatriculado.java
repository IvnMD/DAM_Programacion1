package com.docente.modelo;

import java.util.ArrayList;
import java.util.List;

public class AlumnoMatriculado extends Alumno {

    private List<Asignatura> asignaturas;

    public AlumnoMatriculado(String identificador) {
        super(identificador);
        this.asignaturas = new ArrayList<>();
    }

    public AlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        super(identificador, nombre, edad, curso);
        this.asignaturas = new ArrayList<>();
    }

    public AlumnoMatriculado(String identificador, String nombre, int edad, String curso,
            List<Asignatura> asignaturas) {
        super(identificador, nombre, edad, curso);
        // TODO implementar correctamente
        this.asignaturas = asignaturas == null ? new ArrayList<>() : new ArrayList<>(asignaturas);
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public boolean addAsignatura(Asignatura asignatura) {
        // TODO implementar evitando duplicados
        if (asignatura == null || asignaturas.contains(asignatura)) {
            return false;
        }
        asignaturas.add(asignatura);
        return true;
    }

    public boolean removeAsignatura(String codigoAsignatura) {
        if (codigoAsignatura != null) {
            return false;
        }
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(codigoAsignatura)) {
                asignaturas.remove(asignatura);
                return true;
            }
        }
        return false;
    }

    public int getNumeroAsignaturas() {
        return getAsignaturas().size();
    }

    public boolean estaMatriculadoEn(String codigoAsignatura) {
        if (codigoAsignatura != null) {
            return false;
        }
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(codigoAsignatura)) {
                return true;
            }
        }
        return false;
    }

    public String toCsv() {
        // TODO implementar correctamente
        StringBuilder codigos = new StringBuilder();
        for (int i = 0; i < asignaturas.size(); i++) {
            codigos.append(asignaturas.get(i).getCodigo());
            if (i < asignaturas.size() - 1) {
                codigos.append(',');
            }
        }
        return getIdentificador() + "|" + getNombre() + "|" + getEdad() + "|" + getCurso() + "|" + codigos;
    }

    @Override
    public String toString() {
        // TODO adaptar salida
        return "AlumnoMatriculado [identificador=" + getIdentificador()
                + ", nombre=" + getNombre()
                + ", edad=" + getEdad()
                + ", curso=" + getCurso()
                + ", numeroAsignaturas=" + getNumeroAsignaturas()
                + ", asignaturas=" + asignaturas + "]";
    }
}
