package es.ies.puerto.services;

import java.util.List;

import es.ies.puerto.models.Usuario;

public interface IUsuarioService {
    /**
     * Funcion que guarda un usuario
     * 
     * @param usuario que se guarda
     * @return true / false
     */
    boolean guardar(Usuario usuario);

    /**
     * Listar todos los usuarios
     * 
     * @return lista de todos los usuarios
     */
    List<Usuario> obtenerTodos();

    /**
     * Funcion que crea un usuario
     * 
     * @param nombre el usuario
     * @param edad   del usuario
     * @return true / false
     */
    Usuario crearUsuario(String nombre, int edad);

    /**
     * Funcion que elimina un usuario
     * @param usuario que se va a eliminar
     * @return true / false 
     */
    boolean eliminar (Usuario usuario);
}
