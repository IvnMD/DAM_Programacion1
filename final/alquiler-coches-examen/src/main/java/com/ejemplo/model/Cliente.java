package com.ejemplo.model;

public class Cliente extends Persona {
    private int activo;

    public Cliente(String dni, String nombre, String telefono, String email, int activo) {
        super(dni, nombre, telefono, email);
        this.activo = activo;
    }

    
    public int getActivo() { return activo; }
    public void setActivo(int activo) { this.activo = activo; }
    public boolean isActivo() { return activo == 1; }
}
