package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.sqlite.ClienteSqliteRepository;
import com.ejemplo.validation.ValidationUtils;

public class ClienteService implements IClienteService {
      private final IClienteRepository repository;

      public ClienteService() {
            this.repository = new ClienteSqliteRepository();
      }

      @Override
      public boolean create(Cliente cliente) {
            if (!ValidationUtils.isValidCliente(cliente)) {
                  return false;
            }
            return repository.create(cliente);
      }

      @Override
      public Cliente findByDni(String dni) {
            if (!ValidationUtils.isValidDni(dni)) {
                  return null;
            }
            return repository.findByDni(dni);
      }

      @Override
      public List<Cliente> findAll() {
            return repository.findAll();
      }

      @Override
      public boolean update(Cliente cliente) {
            if (!ValidationUtils.isValidCliente(cliente)) {
                  return false;
            }
            return repository.update(cliente);

      }

      @Override
      public boolean deleteByDni(String dni) {
                        if (!ValidationUtils.isValidDni(dni)) {
                  return false;
            }
            return repository.deleteByDni(dni);

      }

      @Override
      public List<Cliente> findActivos() {
            return repository.findActivos();
      }

      @Override
      public Cliente findByEmail(String email) {
            if (!ValidationUtils.isValidEmail(email)) {
                  return null;
            }
            return repository.findByEmail(email);

      }

}
