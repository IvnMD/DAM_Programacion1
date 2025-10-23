package es.docencia.clases.ejerciciosClases.Programa1;

public class Programa1 {

    public static void main(String[] args) {

        Persona1 persona1 = new Persona1("Ana", 25);
        System.out.println("Persona1+:" + persona1);

        Persona1 persona2 = new Persona1("ana", 25);
        System.out.println("Persona2:" + persona2);

        if (persona1.equals(persona2)){
            System.out.println("Somos la misma persona");
        }        
    }

}