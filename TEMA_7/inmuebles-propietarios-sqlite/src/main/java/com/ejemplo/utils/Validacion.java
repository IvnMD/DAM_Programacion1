package com.ejemplo.utils;

import com.ejemplo.model.Inmueble;
import com.ejemplo.model.Propietario;

public class Validacion {

    public static boolean validInmueble(Inmueble inmueble) {
        if (inmueble == null) {
            return false;
        }
        // if (inmueble.getId() == null || inmueble.getId() <= 0) {
        //     return false;
        // }
        // if (inmueble.getName() == null || inmueble.getName().isBlank()) {
        //     return false;
        // }
        // if (inmueble.getSurname() == null || inmueble.getSurname().isBlank()) {
        //     return false;
        // }
        // if (inmueble.getStartDate() == null || inmueble.getStartDate().isBlank()) {
        //     return false;
        // }
        return true;
    }

    public static boolean validPropietario(Propietario propietario) {
        if (propietario == null) {
            return false;
        }
        // if (propietario.getId() == null || propietario.getId() <= 0) {
        //     return false;
        // }
        // if (propietario.getName() == null || propietario.getName().isBlank()) {
        //     return false;
        // }
        // if (propietario.getCategoryId() == null) {
        //     return false;
        // }
        return true;
    }
}
