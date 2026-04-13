package com.docencia.ficheros.repo;

import com.docencia.ficheros.model.Cliente;
import com.docencia.ficheros.repo.interfaces.IClienteRepository;

import java.util.List;

public class ClienteRepositoryJson implements IClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepositoryJson(String resourcePath) {
  
        
    }

    @Override
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Cliente findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}
