package com.docencia.examen.herencia;

import com.docencia.examen.interfaces.TarificableJuego;
/**
 * @author IvnMD
 * @date 23/01/26
 * @version 1.0.0
 * @brief Clase JuegoMesa que hereda de Juego e implementa TarificableJuego
 */
public class JuegoMesa extends Juego implements TarificableJuego {
    /**
     * Constructor vacio
     */
    public JuegoMesa() { super(); }
    /**
     * Constructor parametrico
     * @param id
     * @param titulo
     * @param complemento
     */
    public JuegoMesa(String id, String titulo, double complemento) {
        super(id, titulo, complemento);
    }

    @Override
    public String tipoJuego() {
        return "MESA";
    }

    @Override
    public double precio() {
        double baseMesa = 35.0;
        return (baseMesa + (baseMesa*complemento)/100);
    }
}
