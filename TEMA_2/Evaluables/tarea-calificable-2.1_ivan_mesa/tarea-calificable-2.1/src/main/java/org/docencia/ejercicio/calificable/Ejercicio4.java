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
        // int contador = 0;
        // frase = frase.trim().toLowerCase();
        // String []busqueda = frase.split(" ");
        // for (int i = 0; i< frase.length(); i++){
        //     for (int j = 0; j < palabra.length(); j++){                                    //!Respuesta examen
        //         if (frase.charAt(i) == palabra.charAt(i))
        //         contador++;
        //         }
        //     }


        // Usar expresiones regulares para separar las palabras de la frase        //! RESPUESTA IA
        String[] palabrasEnFrase = frase.toLowerCase().split("[^a-zA-Z0-9]+");
        
        // Convertir la palabra a minúsculas para la comparación
        palabra = palabra.toLowerCase();
        
        // Comprobar si la palabra aparece en la frase
        for (String palabraFrase : palabrasEnFrase) {
            if (palabraFrase.equals(palabra)) {
                return palabra.length(); // Devolver el tamaño de la palabra
            }
        }

        return 0; // No se encontró la palabra
    }
}

