package com.docencia.clases;

public class CuentaBancaria {

    private final String iban;
    private double saldo;

    public CuentaBancaria() {
        this("iban", 0);
    }

    /**
     * Constructor de la clase Cuenta Bancaria
     * 
     * @param iban de la cuenta. Por defecto el saldo incial es 0.0
     */
    public CuentaBancaria(String iban) {
        this(iban, 0);
    }

    /**
     * Constructor de la clase Cuenta Bancaria
     * 
     * @param iban  Iban identificativo de la cuenta
     * @param saldo Saldo positivo de la cuenta. En caso de <= 0 genera
     *              IllegalArgumentException.
     */
    public CuentaBancaria(String iban, double saldo) {
        this.iban = iban;

        if (saldo < 0) {
            throw new IllegalArgumentException("saldo");
        }
        this.saldo = saldo;
    }

    /* Getters && Setters */

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("saldo");
        }
        this.saldo = saldo;
    }

    /**
     * Funcion que permite ingresar una cantidad en la cuenta
     * 
     * @param cantidad Cantidad que sumamos en la cuenta
     */
    public void ingresar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("cantidad");
        }
        this.saldo = this.saldo + cantidad;
        // saldo += cantidad;
    }

    /**
     * Funcion que retira una cantidad de la cuenta
     * 
     * @param cantidad Cantidad que se retira de la cuenta. Nunca la cantidad a retirar
     *                 será mayor que el saldo disponible
     */
    public void retirar(double cantidad) {
        if (cantidad < -1 || cantidad > saldo) {
            throw new IllegalArgumentException("cantidad");
        }
        this.saldo = this.saldo - cantidad;
        // saldo -= cantidad;
    }

    /**
     * Funcion que devuelve el saldo de la cuenta
     * @param iban Iban de la cuenta
     * @param saldo Saldo de la cuenta
     * @return Un objeto de tipo CuentaBancaria
     * 
     */
    public static CuentaBancaria of(String iban, double saldo) {
        return new CuentaBancaria(iban, saldo);
    }


    @Override
    public String toString() {
        return "Cuenta(" + iban + ", saldo=" + saldo + ")";
    }

    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria("iban1");
        CuentaBancaria cuentaBancaria2 = new CuentaBancaria("iban2", 100);

        System.out.println(cuentaBancaria1);
        System.out.println(cuentaBancaria2);

        CuentaBancaria cuentaBancaria3 = CuentaBancaria.of("iban3", 10);
        System.out.println(cuentaBancaria3);
    }
}

