package com.docencia.interfaces.ejercicio8;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Notificable.
 */
public class EmailNotifier implements Notificable {

    private UUID id;
    private String from;
    private String to;

    public EmailNotifier(UUID id, String from, String to) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.to = to;
        this.from = from;
    }

    public UUID getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean notificar(String mensaje) {
        return mensaje != null && !mensaje.isBlank() && to.contains("@");
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmailNotifier other = (EmailNotifier) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "EmailNotifier [id=" + id + ", from=" + from + ", to=" + to + "]";
    }

}
