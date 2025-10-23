package es.docencia.clases.ejerciciosClases.Programa5;


public class Programa5 {
    public static void main(String[] args){
        //Crea coche1("1234-ABC", "Toyota", "Yaris") y coche2("1234-ABC", "Ford", "Focus"); muestra ambos.
        Coche coche1 = new Coche("Toyota", "Yaris", "1234-ABC");
        Coche coche2 = new Coche("Ford", "Focus", "1234-ABC");
        System.out.println("Coche 1: " + coche1);
        System.out.println("Coche 2: " + coche2);

        if (coche1.equals(coche2)) {
            System.out.println("Los coches son iguales (misma matrícula).");
        } else {
            System.out.println("Los coches son diferentes.");
        }
        // Modifica coche2.setMarca("Seat"); muestra coche2 y verifica que equals sigue true (la matrícula no cambió)
        coche2.setMarca("Seat");
        System.out.println("Coche 2 modificado: " + coche2);

        if (coche1.equals(coche2)) {
            System.out.println("Los coches son iguales (misma matrícula).");
        } else {
            System.out.println("Los coches son diferentes.");
        }
    }

}
