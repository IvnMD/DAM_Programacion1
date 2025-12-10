package com.docencia.herencia.ejercicio24;

/**
 * Ejercicio 24 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio24 {
    
    public static void main(String[] args) {
        EmailNotificacion email = new EmailNotificacion("asdasd", "sdfsdfdsf", "asdasdsad");
        System.out.println(email);
        SMSNotificacion sms = new SMSNotificacion("asdadasd", "asdasd",666);
        System.out.println(sms);
    }




}
