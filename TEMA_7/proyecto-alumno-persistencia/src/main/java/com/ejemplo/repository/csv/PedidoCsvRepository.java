package com.ejemplo.repository.csv;

import com.ejemplo.model.Pedido;
import com.ejemplo.repository.IPedidoRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PedidoCsvRepository extends CsvReaderAbstract implements IPedidoRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public PedidoCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Pedido pedido) {
        if (pedido == null || pedido.getId() == null || findById(pedido.getId()) != null) {
            return false;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.file.StandardOpenOption.APPEND)) {
            bw.write(toLine(pedido));
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            for (String[] row : rows) {
                if (row.length >= 6) {
                    pedidos.add(fromRow(row));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer pedidos: " + e.getMessage());
        }
        return pedidos;
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
        boolean encontrado = false;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId().equals(pedido.getId())) {
                pedidos.set(i, pedido);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            writeAll(pedidos);
        }
        return encontrado;
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
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Pedido p : pedidos) {
                bw.write(toLine(p));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir pedidos: " + e.getMessage());
        }
    }

    private String toLine(Pedido p) {
        return p.getId() + separatorWrite
                + p.getNumero() + separatorWrite
                + p.getClienteId() + separatorWrite
                + p.getFecha() + separatorWrite
                + p.getEstado() + separatorWrite
                + p.getTotal();
    }

    private Pedido fromRow(String[] row) {
        return new Pedido(
                Long.parseLong(row[0].trim()),
                row[1].trim(),
                Long.parseLong(row[2].trim()),
                row[3].trim(),
                row[4].trim(),
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