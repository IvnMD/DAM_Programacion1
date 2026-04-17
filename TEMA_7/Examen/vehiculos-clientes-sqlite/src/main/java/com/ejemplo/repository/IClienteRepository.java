package com.ejemplo.repository;

import com.ejemplo.model.Cliente;
import java.util.List;

public interface IClienteRepository {
    /**
     * Crea un nuevo cliente en la base de datos.
     * @param cliente cliente a crear
     * @return true si se creo correctamente,  
     */
    boolean create(Cliente cliente);

    /**
     * Funcion que devuelve la lista con todos los clientes en la base de datos
     * @return Lista de todos los clientes
     */
    List<Cliente> findAll();

      /**
     * Funcion que busca un dni
     * 
     * @param dni del cliente
     * @return true/false
     */
    Cliente findById(String dni);

    /**
     * Funcion que actualiza un cliente
     * 
     * @param cliente que se actualiza
     * @return true/false
     */
    boolean update(Cliente cliente);
    
    /**
     * Funcion que elimina un cliente
     * 
     * @param dni del cliente a eliminar
     * @return true/false
     */
    boolean deleteById(String dni);
}
