package com.docencia.composicion.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca extends Libro{

    private List<Libro> biblioteca;

    public Biblioteca(){
        biblioteca = new ArrayList<>();
    };

    public Biblioteca(List<Libro> biblioteca){
        this.biblioteca = biblioteca;

    }



}
