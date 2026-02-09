package com.docencia.herencia.ejercicio8;

import java.util.UUID;

public class PagoTarjeta extends Pago {

    private String ultimos4;

    public PagoTarjeta(UUID id, double importe, String ultimos4) {
        super(id, importe);
        setUltimos4(ultimos4);
    }

    public String getUltimos4() { return ultimos4; }

    

    @Override
    public boolean requiereValidacion() {
        return true;
    }

    


    @Override
    public String toString() {
        return "PagoTarjeta [getUltimos4()=" + getUltimos4() + ", id=" + getId() + "]";
    }

    public void setUltimos4(String ultimos4) {
        if (ultimos4 == null || ultimos4.isBlank()){
            throw new IllegalArgumentException();
        }
        this.ultimos4 = ultimos4;
    }
}
