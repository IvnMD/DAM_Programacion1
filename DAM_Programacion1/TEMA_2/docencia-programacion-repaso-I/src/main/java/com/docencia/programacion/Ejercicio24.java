package com.docencia.programacion;
/**
 * @author IvnMD
 * @version 1.0.0
 * @since 07/11/2025
 * @brief Ejercicio24 - Convierte una cadena conviertiendo la primera letra de cada palabra en mayúscula.
 */

public class Ejercicio24 {
    /**
     * Convierte la primera letra de cada palabra en mayúscula.
     * @param text Cadena de texto de entrada
     * @return Cadena de texto con la primera letra de cada palabra en mayúscula
     */
    public static String titleCase(String text) {  //! REVISATELO QUE HUELE A EXAMEN
        if (text == null || text.isEmpty()) {
            return "";
        }

        text = text.toLowerCase().trim();
        String[] palabras = text.split("\\s+"); // <-- divide por uno o más espacios
        String[] resultado = new String[palabras.length];

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            if (!palabra.isEmpty()) {
                char primeraLetra = palabra.charAt(0);
                String primeraLetraMayuscula = String.valueOf(primeraLetra).toUpperCase();
                String palabraMayuscula = primeraLetraMayuscula + palabra.substring(1);
                resultado[i] = palabraMayuscula;
            } else {
                resultado[i] = palabra;
            }
        }

        // Unir las palabras con un solo espacio
        return String.join(" ", resultado);
    }
}

