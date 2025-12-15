package com.docencia.listas.ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * EJERCICIO 3 (ESQUELETO) - Intersección ordenada.
 */
public class Ejercicio3 {

    private Ejercicio3() {
    }

    public static List<Integer> interseccionOrdenada(List<Integer> a, List<Integer> b) {

        if(a ==null || a.isEmpty() || b==null || b.isEmpty()){
            return new ArrayList<>();
        }

        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : a) {
            if(b.contains(numero) && !resultado.contains(numero)){
                resultado.add(numero);
            }
        }
        
        return resultado;
    }
}
