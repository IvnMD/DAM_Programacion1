package unidad3;

/**
 * @author IvnMD
 * @since 20/11/25
 * @version
 * @bugs No bugs known
 * @brief 
 * Clase: Ejercicio03
 * Métodos principales:
 * 
 * evaluarIntento(int numeroSecreto, int intento)
 * Devuelve:
 * 
 * "Demasiado alto"
 * "Demasiado bajo"
 * "¡Correcto!"
 * jugar(int numeroSecreto, int[] intentos)
 * Simula una partida con un máximo de 7 intentos (se usarán como máximo los 7 primeros elementos del array).
 * Devuelve true si el número se adivina dentro de los intentos permitidos, false en caso contrario.
 * 
 */
public class Ejercicio03 {

    /**
     * Funcion que evalua el intento de adivinar el numero
     * @param numeroSecreto Numero a adivinar
     * @param intento Intento del adivinador
     * @return Si el numero es mas bajo, mas alto o si es correcto 
     */
        public static String evaluarIntento(int numeroSecreto, int intento) {
            if (numeroSecreto < intento){
                return "Demasiado alto";
            }
            if (numeroSecreto > intento){
                return "Demasiado bajo";
            }
            return "¡Correcto!";
    }

    /**
     * Simula una partida con un máximo de 7 intentos.
     *
     * @param numeroSecreto número que hay que adivinar
     * @param intentos      array con los intentos del usuario (se usan como máximo 7)
     * @return true si se acierta en <= 7 intentos, false en caso contrario
     */
    public static boolean jugar(int numeroSecreto, int[] intentos) {
        int maxIntentos = 7;
        int usados = Math.min(maxIntentos, intentos.length);

        for (int i = 0; i < usados; i++) {
            if (intentos[i] == numeroSecreto) {
                return true;
            }
        }
        return false;
    }
}
