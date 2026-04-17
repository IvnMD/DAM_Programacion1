package com.ejemplo.repository.csv;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClienteCsvRepository extends CsvReaderAbstract implements IClienteRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public ClienteCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Cliente cliente) {
        if (cliente == null || cliente.getId() == null || findById(cliente.getId()) != null) {
            return false;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.file.StandardOpenOption.APPEND)) {
            bw.write(toLine(cliente));
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            for (String[] row : rows) {
                if (row.length >= 8) {
                    clientes.add(fromRow(row));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente findById(Long id) {
        for (Cliente cliente : findAll()) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean update(Cliente cliente) {
        List<Cliente> clientes = findAll();
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(cliente.getId())) {
                clientes.set(i, cliente);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            writeAll(clientes);
        }
        return encontrado;
    }

    @Override
    public boolean deleteById(Long id) {
        List<Cliente> clientes = findAll();
        boolean eliminado = clientes.removeIf(c -> c.getId().equals(id));
        if (eliminado) {
            writeAll(clientes);
        }
        return eliminado;
    }

    private void writeAll(List<Cliente> clientes) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Cliente c : clientes) {
                bw.write(toLine(c));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir clientes: " + e.getMessage());
        }
    }

    private String toLine(Cliente c) {
        return c.getId() + separatorWrite
                + c.getNif() + separatorWrite
                + c.getNombre() + separatorWrite
                + c.getEmail() + separatorWrite
                + c.getTelefono() + separatorWrite
                + c.getCiudad() + separatorWrite
                + c.getPais() + separatorWrite
                + c.isActivo();
    }

    private Cliente fromRow(String[] row) {
        return new Cliente(
                Long.parseLong(row[0].trim()),
                row[1].trim(),
                row[2].trim(),
                row[3].trim(),
                row[4].trim(),
                row[5].trim(),
                row[6].trim(),
                Boolean.parseBoolean(row[7].trim())
        );
    }

    private Path inicializarPath(String ruta) {
        try {
            Path p = Path.of(ruta);
            if (p.getParent() != null && !Files.exists(p.getParent())) {
                Files.createDirectories(p.getParent());
            }
            if (!Files.exists(p)) {
                Files.createFile(p);
            }
            return p;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo preparar el fichero CSV: " + ruta, e);
        }
    }
}