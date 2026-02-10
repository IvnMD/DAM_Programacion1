package com.docencia.herencia.ejercicio24;
import java.util.Objects;

public abstract class Notificacion {
    private String mensaje;
    private String destinatario;

    public Notificacion(){
        this.mensaje = "";

    };


    public Notificacion(String mensaje, String destinatario) {
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Notificacion)) {
            return false;
        }
        Notificacion notificacion = (Notificacion) o;
        return Objects.equals(mensaje, notificacion.mensaje) && Objects.equals(destinatario, notificacion.destinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensaje, destinatario);
    }

    @Override
    public String toString() {
        return "{" +
            " mensaje='" + getMensaje() + "'" +
            ", destinatario='" + getDestinatario() + "'" +
            "}";
    }
    

}
