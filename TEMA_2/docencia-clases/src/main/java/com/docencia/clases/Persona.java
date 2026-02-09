package com.docencia.clases;

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
    private String apellido2;
    private String identificador;

    /**
     * Contructor por defecto  //! Importantisimo ponerlo en el examen del viernes. 
     */
    public Persona() {};
    /**
     * Constructor de la clase persona
     * @param nombre Parametro para el nombre de la clase
     */
    // public Persona(String nombre){
    //     this.nombre = nombre;     //! Si se descomenta da error con identificador por duplicidad
    // }

    public Persona(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Constructor de la clase persona
     * @param fechaNacimiento fecha de nacimiento de la persona
     * @param nombre Nombre de la persona
     */
    public Persona(String fechaNacimiento, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }

    // Setter
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    // Getter
    public String getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    public String getIdentificador(){
        return this.identificador;
    }
    public String getNombre() {
        return this.nombre;
    }


    //! ToString();

    @Override
    public String toString() {
        return "{" +
            " fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", nombre='" + nombre + "'" +
            ", apellido1='" + getApellido1() + "'" +
            ", apellido2='" + getApellido2() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            "}";
    }
    
    //! toEquals;
    @Override
    public boolean equals(Object o){
        if (this == o){
        return true;
        }
        if (!(o instanceof Persona)){
        return false;
        }
        Persona persona = (Persona)o;
        if (identificador!= persona.getIdentificador()) {
            return false;
        }
        return true;
    }

    // //? Otro metodo para equals
    //     @Override
    // public boolean equals(Object o){
    //     if (this == o){
    //     return true;
    //     }
    //     if (!(o instanceof Persona)){
    //     return false;
    //     }
    //     Persona persona = (Persona)o;
    //     return Object.equals(identificador, persona.identificador);
    // }


}
