package com.docencia.herencia.ejercicio10;

import java.util.UUID;

public class Contrato extends Documento {

    private String partes;

    public Contrato(UUID id, String titulo, String partes) {
        super(id, titulo);
        setPartes(partes);
    }
    
    public String getPartes() { return partes; }

    @Override
    public String tipo() {
        return "Contrato";
    }

    
    @Override
    public String toString() {
        return "Contrato [partes=" + partes + ", id=" + getId() + "]";
    }

    public void setPartes(String partes) {
        if(partes != null && !partes.isEmpty())
            this.partes = partes;
    }

    
}
