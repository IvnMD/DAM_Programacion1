package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Cliente;
import com.docencia.ficheros.repo.interfaces.IClienteRepository;
import com.docencia.ficheros.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class ClienteRepositoryJson implements IClienteRepository {

    private List<Cliente> clientes;
    private final String path;

    public ClienteRepositoryJson(String resourcePath) {
        this.path = resourcePath;

    }

    @Override
    public List<Cliente> findAll() {
        try (InputStream is = ResourceUtils.getResourceAsStream(path)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, new TypeReference<List<Cliente>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Cliente findById(int id) {
        for (Cliente cliente : findAll()) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

}
