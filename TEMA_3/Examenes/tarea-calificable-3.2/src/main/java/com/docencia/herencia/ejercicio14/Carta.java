package com.docencia.herencia.ejercicio14;
/**
 * @author IvnMD
 * @date 09/01/26
 * @version 1.0.0
 * @brief Implementar una jerarquia simple de documentos 
 *        y una funcionalidad común para obtener susdescripciones, 
 *        aplicando programación defensiva ante datos invalidos.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Clase carta que hereda de documento
 */
public class Carta extends Documento {

    
    /**
     * Constructor parametrico
     * @param titulo que hereda de la clase documento
     */
    public Carta(String titulo) {
        super(titulo);
    }

    private String destinatario;
    /**
     * Setters/getters
     * @param destinatario
     */
    public void setDestinatario(String destinatario) {
        if (destinatario == null || destinatario.isBlank()){
            throw new IllegalArgumentException();
        }
        this.destinatario = destinatario.trim();
    }
    public String getDestinatario() {
        return destinatario;
    }
    /**
     * Funcion descripcion, que hace las veces de toString en este caso
    */
    @Override
    public String descripcion() {
        return "Carta: " + getTitulo() + " | " + "Para: " + getDestinatario();
    }
}
