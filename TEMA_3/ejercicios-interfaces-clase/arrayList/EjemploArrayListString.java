import java.util.ArrayList;
import java.util.List;

public class EjemploArrayListString {

    public static void main(String[] args) {

        // ==========================
        // ARRAYLIST DE STRINGS
        // ==========================
        ArrayList<String> listaDeNombres = new ArrayList<>();

        listaDeNombres.add("Juan");
        listaDeNombres.add("María");
        listaDeNombres.add("Carlos");
        listaDeNombres.add(null);

        System.out.println("Tamaño lista: " + listaDeNombres.size());
        System.out.println("Lista de nombres: " + listaDeNombres);

        String nombre = listaDeNombres.get(2);
        System.out.println("Nombre en la posición 2: " + nombre);
        System.out.println("Último nombre: " + listaDeNombres.get(listaDeNombres.size() - 1));

        listaDeNombres.remove("María");
        System.out.println("Lista tras eliminar María: " + listaDeNombres);

        listaDeNombres.remove(1);
        System.out.println("Lista tras eliminar posición 1: " + listaDeNombres);

        // ==========================
        // ARRAYLIST DE PERSONA
        // ==========================
        List<Persona> personas = new ArrayList<>();

        add(personas, new Persona("433", "Donal Tromp"));
        add(personas, new Persona("728", "Super Maduro"));
        add(personas, new Persona("428", "Chi Yin Pin"));

        System.out.println("\nLista de personas:");
        System.out.println(personas);

        // Obtener una persona
        Persona persona = personas.get(0);
        System.out.println("\nPrimera persona: " + persona);

        // contains correcto
        boolean existeDonal = personas.contains(new Persona("433"));
        System.out.println("¿Existe Donal Tromp? " + existeDonal);

        Persona carmen = new Persona("728", "Carmen");
        boolean existeCarmen = personas.contains(carmen);
        System.out.println("¿Existe Carmen? " + existeCarmen);

        // indexOf correcto
        Persona personaUno = new Persona("433");
        int posicion = personas.indexOf(personaUno);
        System.out.println("Se encuentra en la posición: " + posicion);

        System.out.println("\nLista final:");
        System.out.println(personas);
    }

    /**
     * Función add que incluye un elemento en la lista si no existe
     *
     * @param lista   Lista de personas
     * @param persona Persona a añadir
     * @return true si se añade, false si no
     */
    public static boolean add(List<Persona> lista, Persona persona) {
        if (lista == null || persona == null ||
            persona.getIdentificador() == null ||
            persona.getIdentificador().isBlank()) {
            return false;
        }

        if (lista.contains(persona)) {
            return false;
        }

        return lista.add(persona);
    }

    
}
