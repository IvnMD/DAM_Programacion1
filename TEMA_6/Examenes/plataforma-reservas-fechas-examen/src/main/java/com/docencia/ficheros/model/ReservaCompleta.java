package com.docencia.ficheros.model;

public record ReservaCompleta(
        int reservaId,
        String clienteNombre,
        String hotelNombre,
        long noches,
        double precioTotal
) {}
