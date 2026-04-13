package com.docencia.ficheros.model;

import java.util.Objects;

public class Hotel {
    private int id;
    private String nombre;
    private double precioNoche;

    public Hotel() {}

    public Hotel(int id, String nombre, double precioNoche) {
        this.id = id;
        this.nombre = nombre;
        this.precioNoche = precioNoche;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecioNoche() { return precioNoche; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel hotel)) return false;
        return id == hotel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
