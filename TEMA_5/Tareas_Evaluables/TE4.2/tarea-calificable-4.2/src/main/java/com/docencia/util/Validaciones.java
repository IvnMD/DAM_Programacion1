package com.docencia.util;
import java.time.DateTimeException;
import java.util.Objects;
import java.util.regex.Pattern;

import com.docencia.model.Persona;

public class Validaciones{


    public static boolean validacionDocumento (String documento){
        String patron = "^([0-9]{8}[a-zAZ]||[0-9]{8}-[a-zAZ]||[a-zA-Z][0-9]{8}[a-zAZ])$";

        return Pattern.matches(patron, documento);

    }

    public static boolean validacionEmail(String email){
        String patron = "^[a-z]+@[a-z]+.[a-z]$";

        return Pattern.matches(patron,email);
    }

    
    
}
