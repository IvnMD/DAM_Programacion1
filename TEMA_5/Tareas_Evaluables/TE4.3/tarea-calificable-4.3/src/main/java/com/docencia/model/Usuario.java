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

    /**
     * Construtor por identificador unico
     * 
     * @param id unico de la persona que hereda usuario
     */
    public Usuario(int id) {
        super(id);
        email = null;
        fechaRegistro = null;

    }

    /**
     * Constructor por parametro final email (id unico de usuario)
     * 
     * @param email del usuario.
     */
    public Usuario(String email) {
        super(0);
        this.email = email;
        fechaRegistro = null;

    }

    /**
     * Constructor parametrico
     * 
     * @param id            unico de la persona que hereda usuario
     * @param email         del usuario.
     * @param fechaRegistro fecha de registro en la plataforma
     */
    public Usuario(int id, String email, LocalDate fechaRegistro) {
        super(id);
        if (!Validaciones.validacionEmail(email.trim().toLowerCase())) {
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
        this.fechaRegistro = LocalDate.now();
    }

    /**
     *  Constructor parametrico
     * @param id id del usuario
     * @param email
     * @param password
     */
    public Usuario(int id, String email, String password) {
        super(id);
        if (!Validaciones.validacionEmail(email.trim().toLowerCase())) {
            throw new IllegalArgumentException("Email no valido");
        }
        this.email = email;
        this.fechaRegistro = LocalDate.now();

    }
    /**
     * Constructor parametrico 
     * @param id
     * @param nombre
     * @param email
     * @param password
     */
    public Usuario(int id, String nombre, String email, String password) {
        super(id, nombre);
        if (!Validaciones.validacionEmail(email.trim().toLowerCase())) {
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
        if (!Validaciones.validacionPassword(password)) {
            throw new IllegalArgumentException("Password no valido");
        }
        this.password = password;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(email);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(email, other.email);
    }

    @Override
    public String toString() {
        return "Usuario [getNombre()=" + getNombre() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
                + ", getIntentosFallidos()=" + getIntentosFallidos() + ", isBloqueado()=" + isBloqueado()
                + ", getFechaRegistro()=" + getFechaRegistro() + ", getClass()=" + getClass() + "]";
    }

    

}
