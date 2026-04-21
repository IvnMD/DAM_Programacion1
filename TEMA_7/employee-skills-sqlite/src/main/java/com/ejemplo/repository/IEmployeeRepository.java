package com.ejemplo.repository;

import com.ejemplo.model.Employee;
import java.util.List;

public interface IEmployeeRepository {
    boolean create(Employee employee);
    Employee findById(Integer id);
    List<Employee> findAll();
    boolean update(Employee employee);
    boolean deleteById(Integer id);
}
