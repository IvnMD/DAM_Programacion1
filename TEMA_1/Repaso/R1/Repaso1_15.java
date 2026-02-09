

/**
 * @author Ivan Mesa
 * @date 02/10/2025
 * @version 1.0
 * @bugs No hay bugs conocidos
 * @brief Declara una variable de tipo char y asígnale un símbolo del teclado.
 * Luego, muestra el código numérico ASCII de ese símbolo.
 *
 */
public class Repaso1_15 {

    public static void main(String[] args) {

        char simbolo = '@';
        int ASCII = (int) simbolo;

        System.out.println("El símbolo es: " + simbolo);
        System.out.println("El código ASCII de '" + simbolo + "' es: " + ASCII);
    }
}

