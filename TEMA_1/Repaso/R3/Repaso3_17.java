package TEMA_1.Repaso.R3;

import java.util.Scanner;

/**
 * @author Ivan Mesa
 * @date 03/10/25
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Crea un método que reciba una oración y devuelva la misma oración con la primera letra de cada palabra en mayúsculas.
 * 
 */
public class Repaso3_17 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Introduce una frase: ");
        String frase  = "hola, buenos dias.";
        String resultado = "";
        boolean inicioPalabra = true;
        for (int i = 0; i < frase.length(); i++){
            char caracter = frase.charAt(i);
            if (inicioPalabra && caracter != ' '){
                resultado += Character.toUpperCase(caracter);
                inicioPalabra = false;
            } else {
                resultado += caracter;
            }
            if (caracter == ' '){
                inicioPalabra = true;
            }
        }
        System.out.println("Oracion convertida: " + resultado);
    }

    

}
