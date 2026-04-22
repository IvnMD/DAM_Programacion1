package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.repository.IEmployeeRepository;
import com.ejemplo.repository.sqlite.EmployeeSqliteRepository;
import com.ejemplo.repository.sqlite.SQLiteConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeSqliteRepository();
    }

    @Override
    public boolean crear(Employee employee) {
        if (!Utils(employee)) {
            return false;
        }
        Employee employeeBuscar = buscarPorId(employee.getId());
        if (!(employee == null)) {
            return false;
        }
        return repository.create(employeeBuscar);
    }

    @Override
    public Employee buscarPorId(Integer id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Employee> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public boolean actualizar(Employee employee) {
        if (!Utils(employee)) {
            return false;
        }
        Employee employeeBuscar = buscarPorId(employee.getId());
        if (!(employee == null)) {
            return false;
        }
        return repository.update(employeeBuscar);
    }

    }

    @Override
    public boolean eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Employee> listarPorRol(Integer rolId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorRol'");
    }

    @Override
    public List<Employee> listarManagers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarManagers'");
    }

    @Override
    public boolean cambiarManager(Integer employeeId, Integer managerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarManager'");
    }

    @Override
    public int contarSubordinados(Integer managerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarSubordinados'");
    }

    @Override
    public List<Employee> buscarPorApellido(String surname) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorApellido'");
    }

}
