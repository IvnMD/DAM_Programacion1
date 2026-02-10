package com.docencia.clases;

public class Camion implements IVehiculo{

    @Override
    public int numeroPuertas() {
        return 2;
    }

    @Override
    public int numeroRuedas() {
        return 8;
    }

    @Override
    public String sonido() {
        return "plof";
    }



}
