package com.ejemplo.service;

import com.ejemplo.model.Skill;
import com.ejemplo.repository.ISkillRepository;
import com.ejemplo.repository.sqlite.SQLiteConnectionManager;
import com.ejemplo.repository.sqlite.SkillSqliteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SkillService implements ISkillService {

    private final ISkillRepository repository;

    public SkillService() {
        this.repository = new SkillSqliteRepository();
    }

    @Override
    public boolean crear(Skill skill) {
        if (!Utils.validSkill(skill))
            return false;

        // Trim del nombre antes de cualquier comprobación
        String nombreTrimmed = skill.getName().trim();

        // Verificar que tras el trim no quede vacío
        if (nombreTrimmed.isBlank())
            return false;

        if (buscarPorId(skill.getId()) != null)
            return false;

        // Verificar nombre duplicado ignorando mayúsculas y espacios
        List<Skill> todas = repository.findAll();
        for (Skill s : todas) {
            if (s.getName().equalsIgnoreCase(nombreTrimmed)) {
                return false;
            }
        }

        // Aplicar el trim al objeto antes de persistir
        skill.setName(nombreTrimmed);

        return repository.create(skill);
    }

    @Override
    public Skill buscarPorId(Integer id) {
        if (id == null)
            return null;
        return repository.findById(id);
    }

    @Override
    public List<Skill> listarTodas() {
        return repository.findAll();
    }

    @Override
    public boolean actualizar(Skill skill) {
        if (!Utils.validSkill(skill))
            return false;
        if (buscarPorId(skill.getId()) == null)
            return false;

        // Trim del nombre antes de comprobar duplicados
        String nombreTrimmed = skill.getName().trim();
        if (nombreTrimmed.isBlank())
            return false;

        // Verificar nombre duplicado ignorando mayúsculas, excluyendo la propia skill
        List<Skill> todas = repository.findAll();
        for (Skill s : todas) {
            if (s.getName().equalsIgnoreCase(nombreTrimmed) && !s.getId().equals(skill.getId())) {
                return false;
            }
        }

        // Aplicar trim antes de persistir
        skill.setName(nombreTrimmed);

        return repository.update(skill);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (id == null)
            return false;
        if (buscarPorId(id) == null)
            return false;
        return repository.deleteById(id);
    }

    @Override
    public List<Skill> listarPorCategoria(Integer categoryId) {
        if (categoryId == null)
            return new ArrayList<>();
        List<Skill> todas = repository.findAll();
        List<Skill> resultado = new ArrayList<>();
        for (Skill s : todas) {
            if (categoryId.equals(s.getCategoryId())) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    @Override
    public boolean asignarEmpleado(Integer employeeId, Integer skillId, String levelId) {
        if (employeeId == null || skillId == null)
            return false;

        // Verificar que el empleado y la skill existen
        if (buscarPorId(skillId) == null)
            return false;
        if (!empleadoExiste(employeeId))
            return false; // ← ver método privado abajo

        String levelTrimmed = (levelId != null) ? levelId.trim() : null;
        String sql = "INSERT INTO employee_skill (employee_id, skill_id, level_id) VALUES (?,?,?)";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ps.setInt(2, skillId);
            if (levelTrimmed == null)
                ps.setNull(3, java.sql.Types.VARCHAR);
            else
                ps.setString(3, levelTrimmed);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al asignar skill: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Skill> listarPorEmpleado(Integer employeeId) {
        if (employeeId == null)
            return new ArrayList<>();
        String sql = "SELECT s.* FROM skill s " +
                "INNER JOIN employee_skill es ON s.id = es.skill_id " +
                "WHERE es.employee_id = ? ORDER BY s.id";
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                skills.add(new Skill(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("category_id")));
            }
        } catch (Exception e) {
            System.err.println("Error al listar skills por empleado: " + e.getMessage());
        }
        return skills;
    }

    @Override
    public int contarEmpleadosConSkill(Integer skillId) {
        if (skillId == null)
            return 0;
        String sql = "SELECT COUNT(*) FROM employee_skill WHERE skill_id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, skillId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("Error al contar empleados con skill: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Skill> listarSinAsignar() {
        String sql = "SELECT * FROM skill WHERE id NOT IN " +
                "(SELECT DISTINCT skill_id FROM employee_skill) ORDER BY id";
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                skills.add(new Skill(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("category_id")));
            }
        } catch (Exception e) {
            System.err.println("Error al listar skills sin asignar: " + e.getMessage());
        }
        return skills;
    }

    private boolean empleadoExiste(Integer employeeId) {
        String sql = "SELECT id FROM employee WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }
}