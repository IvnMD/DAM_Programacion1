package com.docencia.ficheros.repo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.docencia.ficheros.model.Reserva;
import com.docencia.ficheros.repo.interfaces.IReservaRepository;
import com.docencia.ficheros.util.ResourceUtils;

public class ReservaRepositoryCsv implements IReservaRepository {

    private List<Reserva> reservas = new ArrayList<>();
    private final String path;

    public ReservaRepositoryCsv(String resourcePath) {
        this.path = resourcePath;
    }

    @Override
    public List<Reserva> findAll() {
        List<Reserva> reservas = new ArrayList<>();
        try (InputStream is = ResourceUtils.getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String reserva;
            br.readLine();
            while ((reserva = br.readLine()) != null) {
                String[] campos = reserva.split(",");
                int id = Integer.parseInt(campos[0]);
                int clienteId = Integer.parseInt(campos[1]);
                int hotelId = Integer.parseInt(campos[2]);
                String fechaInicio = campos[3];
                String fechaFin = campos[4];
                try {
                    reservas.add(new Reserva(id, clienteId, hotelId, fechaInicio, fechaFin));
                } catch (IllegalArgumentException e) {
                    throw new IllegalStateException("Reserva invalida", e);
                }
            }
        } catch (IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }

    @Override
    public Reserva findById(int id) {

        for (Reserva reserva : findAll()) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

}
