package com.docencia.composicion.ejercicio7;

public class Estado {
    String valor;

    /**
     * 
     * @param valor valor del estado actual (Abierto/cerrado)
     */
    public Estado(String valor){
        if (valor == null || valor.isEmpty()){
            throw new IllegalArgumentException("");
        }
        if (!valor.equals("abierto") || !valor.equals("cerrado")){
            this.valor = valor.trim().toLowerCase();
        }
    }

}
