package es.ies.puerto.repositories;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Usuario;

public class UsuarioListRepository implements IUsuarioRepository {
    
    List<Usuario> usuarios;

    public UsuarioListRepository(){
        usuarios = new ArrayList<>();
    }
    
    @Override
    public boolean guardar(Usuario usuario) {
        return usuarios.add(usuario);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return List.copyOf(usuarios);
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        return usuarios.remove(usuario);
    }
}
