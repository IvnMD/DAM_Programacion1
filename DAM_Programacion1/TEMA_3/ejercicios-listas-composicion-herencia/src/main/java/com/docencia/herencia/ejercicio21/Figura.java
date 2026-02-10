package com.docencia.herencia.ejercicio21;

public class Figura {
    private long base;
    private long altura;
    // private double radio;

    public Figura(){

    }

    public Figura (long base, long altura){
        this.base = base; 
        this.altura = altura;
    }
    /**
     * Funcion que calcula el area de la figura
     * @return double con el valor obtenido
     */
    public double area(){
        return base * altura;
    }

}
