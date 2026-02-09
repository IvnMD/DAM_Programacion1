import java.util.Objects;

public class Persona {

    private String identificador;
    private String nombre;

    // Constructor vacío
    public Persona() {
    }

    // Constructor con identificador
    public Persona(String identificador) {
        setIdentificador(identificador);
    }

    // Constructor completo
    public Persona(String identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona other = (Persona) obj;
        return Objects.equals(identificador, other.identificador);
    }

    @Override
    public String toString() {
        return "Persona [identificador=" + identificador + ", nombre=" + nombre + "]";
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        if (identificador == null || identificador.isBlank()){
            throw new IllegalArgumentException();
        }
        this.identificador = identificador.trim().toLowerCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException();
        }
        this.nombre = nombre.trim().toLowerCase();;
    }
}
