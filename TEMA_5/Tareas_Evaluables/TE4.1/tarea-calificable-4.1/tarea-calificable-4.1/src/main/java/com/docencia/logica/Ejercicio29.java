package com.docencia.logica;

import java.util.Stack;

public class Ejercicio29 {
  /**
   * ¿Existe camino en laberinto?
   * Implementar usando lógica tradicional (iterativo).
   * 
   * Determina si existe un camino entre dos puntos en un laberinto.
   * Utiliza una búsqueda en profundidad (DFS) de forma iterativa con una pila.
   * @param laberinto Matriz donde 0 es pasillo y 1 es pared.
   * @param fi Fila inicial.
   * @param ci Columna inicial.
   * @param ff Fila final (objetivo).
   * @param cf Columna final (objetivo).
   * @return true si existe un camino, false en caso contrario.
   * @throws IllegalArgumentException si el laberinto es nulo o vacío.
   */
  public static boolean existeCaminoLaberinto(int[][] laberinto, int fi, int ci, int ff, int cf) {
    if (laberinto == null || laberinto.length == 0){
      throw new IllegalArgumentException();
    }

    boolean[][] visitado = new boolean[laberinto.length][laberinto[0].length]; //! [filas][columnas]
    Stack<int[]> pila = new Stack<>();

    pila.push(new int[]{fi,ci}); //! Posicion de salida
    visitado[fi][ci] = true;

    int[][] direcciones = {{1,0}, {-1,0}, {0,1}, {0,-1}}; //! {abajo, arriba, derecha, izquierda}

    while(!pila.isEmpty()){

      int[] actual = pila.pop();
      int fila = actual[0];
      int columna = actual[1];

      if (fila == ff && columna == cf){
        return true;
      }

      for (int[] direccion : direcciones) {
        int proxFila = fila + direccion[0];
        int proxColumna = columna + direccion[1];

        if (proxFila>=0 && proxFila < laberinto.length && proxColumna>=0 && proxColumna < laberinto[0].length &&
          laberinto[proxFila][proxColumna] == 0 && !visitado[proxFila][proxColumna]){
        
        visitado[proxFila][proxColumna] = true;
        pila.push(new int[]{proxFila, proxColumna});
        }
      }
    }
  return false;
  }
}
