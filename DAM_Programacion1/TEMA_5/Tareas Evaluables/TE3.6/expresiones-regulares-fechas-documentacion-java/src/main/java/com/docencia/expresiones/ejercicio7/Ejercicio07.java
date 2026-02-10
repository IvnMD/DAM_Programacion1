package com.docencia.expresiones.ejercicio7;

import java.util.regex.Pattern;

/**
 * 7) VALIDAR CONTRASEÑA “MÍNIMA”
 * - Debe tener entre 8 y 32 caracteres
 * - Sin espacios
 * - Al menos 1 mayúscula
 * - Al menos 1 minúscula
 * - Al menos 1 dígito
 *
 * Válidos: "Abcdefg1", "XyZ12345", "PassWord9"
 * Inválidos: "abcdefg1" (sin mayúscula),
 * "ABCDEFG1" (sin minúscula),
 * "Abcdefgh" (sin dígito),
 * "Abc 1234" (con espacio),
 * "Ab1" (demasiado corta)
 */
public class Ejercicio07 {

  public static boolean isValidPasswordMin(String text) {
    if (text == null || text.isBlank()) {
      return false;

    }
    String patron = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])\\S{8,32}$";

    //! ^ -> Inicio de la cadena
    //* (?=.*[a-z]) -> Asegura que haya al menos una minúscula
    //! (?=.*[A-Z]) -> Asegura que haya al menos una mayúscula
    //*  (?=.*[0-9]) -> Asegura que haya al menos un número (dígito)
    //!  \S{8,32} -> Que tenga entre 8 y 32 caracteres y que NO sean espacios (\S)
    //* */ $ -> Fin de la cadena
    
    return Pattern.matches(patron, text);
  }
}
