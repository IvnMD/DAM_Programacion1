package com.ejemplo.repository.json;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoJsonRepository implements ILineaPedidoRepository {

    private Path path;
    private ObjectMapper objectMapper;

    public LineaPedidoJsonRepository(String ruta) {
        this.objectMapper = new ObjectMapper();
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(LineaPedido lineaPedido) {
        if (lineaPedido == null || lineaPedido.getId() == null || findById(lineaPedido.getId()) != null) {
            return false;
        }
        List<LineaPedido> lineas = findAll();
        lineas.add(lineaPedido);
        writeAll(lineas);
        return true;
    }

    @Override
    public List<LineaPedido> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            JavaType tipo = objectMapper.getTypeFactory().constructCollectionType(List.class, LineaPedido.class);
            return objectMapper.readValue(path.toFile(), tipo);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el fichero JSON de lineas de pedido", e);
        }
    }

    @Override
    public LineaPedido findById(Long id) {
        for (LineaPedido linea : findAll()) {
            if (linea.getId().equals(id)) {
                return linea;
            }
        }
        return null;
    }

    @Override
    public boolean update(LineaPedido lineaPedido) {
        List<LineaPedido> lineas = findAll();
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).getId().equals(lineaPedido.getId())) {
                lineas.set(i, lineaPedido);
                writeAll(lineas);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        List<LineaPedido> lineas = findAll();
        boolean eliminado = lineas.removeIf(l -> l.getId().equals(id));
        if (eliminado) {
            writeAll(lineas);
        }
        return eliminado;
    }

    private void writeAll(List<LineaPedido> lineas) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), lineas);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el fichero JSON de lineas de pedido", e);
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