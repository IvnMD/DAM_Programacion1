package com.docencia.clases.ejerciciosClases.Programa6;
import java.util.Objects;

/**
 *
 * @author IvnMD
 * @version 1.0
 * @author Docencia de Programación
 * @since 24/10/25
 * @bugs Ninguno conocido
 * @see https://github.com/jpexposito/code-learn-practice/tree/main/primero/pro/unidades/unidad-2/tarea-2
 * @brief Clase Alumno para el ejercicio 6
 */
public class Alumno {

    private String dni;
    private String nombre;
    /**
     * Constructor vacio por defecto de la clase
     */
    private Alumno(){};
    /**
     * Constructor parametrizado de la clase
     * @param dni DNI del alumno
     * @param nombre Nombre del alumno
     */
    Alumno(String dni, String nombre)
    {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Redefinición del método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "{" +
            " dni='" + getDni() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

    // Redefinición del método equals para comparar dos objetos de tipo Alumno
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(dni, alumno.dni) && Objects.equals(nombre, alumno.nombre);
    }



}
