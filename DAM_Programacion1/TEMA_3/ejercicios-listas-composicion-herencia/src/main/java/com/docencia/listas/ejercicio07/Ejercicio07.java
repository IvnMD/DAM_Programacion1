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
        // for (int i = 1; i < lista.size(); i++) {
        //     int valorActual = lista.get(i);
        //     int j = i - 1;
        //     while (j >= 0 && lista.get(j) > valorActual) { //!con un WHILE
        //         lista.set(j + 1, lista.get(j));
        //         j--;
        //         }
        //     lista.set(j + 1, valorActual);
        // }

        for (int i = 0; i < lista.size(); i++) 
            for (int j = 0; j < lista.size() - i -1; j++) { //!Joatham Mode
                if (lista.get(j+1) < lista.get(j)){
                    int auxiliar = lista.get(j+1);
                    lista.set(j+1, lista.get(j));
                    lista.set(j,auxiliar);
                }   
            }            
        }
}


