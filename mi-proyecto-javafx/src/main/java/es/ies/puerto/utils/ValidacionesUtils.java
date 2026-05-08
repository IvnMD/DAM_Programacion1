package es.ies.puerto.utils;

import es.ies.puerto.models.Usuario;

public class ValidacionesUtils {

    public static boolean validarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getNombre() == null || usuario.getNombre().isEmpty() || usuario.getEdad() < 18) {
            return false;
        }
        return true;
    }
}
