package com.docencia.service;

import com.docencia.model.Usuario;
import com.docencia.util.Validaciones;

public interface IAuthService {
    public boolean validacionEmail(String email);

    /**
     * Funcion que permite registrar un usuario dentro del sistema
     * @param id unico de la persona
     * @param nombre nombre de la persona
     * @param email del usuario
     * @param password del usuario
     * @return Usuario dentro del sistema
     */
    Usuario register(int id, String nombre, String email, String password);

    boolean login(String email, String password);

    // opcionales (pero implementados)
    boolean isBloqueado(String email);

    void desbloquear(String email);

}
