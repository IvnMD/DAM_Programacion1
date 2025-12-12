package com.docencia.listas.ejercicio2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * EJERCICIO 2 (ESQUELETO) - Invertir y filtrar cadenas.
 */
public class Ejercicio2 {

    private Ejercicio2() {
    }

    /**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static List<String> invertirYFiltrarNoVacias(List<String> cadenas) {

        if (cadenas == null || cadenas.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> resultado = new ArrayList<>();
        for (String cadena : cadenas) {
            if (cadena != null && !cadena.isBlank()) {
                resultado.add(cadena);
            }
        }

        for (int i = 0; i < resultado.size(); i++) {
            String cadena = resultado.get(i);
        }

        List<String> resultadoFinal = new ArrayList<>();
        for (String cadena : resultado) {
            char[] cadenaArray = cadena.toCharArray();// transformo cadena en ArrayCadena
            for (int i = 0; i < cadenaArray.length / 2; i++) { // cada arrayCadea de cadenas lo recorro
                char temporal = cadenaArray[i]; // cojo el valor de i
                cadenaArray[i] = cadenaArray[cadenaArray.length - 1 - i]; // en la posicion de i pongo el valor final
                cadenaArray[cadenaArray.length - 1 - i] = temporal; // en la posicion final pongo la de i
            }
            resultadoFinal.add(String.valueOf(cadenaArray));
        }

        return resultadoFinal;
    }
}
