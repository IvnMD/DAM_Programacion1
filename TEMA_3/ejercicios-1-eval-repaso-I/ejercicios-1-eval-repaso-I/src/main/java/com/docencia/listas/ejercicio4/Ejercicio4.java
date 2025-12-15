package com.docencia.listas.ejercicio4;

import java.util.List;

/**
 * EJERCICIO 4 (ESQUELETO) - Media de valores válidos.
 */
public class Ejercicio4 {

    private Ejercicio4() {
    }


    public static double mediaValoresValidos(List<Integer> valores) {
        if (valores == null || valores.isEmpty()){
            return 0.0;
        }
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i) != null) {
                suma += valores.get(i);
            } else {
                contador++;
            }
            
        }
        if (contador == valores.size()){
            return 0.0;
        }
        double resultado = suma/(valores.size()-contador);
        return resultado;
    }
}
