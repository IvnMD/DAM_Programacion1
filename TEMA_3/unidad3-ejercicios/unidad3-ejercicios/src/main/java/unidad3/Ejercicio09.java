package unidad3;

/**
 * @author IvnMD
 * @date 21/11/25
 * @version 1.0
 * @bugs Ninguno
 * @see Ninguno
 * @brief 
Clase: Ejercicio09
Método principal: calcularEstadisticas(int[] numeros)
Clase auxiliar interna: Estadisticas

Dado un array de números enteros (sin incluir el centinela), calcula:

    Cantidad de números introducidos.
    Media aritmética.
    Máximo.
    Mínimo.

Devuelve un objeto Estadisticas con esos valores.
Si el array está vacío, lanza IllegalArgumentException.
 */
public class Ejercicio09 {

    /**
     * Clase auxiliar para almacenar las estadísticas calculadas.
     */
    public static class Estadisticas {
        private final int cantidad;
        private final double media;
        private final int maximo;
        private final int minimo;

        /**
         * Constructor vacio de la clase Estadisticas.
          */
        public Estadisticas() {};



        /**
         * Constructor de la clase Estadisticas.
         * @param cantidad numeros introducidos
         * @param media media aritmetica
         * @param maximo numero mas alto
         * @param minimo numero mas bajo
         */
        public Estadisticas(int cantidad, double media, int maximo, int minimo) {
            this.cantidad = cantidad;
            this.media = media;
            this.maximo = maximo;
            this.minimo = minimo;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getMedia() {
            return media;
        }

        public int getMaximo() {
            return maximo;
        }

        public int getMinimo() {
            return minimo;
        }
    }

    public static Estadisticas calcularEstadisticas(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException();
        }
        int suma = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE; 
        for (int num : numeros) {
            suma += num;
            if (num > maximo) {
                maximo = num;
            }
            if (num < minimo) {
                minimo = num;
            }
        }
        double media = (double) suma / numeros.length;
        return new Estadisticas(numeros.length, media, maximo, minimo);
    }
}
