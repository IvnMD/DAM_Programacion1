package com.docencia.examen.colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.docencia.examen.herencia.Juego;

public class MapJuegos {

    private final Map<String, Juego> juegos;

    /**
     * inicializacion del Mapa
     */
    public MapJuegos() {
        this.juegos = new HashMap<>();
    }

    /**
     * @param juego
     * @return
     */
    public boolean crearJuego(Juego juego) {
        validar(juego);
        if (juego == null){
            throw new IllegalArgumentException();
        }
        juegos.put(juego.getId(), juego);

        return true;
    }

    /**
     * @param id
     * @return
     */
    public Juego buscarId(String id) {
        juegos.containsKey(id);
        return null;
    }

    /**
     * @param juego
     * @return
     */
    public Juego buscarJuego(Juego juego) {
        validar(juego);
        Juego elemento = juego;
        if (juegos.containsKey(juego.getId())) 
        return juego;
            
        return null;
    }

    public boolean actualizarJuego(Juego juego) {
        return false;
    }

    public boolean eliminarId(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException();
        }
        juegos.remove(id);
        return true;
    }

    public boolean existeJuego(String id) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException();
        }
        if(juegos.containsKey(id)){
                    return true;
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
         for (int i = 0; i < juegos.size(); i++) {
            if(((Juego) juegos).tipoJuego().equals(tipo)){
                contador ++;
            }
    

         }
        return contador;
    }

    public int contar() {
        return juegos.size();
    }

    public List<Juego> listar() {
        return (List<Juego>) Map.copyOf(juegos);
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
