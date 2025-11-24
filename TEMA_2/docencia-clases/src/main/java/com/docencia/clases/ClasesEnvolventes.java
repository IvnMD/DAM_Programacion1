package com.docencia.clases;

import java.util.Arrays;

public class ClasesEnvolventes {
    static String miValor;

    public static void main(String[] args) {
        miValor = "Esto es un valor";
        System.out.println("Imprimir un valor en minuscula:" + miValor.toLowerCase() );
        System.out.println("Imprimir un valor en mayuscula:" + miValor.toUpperCase());
        
        //*Muestra texto si comienza por e/E
        // if (miValor.startsWith("e") || miValor.startsWith("E")){
        //     System.out.println("Muestro un valor porque comienza por e/E: ");
        // }
        if (miValor.toLowerCase().startsWith("e")){           //!startsWith() devuelve un booleano
            System.out.println("Muestro un valor porque comienza por e/E: " + miValor);
        }
        miValor = "2";
        Integer valorEnEntero = Integer.parseInt(miValor); //! parseInt es un metodo estatico
        System.out.println("miValor como entero = " + valorEnEntero);
        miValor = "Esto es un valor";
        String valorSinEspacios = miValor.replaceAll(" ", "");
        System.out.println("Valor sin espacios = " + valorSinEspacios);
        System.out.println("Valor al que apunta: " + miValor.indexOf("s"));
        String [] miArray = miValor.split(" ");
        System.out.println(Arrays.toString(miArray));
        miArray = miValor.split("s");
        System.out.println(Arrays.toString(miArray));

        //! METODOS ESTATICOS

        String[] soyUnArray = {"elemento1", "elemento2", "elemento3"};
        String union = String.valueOf(soyUnArray);
        // System.out.println("Valor de un array unificado: "+union); //! I
        System.out.println(String.join(" ", soyUnArray));

    }
}
