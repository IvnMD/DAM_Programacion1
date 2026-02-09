package com.docencia.programacion;
/**
 * @author IvnMD
 * @date 06/11/25
 * @version 1.0.0
 * @brief Trabajar con matrices (array 2D): sumar una fila y sumar una columna.
 */
public class Ejercicio27 {
    /**
     *  Funcion para sumar las filas de una matriz
     * @param matrix Tamaño de la matriz
     * @param rowIndex Indice de la fila a sumar
     * @return 
     */
    public static int sumRow(int[][] matrix, int rowIndex) {
        if (matrix == null || rowIndex < 0|| matrix.length < rowIndex){
            return 0;
        }
        int suma = matrix[rowIndex][0];
        for (int i = 1; i < matrix[rowIndex].length; i++) {
            suma += matrix[rowIndex][i];
        }
        return suma;
    }
    /**
     *  Funcion para sumar las columnas de una matriz
     * @param matrix Tamaño de la matriz 
     * @param colIndex Indice de la columna a sumar
     * @return
     */
    public static int sumColumn(int[][] matrix, int colIndex) {
        if (matrix == null || colIndex < 0|| matrix.length < colIndex){
            return 0;
        }
        int suma = matrix[0][colIndex];
        for (int j = 1; j < matrix.length; j++) {
            suma += matrix[j][colIndex];
        }
        return suma;
    }
}
