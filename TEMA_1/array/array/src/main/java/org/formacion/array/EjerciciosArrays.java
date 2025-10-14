package org.formacion.array;

import java.util.*;

public class EjerciciosArrays {

    /**
     * Dado un array, devuelve un nuevo array con los elementos en orden inverso.
     * @param array de elementos
     * @return array ordenado
     */
    public static int[] invertir(int[] array) {
        int tamanio = array.length;
        int [] invertido = new int[tamanio];

        for (int i = 0; i < tamanio; i++){
            invertido [i]= array [tamanio-i-1];
        }
        
        return invertido;
    }

    /**
     * Cuenta cuantos pares completos hay de cada color.
     * @param array de colores de los
     * @return
     */
    public static int  paresCalcetines(String[] colores, String color) {
        
        int pareja= 0;
        for (int i = 0; i < colores.length; i++) {
            if (colores[i].equals(color)){
                pareja++;
            }

        }
            
        return pareja/2;
    }


    // /**
    //  * Quita duplicados manteniendo el primer ejemplar.
    //  * @param playlist
    //  * @return playlist sin duplicados
    //  */
    // public static String[] sinRepetidos(String[] playlist) {
    //     int tamanyo = playlist.length;
    //     String[] nueva = new String[tamanyo];
    //     for (int i = 0; i < tamanyo; i++){
    //         String cancion = playList[i];
    //         for (int j = 0; j < nueva.length; j++){
    //             if (cancion != null && cancion.equals(nueva[j])){
    //                 play[j] = cancion;
    //             }
    //             if(play[j] != cancion) {
    //                 play[j] = cancion;
    //             }
    //         }                             //! SIN RESOLVER
    //     }
    //     return nueva;
    // }


    /**
     * Rota un array k posiciones a la derecha.
     * @param array
     * @param k posiciones que debe de rotar
     * @return
     */
    public static int[] rotar(int[] array, int k) {
        int tamanio = array.length;
        int[] rotar = new int [tamanio];

        // if (k > tamanio){
        //     int tamanio //! PROBAR A HACER UN FOR QUE IETERE EL NUMERO DE VECES QUE SUPERA K A LENGTH CON UN CONTADOR
        // }

        for (int posicion = 0; posicion < tamanio; posicion++){
            int indice = posicion +k;
            if (indice >= tamanio){
                rotar[indice-k] = array [indice-tamanio];
            } else {
                rotar[posicion] = array[indice];
            }

        }
        return rotar;
    }

    /**
     * Devuelve un subarray desde índice i hasta j.
     * @param array
     * @param i posicion inicial
     * @param j posicion final
     * @return sub array
     */
    public static int[] rebanada(int[] array, int i, int j) {
        if (i <0 ){
            return null;
        }
        if (j >= array.length) {
            return null;
        }
        if (i >= j){
            return null;
        }
        int tamanyo = j-i;
        int[] resultado = new int[tamanyo];
        for (int k=0; k<tamanyo; k++){
            resultado[k] = array[k+i];
        }

        return resultado;
    }

    /**
     * Suma solo los numeros pares del array.
     * @param array de numeros
     * @return suma de los numeros pares
     */
    public static int sumaPares(int[] array) {
        int suma = 0;

        for (int i = 0; i < array.length; i++){
            if (array[i] % 2  == 0){
                suma += array[i];
            }
        }
        return suma;
    }

    /**
     * Intercambia el primer y último elemento.
     * @param array de numeros de entrada
     * @return
     */
    public static int[] swapExtremos(int[] array) {
        int auxiliar = 0;

        auxiliar = array[array.length -1];
        array [array.length-1] = array [0];
        array[0] = auxiliar;

        return array;
    }

    /**
     * Devuelve los elementos comunes entre dos arrays.
     * @param primerArray
     * @param segundoArray
     * @return array con valores comunes
     */
    public static int[] interseccion(int[] primerArray, int[] segundoArray) {
        int tamanyo = primerArray.length;
        int[] tercerArray = new int [tamanyo];
        int tamanyoFuturo = 0;
 
        for (int i = 0; i < primerArray.length; i++){
            for (int j = 0; j < segundoArray.length; j++){ //!conseguimos la interseccion
                if (primerArray[i] == segundoArray[j]){
                    tamanyoFuturo ++;
                    tercerArray[j] = primerArray[i];

                }  
            }
        }
        int [] cuartoArray = new int [tamanyoFuturo]; //! conseguir que solo imprima la interseccion sin 0's
        for (int k = 0; k < cuartoArray.length; k++){
            cuartoArray[k] = tercerArray[k];
        }
        return cuartoArray;
    }
    /**
     * Elementos que están en un array u otro, pero no en ambos.
     * @param arrayA
     * @param arrayB
     * @return array con la diferencia simetrica
     */
    public static int[] difSim(int[] arrayA, int[] arrayB) {
        int tamanyo1 = arrayA.length;
        int tamanyo2 = arrayB.length;
        int[] tercerArray = new int [tamanyo2];
        if (tamanyo1 > tamanyo2) {
        int[] tercerArray = new int [tamanyo1];
        }
        int tamanyoFuturo = 0;
 
        for (int i = 0; i < arrayA.length; i++){
            tercerArray[i] = arrayA[i];
            System.out.println("debug 1 - "+tercerArray[i] +"-" + tamanyoFuturo);
            for (int j = 0; j < arrayB.length; j++){ //!conseguimos la interseccion
                if (arrayA[i] != arrayB[j]){
                    tamanyoFuturo ++;
                    tercerArray[j] = arrayB [j];
                    System.out.println("debug 2 - "+tercerArray[j]+"-" +  tamanyoFuturo);
                }
            }
        }
           
        //     for (int j = 0; j < arrayB.length; j++){ //!conseguimos la interseccion
        //         if (arrayB[i] != tercerArray[j]){
        //             tamanyoFuturo ++;
        //             tercerArray[i] = arrayA[i];

        //         }  
        //     }
        // }
        // int [] cuartoArray = new int [tamanyoFuturo]; //! conseguir que solo imprima la interseccion sin 0's
        // for (int k = 0; k < cuartoArray.length; k++){
        //     cuartoArray[k] = tercerArray[k];
        // }
        return tercerArray;
    }


    /**
     * Comprueba si un array es palindromo.
     * @param array de entrada
     * @return true/false si es palindrome
     */
    public static boolean esPalindromo(int[] array) {
        return false;
    }

    /**
     * Busca el indice de un valor.
     * @param array de entrada 
     * @param objetivo del indice
     * @return posicion en la que se encuentra
     */
    public static int buscar(int[] array, int objetivo) {
        return -1;
    }

    /**
     * Elimina elementos en las posiciones dadas.
     * @param array de entrada
     * @param indices con las posiciones a liminar
     * @return array sin las posiciones dadas
     */
    public static int[] eliminarPorIndices(int[] array, int[] indices) {
        return null;
    }

    /**
     * Convierte una matriz en un array 1D.
     * @param matriz de entrada
     * @return array con la matriz aplanada
     */
    public static int[] aplanar2D(int[][] matriz) {
        return null;
    }

public static void main(String[] args) {

        System.out.println("Invertir: " + Arrays.toString(EjerciciosArrays.invertir(new int[]{1,2,3,4})));

        System.out.println("Pares de calcetines: " + EjerciciosArrays.paresCalcetines(new String[]{"rojo","azul","rojo","rojo","azul"}, "rojo"));

        // System.out.println("Playlist sin repetidos: " + Arrays.toString(EjerciciosArrays.sinRepetidos(new String[]{"A","B","A","C","B"})));

        System.out.println("Rotación del carrusel: " + Arrays.toString(EjerciciosArrays.rotar(new int[]{1,2,3,4,5}, 2)));

        System.out.println("Rotación del carrusel: " + Arrays.toString(EjerciciosArrays.rebanada(new int[]{0,1,2,3,4}, 1, 4)));

        System.out.println("Suma de pares: " + EjerciciosArrays.sumaPares(new int[]{1,2,3,4,5,6}));

        System.out.println("Congelar extremos: " + Arrays.toString(EjerciciosArrays.swapExtremos(new int[]{10,20,30,40})));

        System.out.println(" Intersección: " + Arrays.toString(EjerciciosArrays.interseccion(new int[]{1,2,3,4}, new int[]{3,4,5})));
 
        System.out.println("Diferencia simétrica: " + Arrays.toString(EjerciciosArrays.difSim(new int[]{1,2,3}, new int[]{3,4,5})));

        System.out.println("Palíndromo: " + EjerciciosArrays.esPalindromo(new int[]{1,2,3,2,1}));

        System.out.println("Índice del tesoro: " + EjerciciosArrays.buscar(new int[]{10,20,30}, 20));

        System.out.println("Eliminación por índices: " + Arrays.toString(EjerciciosArrays.eliminarPorIndices(new int[]{1,2,3,4}, new int[]{1,3})));

    
        System.out.println("Aplanar Matriz: " + Arrays.toString(EjerciciosArrays.aplanar2D(new int[][]{{1,2},{3},{4,5}})));
    }
}
