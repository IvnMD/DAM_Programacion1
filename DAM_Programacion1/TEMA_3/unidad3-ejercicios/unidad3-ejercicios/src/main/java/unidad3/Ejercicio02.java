package unidad3;
import java.util.Objects;

/**
 * @author IvnMD
 * @date 20/11/25
 * @version 1.0.0
 * @brief
 * 
 * Clase: Ejercicio02
 * Método principal: operar(double a, double b, int opcion)
 * 
 * Simula el comportamiento de una calculadora sencilla con el siguiente menú lógico:
 * 
 * Sumar
 * Restar
 * Multiplicar
 * Dividir
 * El método recibe dos operandos y una opción (1–4) y devuelve el resultado de la operación.
 * 
 * Si la opción no es válida, lanza IllegalArgumentException.
 * Si se intenta dividir entre 0 (opción 4 y b == 0), lanza ArithmeticException.
 */
public class Ejercicio02 {

    private double a;
    private double b;
    private int opcion;

    /**
     * Constructor vacio
     */
    public Ejercicio02(){};
    /**
     * Constructor parametrico
     * @param a Primer parametro de entrada
     * @param b Primer parametro de entrada
     * @param opcion Operacion a realizar
     */
    public Ejercicio02(double a, double b, int opcion) {
        this.a = a;
        this.b = b;
        this.opcion = opcion;
    }
    
    /**
     * Setters y getters
     */
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public int getOpcion() {
        if (opcion < 1 || opcion > 4) {
            throw new IllegalArgumentException();
        }
        return opcion;
    }
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    /**
     * Funcion para imprimir el resultado
     */
    @Override
    public String toString() {
        return "{" +
            " a='" + getA() + "'" +
            ", b='" + getB() + "'" +
            ", opcion='" + getOpcion() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ejercicio02)) {
            return false;
        }
        Ejercicio02 ejercicio02 = (Ejercicio02) o;
        return a == ejercicio02.a && b == ejercicio02.b && opcion == ejercicio02.opcion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, opcion);
    }

    
    
    public static double operar(double a, double b, int opcion) {
        switch (opcion) {
            case 1 -> {
                return a + b;
            }
            case 2 -> {
                return a - b;
            }
            case 3 -> {
                return a * b;
            }
            case 4 -> {
                if (b == 0) {
                    throw new ArithmeticException("Division por cero no permitida");
                }
                return a / b;
            }
            default -> throw new IllegalArgumentException("Opcion no valida");
        }
    }
}
