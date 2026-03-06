/**
 * 
 * @author IvnMD
 * @date 04/03/26
 * @version 1.0.0
 * @brief Clase abstracta que define una persona
 * 
 */

package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;
import com.docencia.service.impl.*;
import com.docencia.util.Validaciones;

public class Usuario extends Persona {
    private final String email;
    private String password;
    private int intentosFallidos;
    private boolean bloqueado;
    private final LocalDate fechaRegistro;


    public Usuario(String email) {
        super(0);
        this.email = email;
        fechaRegistro = LocalDate.now();
    }

    public Usuario(String email, String password, int intentosFallidos) {
        this.email = email;
        this.password = password;
        this.intentosFallidos = intentosFallidos;
        this.bloqueado = false;
        this.fechaRegistro = LocalDate.now();
    }

    public Usuario(int id, String nombre, String email, String password) {
        super(id, nombre);
        if (!Validaciones.emailValido(email.trim().toLowerCase())) {
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
        setPassword(password);
        this.fechaRegistro = LocalDate.now();
    }

    public String getEmail() {
        return this.email;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIntentosFallidos() {
        return this.intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }



    @Override
    public String toString() {
        return "Usuario [getNombre()=" + getNombre() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
                + ", getIntentosFallidos()=" + getIntentosFallidos() + ", isBloqueado()=" + isBloqueado()
                + ", getFechaRegistro()=" + getFechaRegistro() + ", getClass()=" + getClass() + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


   
}
