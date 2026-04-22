package com.ejemplo.service;

import com.ejemplo.model.Employee;

public class Utils {

    public static boolean validEmployee(Employee e) {
        if (e == null) {
            return false;
        }
        return true;
    }
}
