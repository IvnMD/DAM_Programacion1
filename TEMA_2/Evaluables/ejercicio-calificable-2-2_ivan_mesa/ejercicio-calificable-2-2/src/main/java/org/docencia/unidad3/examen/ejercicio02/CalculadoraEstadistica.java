package org.docencia.unidad3.examen.ejercicio02;

import java.util.Objects;

/**
 * @author IvnMD
 * @date 21/11/25
 * @version 1.0.0
 * @bugs Sin bugs conocidos
 * @see https://www3.gobiernodecanarias.org/medusa/eforma/campus/mod/assign/view.php?id=9079296
 * @brief Calculadora con un menu logico que segun la opcion escogida, realice una operacion u otra.
 */

/**
 * Clase calculadora
 */
public class CalculadoraEstadistica {

    private double a;
    private double b;
    private int opcion;


    public CalculadoraEstadistica() {
    }

    public CalculadoraEstadistica(double a, double b, int opcion){
        this.a = a;
        this.b = b;
        this.opcion = opcion;
    }

    /**
     * F
     * @param a
     * @param b
     * @param opcion
     * @return
     */
    public double operar(double a, double b, int opcion) {
        if (opcion < 1 || opcion > 4){
            throw new IllegalArgumentException();
        }
        if (opcion == 4 && b == 0) {
             throw new ArithmeticException();
        }
        double operacion = 0.0;
        switch(opcion) {
            case 1: operacion = (double) a + b;
                    break;
            case 2:  operacion = (double) a - b;
                    break;
            case 3:  operacion = (double) a * b;
                    break;
            case 4: operacion = (double) a / b;
                     break;
        }
        return operacion;
    }
    /**
     * Funcion para calcular las estadisticas
     * @param numeros Array con numeros
     * @return devuelve un obejto Estadisticas
     */
    public Estadisticas calcularEstadisticas(double[] numeros) {

        if (numeros == null || numeros.length == 0){
            throw new IllegalArgumentException();
        }
        int cantidad = numeros.length;
        double media = 0.0;
        double maximo = 0.0;
        double minimo = numeros[0];
        
        if (numeros.length == 1) {
            double resultado = numeros[0];
            Estadisticas estadistica = new Estadisticas(1, resultado, resultado, resultado);
        estadistica.getCantidad();
        estadistica.getMedia();
        estadistica.getMaximo();
        estadistica.getMinimo();

        return  estadistica;
        }
            
        for (int i = 0; i< numeros.length; i++){
            if(numeros[i] > maximo){
                maximo = numeros[i];
            }
            if (numeros[i] < minimo){
                minimo = numeros[i];
            }
            media = (numeros[i] + media);

        }
        media = media/cantidad;
        Estadisticas estadistica = new Estadisticas(cantidad, media, maximo, minimo);
        estadistica.getCantidad();
        estadistica.getMedia();
        estadistica.getMaximo();
        estadistica.getMinimo();

        return  estadistica;
    }


    /**
     * Clase  auxiliar que calcula estadisticas
     */
    public static class Estadisticas {
        private final int cantidad;
        private final double media;
        private final double maximo;
        private final double minimo;


        /**
         * Constructor parametrico
         * @param cantidad
         * @param media
         * @param maximo
         * @param minimo
         */
        public Estadisticas(int cantidad, double media, double maximo, double minimo) {
            this.cantidad = cantidad;
            this.media = media;
            this.maximo = maximo;
            this.minimo = minimo;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getMedia() {
            
            return media;
        }

        public double getMaximo() {
            return maximo;
        }

        public double getMinimo() {
            return minimo;
        }


        

        @Override
        public String toString() {
            return "Estadisticas [cantidad=" + cantidad + ", media=" + media + ", maximo=" + maximo + ", minimo="
                    + minimo + "]";
        }

        @Override
        public int hashCode() {
            return Objects.hash(cantidad, media, maximo, minimo);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Estadisticas other = (Estadisticas) obj;
            return cantidad == other.cantidad && Double.doubleToLongBits(media) == Double.doubleToLongBits(other.media)
                    && Double.doubleToLongBits(maximo) == Double.doubleToLongBits(other.maximo)
                    && Double.doubleToLongBits(minimo) == Double.doubleToLongBits(other.minimo);
        }

        

        
    }
}
