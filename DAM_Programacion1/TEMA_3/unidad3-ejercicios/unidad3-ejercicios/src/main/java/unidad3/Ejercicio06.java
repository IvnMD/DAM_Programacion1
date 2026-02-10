package unidad3;

/**
 * @author IvnMD
 * @date 20/11/25
 * @version 1.0.0
 * @brief
 * 
 * Clase: Ejercicio06
 * Método principal: factorial(int n)
 * 
 * Calcula el factorial de un número entero no negativo n.
 * Devuelve el resultado como un valor long.
 * 
 * Si n es negativo, lanza IllegalArgumentException.
 */
public class Ejercicio06 {
    /**
     * Factorial de un numero n
     * @param n Número del cual se quiere calcular el factorial
     * @return Factorial de n
     */
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
        
    }
}
