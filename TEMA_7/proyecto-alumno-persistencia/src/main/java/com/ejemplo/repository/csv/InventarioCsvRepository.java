package com.ejemplo.repository.csv;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InventarioCsvRepository extends CsvReaderAbstract implements IInventarioRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public InventarioCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Inventario inventario) {
        if (inventario == null || inventario.getId() == null || findById(inventario.getId()) != null) {
            return false;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.file.StandardOpenOption.APPEND)) {
            bw.write(toLine(inventario));
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear inventario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Inventario> findAll() {
        List<Inventario> inventarios = new ArrayList<>();
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            for (String[] row : rows) {
                if (row.length >= 7) {
                    inventarios.add(fromRow(row));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer inventarios: " + e.getMessage());
        }
        return inventarios;
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
        boolean encontrado = false;
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId().equals(inventario.getId())) {
                inventarios.set(i, inventario);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            writeAll(inventarios);
        }
        return encontrado;
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
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Inventario inv : inventarios) {
                bw.write(toLine(inv));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir inventarios: " + e.getMessage());
        }
    }

    private String toLine(Inventario inv) {
        return inv.getId() + separatorWrite
                + inv.getProductoId() + separatorWrite
                + inv.getProveedorId() + separatorWrite
                + inv.getUbicacion() + separatorWrite
                + inv.getStockDisponible() + separatorWrite
                + inv.getStockMinimo() + separatorWrite
                + inv.getFechaActualizacion();
    }

    private Inventario fromRow(String[] row) {
        return new Inventario(
                Long.parseLong(row[0].trim()),
                Long.parseLong(row[1].trim()),
                Long.parseLong(row[2].trim()),
                row[3].trim(),
                Integer.parseInt(row[4].trim()),
                Integer.parseInt(row[5].trim()),
                row[6].trim()
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