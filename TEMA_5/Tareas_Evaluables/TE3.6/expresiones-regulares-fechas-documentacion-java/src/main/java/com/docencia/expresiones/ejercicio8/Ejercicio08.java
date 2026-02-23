package com.docencia.expresiones.ejercicio8;

import java.util.regex.Pattern;

/**
 * 8) VALIDAR IPv4 (0–255) EXACTO
 *    - Validar una IPv4 donde cada octeto está en 0..255:
 *      A.B.C.D, cada parte sin salirse del rango.
 *    Válidos:   "0.0.0.0", "255.255.255.255", "192.168.1.10"
 *    Inválidos: "256.0.0.1", "192.168.1", "1.2.3.4.5", "192.168.01.1"
 * 
 */
public class Ejercicio08 {

public static boolean isValidIPv4(String ip) {
    if (ip == null || ip.isBlank()) {
        return false; 
    }
    // 25[0-5]         -> 250-255
    // 2[0-4][0-9]     -> 200-249
    // 1[0-9][0-9]     -> 100-199
    // [1-9][0-9]      -> 10-99 (prohíbe 01, 02, etc.)
    // [0-9]           -> 0-9 (un solo dígito)
    String octeto = "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])";

    String patron = "^" + octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto + "$";

    return Pattern.matches(patron, ip);
  }
}
