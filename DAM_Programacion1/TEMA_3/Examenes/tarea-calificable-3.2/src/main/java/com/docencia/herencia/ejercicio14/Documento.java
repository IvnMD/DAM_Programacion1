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
 * Clase padre documento
 */
public abstract class Documento {
    private final String titulo;

    /**
     * Constructor parametrico
     * 
     * @param titulo del documento.
     */
    protected Documento(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.titulo = titulo.trim();
    }
    /**
     * Getter
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    public abstract String descripcion();
}
