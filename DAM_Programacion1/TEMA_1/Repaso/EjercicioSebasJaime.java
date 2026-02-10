// package TEMA_1.Repaso;

import java.util.Arrays;

public class EjercicioSebasJaime {
    /**
     * Imprime los numeros pares de un array
     * @param args
     * @return array con los numeros pares
     */

     public static void main(String[] args) {
        int [] array = {2,3,6,4,7};
        int [] auxiliar = new int [array.length];
        int contador = 0;
    
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                auxiliar[contador] = array[i];
                contador++;
            }
        }
        int[] solucion = new int [contador];
        for (int j = 0; j < contador; j++){
            if (auxiliar[j] != 0){
                solucion[j] = auxiliar[j];
            }
        }
        System.out.println("Solucion: " + Arrays.toString(solucion));
     }
}
