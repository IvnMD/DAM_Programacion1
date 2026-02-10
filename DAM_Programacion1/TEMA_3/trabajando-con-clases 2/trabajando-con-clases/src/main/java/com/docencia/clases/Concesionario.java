package com.docencia.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.*;



public class Concesionario {

    final List<Coche> coches; //! FINAL sirve para instanciar un objeto una unica vez

    /**
     * 
     */
    public Concesionario(){
        coches = new ArrayList<>(); //! Instanciar SIEMPRE
    }

    public boolean addCoche(Coche coche){
        if (coche == null || coche.getMatricula() == null || coche.getMatricula().isEmpty()){
            return false;
        }
        if (coches.contains(coche)){
            return true;
        }
        coches.add(coche);
        return true;

    }

    public boolean deleteCoche(Coche coche) {
        if (coche ==null) {
            return false;
        }
        return coches.remove(coche);
    }

    public boolean deleteCoches(List<Coche> cochesABorrar) {
        if (cochesABorrar ==null) {
            return false;
        }
        return coches.removeAll(cochesABorrar);
    }

    public List<Coche> cochesOrdenadosPorMatricula(){    //! PREGUNTA DE EXAMEN
        coches.sort(Comparator.comparing((Coche c) -> c.getMatricula(), Comparator.reverseOrder()));

        return coches;
    }

    public List<Coche> cochesOrdenadosPorModelo(){
        coches.sort(Comparator.comparing((Coche c) -> c.getModelo(), Comparator.reverseOrder()));

        return coches;
    }

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        Coche coche1 = new Coche("1111 ABC");
        Coche coche2 = new Coche("0222 DEF");
        Coche coche3 = new Coche("3333 GHI");
        Coche coche4 = new Coche( "1312 ACB");
        concesionario.addCoche(coche1);
        concesionario.addCoche(coche2);
        concesionario.addCoche(coche3);
        concesionario.addCoche(coche4);
        List<Coche> cochesBorrar = new ArrayList<>();
        cochesBorrar.add(coche1);
        cochesBorrar.add(coche2);
        cochesBorrar.add(coche3);
        concesionario.deleteCoches(cochesBorrar);
        // Coche cocheBorrar = new Coche("0222 DEF");
        // concesionario.deleteCoche(cocheBorrar);
        // List<Coche> cochesOrdenadosPorMatricula = concesionario.cochesOrdenadosPorMatricula();
        System.out.println(concesionario.cochesOrdenadosPorMatricula());


    }

}
