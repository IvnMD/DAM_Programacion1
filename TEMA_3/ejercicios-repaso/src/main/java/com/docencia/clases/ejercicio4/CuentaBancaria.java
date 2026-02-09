package com.docencia.clases.ejercicio4;

import java.util.Objects;

public class CuentaBancaria {
    private String iban;
    private String titular;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String iban) {
        setIban(iban);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        if (iban == null ||iban.isBlank()){
            throw new IllegalArgumentException();
        }
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaBancaria{");
        sb.append("iban=").append(iban);
        sb.append(", titular=").append(titular);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.iban);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaBancaria other = (CuentaBancaria) obj;
        return Objects.equals(this.iban, other.iban);
    }


}
