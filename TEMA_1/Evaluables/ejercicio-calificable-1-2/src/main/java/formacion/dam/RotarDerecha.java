package formacion.dam;

    /**
     * @author Ivan Mesa
     * @date 17/10/2025
     * @version 1.0
     * @bugs No hay bugs conocidos
     * @brief Clase para rotar un array de enteros hacia la derecha.
     * 
     * 
     *  Rota el array dado hacia la derecha por k posiciones.
     * 
     * @param datos el arreglo de enteros a rotar
     * @param k el número de posiciones a rotar
     */

public final class RotarDerecha {
    private RotarDerecha() {}
    public static int[] rotar(int[] datos, int k) {
        int n = datos.length;
        int[] resultado = new int[n];
        
        k = k % n;

        for (int i = 0; i < n; i++) {
            int nuevoIndice = (i + k) % n;
            resultado[nuevoIndice] = datos[i];
        }

        return resultado;
    }
}
