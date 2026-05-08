package es.ies.puerto.repositories;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Usuario;

public class UsuarioRepository implements IUsuarioRepository{

    @Override
    public boolean guardar(Usuario usuario) {
        return false;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>();
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}
