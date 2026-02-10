package com.docencia.herencia.ejercicio24;
import java.util.Objects;

public class EmailNotificacion extends Notificacion{
    private String encabezado;

    public EmailNotificacion(){

    }

    public EmailNotificacion(String mensaje, String destinatario){
        super(mensaje, destinatario);
    }

    public EmailNotificacion(String mensaje, String destinatario, String encabezado){
        super(mensaje, destinatario);
        this.encabezado = encabezado;
    }


    public String getEncabezado() {
        return this.encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmailNotificacion)) {
            return false;
        }
        EmailNotificacion emailNotificacion = (EmailNotificacion) o;
        return Objects.equals(encabezado, emailNotificacion.encabezado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encabezado);
    }

    @Override
    public String toString() {
        return "{" +
            " mensaje='" + getMensaje() + "'" +
            ", destinatario='" + getDestinatario() + "'" +
            ", encabezado='" + getEncabezado() + "'" +
            "}";
    }
    
}
