package com.docencia.herencia.ejercicio8;

import java.util.UUID;

public class PagoEfectivo extends Pago {

    private boolean entregado;


    public PagoEfectivo(UUID id, double importe, boolean entregado) {
        super(id, importe);
        setEntregado(entregado);
    }

    public Boolean getEntregado() { return entregado; }

    @Override
    public boolean requiereValidacion() {
        return false;
    }

    

    @Override
    public String toString() {
        return "PagoEfectivo [entregado=" + entregado + ", id=" + getId() + ", importe=" + getImporte() + "]";
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    


}
