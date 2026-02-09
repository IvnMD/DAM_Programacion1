package formacion.dam;

    /**
     * @author Ivan Mesa
     * @date 17/10/2025
     * @version 1.0
     * @bugs No hay bugs conocidos
     * @brief Clase para invertir un array de enteros in place.
     * 
     * 
     *  Invierte el array dado modificando el mismo array.
     * 
     * @param datos el arreglo de enteros a invertir
     */

public final class InvertirInPlace {
    private InvertirInPlace() {}
    public static int[] invertir(int[] datos) {
        for (int i = 0; i < datos.length /2; i++){
            int aux = datos[datos.length-1-i];
            datos[datos.length-1-i] = datos [i];
            datos[i] = aux;
        }
        return datos;
    }
}
