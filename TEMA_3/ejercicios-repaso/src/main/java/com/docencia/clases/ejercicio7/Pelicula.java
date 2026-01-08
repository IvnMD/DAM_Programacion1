package com.docencia.clases.ejercicio7;

import java.util.Objects;

public class Pelicula {
    private String codigo;
    private String titulo;
    private int duracionMin;
    /**
     * Constructor vacio/por defecto
     */
    public Pelicula() {
        this.duracionMin = 90;
    }

    public Pelicula(String codigo) {
        setCodigo(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("");
        }
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    @Override
    public boolean equals(Object o) {
        // TODO: implementar equals comparando SOLO el identificador único (codigo)
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        // TODO: implementar hashCode consistente con equals (usar SOLO el identificador único)
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO: implementar toString legible incluyendo al menos el identificador único
        return super.toString();
    }
}
