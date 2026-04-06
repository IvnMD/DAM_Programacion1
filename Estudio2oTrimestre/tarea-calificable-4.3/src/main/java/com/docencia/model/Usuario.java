package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

import com.docencia.util.Validaciones;

public class Usuario extends Persona{
    private final String email;
    private String password;
    private int intentosFallidos;
    private boolean bloqueado;
    private final LocalDate fechaRegistro;

    public Usuario(){
        super();
        this.email="";
        fechaRegistro = LocalDate.now();
    }

    public Usuario(String email){
        super();
        this.email=email;
        fechaRegistro = LocalDate.now();
    }

    public Usuario (String email, String password, int intentosFallidos, boolean bloqueado, 
           LocalDate fechaRegistro){
        super();
        this.email = email;
        setPassword(password);
        setIntentosFallidos(intentosFallidos);
        this.bloqueado = false;
        this.fechaRegistro = LocalDate.now();
        
    }

    /**
     * Constructor parametrico
     * 
     * @param id       de la persona (identificador unico de la clase padre)
     * @param email    del usuario (identificador unico de esta clase)
     * @param nombre   de la persona
     * @param password contrasenya del usuario
     */
    public Usuario(int id, String email, String nombre, String password) {
        super(id, nombre);
        if (!Validaciones.emailValido(email.trim().toLowerCase())) {
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
        setPassword(password);
        this.fechaRegistro = LocalDate.now();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isBlank()){
            throw new IllegalArgumentException("Password invalido");
        }
        Validaciones.validarPassword(password);
        this.password = password;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }
    
    public void inscrementarIntentosFallidos(int intentosFallidos){
        this.intentosFallidos++;
    }

    public void resetearIntentosFallidos(int intentosFallidos){
        this.intentosFallidos = 0;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void bloquear(boolean bloqueado){
        this.bloqueado = true;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", password=" + password + ", intentosFallidos=" + intentosFallidos
                + ", bloqueado=" + bloqueado + ", fechaRegistro=" + fechaRegistro + "]";
    }

    
        
}
