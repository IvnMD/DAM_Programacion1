package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.repository.IEmployeeRepository;
import com.ejemplo.repository.sqlite.EmployeeSqliteRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeSqliteRepository();
    }

    @Override
    public boolean crear(Employee employee) {
        if (!Utils.validEmployee(employee))
            return false;
        if (buscarPorId(employee.getId()) != null)
            return false;
        if (employee.getReportsTo() != null && employee.getReportsTo().equals(employee.getId()))
            return false;

        employee.setName(employee.getName().trim());
        employee.setSurname(employee.getSurname().trim());
        if (employee.getStartDate() != null) {
            employee.setStartDate(employee.getStartDate().trim());
        }
        return repository.create(employee);
    }

    @Override
    public Employee buscarPorId(Integer id) {
        if (id == null)
            return null;
        return repository.findById(id);
    }

    @Override
    public List<Employee> listarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean actualizar(Employee employee) {
        if (!Utils.validEmployee(employee))
            return false;
        if (buscarPorId(employee.getId()) == null)
            return false;
        if (employee.getReportsTo() != null && employee.getReportsTo().equals(employee.getId()))
            return false;
        employee.setName(employee.getName().trim());
        employee.setSurname(employee.getSurname().trim());
        if (employee.getStartDate() != null)
            employee.setStartDate(employee.getStartDate().trim());
        return repository.update(employee);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (id == null) {
            return false;
        }
        if (buscarPorId(id) == null) {
            return false;
        }
        return repository.deleteById(id);
    }

    @Override
    public List<Employee> listarPorRol(Integer rolId) {
        if (rolId == null)
            return new ArrayList<>();
        List<Employee> todos = repository.findAll();
        List<Employee> resultado = new ArrayList<>();
        for (Employee e : todos) {
            if (rolId.equals(e.getRolId())) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    @Override
    public List<Employee> listarManagers() {
        List<Employee> todos = repository.findAll();
        // Primero recogemos todos los IDs que aparecen como reportsTo
        List<Integer> managerIds = new ArrayList<>();
        for (Employee e : todos) {
            if (e.getReportsTo() != null && !managerIds.contains(e.getReportsTo())) {
                managerIds.add(e.getReportsTo());
            }
        }
        // Luego devolvemos los empleados cuyo ID está en esa lista
        List<Employee> managers = new ArrayList<>();
        for (Employee e : todos) {
            if (managerIds.contains(e.getId())) {
                managers.add(e);
            }
        }
        return managers;
    }

    @Override
    public boolean cambiarManager(Integer employeeId, Integer managerId) {
        if (employeeId == null || managerId == null) {
            return false;
        }
        if (employeeId.equals(managerId)) {
            return false;
        }
        Employee employee = buscarPorId(employeeId);
        if (employee == null) {
            return false;
        }
        if (buscarPorId(managerId) == null) {
            return false;
        }
        employee.setReportsTo(managerId);
        return repository.update(employee);
    }

    @Override
    public int contarSubordinados(Integer managerId) {
        if (managerId == null) {
            return 0;
        }
        List<Employee> todos = repository.findAll();
        int count = 0;
        for (Employee e : todos) {
            if (managerId.equals(e.getReportsTo())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public List<Employee> buscarPorApellido(String surname) {
        if (surname == null || surname.isBlank()) {
            return new ArrayList<>();
        }
        String trimmed = surname.trim();
        List<Employee> todos = repository.findAll();
        List<Employee> resultado = new ArrayList<>();
        for (Employee e : todos) {
            if (trimmed.equalsIgnoreCase(e.getSurname())) {
                resultado.add(e);
            }
        }
        return resultado;
    }
}