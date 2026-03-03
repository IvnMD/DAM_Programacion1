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
     * Validacion del documento de identidad
     * @param documento de identidad (dni o nie)
     * @return true o false
     */
    public static boolean validacionDocumento(String documento) {
        String patron = "^([0-9]{8}[a-z]|[0-9]{8}-[a-z]|[a-z][0-9]{7}[a-z])$"; // ! DNI = 8 nums + letra y NIE = letra +
                                                                               // 7 nums + letra
        return Pattern.matches(patron, documento);

    }
    /**
     * Validacion del email
     * @param email de la poersona
     * @return true o false
     */
    public static boolean validacionEmail(String email) {
        String patron = "^[a-z]+@[a-z]+\\.[a-z]{2,}$"; // ! IMPORTANTISIMO, RECUERDA "\\." PARA ESCAPAR EL PUNTO
                                                       // (recuerda revisar si en el examen te fallo eso)

        return Pattern.matches(patron, email);
    }

}
