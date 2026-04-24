package com.ejemplo.service;

import com.ejemplo.model.Employee;
import java.util.List;

public interface IEmployeeService {

    /**
     * Crea un nuevo empleado validando que los datos sean correctos.
     * El empleado debe tener id, name, surname, startDate y rolId.
     * No se permiten duplicados por identificador.
     */
    boolean crear(Employee employee);

    /**
     * Busca y devuelve un empleado por su identificador único.
     * Si el identificador es null devuelve null.
     */
    Employee buscarPorId(Integer id);

    /**
     * Lista y devuelve todos los empleados registrados en el sistema.
     */
    List<Employee> listarTodos();

    /**
     * Actualiza los datos de un empleado existente.
     * El empleado debe existir previamente en el sistema.
     */
    boolean actualizar(Employee employee);

    /**
     * Elimina un empleado del sistema por su identificador.
     * Si el id es null o el empleado no existe devuelve false.
     */
    boolean eliminar(Integer id);

    /**
     * Lista los empleados que pertenecen a un determinado rol.
     * Si rolId es null devuelve lista vacía.
     */
    List<Employee> listarPorRol(Integer rolId);

    /**
     * Lista los empleados que ejercen como managers de otros empleados.
     * Un manager es aquel cuyo id aparece en el campo reportsTo de otro empleado.
     */
    List<Employee> listarManagers();

    /**
     * Cambia el manager de un empleado asignando un nuevo manager existente.
     * No se permite asignar al propio empleado como su manager.
     */
    boolean cambiarManager(Integer employeeId, Integer managerId);

    /**
     * Cuenta el número de subordinados directos de un manager.
     * Si managerId es null devuelve 0.
     */
    int contarSubordinados(Integer managerId);

    /**
     * Busca empleados cuyo apellido coincida con el valor indicado.
     * La búsqueda ignora mayúsculas y aplica trim al apellido buscado.
     */
    List<Employee> buscarPorApellido(String surname);
}