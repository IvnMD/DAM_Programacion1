package com.docencia.service.impl;

import java.util.Optional;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.service.IUserService;
import com.docencia.util.validaciones.Validaciones;

public class UserServiceImp implements IUserService{

    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
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
