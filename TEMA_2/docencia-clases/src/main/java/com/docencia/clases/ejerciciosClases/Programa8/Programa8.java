package com.docencia.clases.ejerciciosClases.Programa8;

public class Programa8 {
    public static void main(String[] args) {
        Direccion direccion1 = new Direccion("Gran via", 10, "Madrid");
        Direccion direccion2 = new Direccion("Gran via", 10, "Madrid");

        System.out.println("Vivo en " + direccion1.getCalle() + " " + direccion1.getNumero() + ", " + direccion1.getCiudad());
        System.out.println(direccion1.equals(direccion2));
        direccion2.setCiudad("Barcelona");
        System.out.println(direccion2);
        System.out.println(direccion1.equals(direccion2));
    }
}
