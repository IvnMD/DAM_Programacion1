import java.util.ArrayList;
import java.util.List;

public class PersonaList extends ArrayList{
    final List<Persona> list;

    public PersonaList(){
        list = new ArrayList<>();
    }
    /**
     * Función add que incluye un elemento en la lista si no existe
     * @param persona Persona a añadir
     * @return true si se añade, false si no
     */
    public boolean add(Persona persona) {
        if (list == null || persona == null ||
            persona.getIdentificador() == null ||
            persona.getIdentificador().isBlank()) {
            return false;
        }

        if (list.contains(persona)) {
            return false;
        }

        return list.add(persona);
    }
    /**
     * Funcion que elimina una persona de la lista a traces de su id
     * @param id unico de la persona
     * @return true/false
     * 
     */
    public boolean remove (String id){
        
        Persona personaEliminar = new Persona(id);

        return remove(personaEliminar);
    }

        /**
     * Funcion que elimina una persona de la lista a traces de su id
     * @param persona que se elimina de lista
     * @return true/false
     * 
     */
    public boolean remove (Persona persona){

        int posicion = list.indexOf(persona);
        if (posicion < 0){
            return false;
        }
        return list.remove(persona);
    }



}
