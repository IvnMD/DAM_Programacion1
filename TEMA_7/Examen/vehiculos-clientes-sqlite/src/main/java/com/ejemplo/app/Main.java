package com.ejemplo.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.sqlite.SchemaRepository;
import com.ejemplo.service.ClienteService;
import com.ejemplo.service.VehiculoService;

public class Main {

    public static void main(String[] args) {
        String rutaDb = "src/main/resources/data/sqlite/vehiculos.db";
        String rutaBackupDb = "src/main/resources/data/sqlite/vehiculos_backup.db";

        try {
            Files.copy(
                        Path.of(rutaBackupDb),
                        Path.of(rutaDb),
                        StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        
            e.printStackTrace();
        }

        new SchemaRepository(rutaDb).createSchema();

        ClienteService clienteService = new ClienteService();
        VehiculoService vehiculoService = new VehiculoService();

        Cliente cliente = new Cliente("11111111A", "Ana", "ana@demo.com", "600111222", "Madrid", true);
        clienteService.crear(cliente);

        Vehiculo vehiculo = new Vehiculo(null, "1234ABC", "Seat", "Ibiza", "Rojo", 2021, 25000, 12500.0, false, cliente.getDni());
        vehiculoService.crear(vehiculo);

        System.out.println("Clientes: " + clienteService.listarTodos());
        System.out.println("Vehiculos: " + vehiculoService.listarTodos());
    }
}
