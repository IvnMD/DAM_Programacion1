package com.docencia.ejercicio.clases.dos;

import java.util.Objects;

/**
 * Clase libro
 * @author Ivan Mesa Dominguez
 * @since 24/10/25
 * @version 1.0
 * @brief Declaracion de la clase libro
 */

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    /**
     * Constructor vacio
    */
    public Libro() {};

    /**
     * Constructor parametrico
     * @param titulo Titulo del libro
     * @param autor Autor del libro
     * @param isbn Identificador unico del libro
     */
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }
    /**
     * Getters y Setters de los atributos
     * 
     */
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        this.isbn = isbn;

    }

    /**
     * Metodo toString() para poder imprimir el contenido de las clases y no su direccion de memoria. 
     */
    @Override
    public String toString() {
        return "\"" +
            getTitulo() + "\"" +
            " de " + getAutor() + 
            "(ISBN: " + getIsbn() +
            ")";
    }
    /**
     * Metodo equals para comparar entre instancias de la clase
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(isbn.toLowerCase(), libro.isbn.toLowerCase());
    }
    /**
     * Metodo hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn.toLowerCase());
    }


}

