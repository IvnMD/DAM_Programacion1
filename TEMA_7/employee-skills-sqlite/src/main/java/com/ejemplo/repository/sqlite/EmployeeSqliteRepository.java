package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Employee;
import com.ejemplo.repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSqliteRepository extends SQLiteConnectionManager implements IEmployeeRepository {

    public EmployeeSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Employee findById(Integer id) {
        String sql = "SELECT * FROM Employee where id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);

                ResultSet resultado = ps.executeQuery();

                while (resultado.next()){
                    resultado.getString(1);
                }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean update(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    }
