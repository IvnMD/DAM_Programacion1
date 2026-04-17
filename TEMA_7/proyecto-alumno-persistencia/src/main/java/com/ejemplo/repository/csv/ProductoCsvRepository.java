package com.ejemplo.repository.csv;

import com.ejemplo.model.Producto;
import com.ejemplo.repository.IProductoRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductoCsvRepository extends CsvReaderAbstract implements IProductoRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public ProductoCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.path = inicializarPath(ruta);
    }

    @Override
    public boolean create(Producto producto) {
        if (producto == null || producto.getId() == null || findById(producto.getId()) != null) {
            return false;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(path, java.nio.file.StandardOpenOption.APPEND)) {
            bw.write(toLine(producto));
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al crear producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            for (String[] row : rows) {
                if (row.length >= 7) {
                    productos.add(fromRow(row));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer productos: " + e.getMessage());
        }
        return productos;
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
        boolean encontrado = false;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(producto.getId())) {
                productos.set(i, producto);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            writeAll(productos);
        }
        return encontrado;
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
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Producto p : productos) {
                bw.write(toLine(p));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir productos: " + e.getMessage());
        }
    }

    private String toLine(Producto p) {
        return p.getId() + separatorWrite
                + p.getSku() + separatorWrite
                + p.getNombre() + separatorWrite
                + p.getCategoria() + separatorWrite
                + p.getPrecio() + separatorWrite
                + p.getStock() + separatorWrite
                + p.isActivo();
    }

    private Producto fromRow(String[] row) {
        return new Producto(
                Long.parseLong(row[0].trim()),
                row[1].trim(),
                row[2].trim(),
                row[3].trim(),
                Double.parseDouble(row[4].trim()),
                Integer.parseInt(row[5].trim()),
                Boolean.parseBoolean(row[6].trim())
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