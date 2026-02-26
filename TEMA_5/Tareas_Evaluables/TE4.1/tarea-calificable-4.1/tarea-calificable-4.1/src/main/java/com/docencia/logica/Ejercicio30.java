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
        if (arreglo == null || arreglo.length == 0) {
            throw new IllegalArgumentException();
        }

        if (objetivo == 0) return true;
        if (objetivo < 0) return false;



        boolean[] sumaPosible = new boolean[objetivo + 1];
        
        sumaPosible[0] = true;

        for (int numeroActual : arreglo) {
            //! Recorremos el arreglo de atrás hacia adelante para no reutilizar el mismo 'numeroActual' en una misma iteración.
            for (int i = objetivo; i >= numeroActual; i--) {
                
                //! Si la suma (i - numeroActual) ya era posible antes,entonces ahora también es posible formar 'i' sumándole el número actual.
                if (sumaPosible[i - numeroActual]) {
                    sumaPosible[i] = true;
                }
            }
            
            //! Si en cualquier punto ya logramos marcar el objetivo como posible, no necesitamos seguir procesando el resto del arreglo.
            if (sumaPosible[objetivo]) {
                return true;
            }
        }

        return sumaPosible[objetivo];
    }
}
