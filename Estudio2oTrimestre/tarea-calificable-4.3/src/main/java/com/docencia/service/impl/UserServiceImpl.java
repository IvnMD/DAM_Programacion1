package com.docencia.service.impl;

import java.util.Optional;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IUserService;
import com.docencia.util.Validaciones;

public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    public UserServiceImpl (IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        if (id < 1)
            throw new IllegalArgumentException("Id invalido");
        Validaciones.validarEmail(email);
        Validaciones.validarPassword(password);
        email = Validaciones.normalizarEmail(email);

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        return usuario;
    }

    @Override
    public Set<Usuario> listarUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarUsuarios'");
    }

    @Override
    public Set<Usuario> buscarPorEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        if (!)
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorEmail'");
    }

    @Override
    public boolean eliminarPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorEmail'");
    }

    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarNombre'");
    }

    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarPassword'");
    }

}
