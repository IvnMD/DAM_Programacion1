package com.ejemplo.repository.json;

import com.ejemplo.model.Producto;
import com.ejemplo.repository.IProductoRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductoJsonRepository implements IProductoRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public ProductoJsonRepository(String ruta) {
        this.objectMapper = new ObjectMapper();
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Producto producto) {
        if (producto == null || producto.getId() == null || findById(producto.getId()) != null) {
            return false;
        }
        List<Producto> productos = findAll();
        productos.add(producto);
        writeAll(productos);
        return true;
    }

    @Override
    public List<Producto> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            JavaType tipo = objectMapper.getTypeFactory().constructCollectionType(List.class, Producto.class);
            return objectMapper.readValue(path.toFile(), tipo);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el fichero JSON de productos", e);
        }
    }

    @Override
    public Producto findById(Long id) {
        for (Producto producto : findAll()) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean update(Producto producto) {
        List<Producto> productos = findAll();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(producto.getId())) {
                productos.set(i, producto);
                writeAll(productos);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        List<Producto> productos = findAll();
        boolean eliminado = productos.removeIf(p -> p.getId().equals(id));
        if (eliminado) {
            writeAll(productos);
        }
        return eliminado;
    }

    private void writeAll(List<Producto> productos) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), productos);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el fichero JSON de productos", e);
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