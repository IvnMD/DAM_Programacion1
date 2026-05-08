package es.ies.puerto.repositories;

import java.util.List;

import es.ies.puerto.models.Usuario;

public interface IUsuarioRepository {

    /**
     * Funcion que guarda un usuario
     * 
     * @param usuario que se guarda
     * @return true / false
     */
    public boolean guardar(Usuario usuario);

    /**
     * Listar todos los usuarios
     * 
     * @return lista de todos los usuarios
     */
    public List<Usuario> obtenerTodos();

    /**
     * Funcion que elimina un usuario
     * 
     * @param usuario que se va a eliminar
     * @return true / false
     */
    public boolean eliminar(Usuario usuario);
}
