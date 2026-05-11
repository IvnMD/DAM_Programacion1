package com.docencia.ficheros.model;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre;

    public Cliente() {
    }

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Cliente cliente))
            return false;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
