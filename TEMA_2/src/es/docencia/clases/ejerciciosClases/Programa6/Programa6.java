package es.docencia.clases.ejerciciosClases.Programa6;

public class Programa6 {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("12345678A", "Lucía");
        Alumno alumno2 = new Alumno("12345678A", "Otro");

        System.out.println("Dni de alumno 1 = " + alumno1.getDni());
        System.out.println("Nombre de alumno 1 = " + alumno1.getNombre());

        alumno1.setNombre("Lucía Pérez");
        System.out.println("Nombre de alumno 1 modificado = " + alumno1.getNombre());

        if (alumno1.equals(alumno2)) {
            System.out.println("Los alumnos son iguales (mismo DNI).");
            
        }

    }

}
