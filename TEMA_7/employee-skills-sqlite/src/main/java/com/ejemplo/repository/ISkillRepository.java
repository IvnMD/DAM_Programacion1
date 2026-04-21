package com.ejemplo.repository;

import com.ejemplo.model.Skill;
import java.util.List;

public interface ISkillRepository {
    boolean create(Skill skill);
    Skill findById(Integer id);
    List<Skill> findAll();
    boolean update(Skill skill);
    boolean deleteById(Integer id);
}
