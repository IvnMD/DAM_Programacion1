package com.ejemplo.repository.json;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClienteJsonRepository implements IClienteRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public ClienteJsonRepository(String ruta) {
        this.objectMapper = new ObjectMapper();
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Cliente cliente) {
        if (cliente == null || cliente.getId() == null || findById(cliente.getId()) != null) {
            return false;
        }
        List<Cliente> clientes = findAll();
        clientes.add(cliente);
        writeAll(clientes);
        return true;
    }

    @Override
    public List<Cliente> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            JavaType tipo = objectMapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            return objectMapper.readValue(path.toFile(), tipo);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el fichero JSON de clientes", e);
        }
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
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(cliente.getId())) {
                clientes.set(i, cliente);
                writeAll(clientes);
                return true;
            }
        }
        return false;
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
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), clientes);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el fichero JSON de clientes", e);
        }
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
            throw new RuntimeException("No se pudo preparar el fichero JSON: " + ruta, e);
        }
    }
}