package com.docencia.logica;

import java.util.Stack;

public class Ejercicio28 {
  /**
   * Cuenta soluciones N-Reinas
   * Implementar usando lógica tradicional (iterativo).
   * 
   * Cuenta el número de soluciones válidas para el problema de las N-Reinas
   * usando backtracking iterativo con pila explícita (DFS simulado).
   * 
   * @param n Tamaño del tablero y número de reinas a colocar.
   * @return Número de soluciones válidas.
   * @throws IllegalArgumentException Si es menor o igual a 0.
   */
  public static int contarSolucionesNReinas(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    int contador = 0;
    Stack<int[]> pila = new Stack<>();
    for (int col = 0; col < n; col++) {
      int[] estado = new int[n];
      java.util.Arrays.fill(estado, -1);
      estado[0] = col;
      pila.push(estado);
    }

    while (!pila.isEmpty()) {
      int[] cols = pila.pop();

      int fila = 0;
      while (fila < n - 1 && cols[fila + 1] != -1)
        fila++;

      if (fila == n - 1 && cols[fila] != -1) {
        contador++;
        continue;
      }

      int siguienteFila = fila + 1;
      for (int col = 0; col < n; col++) {
        if (esSeguro(cols, siguienteFila, col)) {
          int[] nuevoEstado = cols.clone();
          nuevoEstado[siguienteFila] = col;
          pila.push(nuevoEstado);
        }
      }
    }

    return contador;
  }

  /**
   * Verifica si colocar una reina en (fila, col) es seguro
   * revisando conflictos con todas las reinas ya colocadas.
   *
   * @param cols Array con columnas ocupadas por fila.
   * @param fila Fila donde se quiere colocar la nueva reina.
   * @param col  Columna candidata.
   * @return true si la posición es segura, false si no.
   */
  private static boolean esSeguro(int[] cols, int fila, int col) {
    for (int f = 0; f < fila; f++) {
      int c = cols[f];
      if (c == col || Math.abs(c - col) == Math.abs(f - fila)) {
        return false;
      }
    }
    return true;
  }
}

/**
 * 
 * Línea 23 - 1er FOR:
 * 
 * for (int col = 0; col < n; col++)
 *
 * Inicializa el algoritmo colocando la primera reina en la fila 0.
 * Se prueban todas las columnas posibles (0 hasta n-1).
 * Cada iteración representa un posible punto de partida distinto.
 *
 * Dentro de este FOR:
 *
 * - Se crea un array "estado" de tamaño n.
 *   Cada índice representa una fila.
 *   El valor almacenado es la columna donde está la reina.
 *
 * - Se inicializa todo el array con -1.
 *   El -1 significa "no hay reina en esta fila todavía".
 *
 * - estado[0] = col;
 *   Se coloca la reina en la fila 0, columna actual.
 *
 * - pila.push(estado);
 *   Se guarda este estado inicial en la pila.
 *   Al terminar este bucle, la pila contiene n estados distintos,
 *   uno por cada posible columna inicial.
 *
 *
 * Línea 33 - 2º WHILE:
 * 
 * while (fila < n - 1 && cols[fila + 1] != -1)
 *
 * Objetivo: determinar en qué fila estamos trabajando.
 *
 * Se busca la última fila que ya tiene una reina colocada.
 * Avanza mientras:
 *   - No haya llegado a la última fila.
 *   - La siguiente fila tenga una reina (valor distinto de -1).
 *
 * Al terminar, "fila" representa la última fila ocupada.
 *
 *
 * Línea 37 - 1er IF:
 * 
 * if (fila == n - 1 && cols[fila] != -1)
 *
 * Comprueba si ya hemos colocado reinas en todas las filas.
 *
 * Si estamos en la última fila (n-1) y tiene reina:
 *   → Hemos encontrado una solución completa válida.
 *   → Se incrementa el contador.
 *   → Se hace continue para no seguir expandiendo este estado.
 *
 *
 * Línea 42 - 2º FOR:
 * 
 * for (int col = 0; col < n; col++)
 *
 * Intenta colocar una nueva reina en la siguiente fila.
 *
 * - Se calcula siguienteFila = fila + 1.
 * - Se prueban todas las columnas posibles en esa fila.
 *
 * Para cada columna:
 *
 *   if (esSeguro(cols, siguienteFila, col))
 *
 *   Se verifica que:
 *     - No haya otra reina en la misma columna.
 *     - No haya conflicto en diagonales.
 *
 *   Si es seguro:
 *     - Se clona el estado actual (para no modificar el original).
 *     - Se coloca la nueva reina.
 *     - Se añade el nuevo estado a la pila.
 *
 * Esto genera nuevas ramas del árbol de búsqueda.
 *
 *
 * Método esSeguro:
 * Recorre todas las filas anteriores (0 hasta fila-1)
 * y verifica:
 *
 *   1) Misma columna:
 *        c == col
 *
 *   2) Misma diagonal:
 *        Math.abs(c - col) == Math.abs(f - fila)
 *
 * Si ocurre alguna de estas condiciones → devuelve false.
 * Si ninguna ocurre → devuelve true.
 *
 *
 * FUNCIONAMIENTO GENERAL:
 * 
 * - Se inicializan todas las posiciones posibles en fila 0.
 * - Se usa una pila para simular la recursividad (DFS iterativo).
 * - Cada estado representa un tablero parcial.
 * - Si se completa hasta la última fila → se cuenta solución.
 * - Si no, se generan nuevos estados válidos.
 * - El proceso termina cuando la pila queda vacía.
 *
 * Es un backtracking iterativo que simula la versión recursiva
 * usando una pila explícita.
 *
 */