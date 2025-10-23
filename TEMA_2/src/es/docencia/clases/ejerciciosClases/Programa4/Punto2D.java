package es.docencia.clases.ejerciciosClases.Programa4;

/**
 * @author IvnMD
 * @date 24/10/2025
 * @version 1.0
 * @bugs Sin bugs conocidos
 * @brief Clase Punto2D: Clase que representa un punto en el plano 2D
 */

public class Punto2D {

    private int x;
    private int y;
    /**
     * Constructor por defecto
     */
    public Punto2D(){};
    /**
     * Constructor con parametros
     * @param x coordenada x del punto
     * @param y coordenada y del punto
     */
    public Punto2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Punto2D)) {
            return false;
        }
        Punto2D punto2D = (Punto2D) o;
        return x == punto2D.x && y == punto2D.y;
    }


}
