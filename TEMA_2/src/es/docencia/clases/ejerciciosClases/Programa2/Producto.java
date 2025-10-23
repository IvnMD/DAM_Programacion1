package es.docencia.clases.ejerciciosClases.Programa2;
import java.util.Objects;

public class Producto {
    
    private String codigo;
    public float precio;

    /**
     * 
     */
    public Producto(){};

    /**
     * 
     * @param codigo
     * @param precio
     */
    public Producto(String codigo, float precio){
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo) && precio == producto.precio;
    }

}
