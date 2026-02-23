package com.docencia.examen.herencia;

import com.docencia.examen.interfaces.TarificableJuego;

/**
 * @author IvnMD
 * @date 23/01/26
 * @version 1.0.0
 * @brief Clase Arcade que hereda de Juego e implementa TarificableJuego
 */

public class Arcade extends Juego implements TarificableJuego {
    /**
     * Constructor vacio
     */
    public Arcade() { super(); }
    /**
     * Constructor parametrico 
     * @param id
     * @param titulo
     * @param complemento
     */
    public Arcade(String id, String titulo, double complemento) {
        super(id, titulo, complemento);
    }

    @Override
    public String tipoJuego() {
        return "ARCADE";
    }

    @Override
    public double precio() {
        double baseArcade = 20.0;
        return (baseArcade + (baseArcade*complemento)/100);
    }
}
