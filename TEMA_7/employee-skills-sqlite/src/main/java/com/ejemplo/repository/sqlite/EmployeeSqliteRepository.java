package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Employee;
import com.ejemplo.repository.IEmployeeRepository;

public class EmployeeSqliteRepository extends SQLiteConnectionManager implements IEmployeeRepository {

    public EmployeeSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Employee employee) {
        String sql = "INSERT INTO employee (id, name, surname, start_date, reports_to, rol_id) VALUES (?,?,?,?,?,?)";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getSurname());
            ps.setString(4, employee.getStartDate());
            if (employee.getReportsTo() == null) {
                ps.setNull(5, java.sql.Types.INTEGER);
            } else {
                ps.setInt(5, employee.getReportsTo());
            }
            ps.setInt(6, employee.getRolId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Employee findById(Integer id) {
        if (id == null) {
            return null;
        }
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Integer reportsTo = rs.getObject("reports_to") != null ? rs.getInt("reports_to") : null;
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("start_date"),
                        reportsTo,
                        rs.getInt("rol_id"));
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el empleado con ID " + id);
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee ORDER BY id";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer reportsTo = rs.getObject("reports_to") != null ? rs.getInt("reports_to") : null;
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("start_date"),
                        reportsTo,
                        rs.getInt("rol_id"));
                employees.add(employee);
            }
        } catch (Exception e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
        return employees;
    }

    @Override
    public boolean update(Employee employee) {
        // Verificar que el empleado existe
        if (findById(employee.getId()) == null) {
            return false;
        }

        // Verificar que el manager existe (si se especifica)
        if (employee.getReportsTo() != null) {
            if (findById(employee.getReportsTo()) == null) {
                return false;
            }
        }

        // Verificar que el rol existe
        if (!existeRol(employee.getRolId())) {
            return false;
        }

        String sql = "UPDATE employee SET name=?, surname=?, start_date=?, reports_to=?, rol_id=? WHERE id=?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getStartDate());
            if (employee.getReportsTo() == null) {
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, employee.getReportsTo());
            }
            ps.setInt(5, employee.getRolId());
            ps.setInt(6, employee.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    private boolean existeRol(Integer rolId) {
        String sql = "SELECT id FROM rol WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, rolId);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error al eliminar empleado con ID " + id + ": " + e.getMessage());
            return false;
        }
    }
}