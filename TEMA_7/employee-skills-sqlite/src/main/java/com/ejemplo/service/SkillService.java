package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.model.Skill;
import com.ejemplo.repository.ISkillRepository;
import com.ejemplo.repository.sqlite.SQLiteConnectionManager;
import com.ejemplo.repository.sqlite.SkillSqliteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillService implements ISkillService {

    private final ISkillRepository repository;

    public SkillService() {
        this.repository = new SkillSqliteRepository();
    }

    @Override
    public boolean crear(Skill skill) {
        if (!Utils.validSkill(skill)){
            return false;
        }
       Skill skillBuscar = buscarPorId(skill.getId());
        if (skillBuscar == null) {
            return false;
        }
        return repository.create(skillBuscar);
    }

    @Override
    public Skill buscarPorId(Integer id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Skill> listarTodas() {
        return repository.findAll();
    }

    @Override
    public boolean actualizar(Skill skill) {
        if (!Utils.validSkill(skill)){
            return false;
        }
       Skill skillBuscar = buscarPorId(skill.getId());
        if (skillBuscar == null) {
            return false;
        }
        return repository.update(skillBuscar);
    }
    

    @Override
    public boolean eliminar(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Skill> listarPorCategoria(Integer categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorCategoria'");
    }

    @Override
    public boolean asignarEmpleado(Integer employeeId, Integer skillId, String levelId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarEmpleado'");
    }

    @Override
    public List<Skill> listarPorEmpleado(Integer employeeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorEmpleado'");
    }

    @Override
    public int contarEmpleadosConSkill(Integer skillId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarEmpleadosConSkill'");
    }

    @Override
    public List<Skill> listarSinAsignar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarSinAsignar'");
    }

}

