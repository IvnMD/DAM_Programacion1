package com.docencia.programacion;

public class Ejercicio20 {
    /**
     * Funcion que obtiene las iniciales de un nombre
     * @param fullName Cadena de texto de entrada (Nombre completo con espacios)
     * @return Iniciales del nombre
     */
    public static String getInitials(String fullName) {  //! PREGUNTA DE EXAMEN
        if (fullName == null || fullName.isEmpty()){
            return "";
        }
        fullName = fullName.trim();
        String [] arrayFullName = fullName.split(" ");
        String iniciales = "";
        for (String word:arrayFullName){
            char inicial = word.charAt(0);
            String inicialStr = String.valueOf(inicial).toUpperCase();
            iniciales += inicialStr;
        }

        return iniciales.trim();
    }
}
