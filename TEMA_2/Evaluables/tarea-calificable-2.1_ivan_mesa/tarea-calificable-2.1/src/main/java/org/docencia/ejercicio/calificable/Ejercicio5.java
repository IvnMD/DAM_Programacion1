package org.docencia.ejercicio.calificable;
/**
 * @author IvnMD
 * @since 07/11/25
 * @version 1.0.0
 * @brief En este ejercicio que deben definirse las utilidades basadas en el Teorema de Pitagoras
 */
public class Ejercicio5 {

    private Ejercicio5() {}
    /**
     * Funcion que calcula la hipotenusa segun el Teorema pitagoras
     * @param a Cateto a
     * @param b Cateto B
     * @return Hipotenusa 
     */
    public static double hipotenusa(double a, double b) {
        if (a <= 0 || b <= 0){
            return -1;
        }
        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        return c;
    }
    /**
     * Funcion que calcula un cateto a partir de el otro cateto y la hipotenusa
     * @param c Hipotenusa
     * @param otroCateto Cateto contrario (cateto b)
     * @return Cateto a
     */
    public static double catetoDesdeHipotenusa(double c, double otroCateto) {
        if (c <= otroCateto || otroCateto <= 0.0 ){
        return -1;
        }
        double a = Math.sqrt(Math.pow(c,2) - Math.pow(otroCateto,2));


        return a;
    }

}