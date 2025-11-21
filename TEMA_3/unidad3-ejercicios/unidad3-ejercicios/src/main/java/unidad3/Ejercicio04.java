package unidad3;
/**
 * @author IvnMD
 * @date 20/11/25
 * @version 1.0.0
 * @brief
 * 
 * Clase: Ejercicio04
 * Método principal: contarSignos(int[] numeros)
 * 
 * Cuenta la cantidad de números positivos, negativos y ceros en un arreglo de enteros.
 * Devuelve un objeto ContadorSignos con los conteos correspondientes.
 * 
 * Si el arreglo es nulo o vacío, devuelve un objeto ContadorSignos con todos los conteos en 0.
 */
public class Ejercicio04 {

    public static class ContadorSignos {

        private final int positivos;
        private final int negativos;
        private final int ceros;

        public ContadorSignos(int positivos, int negativos, int ceros) {
            this.positivos = positivos;
            this.negativos = negativos;
            this.ceros = ceros;
        }

        public int getPositivos() {
            if (positivos < 0) {
                return 0;
            }
            return positivos;
        }

        public int getNegativos() {
            if (negativos < 0) {
                return 0;
            }
            return negativos;
        }

        public int getCeros() {
            if (ceros < 0) {
                return 0;
            }
            return ceros;
        }
    }

    public static ContadorSignos contarSignos(int[] numeros) {
        int contadorPositivos = 0;
        int contadorNegativos = 0;
        int contadorCeros = 0;
        if (numeros == null || numeros.length == 0) {
            return new ContadorSignos(0, 0, 0);
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 0) {
                contadorNegativos++;
            } else if (numeros[i] > 0) {
                contadorPositivos++;
            } else if (numeros[i] == 0) {
                contadorCeros++;
            }
        }
        return new ContadorSignos(contadorPositivos, contadorNegativos, contadorCeros);
    }
}
