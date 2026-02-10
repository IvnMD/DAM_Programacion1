/**
 * @author IvnMD
 * @date 10/12/25
 * @version 1.0.0
 */

package com.docencia.examen.composicion;

import java.util.ArrayList;
import java.util.List;

import com.docencia.examen.herencia.Directivo;
import com.docencia.examen.herencia.Empleado;
import java.util.Objects;

/**
 * Clase Empresa
 */
public class Empresa {

    private String cif;
    private String nombre;
    private Directivo directorGeneral;
    private List<Empleado> empleados;
    
    /**
     * Constructor vacio/por defecto
     */
    public Empresa(){};


    /**
     * Constructor por identificador unico
     * @param cif
     */
    public Empresa(String cif){
        this.cif = cif;
    }

    public Empresa(String cif, String nombre, Directivo directorGeneral) {
        this.cif = cif;
        this.nombre = nombre;
        this.directorGeneral = directorGeneral;
        empleados = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public Directivo getDirectorGeneral() {
        return directorGeneral;
    }

    public Empresa(String cif, String nombre, Directivo directorGeneral, List<Empleado> empleados) {
        this.cif = cif;
        this.nombre = nombre;
        this.directorGeneral = directorGeneral;
        this.empleados = empleados;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDirectorGeneral(Directivo directorGeneral) {
        this.directorGeneral = directorGeneral;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }


        //TODO: agrega un empleado a la lista
    public void agregarEmpleado(Empleado e) {
        if( e == null){
            return;
        }
        empleados.add(e);
    }

    //TODO: devuelve el numero de empleados en la lista
    public int getNumeroEmpleados() {
        int contador = 0;
        for (Empleado empleado : empleados) {
            contador++;
        }
        return contador;
    }

    //TODO: busca un empleado por su identificador y lo devuelve (o null si no lo encuentra)
    public Empleado buscarPorIdentificador(String id) {
        if(id == null || id.isEmpty()){
            return null;
        }
        for (Empleado empleado : empleados) {
            if (empleado.equals(id) )
        }
        return null;
    }

    //TODO: elimina un empleado por su identificador, devuelve true si lo ha eliminado,
    public boolean eliminarPorIdentificador(String id) {
        
       return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empresa)) {
            return false;
        }
        Empresa empresa = (Empresa) o;
        return Objects.equals(cif, empresa.cif) && Objects.equals(nombre, empresa.nombre) && Objects.equals(directorGeneral, empresa.directorGeneral) && Objects.equals(empleados, empresa.empleados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cif, nombre, directorGeneral, empleados);
    }
    

    @Override
    public String toString() {
        return "{" +
            " cif='" + getCif() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", directorGeneral='" + getDirectorGeneral() + "'" +
            ", empleados='" + getEmpleados() + "'" +
            "}";
    }


    
}
