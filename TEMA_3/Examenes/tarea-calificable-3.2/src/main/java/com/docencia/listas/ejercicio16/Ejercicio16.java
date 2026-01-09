package com.docencia.listas.ejercicio16;
/**
 * @author IvnMD
 * @date 09/01/26
 * @version 1.0.0
 * @brief Sumar la longitud de todas las cadenas no nulas y no en blanco.
 *        Si lista null o sin cadenas validas → 0.
 */

import java.util.List;


/**
 * Ejercicio 16
 *
 * Clase lanzadora (opcional) y contenedor de metodos del enunciado.
 */

public class Ejercicio16 {

    private Ejercicio16() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aqui pruebas manuales rapidas si lo deseas.
    }


    /**
     * Funcion que suma la longitud de las cadenas de texto no vacias incluidas en una lista
     * @param textos cadenas que componen la lista
     * @return int con el la suma total de caracteres validos contenidos en la lista
     */
    public static int sumarLongitudesNoVacias(List<String> textos) {

        if(textos == null || textos.isEmpty()){
            return 0;
        }
        int resultado = 0;
        for (String texto : textos) {
            if (texto != null && !texto.isBlank()) {
                resultado += texto.trim().length();
            }
        }
        return resultado;
    }

}
