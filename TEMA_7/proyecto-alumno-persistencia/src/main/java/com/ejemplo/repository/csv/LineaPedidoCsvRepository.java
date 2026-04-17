package com.ejemplo.repository.csv;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoCsvRepository extends CsvReaderAbstract implements ILineaPedidoRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public LineaPedidoCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(LineaPedido lineaPedido) {
        if (lineaPedido == null || lineaPedido.getId() == null || findById(lineaPedido.getId()) != null) {
            return false;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.file.StandardOpenOption.APPEND)) {
            bw.write(toLine(lineaPedido));
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear linea de pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<LineaPedido> findAll() {
        List<LineaPedido> lineas = new ArrayList<>();
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            for (String[] row : rows) {
                if (row.length >= 6) {
                    lineas.add(fromRow(row));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer lineas de pedido: " + e.getMessage());
        }
        return lineas;
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
        boolean encontrado = false;
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).getId().equals(lineaPedido.getId())) {
                lineas.set(i, lineaPedido);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            writeAll(lineas);
        }
        return encontrado;
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
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (LineaPedido l : lineas) {
                bw.write(toLine(l));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir lineas de pedido: " + e.getMessage());
        }
    }

    private String toLine(LineaPedido l) {
        return l.getId() + separatorWrite
                + l.getPedidoId() + separatorWrite
                + l.getProductoId() + separatorWrite
                + l.getCantidad() + separatorWrite
                + l.getPrecioUnitario() + separatorWrite
                + l.getSubtotal();
    }

    private LineaPedido fromRow(String[] row) {
        return new LineaPedido(
                Long.parseLong(row[0].trim()),
                Long.parseLong(row[1].trim()),
                Long.parseLong(row[2].trim()),
                Integer.parseInt(row[3].trim()),
                Double.parseDouble(row[4].trim()),
                Double.parseDouble(row[5].trim())
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