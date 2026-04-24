package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Skill;
import com.ejemplo.repository.ISkillRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SkillSqliteRepository extends SQLiteConnectionManager implements ISkillRepository {

    public SkillSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Skill skill) {
        if (!existeCategoria(skill.getCategoryId()))
            return false;
        if (existeNombre(skill.getName()))
            return false;

        String sql = "INSERT INTO skill (id, name, category_id) VALUES (?,?,?)";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, skill.getId());
            ps.setString(2, skill.getName());
            ps.setInt(3, skill.getCategoryId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Skill findById(Integer id) {
        if (id == null)
            return null;

        String sql = "SELECT * FROM skill WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Skill(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("category_id"));
                }
            }
        } catch (Exception e) {
            System.err.println("Error al buscar skill con ID " + id);
        }
        return null;
    }

    @Override
    public List<Skill> findAll() {
        String sql = "SELECT * FROM skill ORDER BY id";
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    skills.add(new Skill(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("category_id")));
                }
            }
        } catch (Exception e) {
            System.err.println("Error al listar skills: " + e.getMessage());
        }
        return skills;
    }

    @Override
    public boolean update(Skill skill) {
        // Verificar que la skill existe
        if (findById(skill.getId()) == null) {
            return false;
        }

        // Verificar que la categoría existe
        if (!existeCategoria(skill.getCategoryId())) {
            return false;
        }

        String sql = "UPDATE skill SET name=?, category_id=? WHERE id=?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, skill.getName());
            ps.setInt(2, skill.getCategoryId());
            ps.setInt(3, skill.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM skill WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    // ── Métodos privados auxiliares ──────────────────────────────────────────

    private boolean existeNombre(String name) {
        String sql = "SELECT id FROM skill WHERE LOWER(name) = LOWER(?)";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean existeCategoria(Integer categoryId) {
        String sql = "SELECT id FROM category WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            return false;
        }
    }
}