package com.docencia.listas.ejercicio07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio07 {

    private Ejercicio07() {
    }

    public static void ordenarConSort(List<Integer> lista) {
        Collections.sort(lista);
    }

    public static void ordenarSinSort(List<Integer> lista) {
        
        List<Integer> resultado = new ArrayList<>();
        

        for (int i = 1; i < lista.size(); i++) {
            
            if (Collections.min(lista) < lista.get(i)){
                resultado.set(i, lista);

            }
            
        }
    }
}
