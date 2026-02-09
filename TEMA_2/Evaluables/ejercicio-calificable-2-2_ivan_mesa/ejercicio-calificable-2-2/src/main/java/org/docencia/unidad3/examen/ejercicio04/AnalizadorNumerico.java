/**
 * @author IvnMD
 * @date 21/11/25
 * @version 1.0.0
 * @bugs Sin bugs conocidos
 * @see https://www3.gobiernodecanarias.org/medusa/eforma/campus/mod/assign/view.php?id=9079296
 * @brief 
 */
package org.docencia.unidad3.examen.ejercicio04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AnalizadorNumerico {
    /**
     * Funcion que cuenta positivos, negativos y ceros
     * @param numeros Array 
     * @return 
     */
    public ContadorSignos contarSignos(int[] numeros) {
        if (numeros == null || numeros.length == 0){
            throw new IllegalArgumentException();
        }
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] > 0){
                positivos++;
            }
            if (numeros[i] < 0){
                negativos++;
            }
            if (numeros[i] == 0){
                ceros++;
            }
        }
        ContadorSignos resultado = new ContadorSignos(positivos, negativos, ceros);
        resultado.getNegativos();
        resultado.getPositivos();
        resultado.getCeros();
        return resultado;
    }

    
    public ParesImpares calcularParesImpares(int a, int b) {
        if (a > b) {
            int temporal = 0;
            temporal = a;
            a = b;
            b = temporal;
        }
        for (int i = a; i < b; i++){
            if (i%2 == 0){
                getPares.add(i);
            }
        }
        
    
        return null;
    }

    
    public int contarPrimos(int a, int b) {
    
        return 0;
    }

    public static class ContadorSignos {
        private final int positivos;
        private final int negativos;
        private final int ceros;
        /**
         * Constructor parametrico
         * @param positivos cantidad de numeros positios
         * @param negativos cantidad de numeros negativos
         * @param ceros contidad de ceros
         */
        public ContadorSignos(int positivos, int negativos, int ceros) {
            this.positivos = positivos;
            this.negativos = negativos;
            this.ceros = ceros;
        }

        public int getPositivos() {
            return positivos;
        }

        public int getNegativos() {
            return negativos;
        }

        public int getCeros() {
            return ceros;
        }



        

        
    }

    
    public static class ParesImpares {
        private final List<Integer> pares;
        private final List<Integer> impares; // add para sumer y remove para borrar 

        public ParesImpares(List<Integer> pares, List<Integer> impares) {
            this.pares = new ArrayList<>(pares);
            this.impares = new ArrayList<>(impares);
    
        }

        public List<Integer> getPares() {
            return pares;
        }

        public List<Integer> getImpares() {
            return impares;
        }

        

        
    }
}
