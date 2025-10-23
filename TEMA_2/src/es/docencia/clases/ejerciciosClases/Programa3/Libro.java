package es.docencia.clases.ejerciciosClases.Programa3;

import java.util.Objects;
/**
 * @author IvnMD
 * @date 24/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Clase Libro: Clase que representa un libro con ISBN y título.
 * 
 */

public class Libro {
    
    private String isbn;
    private String titulo;

    /**
     * Constructor por defecto
     */
    public Libro(){};

    /**
     * Constructor con parametros
     * @param isbn identificador del libro
     * @param titulo título del libro
     */
    public Libro(String isbn, String titulo){
        this.isbn = isbn;
        this.titulo = titulo;   
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public String toString() {
        return "{" +
            " isbn='" + getIsbn() + "'" +
            ", titulo='" + getTitulo() + "'" +
            "}";
    }


}
