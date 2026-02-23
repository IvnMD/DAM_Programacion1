package com.docencia.recursividad;

public class Ejercicio29 {
  /**
   * ¿Existe camino en laberinto?
   */
  public static boolean existeCaminoLaberinto(int[][] laberinto, int fi, int ci, int ff, int cf) {
    if (laberinto == null || laberinto.length == 0) {
      return false;
    }
    boolean[][] visitado = new boolean[laberinto.length][laberinto[0].length];
    return resolver(laberinto, fi, ci, ff, cf, visitado);
  }

  private static boolean resolver(int[][] laberinto, int r, int c, int ff, int cf, boolean[][] visitado) {
    if (r < 0 || r >= laberinto.length || c < 0 || c >= laberinto[0].length) {
      return false;
    }

    if (laberinto[r][c] == 1 || visitado[r][c]) {
      return false;
    }

    if (r == ff && c == cf) {
      return true;
    }

    visitado[r][c] = true;

    return resolver(laberinto, r + 1, c, ff, cf, visitado) || resolver(laberinto, r - 1, c, ff, cf, visitado) ||
        resolver(laberinto, r, c + 1, ff, cf, visitado) || resolver(laberinto, r, c - 1, ff, cf, visitado);
  }
}
