package unidad3;

/**
 * @author IvnMD
 * @date 20/11/25
 * @version 1.0.0
 * @brief
 * 
Clase: Ejercicio05
Métodos principales:

    tablaMultiplicar(int n)
    Devuelve un array de tamaño 10 con la tabla de multiplicar de n del 1 al 10:
        resultado[0] = n * 1
        ...
        resultado[9] = n * 10

    sumaTabla(int n)
    Devuelve la suma de todos los valores de la tabla de n de 1 a 10:
    n*1 + n*2 + ... + n*10.

 */
public class Ejercicio05 {
    /**
     * Tabla de multiplicar del numero n
     * @param n Número del cual se quiere la tabla de multiplicar
     * @return Arreglo con la tabla de multiplicar del número n
     */
    public static int[] tablaMultiplicar(int n) {
        int[] tabla = new int[10];
        for (int i = 0; i < 10; i++) {
            tabla[i] = n * (i + 1);
        }
        return tabla;
    }

    /**
     * Suma de la tabla de multiplicar del numero n
     * @param n Número del cual se quiere la suma de la tabla de multiplicar
     * @return Suma de la tabla de multiplicar del número n
     */
    public static int sumaTabla(int n) {
        int suma = 0;
        for (int i = 1; i <= 10; i++) {
            suma += n * i;
        }
        return suma;
    }
}
