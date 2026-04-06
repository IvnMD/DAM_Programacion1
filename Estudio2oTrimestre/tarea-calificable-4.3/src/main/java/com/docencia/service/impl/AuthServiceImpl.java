package com.docencia.service.impl;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IAuthService;
import com.docencia.util.Validaciones;

public class AuthServiceImpl implements IAuthService {

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
        if (id < 1 || !Validaciones.emailValido(email) || !Validaciones.passwordValida(password)) {
            return null;
        }

        Validaciones.validarPassword(password);
        email = Validaciones.normalizarEmail(email);

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Usuario ya registrado");
        }
        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        return usuario;
    }

    @Override
    public boolean login(String email, String password) {
        if (!Validaciones.emailValido(email)) {
            return false;
        }

        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);

        if (usuario == null) {
            return false;
        }
        if (usuario.isBloqueado()) {
            return false;
        }
        if (usuario.getPassword().equals(password)) {
            usuario.resetearIntentosFallidos(0);
            userRepository.save(usuario);
            return true;
        } else {
            usuario.inscrementarIntentosFallidos(0);
            userRepository.save(usuario);
            if (usuario.getIntentosFallidos() >= 3) {
                usuario.setBloqueado(true);
                System.out.println("Usuario bloqueado");
            }
            return false;
        }

    }

    @Override
    public boolean isBloqueado(String email) {
        if(!Validaciones.emailValido(email)){
            return false;
        }
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        return usuario != null && usuario.isBloqueado();
        
    }

    @Override
    public void desbloquear(String email) {
        if(!Validaciones.emailValido(email)){
            throw new IllegalArgumentException("Email no valido");
        }
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        if(usuario == null){
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        usuario.setBloqueado(false);
        usuario.resetearIntentosFallidos(0);
        userRepository.save(usuario);
        
    }


    @Override
    public boolean validacionEmail(String email) {
        return Validaciones.emailValido(email);
    }

}
