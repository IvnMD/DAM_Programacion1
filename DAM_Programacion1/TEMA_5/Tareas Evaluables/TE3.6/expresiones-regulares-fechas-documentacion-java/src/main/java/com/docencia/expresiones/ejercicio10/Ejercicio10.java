package com.docencia.expresiones.ejercicio10;

import java.util.regex.Pattern;

/**
 /**
 * 10) VALIDAR DNI/NIF ESPAÑOL (8 dígitos + letra) EXACTO
 *    - Validar un DNI/NIF con este formato:
 *      8 dígitos (sin separadores) + 1 letra (mayúscula)
 *    - Reglas:
 *      1) Debe ser EXACTAMENTE: ^\d{8}[A-Z]$
 *      2) Además, la letra debe corresponder al número:
 *         letra = "TRWAGMYFPDXBNJZSQVHLCKE"[numero % 23]
 *
 *    Válidos (si la letra cuadra):
 *      "00000000T", "12345678Z", "53077918Y"
 *
 *    Inválidos:
 *      - Formato incorrecto: "1234567Z", "12345678-z", "12.345.678Z"
 *      - Letra incorrecta:   "12345678A"
 *
 */
public class Ejercicio10 {

    public static boolean validarDNI(String dni) {
        if (dni == null || dni.isBlank()){
            return false;
        }
        String patron = "^\\d{8}[A-Z]$";
        // Validar el formato
        if (!dni.matches(patron)) {
            return false;
        }

        String letras_dni = "TRWAGMYFPDXBNJZSQVHLCKE";
                
        // Extraer el número (primeros 8 caracteres)
        String numero = dni.substring(0, 8);
        
        // Extraer la letra (último carácter)
        char letra = dni.charAt(8);
        
        // Calcular la letra correcta
        int numeroInt = Integer.parseInt(numero);
        char letraCorrecta = letras_dni.charAt(numeroInt % 23);
        
        // Verificar que la letra coincida
        return letra == letraCorrecta;
    
    }

}
