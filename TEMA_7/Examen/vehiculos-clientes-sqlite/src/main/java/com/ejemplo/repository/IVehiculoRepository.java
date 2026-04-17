package com.ejemplo.repository;

import com.ejemplo.model.Vehiculo;
import java.util.List;

public interface IVehiculoRepository {

    /**
     * Funcion que crea un vehiculo en la base de datos
     * 
     * @param vehiculo a crear
     * @return true/false
     */
    boolean create(Vehiculo vehiculo);

    /**
     * Funcion que devuelve la lista con todos los vehiculos en la base de datos
     * 
     * @return Lista de todos los vehiculos
     */
    List<Vehiculo> findAll();

    /**
     * Funcion que busca un vehiculo por su id
     * 
     * @param id del vehiculo
     * @return true/false
     */
    Vehiculo findById(Long id);

    /**
     * Funcion que actualiza un vehiculo
     * 
     * @param vehiculo que se actualiza
     * @return true/false
     */
    boolean update(Vehiculo vehiculo);

    /**
     * Funcion que elimina un vehiculo
     * 
     * @param id del vehiculo a eliminar
     * @return true/false
     */
    boolean deleteById(Long id);
}
