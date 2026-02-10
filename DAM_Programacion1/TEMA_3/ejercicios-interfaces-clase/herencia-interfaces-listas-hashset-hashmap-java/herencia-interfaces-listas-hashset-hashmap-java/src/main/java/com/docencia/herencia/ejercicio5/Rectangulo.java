package com.docencia.herencia.ejercicio5;

import java.util.UUID;

public class Rectangulo extends Figura {

    private double ancho;
    private double alto;

    public Rectangulo(UUID id, String color, double ancho, double alto) {
        super(id, color);

        setAncho(ancho);
        setAlto(alto);
}

    public double getAncho() { return ancho; }
    public double getAlto() { return alto; }

    

    public Rectangulo(UUID id) {
        super(id);
    }

    public void setAncho(double ancho) {
        if (ancho <= 0) {
            throw new IllegalArgumentException();
        }
        this.ancho = ancho;
    }

    public void setAlto(double alto) {
        if (alto <=0){
            throw new IllegalArgumentException();
        }
        this.alto = alto;
    }

    @Override
    public double area() {
        return getAncho() * getAlto();
    }

    @Override
    public String toString() {
        return "Rectangulo [ancho=" + ancho + ", alto=" + alto + ", id=" + getId() + "]";
    }

    
}
