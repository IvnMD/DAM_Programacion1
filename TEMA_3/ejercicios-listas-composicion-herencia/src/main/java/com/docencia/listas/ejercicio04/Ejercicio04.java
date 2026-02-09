package com.docencia.listas.ejercicio04;

import java.util.Collections;
import java.util.List;


public class Ejercicio04 {

    private Ejercicio04() {
    }

    public static void reemplazar(List<String> nombres, String antiguo, String nuevo) {
        // for (int i = 0; i < nombres.size(); i++) {
        //     nombres.get(i).replaceAll(antiguo, nuevo);
            
        // }

        Collections.replaceAll(nombres, antiguo, nuevo);
    }
}
