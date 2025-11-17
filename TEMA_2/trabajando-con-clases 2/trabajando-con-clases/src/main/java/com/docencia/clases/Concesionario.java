package com.docencia.clases;

import java.util.ArrayList;
import java.util.List;



public class Concesionario {

    List<Coche> coches = null;

    /**
     * 
     */
    Concesionario(){
        coches = new ArrayList<>(); //?
    }

    public boolean addCoche(Coche coche){
        if (coche == null || coche.getMatricula() == null || coche.getMatricula().isEmpty()){
            return false;
        }
        if (coche.contains(coche){
            return true;
        }
        coches.add(coche);
        return true;

    }

}
