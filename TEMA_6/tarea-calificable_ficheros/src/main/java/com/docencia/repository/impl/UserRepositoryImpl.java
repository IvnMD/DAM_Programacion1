package com.docencia.repository.impl;

import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.file.FileCsv;
import com.docencia.util.Validaciones;
/**
 * @author IvnMD
 * @date 08/03/26
 * @version 1.0.0
 * @brief Implementación del repositorio de usuarios usando un HashSet en memoria
 */
public class UserRepositoryImpl extends FileCsv implements IUserRepository {
    final Set<Usuario> usuarios;


    /**
     * Construcotr que inicializa un set vacio
     */
    public UserRepositoryImpl() {
        super();
        usuarios = super.read();
    }

    @Override
    public Usuario findByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        if (!existsByEmail(email)) {
            return null;
        }

        Usuario usuarioBuscar = new Usuario((email));
        for (Usuario usuario : usuarios) {
            if (usuario.equals(usuarioBuscar)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        Usuario usuarioBuscar = new Usuario(email);
        return usuarios.contains(usuarioBuscar);
    }

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);
        this.write(usuario.toCSV());

    }


    @Override
    public Set<Usuario> findAll() {
        return usuarios;
    }

    @Override
    public boolean deleteByEmail(String email) {
        email = Validaciones.normalizarEmail(email);
        usuarios.remove(new Usuario(email));
        // usuarios contiene ahora la lista actualizada
        this.delete();
        for (Usuario usuario : usuarios) {
            this.write(usuario.toCSV());
        }
        return true;

    }

    public boolean update(Usuario usuarioUpdate){
        usuarios.remove(usuarioUpdate);
        usuarios.add(usuarioUpdate);

              this.delete();
        for (Usuario usuario : usuarios) {
            this.write(usuario.toCSV());
        }
        return true;
    }
}
