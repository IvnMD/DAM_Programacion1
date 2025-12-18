package com.docencia.listas.ejercicio15;


import java.util.List;

/**
 * @author IvnMD
 * @date 18/12/25
 * @version 1.0.0
 */
/**
 * Ejercicio 15
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio15 {

    private Ejercicio15() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


    /**
     * Metodo para buscar coincidencias dentro de una lista
     * @param textos elementos de la lista
     * @param fragmento del que buscamos coincidencia
     * @return
     */
    public static String buscarPrimeraQueContiene(List<String> textos, String fragmento) {
        if (textos == null || textos.isEmpty()){
            return null;
        }
        if(fragmento == null || fragmento.isBlank()){
            return null;
        }
        String resultado = "";
        fragmento = fragmento.trim().toLowerCase();
        for (String cadena : textos) {
            if(cadena.contains(fragmento)){
                resultado = cadena;
                return resultado.trim();
            }
        }
        return resultado;
    }

}
