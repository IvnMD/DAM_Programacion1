package com.docencia.clases.ejercicio10;

import java.util.Objects;

public class Mascota {
    private String chip;
    private String nombre;
    private String tipo;

    public Mascota() {
    }

    public Mascota(String chip) {
        setChip(chip);
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        if(chip == null || chip.isBlank()){
            throw new IllegalArgumentException();
        }
        this.chip = chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.chip);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mascota other = (Mascota) obj;
        return Objects.equals(this.chip, other.chip);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mascota{");
        sb.append("chip=").append(chip);
        sb.append(", nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }


}
