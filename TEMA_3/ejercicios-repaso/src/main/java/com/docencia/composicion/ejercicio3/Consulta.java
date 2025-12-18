package com.docencia.composicion.ejercicio3;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena una consulta
 */
public class Consulta {
    private final Paciente paciente;
    private final String motivo;


    /**
     * Constructor paramatrico de la clase consulta
     * @param paciente de la consulta
     * @param motivo de la consulta
     */
    public Consulta(Paciente paciente, String motivo) {
        this.paciente = paciente;
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getMotivo() {
        return motivo;
    }
}
