/**
 * @author IvnMD
 * @date 23/01/26
 * @version 1.0.0
 * @brief Clase abstracta juego
 */
package com.docencia.examen.herencia;

import java.util.Objects;


/**
 * Clase abstracta juego
 */
public abstract class Juego {

    protected String id;
    protected String titulo;
    protected double complemento; // porcentaje (0..100)

    /**
     * Constructor vacio/por defecto
     */
    protected Juego() {}
    /**
     * Constructor por identificador unico
     * @param Id unico del juego
     */
    protected Juego(String Id) {
        setId(id);
    }
    /**
     * Constructor parametrico
     * @param id del juego
     * @param titulo del juego
     * @param complemento porcentaje de incremento de precio segun tipo de juego
     */
    protected Juego(String id, String titulo, double complemento) {
        setId(id);
        setTitulo(titulo);
        setComplemento(complemento);
    }
    /**
     * setters y getters
     * 
     */
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getComplemento() { return complemento; }

    public abstract String tipoJuego();

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public void setTitulo(String titulo) {
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException();
        }
        this.titulo = titulo;
    }

    public void setComplemento(double complemento) {
        if(complemento < 0 || complemento > 100){
            throw new IllegalArgumentException();
        }
        this.complemento = complemento;
    }
    /**
     * HashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object obj) {
      if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Juego)){
            return false;
        }
        Juego other = (Juego) obj;
        return Objects.equals(id, other.id);
    }
    /**
     * Metodo ToString
     */
    @Override
    public String toString() {
        return "Juego [id=" + id + ", titulo=" + titulo + ", complemento=" + complemento + "]";
    }

    
    

    

    
}
