package org.docencia.ejercicio.calificable;
/**
 * @author IvnMD
 * @since 07/11/25
 * @version 1.0.0
 * @brief Calcula el área de un triangulo usando la formula de Heron
 */

 /**
  * Clase que ejecuta la formula de Heron para calcular el areea de un triangulo
  */
public class Ejercicio3 {
    

    public Ejercicio3() {}

    /**
     * Funcion que calcula el area de un triangulo
     * @param a Lado A
     * @param b Lado B
     * @param c Lado C
     * @return Area del triangulo 
     */
    public static double areaHeron(double a, double b, double c) {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0 || a+b<=c || a+c<=b || b+c<=a){
            return -1.0;
        }
        double s = (a + b + c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

  
    
}
