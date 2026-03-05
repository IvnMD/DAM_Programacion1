package com.docencia.service;

import com.docencia.model.Usuario;

public interface IAuthService {
    public static boolean validacionEmail(String email);

    Usuario register(int id, String nombre, String email, String password);

    boolean login(String email, String password);

    // opcionales (pero implementados)
    boolean isBloqueado(String email);

    void desbloquear(String email);

}
