package com.ejemplo.utils;

import com.ejemplo.model.Clase;
import com.ejemplo.model.Socio;

public class Validaciones {
           
    static public boolean validarClase(Clase entity) {
        
    return entity != null && entity.getId() != null && entity.getNombre() != null && !entity.getNombre().trim().isEmpty();
    }

    static public boolean validarSocio(Socio entity) {
        
    return entity != null && entity.getId() != null && entity.getNombre() != null && !entity.getNombre().trim().isEmpty();
    }

}
