package com.docencia.service.impl;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IAuthService;
import com.docencia.util.Validaciones;

/**
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Implementacion del servicio de autenticacion de los usuarios
 */
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
        email = Validaciones.normalizarEmail(email);
        Validaciones.validarPassword(password);

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        return usuario;
    }

    @Override
    public boolean login(String email, String password) {
        if (!Validaciones.emailValido(email))
            return false;
        email = Validaciones.normalizarEmail(email);

        Usuario usuario = userRepository.findByEmail(email);

        if (usuario == null) {
            return false;
        }
        if (usuario.isBloqueado()) {
            return false;
        }
        for (int i = 0; i <= 3; i++) {
            if (usuario.getPassword().equals(password)) {
                usuario.resetearIntentosFallidos();
                return true;
            } else {
                usuario.incrementarIntentosFallidos();
                if (usuario.getIntentosFallidos() == 3) {
                    usuario.setBloqueado(true);
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isBloqueado(String email) {
        if (!Validaciones.emailValido(email))
            return false;
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        return usuario != null && usuario.isBloqueado();
    }

    @Override
    public void desbloquear(String email) {
        if (!Validaciones.emailValido(email)) {
            throw new IllegalArgumentException("Email no valido");
        }
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        usuario.setBloqueado(false);
        usuario.resetearIntentosFallidos();
    }

    @Override
    public boolean validacionEmail(String email) {
        return Validaciones.emailValido(email);
    }

}
