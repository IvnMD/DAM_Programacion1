package com.docencia.listas.ejercicio08;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio08 {

    private Ejercicio08() {
    }

    public static class ResultadoParticion {
        private final List<Integer> pares;
        private final List<Integer> impares;

        public ResultadoParticion(List<Integer> pares, List<Integer> impares) {
            this.pares = pares;
            this.impares = impares;
        }

        public List<Integer> getPares() {
            List<Integer> cuenta = new ArrayList<>();
            for (int i = 0; i < cuenta.size(); i++) {
                if(cuenta.get(i) % 2 == 0){
                    pares.add(cuenta.get(i));
                }
            }
            return pares;
        }

        public List<Integer> getImpares() {
            List<Integer> cuenta = new ArrayList<>();
            for (int i = 0; i < cuenta.size(); i++) {
                if (cuenta.get(i)% 2 != 0){
                    impares.add(cuenta.get(i));
                }
            }
            return impares;
        }
    }

    public static ResultadoParticion partir(List<Integer> lista) {
        ResultadoParticion partido = new ResultadoParticion(new ArrayList<>(), new ArrayList<>());
        for (Integer numero : lista) {
            if (numero % 2 == 0) {
                partido.getPares().add(numero);
            } else {
                partido.getImpares().add(numero);   
             }
        }
        return partido;
    }
}
