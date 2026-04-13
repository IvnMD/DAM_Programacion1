package com.docencia.ficheros.util;

import com.docencia.ficheros.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonManager {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Cliente read(Path path) {
        try {
            if (path == null || !Files.exists(path)) {
                return new Cliente();
            }
            return objectMapper.readValue(path.toFile(), Cliente.class);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer el JSON", e);
        }
    }

    public void write(Path path, Cliente data) {
        try {
            if (path == null) {
                throw new IllegalArgumentException("La ruta JSON no puede ser null");
            }
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), data);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo escribir el JSON", e);
        }
    }
}
