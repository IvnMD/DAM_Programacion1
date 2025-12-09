package com.docencia.listas.ejercicio09; // declara el paquete al que pertenece la clase

import java.util.ArrayList; // importa ArrayList para poder crear listas mutables
import java.util.List;      // importa la interfaz List para usarla como tipo

public class Ejercicio09 { // declaración de la clase pública Ejercicio09

    public static List<String> pagina(List<String> elementos, int numeroPagina, int tamanoPagina) {
        // método público y static que recibe:
        // - elementos: la lista completa de Strings a paginar
        // - numeroPagina: número de la página que queremos (1-based)
        // - tamanoPagina: cantidad máxima de elementos por página
        // devuelve una sublista (List<String>) con los elementos de esa página

        if (elementos == null || numeroPagina < 1 || tamanoPagina < 1) {
            return new ArrayList<>(); // si la lista es null o los parámetros no son válidos,
            // devolvemos una lista vacía para evitar NPE o input inválido
        }

        int inicio = (numeroPagina - 1) * tamanoPagina;
        // calcula el índice inicial en la lista (0-based).
        // ejemplo: pagina 1 -> inicio = 0; pagina 2 con tam=3 -> inicio = 3

        if (inicio >= elementos.size()) {
            return new ArrayList<>(); // si el índice inicial está fuera de la lista,
            // significa que la página pedida es demasiado alta: devolvemos vacía
        }

        int fin = Math.min(inicio + tamanoPagina, elementos.size());
        // calcula el índice final (exclusive) de la sublista.
        // usamos Math.min para no pasarnos del tamaño de la lista.
        // fin será inicio+tamanoPagina o el tamaño de la lista si no hay suficientes elementos.

        return new ArrayList<>(elementos.subList(inicio, fin));
        // devuelve una nueva ArrayList que copia la subList desde inicio (inclusive)
        // hasta fin (exclusive). Se copia para:
        //  - evitar que la subList vista sobre la lista original cause ConcurrentModification si se modifica
        //  - devolver una lista independiente (mejor encapsulación)
    }
}
