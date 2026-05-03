package com.ejemplo.model;

import java.time.LocalDate;

public class Alquiler {
    private Integer id;
    private String dniCliente;
    private Integer idVehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public Alquiler(Integer id, String dniCliente, Integer idVehiculo, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.id = id;
        this.dniCliente = dniCliente;
        this.idVehiculo = idVehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }
    public Integer getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(Integer idVehiculo) { this.idVehiculo = idVehiculo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
