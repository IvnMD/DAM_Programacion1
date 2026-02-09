package org.docencia.ejercicio.calificable;
/**
 * @author IvnMD
 * @since 07/11/25
 * @version 1.0.0
 * @brief Implementa un metodo que cuente la cantidad de vocales en una cadena de texto (contarVocales). 
 *        Las vocales pueden ser tanto mayúsculas como minúsculas (a, e, i, o, u).
 */
public class Ejercicio2 {
    /**
     * Funcion que cuenta las vocales de una cadena de texto.
     * @param frase Cadena de texto de entrada
     * @return Entero que representa el total de vocales
     */
    public static int contarVocales(String frase) {
        if (frase == null || frase.isEmpty()){
            return 0;
        }

        frase = frase.toLowerCase().trim();
        int contador = 0;
        for (int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i'  || frase.charAt(i) == 'o' || frase.charAt(i) == 'u'){
                contador++;
            }
        }
        
        return contador;
    }
}
