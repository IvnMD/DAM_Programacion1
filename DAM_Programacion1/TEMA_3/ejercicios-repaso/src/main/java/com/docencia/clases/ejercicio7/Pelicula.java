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
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("codigo=").append(codigo);
        sb.append(", titulo=").append(titulo);
        sb.append(", duracionMin=").append(duracionMin);
        sb.append('}');
        return sb.toString();
    }


}
