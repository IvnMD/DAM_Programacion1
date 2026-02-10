package formacion.dam;

    /**
     * @author Ivan Mesa
     * @date 17/10/2025
     * @version 1.0
     * @bugs No hay bugs conocidos
     * @brief Clase para calcular el máximo y la primera posición de un array de enteros.
     * 
     * 
     *  Calcula el valor máximo y la primera posición en la que aparece en el array dado.
     * 
     * @param datos el arreglo de enteros a analizar
     */

public final class MaximoYPrimeraPosicion {
    
    private MaximoYPrimeraPosicion() {}
    public static int[] calcular(int[] datos) {
        
        int maximo = datos[0];
        int indice = 0;

        for (int i = 1; i < datos.length; i++){

            if (maximo < datos[i]){
               maximo = datos[i];
               indice = i;
            }        
        }
        int[] resultado = {maximo,indice};

        return resultado;
    }
}
