package com.docencia.repository;

import com.docencia.model.Usuario;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

 

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
    
    /**
     * Funcion que guarda un usuario
     * @param usuario a guardar
     */
    public void save(Usuario usuario);

    /**
     * Funcion que lista todos los usuarios
     * @return Lista de todos los usuarios
     */
    public java.util.Set<Usuario> findAll();


    /**
     * Funcion que elimina un usuario buscando por su email
     * @param email del usuario a eliminar
     * @return
     */
    public boolean deleByEmail(String email);

    
        
    
}
