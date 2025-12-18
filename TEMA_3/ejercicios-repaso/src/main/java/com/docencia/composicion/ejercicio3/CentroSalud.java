package com.docencia.composicion.ejercicio3;


import java.util.ArrayList;
import java.util.List;


public class CentroSalud {
    private final List<Consulta> consultas = new ArrayList<>();

    public void registrarConsulta(Paciente paciente, String motivo) {
        if (paciente == null || motivo.isBlank()) {
            return;
        }
            consultas.add(new Consulta(paciente, motivo.trim()));
    }

    public int contarConsultasDe(String nombrePaciente) {
        if(nombrePaciente == null || nombrePaciente.isBlank()){
            return 0;
        }
        
        int resultado = 0;
        nombrePaciente = nombrePaciente.trim().toLowerCase();
        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            Paciente pacienteBuscar = new Paciente(nombrePaciente);
            if (nombrePaciente.equals(paciente.getNombre())){
                resultado = resultado +1;
            }
        }
        return resultado;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
