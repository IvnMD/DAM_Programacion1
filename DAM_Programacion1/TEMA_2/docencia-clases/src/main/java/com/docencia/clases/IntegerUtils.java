package com.docencia.clases;
/**
 * @author IvnMD
 * @version 1.0.0
 * @date 31/10/25
 * @brief Clase que realiza la transformacion de valores enteros
 * @bugs Sin bugs conocidos
 */
public final class IntegerUtils {
    private IntegerUtils() {}
    /**
     * Funcion que transforma un valor de base 10 en binario
     * @param x valor d eentrada
     * @return String con el valor binario
     */
    public static String bin(int x) {
        
        return Integer.toBinaryString(x);
    }

    /**
     * 
     * @param x
     * @return
     */
    public static int popcount(int x) {
         return 0;
        }

        /**
         * Compara dos parametros de entrada y los compara sin signo
         * @param a Valor de entrada 1
         * @param b Valor de entrada 2
         * @return Devuelve un entero negativo si el primer número es menor, cero si son iguales, y un entero positivo si el primer número es mayor, basándose en su representación sin signo
         */
    public static int comparaSinSigno(int a, int b) { 
        
        return Integer.compareUnsigned(a,b);
        
    }

    public static void main(String[] args) {

        String resultado = bin(21);
        System.out.println("Valor binario obtenido: " + resultado);
        int resultado2 = comparaSinSigno(3,-2);
        System.out.println("Son iguales al ignorar el signo? = " + resultado2);

    }
}
