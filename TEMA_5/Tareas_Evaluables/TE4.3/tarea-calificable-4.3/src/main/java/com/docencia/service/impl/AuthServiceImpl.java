package com.docencia.service.impl;

import java.util.regex.Pattern;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.impl.UserRepositoryImpl;
import com.docencia.service.IAuthService;

public class AuthServiceImpl implements IAuthService{

    final IUserRepository = userRepository;

    public AuthServiceImpl(){
        this.userRepository = new UserRepositoryImpl();
    }


    // public static boolean validacionDocumento(String documento) {
    //     String patron = "^([0-9]{8}[a-z]|[0-9]{8}-[a-z]|[a-z][0-9]{7}[a-z])$"; // ! DNI = 8 nums + letra y NIE = letra +
    //                                                                            // 7 nums + letra
    //     return Pattern.matches(patron, documento);

    // }


    @Override
    public Usuario register(int id, String nombre, String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public boolean login(String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
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


