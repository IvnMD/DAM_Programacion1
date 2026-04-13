package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Cliente;
import com.docencia.ficheros.repo.interfaces.IClienteRepository;
import com.docencia.ficheros.util.JsonManager;
import com.docencia.ficheros.util.ResourceUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryJson implements IClienteRepository {
    private final Path resourcePath;
    private final ResourceUtils resourceUtils;
    private final JsonManager jsonManager;
    private List<Cliente> clientes;

    



    public ClienteRepositoryJson(String resourcePath) {
        this.resourceUtils = new ResourceUtils();
        this.jsonManager = new JsonManager();
        this.resourcePath = Path.of("data", "clientes.json");
        Cliente cliente = jsonManager.read(Path.of("data", "clientes.json"));
        this.clientes = new ArrayList<>();
        

    }

    

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    @Override
    public Cliente findById(int id) {
        Cliente clienteBuscar = new Cliente(id);
        int indice = clientes.indexOf(clienteBuscar);
        if (indice < 0) return null;
        
        return clientes.get(indice);


    }

    
}
