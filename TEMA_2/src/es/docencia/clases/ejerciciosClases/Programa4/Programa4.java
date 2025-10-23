package es.docencia.clases.ejerciciosClases.Programa4;

public class Programa4 {
    public static void main(String[] args) {
        Punto2D punto1 = new Punto2D(3, 4);
        Punto2D punto2 = new Punto2D(3, 4);
        Punto2D punto3 = new Punto2D(5, 4);

        System.out.println("Punto 1: " + punto1);
        System.out.println("Punto 2: " + punto2);
        System.out.println("Punto 3: " + punto3);

        if (punto1.equals(punto2)) {
            System.out.println("Los puntos 1 y 2 son iguales.");
        } else {
            System.out.println("Los puntos1 y 2 son diferentes.");
        }  
        if (punto1.equals(punto3)) {
            System.out.println("Los puntos 1 y 3 son iguales.");
        } else {
            System.out.println("Los puntos 1 y 3 son diferentes.");
        }
        punto2.setX(7);
        System.out.println("Punto 2 modificado: " + punto2);

        if (punto1.equals(punto2)) {
            System.out.println("Los puntos 1 y 2 son iguales.");
        } else {
            System.out.println("Los puntos1 y 2 son diferentes.");
        }  
    }

}
