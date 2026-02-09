package com.docencia.herencia.ejercicio30;

import java.util.ArrayList;
import java.util.List;


import com.docencia.herencia.ejercicio21.Circulo;
import com.docencia.herencia.ejercicio21.Figura;
import com.docencia.herencia.ejercicio21.Triangulo;

public class GrupoFiguras {
    
    final private List<Figura> figuras;

    public GrupoFiguras(){
        figuras = new ArrayList<>();
    }

    public GrupoFiguras(List<Figura> figuras){
        this.figuras = figuras;
    }

    public double areaTotal(){
        double resultado = 0;
        for (Figura figura : figuras) {
                resultado = resultado + figura.area();

        }
        return resultado;
    }

    public double areaTotalCirculo(){
        double resultado = 0;
        for (Figura figura : figuras) {
            if(figura instanceof Circulo){
                resultado = resultado + figura.area();
            }
        }
        return resultado;
    }    
    
    public double areaTotalTriangulo(){
        double resultado = 0;
        for (Figura figura : figuras) {
            if(figura instanceof Triangulo){
                resultado = resultado + figura.area();
            }
        }
        return resultado;
    }

        public double areaTotalOtros(){
        double resultado = 0;
        for (Figura figura : figuras) {
            if(!(figura instanceof Triangulo) && !(figura instanceof Circulo)){
                resultado = resultado + figura.area();
            }

        }
        return resultado;
    }



    

}
