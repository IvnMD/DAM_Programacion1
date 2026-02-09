package com.docencia.interfaces.ejercicio3;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Conectable.
 */
public class Wifi implements Conectable {

    private UUID id;
    private String ssid;
    private String password;

    public Wifi(UUID id, String ssid, String password) {       
        this.id = id == null ? UUID.randomUUID() : id;
        this.ssid = ssid;
        this.password = password;
    }

    public UUID getId() { return id; }
    public String getSsid() { return ssid; }
    public String getPassword() { return password; }

    @Override
    public boolean conectar(String destino) {
        return destino != null && !destino.isBlank();
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
        Wifi other = (Wifi) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Wifi [id=" + id + ", ssid=" + ssid + ", password=" + password + "]";
    }

    
}
