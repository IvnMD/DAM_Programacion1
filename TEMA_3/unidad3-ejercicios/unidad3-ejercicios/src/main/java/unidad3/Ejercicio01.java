package unidad3;

import java.util.Objects;

/**
 * Clase que representa la calificacion de un estudiante basada en su nota numerica.
 * Proporciona metodos para obtener la calificacion en formato texto.
 * @author IvnMD
 * @version 1.0.0
 * @date 2024-06-10
 * @brief Esta clase permite convertir una nota numerica (0-10) en una calificacion textual
 * 
 */
public class Ejercicio01 {

    private int nota;
    /**
     * Constructor vacio
     */
    public Ejercicio01() {}
    /**
     * Constructor parametrico
     * @param nota Nota del estudiante entre 0 y 10
     */
    public Ejercicio01(int nota) {
        this.nota = nota;;
    }
    /**
     * Obtiene la nota del estudiante
     * @return Nota del estudiante entre 0 y 10
     */
    public int getNota() {
        return nota;
    }
    /**
     * Establece la nota del estudiante
     * @param nota Nota del estudiante entre 0 y 10
     */
    public void setNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
        this.nota = nota;
    }

    @Override
    public String toString() {
        return calificar(nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nota);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Ejercicio01 other = (Ejercicio01) obj;
        return nota == other.nota;
    }

    public static String calificar(int nota) {
        if (nota < 0 || nota > 10)
            throw new IllegalArgumentException();

        if (nota < 5) return "Insuficiente";
        if (nota == 5) return "Suficiente";
        if (nota == 6) return "Bien";
        if (nota < 9) return "Notable";
        return "Sobresaliente"; // 9 o 10
    }
}

