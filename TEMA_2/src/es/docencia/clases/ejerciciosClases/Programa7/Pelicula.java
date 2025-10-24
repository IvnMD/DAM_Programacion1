package es.docencia.clases.ejerciciosClases.Programa7;

import java.util.Objects;

/** 
 * @author IvnMD
 * @since 24/10/25
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Clase pelicula del ejercicio 7
*/
public class Pelicula {

    private String titulo;
    private int anyo;

    /**
     * Constructor por defecto
     */
    public Pelicula(){};
    /**
     * Contructor por parametros 
     * @param titulo Titulo de la pelicula
     * @param anyo Año de la pelicula
     */
    public Pelicula(String titulo, int anyo){
        this.titulo = titulo;
        this.anyo = anyo;
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return this.anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "{" +
            " titulo='" + getTitulo() + "'" +
            ", anyo='" + getAnyo() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pelicula)) {
            return false;
        }
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(titulo, pelicula.titulo) && anyo == pelicula.anyo;
    }




}
