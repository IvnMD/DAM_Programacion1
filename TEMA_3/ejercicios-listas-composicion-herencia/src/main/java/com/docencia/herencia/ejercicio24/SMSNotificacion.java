package com.docencia.herencia.ejercicio24;
import java.util.Objects;

public class SMSNotificacion extends Notificacion{
    private int numero;

    public SMSNotificacion(){};

    public SMSNotificacion(String mensaje, String destinatario){
        super(mensaje, destinatario);
    }

    public SMSNotificacion(String mensaje, String destinario, int numero){
        super(mensaje, destinario);
        this.numero = numero;
    }


    public SMSNotificacion(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SMSNotificacion)) {
            return false;
        }
        SMSNotificacion sMSNotificacion = (SMSNotificacion) o;
        return numero == sMSNotificacion.numero;
    }


    public SMSNotificacion numero(int numero) {
        setNumero(numero);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            "}";
    }

}
