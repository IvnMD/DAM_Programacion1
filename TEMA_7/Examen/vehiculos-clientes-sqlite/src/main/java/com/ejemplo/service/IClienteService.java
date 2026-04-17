package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import java.util.List;

/**
 * API de servicios para la gestion de clientes.
 */
public interface IClienteService {
    /**
     * Clase que crea un cliente
     * 
     * @param cliente que se crea
     * @return true/false
     */
    boolean crear(Cliente cliente);

    /**
     * Funcion que busca un dni
     * 
     * @param dni del cliente
     * @return true/false
     */
    Cliente buscarPorDni(String dni);

    /**
     * Funcion que lista todos los clientes
     * 
     * @return lista de todos los clientes
     */
    List<Cliente> listarTodos();

    /**
     * Funcion que actualiza un cliente
     * 
     * @param cliente que se actualiza
     * @return true/false
     */
    boolean actualizar(Cliente cliente);

    /**
     * Funcion que elimina un cliente
     * 
     * @param dni del cliente a eliminar
     * @return true/false
     */
    boolean eliminar(String dni);

    /**
     * Funcion que lista los clientes activos
     * 
     * @return Lista de los clientes activos
     */
    List<Cliente> listarActivos();

    /**
     * Funcion que busca a los clientes por ciudad
     * 
     * @param ciudad del cliente
     * @return Lista de los clientes que pertecenes a esa ciudad
     */
    List<Cliente> buscarPorCiudad(String ciudad);

    /**
     * Funcion que cuenta clientes activos
     * 
     * @return numero total de clientes activos
     */
    int contarActivos();
}
