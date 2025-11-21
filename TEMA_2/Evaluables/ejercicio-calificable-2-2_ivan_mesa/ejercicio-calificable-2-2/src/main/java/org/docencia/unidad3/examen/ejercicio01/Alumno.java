package org.docencia.unidad3.examen.ejercicio01;

import java.util.Objects;
/**
 * @author IvnMD
 * @date 21/11/25
 * @version 1.0.0
 * @bugs Sin bugs conocidos
 * @see https://www3.gobiernodecanarias.org/medusa/eforma/campus/mod/assign/view.php?id=9079296
 * @brief Clase Alumno que modela un estudeiante con nombre y nota.
 */
public class Alumno {

    private String nombre;
    private int nota;
    /**
     * Constructor vacio/por defecto
     */
    public Alumno() {
    }
    /**
     * Constructor parametrico
     * @param nombre nombre del alumno
     * @param nota nota del alumno
     */
    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
        if (nota < 0 || nota > 10){
        throw new IllegalArgumentException();
        }
    }
    /**
     * Setters y getters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        if (nota < 0 || nota > 10){
            throw new IllegalArgumentException();
        }
        return nota;
    }


    public void setNota(int nota) {
            if (nota < 0 || nota > 10){
            throw new IllegalArgumentException();
        }
        this.nota = nota;
    }

    public String getCalificacionTexto() {

        if (nota < 5 ){
            return "Insuficiente";
        }
        if (nota == 5 ){
            return "Suficiente";
        }
        if (nota == 6) {
            return "Bien";
        }
        if (nota < 9) {
            return "Notable";
        }
        return "Sobresaliente";
    }

    public boolean comprobradorNota(){
        if (nota < 0 || nota > 10){
            throw new IllegalArgumentException();
        }
        return true;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        return Objects.equals(nombre, other.nombre) && nota == other.nota;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", nota=" + nota + ", getCalificacionTexto()=" + getCalificacionTexto()
                + "]";
    }
    

}
