package es.ies.puerto.services;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.IUsuarioRepository;
import es.ies.puerto.repositories.UsuarioListRepository;
import es.ies.puerto.utils.Utils;
import es.ies.puerto.utils.ValidacionesUtils;

public class UsuarioService extends Utils implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(){
        this.usuarioRepository = new UsuarioListRepository();
    }

        @Override
    public boolean guardar(Usuario usuario) {
        if (!validarUsuario(usuario)){
            return false;
        }
        return usuarioRepository.guardar(usuario);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.obtenerTodos();
    }

    @Override
    public Usuario crearUsuario(String nombre, int edad) {
        Usuario usuario = new Usuario(nombre, edad);
        if (guardar(usuario)){
            return usuario;
        }
        return null;

    }

    @Override
    public boolean eliminar(Usuario usuario) {
        return usuarioRepository.eliminar(usuario);
        
    }
}
