package com.docencia.examen.listas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.docencia.examen.clases.Usuario;

//TODO: Completar clase GestorUsuarios con las funciones necesarias, y documenta la clase.
public class GestorUsuarios {

    // Lista interna donde guardamos los usuarios
    private List<Usuario> usuarios = new ArrayList<>();

    //TODO: agrega un usuario a la lista
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    //TODO: devuelve el numero de usuarios en la lista
    public int numeroUsuarios() {
        int contador = 0;
        for (Usuario usuario : usuarios) {
            contador++;
        }
       return contador;
    }

    //TODO: indica si la lista está vacía
    public boolean estaVacia() {
        if(usuarios == null || usuarios.isEmpty()){
        return true;
        }
        return false;
    }


    //TODO: indica si la lista contiene un usuario (usa equals de Usuario)
    public boolean contieneUsuario(Usuario usuario) {
        for (Usuario usuario : usuarios) {
            if(usuario.equals(usuario){

            }
        }
        return false;
    }


    public Usuario obtenerPorPosicion(int indice) {
        
        return null; 
    }

    //TODO: busca un usuario por su identificador y lo devuelve (o null si no lo encuentra)
    public Usuario buscarPorIdentificador(String id) {
        
        return null;
    }

    //TODO: elimina un usuario por su identificador, devuelve true si lo ha eliminado,
    // false si no lo ha encontrado
    public boolean eliminarPorIdentificador(String id) {
        return false;
    }


    //TODO: limpia la lista de usuarios
    public void limpiar() {
        GestorUsuarios.removeAll(usuarios);
    }

    

    public static void main(String[] args) {
       
    }
}
