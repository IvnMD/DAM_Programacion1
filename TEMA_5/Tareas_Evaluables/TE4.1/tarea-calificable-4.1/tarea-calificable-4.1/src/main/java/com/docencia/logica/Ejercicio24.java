package com.docencia.logica;

public class Ejercicio24 {
  /**
   * Encuentra pico en mountain array
   * Implementar usando lógica tradicional (iterativo).
   */
  public static int encontrarPico(int[] arregloMontana) {
    if (arregloMontana == null || arregloMontana.length == 0){
      throw new IllegalArgumentException();
    }
    int bajo = 0;
    int alto = arregloMontana.length-1;
    while (bajo < alto) {
      int medio = (bajo + alto) / 2; //! medio=bajo+(alto−bajo)/2 evita desbordamientos
      if(arregloMontana[medio] < arregloMontana[medio +1]){
        bajo = medio +1;
      } else {
        alto = medio;
      }
    }
    return bajo;
  }
}
/**
 * 1. Si arreglo[medio] < arreglo[medio + 1], estás en la subida, por lo que el pico 
 *    tiene que estar a la derecha (bajo = medio + 1).
 * 
 * 2. Si no, estás en la bajada (o en el mismo pico), por lo que el pico está a la 
 *    izquierda o es el elemento actual (alto = medio).
 */