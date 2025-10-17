package formacion.dam;

/**
 * @author Ivan Mesa
 * @date 17/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Clase para calcular la suma y el conteo de números positivos en un array de enteros.
 *
 * Calcula la suma y el conteo de números positivos en el array dado.
 * 
 * @param datos el arreglo de enteros a analizar
 * 
 */

public final class SumaYConteoPositivos {
    public record Resultado(int suma, int conteo) {}
    private SumaYConteoPositivos() {}
    public static int[] calcular(int[] datos) {
        int suma = 0;
        int conteo = 0;
        int[] array = new int [datos.length];

        if (datos == null){
        return null;
        }

        for (int i = 0; i < array.length; i++){
            if (datos[i] > 0){
                suma += datos[i];
                conteo++;
            }

        }
        int [] resultado = {suma, conteo};
 
        return resultado;
    }
}
