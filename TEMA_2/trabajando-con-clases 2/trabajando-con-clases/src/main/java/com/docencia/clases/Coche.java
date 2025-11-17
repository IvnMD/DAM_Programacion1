package com.docencia.clases;

public class Coche extends Vehiculo{

    public Coche (String matricula){
        super("B", matricula);
    }

    @Override
    public String suSonido() {
        return "BrumBrum";
    }

    @Override
    public int numeroRuedas() {
        return 4;
    }

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Motocicleta("7300XXX");
        System.out.println(vehiculo1.suSonido());
        Vehiculo vehiculo2 = new Coche("2523CZV");
        System.out.println(vehiculo2.suSonido());
        System.out.println("Numero de ruedas del coche es: " + vehiculo2.numeroRuedas());
        System.out.println("Numero de ruedas de la moto es: " + vehiculo1.numeroRuedas());

        if (vehiculo1 instanceof Motocicleta){
            System.out.println("Soy una instancia de moto "+ vehiculo1);
        }
        if (vehiculo2 instanceof Coche){
            System.out.println("Soy una instancia de coche " + vehiculo2);
        }
    }

    public boolean contains(Coche coche) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
