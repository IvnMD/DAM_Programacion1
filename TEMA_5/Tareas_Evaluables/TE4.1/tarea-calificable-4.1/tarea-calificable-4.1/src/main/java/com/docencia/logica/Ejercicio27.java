package com.docencia.logica;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio27 {
  /**
   * Genera subconjuntos
   * Implementar usando lógica tradicional (iterativo).
   */
    public static List<List<Integer>> generarSubconjuntos(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> resultado = new ArrayList<>();
        resultado.add(new ArrayList<>());

        for (int num : arreglo) {
            int size = resultado.size();
            for (int i = 0; i < size; i++) {
                List<Integer> nuevoSubconjunto = new ArrayList<>(resultado.get(i)); 
                nuevoSubconjunto.add(num); 
                resultado.add(nuevoSubconjunto);
            }
        }

        return resultado;
    }
}
/**
 * Supongamos que el arreglo es [1, 2]:
 * 
 *     Inicio: resultado = [ [] ]
 * 
 *     Procesando el 1:
 *         - Copiamos [] → le sumamos 1 → obtenemos [1]
 *         - resultado = [ [], [1] ]
 *     Procesando el 2:
 *         - Copiamos [] → le sumamos 2 → obtenemos [2]
 *         - Copiamos [1] → le sumamos 2 → obtenemos [1, 2]
 *         - resultado = [ [], [1], [2], [1, 2] ]
 */
