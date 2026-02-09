package com.docencia.examen.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.docencia.examen.herencia.Juego;

public class SetJuegos {

    private final Set<Juego> juegos;

    public SetJuegos() {
        this.juegos = new HashSet<>();
    }

    public boolean crearJuego(Juego juego) {
        validar(juego);
        if (juego == null){
            throw new IllegalArgumentException();
        }
        juegos.add(juego);

        return true;
    }

    public Juego buscarId(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException();
        }
        for (Juego juego : juegos) {
            if (juegos.contains(juego.getId())){
                return juego;
            }
        }
        return null;
    }

    public Juego buscarJuego(Juego juego) {
        validar(juego);
        Juego elemento = juego;
            for (Juego juego2 : juegos) {
                if (juego2.getId().equals(elemento)){
                    return juego;
                }
            }
        return null;
    }

    public boolean actualizarJuego(Juego juego) {
        validar(juego);
        Juego existente = juego;
        for (Juego juego2 : juegos) {
            if (juego2.getId().equals(existente)){
                
            }
        }
        
        return false;
    }

    public boolean eliminarId(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException();
        }
        juegos.removeIf(juego -> juego.getId().equals(id));
        return true;

    }

    public boolean existeJuego(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException();
        }
        for (Juego juego : juegos) {
                if(juego.getId().equals(id)){
                    return true;
                }
        }

        return false;
    }

    public double calcularPrecio(String tipo) {
        if (tipo == null || tipo.isBlank()){
            throw new IllegalArgumentException();
        }
        double resultado = 0;
        if(tipo == "MESA") {
            
        }
            
        return resultado;
    }

    public double calcularPrecioTotal() {
        return 0.0;
    }

    public int contarPorTipo(String tipo) {
        if (tipo == null || tipo.isBlank()){
            throw new IllegalArgumentException();
        }
        int contador = 0;
         for (Juego juego : juegos) {
            if(juego.tipoJuego().equals(tipo)){
                contador ++;
            }
         }
        return contador;
    }

    public int contar() {
        return juegos.size();
    }

    public List<Juego> listar() {
        return  List.copyOf(juegos);
    }

        public void validar (Juego juego){
        if (juego == null) {
            throw new IllegalArgumentException();
        }
        if (juego.getId() == null || juego.getId().isBlank()){
            throw new IllegalArgumentException();
        }
        if (juego.getTitulo() == null || juego.getTitulo().isBlank()){
            throw new IllegalArgumentException();
        }
        if (juego.getComplemento() < 0 || juego.getComplemento() > 100){
            throw new IllegalArgumentException();
        }
    }
}
