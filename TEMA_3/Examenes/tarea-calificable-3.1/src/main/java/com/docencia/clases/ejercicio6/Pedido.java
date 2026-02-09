package com.docencia.clases.ejercicio6;

import java.util.Objects;
/**
 * Clase que representa un pedido
 */
public class Pedido {
    private String codigo;
    private double importe;
    private String estado;

    /**
     * Constructor vacio/por defecto
     */
    public Pedido() {
        
    }

    public Pedido(String codigo) {
        this.codigo = codigo;
    }

    public Pedido(String codigo, double importe, String estado){
        this.codigo = codigo;
        this.importe = importe;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Pedido [codigo=" + codigo + ", importe=" + importe + ", estado=" + estado + "]";
    }

    


//     @Override
//     public boolean equals(Object o) {
//         // TODO: implementar equals comparando SOLO el identificador único (codigo)
//         return super.equals(o);
//     }

//     @Override
//     public int hashCode() {
//         // TODO: implementar hashCode consistente con equals (usar SOLO el identificador único)
//         return super.hashCode();
//     }

//     @Override
//     public String toString() {
//         // TODO: implementar toString legible incluyendo al menos el identificador único
//         return super.toString();
//     }
}
