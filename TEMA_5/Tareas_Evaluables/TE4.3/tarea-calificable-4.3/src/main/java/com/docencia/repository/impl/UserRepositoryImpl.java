package com.docencia.repository.impl;

import java.util.*;
import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;

import javax.print.attribute.HashAttributeSet;

public class UserRepositoryImpl implements IUserRepository{
    final Set<Usuario> usuarios;

    public UserRepositoryImpl(){
        usuarios = new HashSet<>();
    }

    @Override
    public Usuario findByEmail(String email) {
       if (!existsByEmail(email)){
        return null;
       }
    
       Usuario usuarioBuscar = new Usuario((email));
       for (Usuario usuario : usuarios) {
            if(usuario.equals(usuarioBuscar)){
                return usuario;
            }
       }
       return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        Usuario usuarioBuscar = new Usuario(email);
        return usuarios.contains(usuarioBuscar);
        }

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);
        
    }

    /**
     * Funcion que retorna todos los elementos del repositorio
     * @set<usuarios>
     */
    @Override
    public Set<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public boolean deleteByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleByEmail'");
    }


}
