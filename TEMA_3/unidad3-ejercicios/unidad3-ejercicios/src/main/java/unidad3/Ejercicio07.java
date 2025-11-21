package unidad3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IvnMD
 * @date 20/11/25
 * @version 1.0.0
 * @brief
 * 
Clase: Ejercicio07
Método principal: calcularParesImpares(int a, int b)
Clase auxiliar interna: ParesImpares

Dado un rango entre a y b (ambos inclusive):

    Si a > b, intercambia los valores.
    Recorre el intervalo y separa los números en dos listas:
        Lista de números pares.
        Lista de números impares.

Devuelve un objeto ParesImpares con ambas listas.
 */
public class Ejercicio07 {
    /**
     * Clase auxiliar para almacenar listas de pares e impares
     */
    public static class ParesImpares {
        private final List<Integer> pares;
        private final List<Integer> impares;

        /**
         * Constructor vacío: inicializa listas vacías
         */
        public ParesImpares() {
            this.pares = new ArrayList<>();
            this.impares = new ArrayList<>();
        }


        /**
         * Constructor parametrico
         * @param pares numeros pares
         * @param impares numeros impares
         */
        public ParesImpares(List<Integer> pares, List<Integer> impares) {
            this.pares = pares;
            this.impares = impares;
        }

        public List<Integer> getPares() {
            return pares;
        }

        public List<Integer> getImpares() {
            return impares;
        }
    }


    public static ParesImpares calcularParesImpares(int a, int b) {
        if (a > b) {
            // Intercambiar valores
            int temp = a;
            a = b;
            b = temp;
        }
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                pares.add(i);
            } else {
                impares.add(i);
            }
        }
        return new ParesImpares(pares, impares);
    }
}
