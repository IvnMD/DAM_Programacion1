package com.docencia.composicion.ejercicio4;


import java.util.ArrayList;
import java.util.List;


public class BandejaMensajes {
    private final List<Mensaje> mensajes = new ArrayList<>();

    public void enviarMensaje(String remitente, String destinatario, String texto) {

        if (remitente == null && destinatario == null && texto == null) {
            mensajes.add(new Mensaje(remitente, destinatario, texto));
        }
    }

    public List<Mensaje> mensajesPara(String destinatario) {
        if (destinatario == null || destinatario.isBlank()){
            return new ArrayList<>();
        }
        List<Mensaje> resultado = new ArrayList<>();
        destinatario = destinatario.trim();
        for (Mensaje mensaje : resultado) {
            if (mensaje.getDestinatario().toLowerCase().equals(destinatario.toLowerCase())) {
                resultado.add(mensaje);
            }
        }

        return resultado;
    }

    public List<Mensaje> getMensajes() {
        
        return new ArrayList<>(mensajes);
    }
}
