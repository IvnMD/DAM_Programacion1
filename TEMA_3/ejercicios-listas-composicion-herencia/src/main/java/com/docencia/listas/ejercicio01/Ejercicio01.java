package com.docencia.listas.ejercicio01;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio01 {

    private Ejercicio01() {
        // Utilidad estática
    }

    public static int maximo(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()){
            return -1;
        }
        return Collections.max(numeros);
        // int resultado = numeros.get(0);
        // for (int i = 1; i < numeros.size() ;i++){
        //     if (resultado < numeros.get(i)) {
        //         resultado = numeros.get(i);
        //     }

        // }
        // return resultado;
        
    }

    public static int minimo(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()){
            return -1;
        }
        return Collections.min(numeros);
        // int resultado = numeros.get(0);
        // for (int i = 1; i < numeros.size() ;i++){
        //     if (resultado > numeros.get(i)) {
        //         resultado = numeros.get(i);
        //     }

        // }
        // return resultado;
        
    }
    

    public static void eliminarNegativos(List<Integer> numeros) {
        
        // List <Integer> resultado = new ArrayList <>();
        // for (Integer numero : numeros) {     //! Opcion 1
        //     if (numero >= 0) {
        //         resultado.add(numero);
        //     }
        // }
        // numeros = resultado;

        // List<Integer> eliminar = new ArrayList<>();  //! Opcion 2 (personal)
        // for (Integer numero : numeros) {
        //     if (numero < 0) {
        //         eliminar.add(numero);
        //     }
        // }
        // numeros.removeAll(eliminar);

        numeros.removeIf(numero -> numero < 0);  //! Opcion 3
    }
}

