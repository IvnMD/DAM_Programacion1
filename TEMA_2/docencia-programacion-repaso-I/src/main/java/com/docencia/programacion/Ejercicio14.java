package com.docencia.programacion;

public class Ejercicio14 {
    private final double[] grades;
    /**
     * Construcotr por defecto
     * @param grades
     */
    public Ejercicio14() {
        this.grades = new double[0];
    }
    /**
     * Constructor con un array como parametros
     * @param grades Conjunto de notas de entrada
     */
    public Ejercicio14(double[] grades) {

            this.grades = grades;
    }
    /**
     * Funcion que devuelve el maximo
     *  @param 
     */
    public double getMaxGrade() {
        if (grades == null || grades.length < 1){
            return 0.0d;
        }
        double maximo = grades[1];
        for (double numero : grades){
            if (maximo < numero){
                maximo = numero;
            }


        }
        return maximo;
    }

    public double getMinGrade() {
        double minimo = grades[1];
        for (double numero : grades){
            if (minimo > numero){
                minimo = numero;
            }


        }        
        return minimo;
    }

    public double getAverageGrade() {
        double media = 0.0;
        for (double numero : grades){
            media += numero;


        }        
        return media/grades.length;
    }
}
