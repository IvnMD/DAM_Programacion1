package com.docente.servicio;

import com.docente.modelo.Alumno;
import com.docente.modelo.AlumnoMatriculado;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAlumnoMatriculadoRepositorio;
import com.docente.persistencia.impl.AlumnoMatriculadoRepositorioCSV;
import com.docente.validacion.Validaciones;

import java.util.ArrayList;
import java.util.List;


public class AlumnoMatriculadoService implements IAlumnoMatriculadoService {

    private final IAlumnoMatriculadoRepositorio alumnoRepositorio;
    private final IAsignaturaService asignaturaService;
    private final List<AlumnoMatriculado> alumnosMatriculados;

    public AlumnoMatriculadoService() {
        this(new AlumnoMatriculadoRepositorioCSV(), new AsignaturaService());
    }

    public AlumnoMatriculadoService(IAlumnoMatriculadoRepositorio alumnoRepositorio, IAsignaturaService asignaturaService) {
        this.alumnoRepositorio = alumnoRepositorio;
        this.asignaturaService = asignaturaService;
        this.alumnosMatriculados = new ArrayList<>(alumnoRepositorio.obtenerAlumnosMatriculados());
    }

    @Override
    public List<String> read() {
        List<String> matriculadosStr = new ArrayList<>();
        for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
            matriculadosStr.add(alumnoMatriculado.toString());
        }
        return matriculadosStr ;
    }

    public boolean updateLista() {
        alumnoRepositorio.guardarAlumnosMatriculados(alumnosMatriculados);
        return true;
    }

    @Override
    public boolean crearAlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        if (!Validaciones.esIdentificadorValido(identificador)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esEdadValida(edad)
                || !Validaciones.esCursoValido(curso)
                || !Validaciones.esCodigoAsignaturaValido(curso)) {
            return false;
        }

        AlumnoMatriculado matriculaNueva = new AlumnoMatriculado(identificador, nombre, edad, curso);
        if (!alumnosMatriculados.contains(matriculaNueva)) {
            return false;
        }
        int posicion = alumnosMatriculados.indexOf(matriculaNueva);
        alumnosMatriculados.set(posicion, matriculaNueva);
        return updateLista();
    }

    @Override
    public boolean actualizarAlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        if (!Validaciones.esIdentificadorValido(identificador)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esEdadValida(edad)
                || !Validaciones.esCursoValido(curso)) {
            return false;
        }

        AlumnoMatriculado nuevaMatricula = new AlumnoMatriculado(identificador, nombre, edad, curso);
        if (!alumnosMatriculados.contains(nuevaMatricula)) {
            return false;
        }
        int posicion = alumnosMatriculados.indexOf(nuevaMatricula);
        alumnosMatriculados.set(posicion, nuevaMatricula);
        return updateLista();
    }

    @Override
    public boolean deleteAlumnoMatriculado(String identificador) { 
        if (!Validaciones.esIdentificadorValido(identificador)) {
            return false;
        }

        AlumnoMatriculado nuevaMatricula = new AlumnoMatriculado(identificador);
        if (!alumnosMatriculados.contains(nuevaMatricula)) {
            return false;
        }
        int posicion = alumnosMatriculados.indexOf(nuevaMatricula);
        alumnosMatriculados.remove(posicion);
        return updateLista();
    }

    @Override
    public AlumnoMatriculado buscarAlumnoMatriculado(String identificador) {
        if (!Validaciones.esIdentificadorValido(identificador)) {
            return null;
        }
        AlumnoMatriculado matriculaBusqueda = new AlumnoMatriculado(identificador);
        if (!alumnosMatriculados.contains(matriculaBusqueda)) {
            return null;
        }
        int indice = alumnosMatriculados.indexOf(matriculaBusqueda);
        return alumnosMatriculados.get(indice);
    }
    

    @Override
    public boolean matricularAsignatura(String identificadorAlumno, String codigoAsignatura) {
        AlumnoMatriculado nuevaMatricula = new AlumnoMatriculado (identificadorAlumno);
        // buscarAlumnoMatriculado(nuevaMatricula);
        

        return false;
    }

    @Override
    public boolean desmatricularAsignatura(String identificadorAlumno, String codigoAsignatura) {
        // TODO implementar
        return false;
    }

    @Override
    public int getNumeroAsignaturas(String identificadorAlumno) {
        int contador = 0;
        for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
            contador++;
        }
        return contador;
    }

    @Override
    public boolean estaMatriculadoEn(String identificadorAlumno, String codigoAsignatura) {
        Alumno alumnoBuscar = new Alumno(identificadorAlumno);
        if (alumnosMatriculados.contains(alumnoBuscar) ){
            return true;
        }
        return false;
    }
}
