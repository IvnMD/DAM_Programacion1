package org.docencia.ejercicio.calificable;
/**
 * @author IvnMD
 * @since 07/11/25
 * @version 07/11/25
 * @brief Busca una palabra en una frase y encuentra el tamaño
 */
public class Ejercicio4 {
    /**
     * Funcion que busca una palabra en una frase y devuelve el tamaño de la misma si existe
     * @param frase Cadena de entrada
     * @param palabra Subcadena que debemos encontrar
     * @return Contador del total de caracteres de la letra.
     */
    public static int tamPalabraEnFrase(String frase, String palabra) {
        if (frase == null || frase.isEmpty() || palabra == null || palabra.isEmpty()){
            return 0;
        }
        int contador = 0;
        frase = frase.trim().toLowerCase();
        String []busqueda = frase.split(" ");
        for (int i = 0; i< frase.length(); i++){
            for (int j = 0; j < palabra.length(); j++){
                if (frase.charAt(i) == palabra.charAt(i))
                contador++;
                }
            }
           return contador; 
    
    }

}
