package com.docencia.composicion.ejercicio5;


import java.util.ArrayList;
import java.util.List;


public class AgendaContactos {
    private final List<Contacto> contactos = new ArrayList<>();

    /**
     * TODO: Implementar según enunciado/tests.
     */
    public void anadirContacto(String nombre, String telefono) {
        if (nombre != null && !nombre.isBlank() 
                && telefono !=null && !telefono.isBlank() && telefono.length() == 9){
            contactos.add(new Contacto(nombre.trim().toLowerCase(), telefono.trim()));
        }
        
    }
    /**
     * TODO: Implementar según enunciado/tests.
     */
    public String buscarTelefono(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return null;
        }
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre.trim().toLowerCase())) { // Normalize here too
                return contacto.getTelefono();
            }
        }
        return null; 
    }

    public List<Contacto> getContactos() {
        return new ArrayList<>(contactos);
    }
}
