package com.docencia.programacion;
/**
 * @author IvnMD
 * @since 06/11/25
 * @version 1.0.0
 * @brief Conversor de Celsius a Fahrenheit.
 */
public class Ejercicio5 {
    /**
     * Convierte grados Celsius a Fahrenheit.
     * @param celsius Grados en Celsius.
     * @return Grados en Fahrenheit. Si la temperatura en Celsius es menor que -273.15, devuelve 0.0.
     */
    public static double celsiusToFahrenheit(double celsius) {
        if (celsius >= -273.15){
            return (celsius * 9/5) + 32;
        }
        return 0.0;
    }
}
