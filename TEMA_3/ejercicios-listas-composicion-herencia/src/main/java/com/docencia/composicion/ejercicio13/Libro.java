package com.docencia.composicion.ejercicio13;
import java.util.Objects;

public class Libro {

    private String titulo;
    private String autor;
    private int anyo;

    public Libro(){

    };


    public Libro(String titulo, String autor, int anyo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyo() {
        return this.anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void agregaLibro(Libro libro){
        Libro libro = new Libro();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && anyo == libro.anyo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, anyo);
    }

    @Override
    public String toString() {
        return "{" +
            " titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", anyo='" + getAnyo() + "'" +
            "}";
    }
    
}
