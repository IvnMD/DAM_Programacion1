package com.docencia.listas.ejercicio1;

import java.util.List;

/**
 * EJERCICIO 1 (ESQUELETO) - Contar mayores que un umbral.
 */
public class Ejercicio1 {

    private Ejercicio1() {
    }

    /**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static int contarMayoresQue(List<Integer> numeros, int umbral) {
        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }
        int resultado = 0;
        for (Integer numero : numeros) {
            if (numero != null && numero > umbral) {
                resultado++;
            }
        }
        return resultado;
    }
}
