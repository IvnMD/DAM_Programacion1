package com.docencia.clases;

public class Coche extends Vehiculo{

    public Coche (String matricula){
        super("B", matricula);
    }

    @Override
    public String suSonido() {
        return "BrumBrum";
    }

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Motocicleta("7300XXX");
        System.out.println(vehiculo1.suSonido());
        Vehiculo vehiculo2 = new Coche("2523CZV");
        System.out.println(vehiculo2.suSonido());


        if (vehiculo1 instanceof Motocicleta){
            System.out.println("Soy una instancia de moto");
        }
        if (vehiculo2 instanceof Coche){
            System.out.println("Soy una instancia de coche");
        }
    }
}
