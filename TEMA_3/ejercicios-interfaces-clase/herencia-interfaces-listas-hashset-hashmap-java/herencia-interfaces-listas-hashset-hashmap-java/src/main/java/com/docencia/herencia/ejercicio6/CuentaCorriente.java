package com.docencia.herencia.ejercicio6;

import java.util.UUID;

public class CuentaCorriente extends CuentaBancaria {

    private double limiteDescubierto;

    public CuentaCorriente(UUID id, String titular, double saldo, double limiteDescubierto) {
        super(id, titular, saldo);
        setLimiteDescubierto(limiteDescubierto);
}
    public double getLimiteDescubierto() { return limiteDescubierto; }

    public void setLimiteDescubierto(double limiteDescubierto){
        if (limiteDescubierto <= 0){
            throw new IllegalArgumentException();
        }
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    public double comisionMensual() {
        return 4.99;
    }
    @Override
    public String toString() {
        return "CuentaCorriente [getLimiteDescubierto()=" + getLimiteDescubierto() + ", id=" + getId()
                + ", getTitular()=" + getTitular() + ", getSaldo()=" + getSaldo() + "]";
    }

    
}
