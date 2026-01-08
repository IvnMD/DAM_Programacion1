package com.docencia.listas.ejercicio6;


import java.util.List;


/**
 * Ejercicio 6
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio6 {

    private Ejercicio6() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


    /**
     * Contador de ocurrencias en una lista
     * @param textos lista de palabras
     * @param objetivo palabra objetivo
     * @return total de palabras coincidentes econtradas
     */
    public static int contarOcurrencias(List<String> textos, String objetivo) {
        if (textos == null || textos.isEmpty() || objetivo == null || objetivo.isBlank()){
            return 0;
        }
        int resultado = 0;
        for (String palabras : textos) {
            if(palabras != null && palabras.trim().toLowerCase().equals(objetivo.trim().toLowerCase())){
                resultado++;
            }
        }
        return resultado;
    }

}
