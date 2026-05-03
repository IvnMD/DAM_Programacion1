package com.docencia.algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class OrdenacionServiceImpl implements OrdenacionService {

    @Override
    public List<Integer> ordenarBurbujaAscendente(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<Integer> resultado = new ArrayList<>(numeros);
        for (int i = 0; i < resultado.size() - 1; i++) {
            for (int j = 0; j < resultado.size() - i - 1; j++) {
                if (resultado.get(j) > resultado.get(j + 1)) {
                    int aux = resultado.get(j);
                    resultado.set(j, resultado.get(j + 1));
                    resultado.set(j + 1, aux);

                }
            }
        }
        return resultado;
    }

    @Override
    public List<Integer> ordenarBurbujaDescendente(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<Integer> resultado = new ArrayList<>(numeros);
        for (int i = 0; i < resultado.size() - 1; i++) {
            for (int j = 0; j < resultado.size() - i - 1; j++) {
                if (resultado.get(j) < resultado.get(j + 1)) {
                    int aux = resultado.get(j);
                    resultado.set(j, resultado.get(j + 1));
                    resultado.set(j + 1, aux);

                }
            }
        }
        return resultado;
    }

    @Override
    public List<String> ordenarPalabrasAlfabeticamente(List<String> palabras) {
        if (palabras == null || palabras.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> resultado = new ArrayList<>(palabras);
        resultado.sort(String.CASE_INSENSITIVE_ORDER);
        return resultado;
        
        //! return new ArrayList<>(new TreeSet<>(palabras)); 
        //? Ventajas: Ordena automáticamente, elimina duplicados.
        //? Desventaja: No permite elementos repetidos.
        //! Set<String> sorted = new TreeSet<>((a, b) -> a.compareToIgnoreCase(b));
        //? Para ignorar las mayusculas 

    }

    @Override
    public List<Integer> invertirLista(List<Integer> numeros) {
l,lklkkkkk,m   
    }

    @Override
    public Boolean estaOrdenadaAscendente(List<Integer> numeros) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaOrdenadaAscendente'");
    }

}
