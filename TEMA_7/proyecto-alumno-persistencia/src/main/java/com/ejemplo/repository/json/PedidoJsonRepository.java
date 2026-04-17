package com.ejemplo.repository.json;

import com.ejemplo.model.Pedido;
import com.ejemplo.repository.IPedidoRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PedidoJsonRepository implements IPedidoRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public PedidoJsonRepository(String ruta) {
        this.objectMapper = new ObjectMapper();
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Pedido pedido) {
        if (pedido == null || pedido.getId() == null || findById(pedido.getId()) != null) {
            return false;
        }
        List<Pedido> pedidos = findAll();
        pedidos.add(pedido);
        writeAll(pedidos);
        return true;
    }

    @Override
    public List<Pedido> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            JavaType tipo = objectMapper.getTypeFactory().constructCollectionType(List.class, Pedido.class);
            return objectMapper.readValue(path.toFile(), tipo);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el fichero JSON de pedidos", e);
        }
    }

    @Override
    public Pedido findById(Long id) {
        for (Pedido pedido : findAll()) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public boolean update(Pedido pedido) {
        List<Pedido> pedidos = findAll();
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId().equals(pedido.getId())) {
                pedidos.set(i, pedido);
                writeAll(pedidos);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        List<Pedido> pedidos = findAll();
        boolean eliminado = pedidos.removeIf(p -> p.getId().equals(id));
        if (eliminado) {
            writeAll(pedidos);
        }
        return eliminado;
    }

    private void writeAll(List<Pedido> pedidos) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), pedidos);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el fichero JSON de pedidos", e);
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