package com.docencia.listas.ejercicio10;

import java.util.List;

public class Ejercicio10 {

    private Ejercicio10() {
    }

    public static void rotar(List<Integer> lista, int k) {
        List<Integer> copia = List.copyOf(lista);
        int n = lista.size();
        for (int i = 0; i < lista.size(); i++) {
            lista.set((i + k) % n, copia.get(i));
        }
    }
}
/**Método rotar - Visión general
    El método rotar desplaza cíclicamente todos los elementos de una lista hacia la derecha 
    un número k de posiciones. 
    Por ejemplo, si tienes [1, 2, 3, 4] y rotas con k=2, obtendrás [3, 4, 1, 2].

Copia de la lista
    La primera línea dentro del método, List<Integer> copia = List.copyOf(lista), 
    crea una copia inmutable de la lista original. Esto es crucial porque necesitamos acceder 
    a los valores originales mientras modificamos la lista al mismo tiempo. 
    Si modificáramos la lista directamente sin copiarla primero, estaríamos cambiando 
    los valores que intentamos leer, lo que daría resultados incorrectos.

El algoritmo de rotación
    El bucle for itera sobre cada posición de la lista original (usando la copia). 
    Para cada elemento en la posición i, lo coloca en la nueva posición (i + k) % n. 
    El operador módulo (%) es clave aquí: garantiza que los índices se envuelvan alrededor. 
    Por ejemplo, si n=4 e i=3 con k=2, entonces (3 + 2) % 4 = 1, moviendo el elemento a la posición 1.

Gotcha importante: Este enfoque asume que k es positivo y generalmente menor que n. 
    Si k es negativo o muy grande, los resultados pueden ser inesperados, 
    aunque el módulo técnicamente lo maneja correctamente.
*/

