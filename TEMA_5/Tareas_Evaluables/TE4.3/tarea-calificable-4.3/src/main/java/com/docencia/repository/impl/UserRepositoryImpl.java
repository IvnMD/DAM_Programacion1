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
        if (usuarios.contains(usuarioBuscar)){
            return true;
        }
        return false;
        }


}
