package com.docencia.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {


    public static String normalizarEmail(String email){
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email nulo o vacio");
        }
         return email.toLowerCase().trim();
    }

    public static boolean emailValido(String email){
        // Pattern patron = Pattern.compile ("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
        // Matcher matcher = patron.matcher(email);
        // return matcher.matches();    
        String patron = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        if (!Pattern.matches(patron, email)){
            return false;
        }
        return patron.matches(email);
    }

    public static boolean passwordValida(String password){
        if (password == null || password.isBlank() || password.length() < 6){
            throw new IllegalArgumentException("Password invalido, nulo o vacio");
        }
        String patron = "^\\w{6,}$";
        if (!Pattern.matches(patron, password)){
            return false;
        }
        return patron.matches(password);
    }

    public static void validarNombre(String nombre){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre no valido");
        }
        nombre = nombre.trim();
        if (nombre.length() < 5) {
            throw new IllegalArgumentException("Nombre demasiado corto");
        }
    }

    public static void validarEmail(String email){
        if (!emailValido(email)){
            throw new IllegalArgumentException("Email no valido");
        }

    }

    public static void validarPassword(String password){
        if (!passwordValida(password)){
            throw new IllegalArgumentException("Password invalido");
        }
    }

}
