package com.docencia.examen.herencia;

import com.docencia.examen.clases.Usuario;
import java.util.Objects;

//TODO: Completar clase Empleado con las funciones necesarias, y documenta la clase.
public class Empleado extends Usuario {

    String departamento;
    double salario;
    /**
     * Constructor vacio o por defecto
     */
    public Empleado() {

    }
    /**
     * Constructor por identificador unico
     * @param identificador
     */
    public Empleado(String identificador) {
        super(identificador);
      
    }
    /**
     * Constructor parametrico
     * @param identificador identificador unico
     * @param nombre nombre del usuario
     * @param apellidos apellidos del usuario
     * @param departamento departamente donde trabaja el empleado
     * @param salario salario del empleado
     */
    public Empleado(String identificador, String nombre, String apellidos,
                    String departamento, double salario) {
        super(identificador, nombre, apellidos);
        this.departamento = departamento;
        this.salario = salario;

    }
    /**
     * Getters y setters
     */
    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "identificador='" + getIdentificador() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salario=" + salario +
                '}';
    }



    public Empleado(String departamento, double salario) {
        this.departamento = departamento;
        this.salario = salario;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

}


