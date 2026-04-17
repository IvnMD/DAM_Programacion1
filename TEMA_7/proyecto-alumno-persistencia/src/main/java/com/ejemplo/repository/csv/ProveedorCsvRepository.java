package com.ejemplo.repository.csv;

import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProveedorCsvRepository extends CsvReaderAbstract implements IProveedorRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public ProveedorCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Proveedor proveedor) {
        if (proveedor == null || proveedor.getId() == null || findById(proveedor.getId()) != null) {
            return false;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.file.StandardOpenOption.APPEND)) {
            bw.write(toLine(proveedor));
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear proveedor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Proveedor> findAll() {
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            for (String[] row : rows) {
                if (row.length >= 6) {
                    proveedores.add(fromRow(row));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer proveedores: " + e.getMessage());
        }
        return proveedores;
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
        boolean encontrado = false;
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getId().equals(proveedor.getId())) {
                proveedores.set(i, proveedor);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            writeAll(proveedores);
        }
        return encontrado;
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
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Proveedor p : proveedores) {
                bw.write(toLine(p));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir proveedores: " + e.getMessage());
        }
    }

    private String toLine(Proveedor p) {
        return p.getId() + separatorWrite
                + p.getCodigo() + separatorWrite
                + p.getNombre() + separatorWrite
                + p.getContacto() + separatorWrite
                + p.getEmail() + separatorWrite
                + p.getPais();
    }

    private Proveedor fromRow(String[] row) {
        return new Proveedor(
                Long.parseLong(row[0].trim()),
                row[1].trim(),
                row[2].trim(),
                row[3].trim(),
                row[4].trim(),
                row[5].trim()
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