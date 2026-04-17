package com.ejemplo.service;

import com.ejemplo.model.Vehiculo;
import java.util.List;


public interface IVehiculoService {

    /**
     * Funcion que crea un vehiculo en la base de datos
     * 
     * @param vehiculo a crear
     * @return true/false
     */
    boolean crear(Vehiculo vehiculo);

    /**
     * Funcion que busca un vehiculo por su id
     * 
     * @param id del vehiculo
     * @return true/false
     */
    Vehiculo buscarPorId(Long id);

    /**
     * Funcion que devuelve la lista con todos los vehiculos en la base de datos
     * 
     * @return Lista de todos los vehiculos
     */
    List<Vehiculo> listarTodos();

    /**
     * Funcion que actualiza un vehiculo
     * 
     * @param vehiculo que se actualiza
     * @return true/false
     */
    boolean actualizar(Vehiculo vehiculo);

    /**
     * Funcion que elimina un vehiculo
     * 
     * @param id del vehiculo a eliminar
     * @return true/false
     */
    boolean eliminar(Long id);

    /**
     * Funcion que lista los vehiculos por su cliente 
     * 
     * @param dni del propietario del vehiculo
     * @return Lista de los vehiculos por cliente
     */
    List<Vehiculo> listarPorCliente(String dni);

    /**
     * funcion que lista los vehiculos vendidos
     * @return Lista de los vehiculos vendidos
     */
    List<Vehiculo> listarVendidos();

    /**
     * Funcion que lista los vehiculos disponibles
     * @return Lista de los vehiculos disponibles
     */
    List<Vehiculo> listarDisponibles();

    /**
     * Funcion que cambia el propietario de un vehiculo
     * @param vehiculoId que va a cambiar de propietario
     * @param nuevoDni dni del propietario
     * @return true/false
     */
    boolean cambiarPropietario(Long vehiculoId, String nuevoDni);

    /**
     * Funcion que marca un vehiculo como vendido
     * @param vehiculoId vendido
     * @return true/false
     */
    boolean marcarComoVendido(Long vehiculoId);

    /**
     * Funcion que actualiza los kilometos del vehiculo
     * @param vehiculoId vehiculo que actualiza sus kilometros
     * @param kilometros del vehiculo
     * @return true/false
     */
    boolean actualizarKilometros(Long vehiculoId, int kilometros);

    /**
     * Funcion que calcula el precio medio de los vehiculos
     * @return precio medio de los vehiculos
     */
    double calcularPrecioMedio();

    /**
     * Funcion que calcula el valor total de los vehiculos disponibles
     * @return valor total de los vehiculos disponibles
     */
    public double calcularValorTotalDisponible();

    /**
     * Funcion que cuenta el numero de vehiculos de un cliente
     * @param dniCliente propietario de los vehiculos
     * @return numero total de vehiculos de ese cliente
     */
    public int contarVehiculosDeCliente(String dniCliente);
}
