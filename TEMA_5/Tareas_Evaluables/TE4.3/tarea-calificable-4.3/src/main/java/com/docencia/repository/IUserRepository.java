package com.docencia.repository;

import com.docencia.model.Usuario;

public interface IUserRepository {
    /**
     * Funcion que realiza la busqueda de un usuario
     * @param email String con email normalizado
     * @return true/false
     */
    public Usuario findByEmail(String email);

    /**
     * Funcion que comprueba si existe un email
     * @param email String con el email normalizado
     * @return true/false
     */
    public boolean existsByEmail(String email);
}
