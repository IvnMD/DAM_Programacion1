package com.ejemplo.service;

import com.ejemplo.model.Skill;
import java.util.List;

public interface ISkillService {

    /**
     * Crea una nueva skill validando que los datos sean correctos.
     * No se permiten nombres duplicados ni skill sin categoria existente.
     */
    boolean crear(Skill skill);

    /**
     * Busca y devuelve una skill por su identificador único.
     * Si el identificador es null devuelve null.
     */
    Skill buscarPorId(Integer id);

    /**
     * Lista y devuelve todas las skills registradas en el sistema.
     */
    List<Skill> listarTodas();

    /**
     * Actualiza los datos de una skill existente.
     * No se permiten nombres duplicados al actualizar la skill.
     */
    boolean actualizar(Skill skill);

    /**
     * Elimina una skill del sistema por su identificador.
     * No se puede eliminar una skill que esté asignada a un empleado.
     */
    boolean eliminar(Integer id);

    /**
     * Lista las skills que pertenecen a una determinada categoria.
     * Si categoryId es null devuelve lista vacía.
     */
    List<Skill> listarPorCategoria(Integer categoryId);

    /**
     * Asigna una skill a un empleado con un nivel determinado.
     * Tanto el empleado como la skill deben existir previamente.
     */
    boolean asignarEmpleado(Integer employeeId, Integer skillId, String levelId);

    /**
     * Lista las skills asignadas a un empleado concreto.
     * Si el empleado es null devuelve lista vacía.
     */
    List<Skill> listarPorEmpleado(Integer employeeId);

    /**
     * Cuenta el número de empleados que tienen asignada una skill concreta.
     * Si skillId es null devuelve 0.
     */
    int contarEmpleadosConSkill(Integer skillId);

    /**
     * Lista las skills que no han sido asignadas a ningún empleado.
     * Una skill sin asignar no aparece en la tabla employee_skill.
     */
    List<Skill> listarSinAsignar();
}