package formacion.dam;

    /**
     * @author Ivan Mesa
     * @date 17/10/2025
     * @version 1.0
     * @bugs No hay bugs conocidos
     * @brief Clase para que almacena en un array los elementos mayores a la media de otro array.
     * 
     * 
     *  Almacena en un nuevo array los elementos mayores a la media del array dado. 
     * 
     * @param datos el arreglo de enteros a filtrar
     */

@SuppressWarnings("unused")
public final class ElementosSobreMedia {
    private ElementosSobreMedia() {}
    
    public static int[] filtrar(int[] datos) {
        int media = 0;
        int contador = 0;

        for (int i = 0; i < datos.length; i++) {
            media += datos[i];
        }
        int[] temporal = new int [datos.length];
        media /= datos.length;

        for (int j = 0; j < datos.length; j++) {
            if (datos[j] > media){
                temporal[contador++] = datos[j];
            }
        }
        int[] resultado = new int [contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = temporal[i];

        }
       
        return resultado;
    }
}

