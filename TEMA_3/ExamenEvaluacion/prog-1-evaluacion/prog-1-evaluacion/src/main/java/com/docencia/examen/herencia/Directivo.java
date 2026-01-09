/**
 * @author IvnMD
 * @since 10/12/25
 * @version 1.0.0
 */


package com.docencia.examen.herencia;
import java.util.Objects;



/**
 * Clase directivo que hereda de la clase empleado
 */
public class Directivo extends Empleado {

    String categoria;   
    double complemento; 
    /**
     * Constructor vacio/por defecto
     */
    public Directivo() {
    }
    /**
     * Constructor parametrico por identificador unico
     * @param identificador identificador unico
     */
    public Directivo(String identificador) {
        super(identificador);

    }
    /**
     * Constructor parametrico
     * @param identificador identificador unico
     * @param nombre nombre del usuario
     * @param apellidos apellidos del usuario
     * @param departamento departamente donde trabaja el empleado
     * @param salario salario del empleado
     * @param categoria categoria de directivo
     * @param complemento complemento al sueldo del directivo
     */
    public Directivo(String identificador,
                     String nombre,
                     String apellidos,
                     String departamento,
                     double salario,
                     String categoria,
                     double complemento) {
        super(identificador, nombre, apellidos, departamento, salario);
        this.categoria = categoria;
        this.complemento = complemento;

    }
    /**
     * Getters y setters
     */
    public String getCategoria() {
        return categoria;
    }

    public double getComplemento() {
        return complemento;
    }

    //TODO: devuelve el salario total (salario base + complemento)
    public double getSalarioTotal() {
        return salario + complemento;
    }

    @Override
    public String toString() {
        return "Directivo{" +
                "identificador='" + getIdentificador() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos()+ '\'' +
                ", departamento='" + departamento + '\'' +
                ", salarioBase=" + salario +
                ", categoria='" + categoria + '\'' +
                ", complemento=" + complemento +
                ", salarioTotal=" + getSalarioTotal() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Directivo)) {
            return false;
        }
        Directivo directivo = (Directivo) o;
        return Objects.equals(identificador, directivo.identificador);
    }


    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
        

}
