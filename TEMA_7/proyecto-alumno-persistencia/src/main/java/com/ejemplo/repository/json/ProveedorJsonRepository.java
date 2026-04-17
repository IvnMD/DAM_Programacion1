package com.ejemplo.repository.json;

import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProveedorJsonRepository implements IProveedorRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public ProveedorJsonRepository(String ruta) {
        this.objectMapper = new ObjectMapper();
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Proveedor proveedor) {
        if (proveedor == null || proveedor.getId() == null || findById(proveedor.getId()) != null) {
            return false;
        }
        List<Proveedor> proveedores = findAll();
        proveedores.add(proveedor);
        writeAll(proveedores);
        return true;
    }

    @Override
    public List<Proveedor> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            JavaType tipo = objectMapper.getTypeFactory().constructCollectionType(List.class, Proveedor.class);
            return objectMapper.readValue(path.toFile(), tipo);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el fichero JSON de proveedores", e);
        }
    }

    @Override
    public Proveedor findById(Long id) {
        for (Proveedor proveedor : findAll()) {
            if (proveedor.getId().equals(id)) {
                return proveedor;
            }
        }
        return null;
    }

    @Override
    public boolean update(Proveedor proveedor) {
        List<Proveedor> proveedores = findAll();
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getId().equals(proveedor.getId())) {
                proveedores.set(i, proveedor);
                writeAll(proveedores);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        List<Proveedor> proveedores = findAll();
        boolean eliminado = proveedores.removeIf(p -> p.getId().equals(id));
        if (eliminado) {
            writeAll(proveedores);
        }
        return eliminado;
    }

    private void writeAll(List<Proveedor> proveedores) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), proveedores);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el fichero JSON de proveedores", e);
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