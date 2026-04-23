package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.model.Skill;

public class Utils {

    public static boolean validEmployee(Employee employee) {
        if (employee == null ) {
            return false;
        }
        return true;
    }

        public static boolean validSkill(Skill skill) {
        if (skill == null) {
            return false;
        }
        return true;
    }
}
