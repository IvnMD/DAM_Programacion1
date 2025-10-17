package formacion.dam;

import java.util.Arrays;


public final class ElementosSobreMedia {
    private ElementosSobreMedia() {}
    
    public static int[] filtrar(int[] datos) {
        int media = 0;
        int contador = 0;

        for (int i = 0; i < datos.length; i++) {
            media += datos[i];
        }
        int[] temporal = new int [datos.length];
        media /= datos.length;

        for (int j = 0; j < datos.length; j++) {
            if (datos[j] > media){
                temporal[contador++] = datos[j];
            }
        }
        int[] resultado = new int [contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = temporal[i];

        }
       
        return resultado;
    }
}

