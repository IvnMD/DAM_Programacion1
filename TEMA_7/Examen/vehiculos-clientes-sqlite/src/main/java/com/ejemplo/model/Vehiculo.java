package com.ejemplo.model;

import java.util.Objects;

public class Vehiculo {

    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private Integer anio;
    private Integer kilometros;
    private Double precio;
    private boolean vendido;
    private String dniCliente;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String matricula, String marca, String modelo, String color,
                    Integer anio, Integer kilometros, Double precio, boolean vendido, String dniCliente) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.kilometros = kilometros;
        this.precio = precio;
        this.vendido = vendido;
        this.dniCliente = dniCliente;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public Integer getKilometros() { return kilometros; }
    public void setKilometros(Integer kilometros) { this.kilometros = kilometros; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public boolean isVendido() { return vendido; }
    public void setVendido(boolean vendido) { this.vendido = vendido; }
    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", anio=" + anio +
                ", kilometros=" + kilometros +
                ", precio=" + precio +
                ", vendido=" + vendido +
                ", dniCliente='" + dniCliente + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
