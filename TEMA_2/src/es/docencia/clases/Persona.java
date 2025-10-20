/**
 * Clase persona que almacena la informacion de esta
 * @author Iván Mesa
 * @version 1.0.0
 * @date 20/10/25
 * @bugs No bugs known.
 */
public class Persona {

    private String fechaNacimiento;
    private String nombre;
    private String apellido1;
    private Strgins apellido2;

    /**
     * Contructor por defecto  //! Importantisimo ponerlo en el examen del viernes. 
     */
    public Persona() {};
    /**
     * Constructor de la clase persona
     * @param nombre Parametro para el nombre de la clase
     */
    public Persona(String nombre){
        this.nombre; 
    }
    /**
     * Constructor de la clase persona
     * @param fechaNacimiento fecha de nacimiento de la persona
     * @param nombre Nombre de la perdona
     */
    public Persona(String fechaNacimiento, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }

    public void setFechaNacimeinto(String fechaNaciemiento){
        this.fechaNacimiento = fechaNaciemiento;
    }

    public String getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

}
