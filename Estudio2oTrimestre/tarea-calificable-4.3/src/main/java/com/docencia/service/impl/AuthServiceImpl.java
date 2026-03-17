package com.docencia.service.impl;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IAuthService;
import com.docencia.util.Validaciones;

public class AuthServiceImpl implements IAuthService{

        final IUserRepository userRepository;

    /**
     * Constructor que introduce el repositorio de usuarios
     * 
     * @param userRepository repositorio usado para persistir y consultar usuarios
     */
    public AuthServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario register(int id, String nombre, String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public boolean login(String email, String password) {
        if (!Validaciones.emailValido(email)){
            return false;
        }

        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        
        if (usuario == null){
            return false;
        }
        if (usuario.isBloqueado()){
            return false;
        }
        if(usuario.getPassword().equals(password)){
            usuario.resetearIntentosFallidos(0);
            userRepository.save(usuario);
        }

    }

    @Override
    public boolean isBloqueado(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBloqueado'");
    }

    @Override
    public void desbloquear(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desbloquear'");
    }

}
