package unidad3;
/**
 * @author IvnMD
 * @date 21/11/25
 * @version 1.0
 * @bugs Ninguno
 * @see Ninguno
 * @brief 
 * Clase: Ejercicio08
 * Método principal: esPrimo(int n)
 * 
 * Determina si un número entero n mayor que 1 es primo:
 * 
 *     Si n <= 1, lanza IllegalArgumentException.
 *     Comprueba divisores desde 2 hasta sqrt(n):
 *         Si encuentra un divisor, devuelve false.
 *         Si no encuentra ninguno, devuelve true.
 */
public class Ejercicio08 {
    /**
     * Determina si un número entero n mayor que 1 es primo.
     * @param n Número entero a evaluar.
     * @return true si n es primo, false en caso contrario.
     */
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("El número debe ser mayor que 1.");
        }
        for (int i = 2; i <= Math.sqrt(n); i++) { 
            if (n % i == 0) {
        return false;   
            }
            
        }
        return true;
    }
}
