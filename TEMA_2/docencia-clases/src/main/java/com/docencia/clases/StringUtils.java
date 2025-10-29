package com.docencia.clases;

/**
 * @author IvnMD
 * @version 1.0.0
 * 
 */

public class StringUtils {
    /**
     * Funcion que normaliza una cadena de texto
     * @param cadena String que pretende normalizar
     * @return String de texto normalizado
     */
    public static String normalizaNombre(String cadena) {
        if(cadena == null || cadena.isEmpty()){             //! PREGUNTA DE EXAMEN
            return cadena;
        }
        System.out.println("Vamos a transformar = " + cadena);
        cadena = cadena.trim();                                               //? Eliminamos los espacios
        cadena = cadena.toLowerCase();                                        //? Todo a minuscula
        char primeraLetra = cadena.charAt(0);                                 //? Obtenemos el primer caracter
        String primeraLetraStr = String.valueOf(primeraLetra);                //? Convertimos el char en string
        String primeraLetraMayuscula = primeraLetraStr.toUpperCase();         //? Convertimos el caracter en mayuscula
        cadena = cadena.replaceFirst(primeraLetraStr, primeraLetraMayuscula); //? Reemplazamos la primera letra en el String de entrada
        return cadena;
    }

    /**
     * Funcion que cuenta el numero de vocales y consonantes de una cadena
     * @param cadena String de entrada
     * @return Array con el numero de vocales y consonantes
     */
    public static int[] cuentaLetras(String cadena) {  //! PREGUNTA DE EXAMEN
        int[] resultado = new int [2];
        if (cadena == null || cadena.isEmpty()){
            return resultado;
        }
        System.out.println("La cadena de entrada en esta funcion es = " + cadena);
        int letras = 0;
        int vocales =0;
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        for (int j = 0; j < cadena.length(); j++){
 
            char caracter = cadena.charAt(j);
            if (caracter >= 'a' && caracter <= 'z'){
                letras = letras + 1;
            }
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
                vocales++;
            }
        }
        resultado[0] = vocales;
        resultado[1] = letras - vocales;
        return resultado;
    }

    public static boolean esPalindromo(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false;
        }
        System.out.println("Comprobremos si esto es un palindromo = " + cadena);
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        char [] cadenaArray = cadena.toCharArray();
        for (int i = 0; i < cadena.length()/2; i++){

            if (cadenaArray[i] != cadenaArray[cadenaArray.length-1-i]){
                return false;    //? Otra opcion sin array seria: 
                                 //? if (palabra.charAt(i) != palabra.charAt(palabra.length() -1 - i)
            }
        }
        return true;
    }

    public static String acronimo(String frase) {
        return null;
    }



    public static void main(String[] args) {

        String resultado = normalizaNombre("  aNA  ");
        System.out.println(resultado);
        int[] resultado2 = cuentaLetras(" Hola, 123 ");
        System.out.println("Total de vocales y consonantes en ese orden = [" + resultado2[0] + ","+ resultado2[1] + "]");
        boolean resultado3 = esPalindromo("Arepera");
        System.out.println("Es palindromo? = " + resultado3);
        
    }
}