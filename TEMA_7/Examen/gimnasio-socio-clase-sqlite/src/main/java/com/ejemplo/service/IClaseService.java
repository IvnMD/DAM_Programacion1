package com.ejemplo.service;

import com.ejemplo.model.Clase;
import com.ejemplo.model.ClaseMonitor;
import com.ejemplo.model.ClaseReservaSocio;

import java.util.List;

public interface IClaseService {
    /**
     * Funcion que crea un usuario
     * @param clase a crear
     * @return true / false 
     */
    boolean create(Clase clase);

    /**
     * Funcion que busca una clase por su id
     * @param Id de la clase a buscar
     * @return clase si existe / null si no
     */
    Clase findById(Integer id);
    /**
     * Funcion que lista todas las clases
     */
    List<Clase> findAll();
    /**
     * Funcion que actualiza los atributos de una clase
     * @param clase que se va a actulizar
     */

    //! List<ClaseMonitor> findAllCM();


    boolean update(Clase clase);
    /**
     * Funcion que elimina una clase por su id
     * 
     */
    boolean deleteById(Integer id);
    /**
     * Funcion que lista las clases con plazas disponibles
     */
    List<Clase> findDisponibles();
    /**
     * Funcion que lista las clases por su tipo
     */
    List<Clase> findByTipo(String tipo);
    /**
     * Funcion que lista las clases por el id de su monitor
     */
    List<Clase> findByMonitor(Integer idMonitor);
    /**
     * Funcion que lista las clases con monitor asignado
     */
    List<ClaseMonitor> findClasesConMonitor();
    /**
     * Funcion que relaciona las reservas con los socios
     */
    List<ClaseReservaSocio> findReservasConSocio();
}
