package com.docencia.herencia.ejercicio7;

import java.util.UUID;

public class Telefono extends Dispositivo {

    private String numero;

    public Telefono(UUID id, String fabricante, String numero) {
        super(id, fabricante);
        setNumero(numero);
}

    public String getNumero() { return numero; }

    

    @Override
    public String tipo() {
        return "Telefono";
    }

    

    @Override
    public String toString() {
        return "Telefono [getNumero()=" + getNumero() + ", id=" + getId() + "]";
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isBlank()){
            throw new IllegalArgumentException();
        }
        this.numero = numero;
    }
}
