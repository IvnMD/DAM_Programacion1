package com.ejemplo.repository.json;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InventarioJsonRepository implements IInventarioRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public InventarioJsonRepository(String ruta) {
        this.objectMapper = new ObjectMapper();
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Inventario inventario) {
        if (inventario == null || inventario.getId() == null || findById(inventario.getId()) != null) {
            return false;
        }
        List<Inventario> inventarios = findAll();
        inventarios.add(inventario);
        writeAll(inventarios);
        return true;
    }

    @Override
    public List<Inventario> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            JavaType tipo = objectMapper.getTypeFactory().constructCollectionType(List.class, Inventario.class);
            return objectMapper.readValue(path.toFile(), tipo);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el fichero JSON de inventarios", e);
        }
    }

    @Override
    public Inventario findById(Long id) {
        for (Inventario inventario : findAll()) {
            if (inventario.getId().equals(id)) {
                return inventario;
            }
        }
        return null;
    }

    @Override
    public boolean update(Inventario inventario) {
        List<Inventario> inventarios = findAll();
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId().equals(inventario.getId())) {
                inventarios.set(i, inventario);
                writeAll(inventarios);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        List<Inventario> inventarios = findAll();
        boolean eliminado = inventarios.removeIf(inv -> inv.getId().equals(id));
        if (eliminado) {
            writeAll(inventarios);
        }
        return eliminado;
    }

    private void writeAll(List<Inventario> inventarios) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), inventarios);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el fichero JSON de inventarios", e);
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