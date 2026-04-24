package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.model.Skill;

public class Utils {

    public static boolean validEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        if (employee.getId() == null || employee.getId() <= 0) {
            return false;
        }
        if (employee.getName() == null || employee.getName().isBlank()) {
            return false;
        }
        if (employee.getSurname() == null || employee.getSurname().isBlank()) {
            return false;
        }
        if (employee.getStartDate() == null || employee.getStartDate().isBlank()) {
            return false;
        }
        return true;
    }

    public static boolean validSkill(Skill skill) {
        if (skill == null) {
            return false;
        }
        if (skill.getId() == null || skill.getId() <= 0) {
            return false;
        }
        if (skill.getName() == null || skill.getName().isBlank()) {
            return false;
        }
        if (skill.getCategoryId() == null) {
            return false;
        }
        return true;
    }
}