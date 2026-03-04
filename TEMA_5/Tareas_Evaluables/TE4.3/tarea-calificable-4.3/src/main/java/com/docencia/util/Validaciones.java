package com.docencia.util;

import java.util.regex.Pattern;
/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief metodos utiles para validr los documentos
 */
public class Validaciones {
    
    /**
     * Validacion de la contraseña
     * @param password del usuario
     * @return true o false
     */
    public static boolean validacionPassword(String password) {
        String patron = "^\\w{6,}$"; 
                                                                               
        return Pattern.matches(patron, password);

    }

    /**
     * Validacion del email
     * @param email de la poersona
     * @return true o false
     */
    public static boolean emailValido(String email) {
        String patron = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"; // ! IMPORTANTISIMO, RECUERDA "\\." PARA ESCAPAR EL PUNTO
                                                       // (recuerda revisar si en el examen te fallo eso)

        return Pattern.matches(patron, email);
    }

    /**
     * Funcion que normaliza el email
     * @param email
     * @return
     */
    public static String normalizarEmail(String email){
        if(email == null){
            throw new IllegalArgumentException("Email nulo");
        }
        String emailNormalizado = email.trim().toLowerCase();

        return emailNormalizado;
    }

  

    public static void validarNombre(String nombre){
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre nulo");
        }
        nombre = nombre.trim();
        if (nombre.length() < 5) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
    }

    public static void validarEmail(String email)
    Función: lanza IllegalArgumentException si email inválido.
    public static void validarPassword(String password)
    Función: lanza IllegalArgumentException si password inválida.

}

