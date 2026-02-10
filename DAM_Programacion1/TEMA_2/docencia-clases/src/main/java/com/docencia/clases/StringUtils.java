package com.docencia.clases;

/**
 * @author IvnMD
 * @version 1.0.0
 * 
 */

public class StringUtils {
    /**
     * Funcion que normaliza una cadena de texto
     * 
     * @param cadena String que pretende normalizar
     * @return String de texto normalizado
     */
    public static String normalizaNombre(String cadena) {
        if (cadena == null || cadena.isEmpty()) { // ! PREGUNTA DE EXAMEN
            return cadena;
        }
        System.out.println("normalizaNombre --> input = " + cadena);
        cadena = cadena.trim(); // ? Eliminamos los espacios
        cadena = cadena.toLowerCase(); // ? Todo a minuscula
        char primeraLetra = cadena.charAt(0); // ? Obtenemos el primer caracter
        String primeraLetraStr = String.valueOf(primeraLetra); // ? Convertimos el char en string
        String primeraLetraMayuscula = primeraLetraStr.toUpperCase(); // ? Convertimos el caracter en mayuscula
        cadena = cadena.replaceFirst(primeraLetraStr, primeraLetraMayuscula); // ? Reemplazamos la primera letra en el
                                                                              // String de entrada
        return cadena;
    }

    /**
     * Funcion que cuenta el numero de vocales y consonantes de una cadena
     * 
     * @param cadena String de entrada
     * @return Array con el numero de vocales y consonantes
     */
    public static int[] cuentaLetras(String cadena) { // ! PREGUNTA DE EXAMEN
        int[] resultado = new int[2];
        if (cadena == null || cadena.isEmpty()) {
            return resultado;
        }
        System.out.println("cuentaLetras --> input = " + cadena);
        int letras = 0;
        int vocales = 0;
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        for (int j = 0; j < cadena.length(); j++) {

            char caracter = cadena.charAt(j);
            if (caracter >= 'a' && caracter <= 'z') {
                letras = letras + 1;
            }
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                vocales++;
            }
        }
        resultado[0] = vocales;
        resultado[1] = letras - vocales;
        return resultado;
    }

    /**
     * Funcion que comprueba si una cadena de texto es palindromo
     * @param cadena Cadena de entrada
     * @return Booleano que dice si es palindromo o no
     */
    public static boolean esPalindromo(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false;
        }
        System.out.println("esPalindromo --> input = " + cadena);
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        char[] cadenaArray = cadena.toCharArray();
        for (int i = 0; i < cadena.length() / 2; i++) {

            if (cadenaArray[i] != cadenaArray[cadenaArray.length - 1 - i]) {
                return false; // ? Otra opcion sin array seria:
                              // ? if (palabra.charAt(i) != palabra.charAt(palabra.length() -1 - i)
            }
        }
        return true;
    }

    /**
     * Funcion que recibe una cadena de texto sin mayusculas y la convierte en un acronimo
     * @param frase Cadena de Texto de entrada
     * @return Acronimo con las iniciales de todas las palabras de la cadena de texto.
     */
    public static String acronimo(String frase) {
        if (frase == null || frase.isEmpty()) {
            return frase;
        }
        String resultado = " ";
        System.out.println("acronimo --> input = " + frase);
        frase = frase.trim();
        String[] palabras = frase.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            char letra = palabra.charAt(0);
            resultado += String.valueOf(letra);
        }

        return resultado.toUpperCase();
    }

    /**
     * Funcion que recibe una cadena de texto y la convierte en un acronimo con las mayusculas obtenidas.
     * @param frase Cadena de texto entrante
     * @return Acronimo con las mayusculas obtenidas
     */
    public static String acronimoMayus(String frase) {
        if (frase == null || frase.isEmpty()) {
            return frase;
        }
        String resultado = " ";
        System.out.println("acronimoMayus --> input = " + frase);
        frase = frase.trim();
        String[] palabras = frase.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            char letra = palabra.charAt(0);
            String letraStr = String.valueOf(letra);
            String letraMayus = letraStr.toUpperCase();
            if (letraStr.equals(letraMayus)) {
                resultado += String.valueOf(letra);
            }
        }

        return resultado;
    }

    /**
     * Funcion que recibe una cadena de texto y la convierte en un acronimo
     * @param frase Cadena de texto de entrada
     * @return Segun si encuentra mayusculas o no, el acronimo de salida sera una u otra. 
     */
    public static String acronimoCombi(String frase) {
        if (frase == null || frase.isEmpty()) {
            return frase;
        }
        String resultado = "";
        // Hola soy una frase
        System.out.println("acronimoCombi --> input = " + frase);
        frase = frase.trim();
        // Hola soy una frase = {"Hola","soy","una","Frase"}
        String[] palabras = frase.split(" ");
        // {"Hola","soy","una","frase"}
        boolean mayuscula = false;
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            char letra = palabra.charAt(0);// i=0-> H, i=1->s,....
            String letraStr = String.valueOf(letra);
            String letraMayuscula = letraStr.toUpperCase();
            if (letraStr.equals(letraMayuscula)) {
                mayuscula = true;
                resultado = resultado + letraStr;
            }
        }
        if (mayuscula == false) { // (!mayuscula)
            resultado = "";
            for (int i = 0; i < palabras.length; i++) {
                String palabra = palabras[i];
                char letra = palabra.charAt(0);
                String letraStr = String.valueOf(letra);
                resultado = resultado + letraStr;
            }
        }
        return resultado.toUpperCase();
    }

    public static void main(String[] args) {

        String resultado = normalizaNombre("  aNA  ");
        System.out.println(resultado);
        int[] resultado2 = cuentaLetras(" Hola, 123 ");
        System.out.println("Total de vocales y consonantes en ese orden = [" + resultado2[0] + "," + resultado2[1] + "]");
        boolean resultado3 = esPalindromo("Arepera");
        System.out.println("Es palindromo? = " + resultado3);
        String resultado4 = acronimo("   Hola soy una Frase");
        System.out.println(resultado4);
        String resultado5 = acronimoMayus("   Hola soy una Frase");
        System.out.println(resultado5);
        String resultado6 = acronimoCombi("   Hola soy una Frase");
        System.out.println(resultado6);
        String resultado7 = acronimoCombi("   hola soy una frase minuscula");
        System.out.println(resultado7);
    }
}