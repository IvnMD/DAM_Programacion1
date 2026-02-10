package com.docencia.ejercicio.clases.tres;

import java.util.Objects;

/**
 * Clase CuentaBancaria
 * @author Ivan Mesa Dominguez
 * @since 24/10/25
 * @version 1.0
 * @brief Declaracion de la clase Cuenta Bancaria
 */

public class CuentaBancaria {
    private String titular;
    private String numero;
    private double saldo;

    /**
     * constructor vacio
     */
    public CuentaBancaria() {};

    /**
     * Constructor por paramatros si la cuenta se crea sin saldo inicial
     * @param titular Titular de la cuenta bancaria
     * @param numero Numero de cuenta
     */
    public CuentaBancaria(String titular, String numero){
        this.titular = titular;
        this.numero = numero;
    }
    /**
     * Constructor por parametros
     * @param titular Titular de la cuenta bancaria
     * @param numero Numero de cuenta
     * @param saldo Saldo de la cuenta
     */
    public CuentaBancaria(String titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;

    }

    /**
     * Getters y Setters de los atributos
     * 
     */
    public String getTitular() { return titular; }
    public void setTitular(String titular) {
        
        this.titular = titular;
    }
    public String getNumero() { return numero; }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    /**
     * Metodo toString() para poder imprimir el contenido de las clases y no su direccion de memoria. 
     */
    @Override
    public String toString() {
        return getNumero() + " - " + getTitular() +
            " - saldo=" + getSaldo();
    }
    /**
     * Metodo equals para comparar entre instancias de la clase
     */

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria cuentaBancaria = (CuentaBancaria) o;
        return Objects.equals(numero.toLowerCase(), cuentaBancaria.numero.toLowerCase());
    }
    /**
     * Metodo hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(numero.toLowerCase());
    }


}

