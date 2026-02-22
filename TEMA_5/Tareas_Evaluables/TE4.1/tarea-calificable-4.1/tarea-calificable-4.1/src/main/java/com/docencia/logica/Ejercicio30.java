package com.docencia.logica;

public class Ejercicio30 {
  /**
   * Subset sum (existe subconjunto)
   * Implementar usando lógica tradicional (iterativo).
   * 
   * 
   * Determina si algún subconjunto de los elementos en el arreglo suma exactamente el objetivo.
   * @param arreglo Conjunto de números disponibles.
   * @param objetivo El valor de suma buscado.
   * @return true si existe dicha suma, false en caso contrario.
   * @throws IllegalArgumentException si el arreglo es nulo.
  */
  public static boolean existeSubconjuntoSuma(int[] arreglo, int objetivo) {
        if (arreglo == null) {
            throw new IllegalArgumentException();
        }
        
        if (objetivo == 0) return true;
        if (objetivo < 0) return false;

        boolean[] sumaPosible = new boolean[objetivo + 1];
        sumaPosible[0] = true;

        for (int numeroActual : arreglo) {
            for (int sumaActual = objetivo; sumaActual >= numeroActual; sumaActual--) {
                if (sumaPosible[sumaActual - numeroActual]) {
                    sumaPosible[sumaActual] = true;
                }
            }
            
            if (sumaPosible[objetivo]) {
                return true;
            }
        }

        return sumaPosible[objetivo];
    }
}
