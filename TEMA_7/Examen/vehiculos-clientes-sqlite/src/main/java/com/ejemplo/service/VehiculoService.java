package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.IVehiculoRepository;
import com.ejemplo.repository.sqlite.ClienteSqliteRepository;
import com.ejemplo.repository.sqlite.VehiculoSqliteRepository;

import java.util.ArrayList;
import java.util.List;

public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final IClienteRepository clienteRepository;

    public VehiculoService() {
        this.vehiculoRepository = new VehiculoSqliteRepository();
        this.clienteRepository = new ClienteSqliteRepository();
    }

    @Override
    public boolean crear(Vehiculo vehiculo) {
        if (!validar(vehiculo) || vehiculoRepository.findById(vehiculo.getId()) != null) {
            return false;
        }
        return vehiculoRepository.create(vehiculo);
    }

    @Override
    public Vehiculo buscarPorId(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) {
        if (!validar(vehiculo) || vehiculoRepository.findById(vehiculo.getId()) != null) {
            return false;
        }
        return vehiculoRepository.update(vehiculo);
    }

    @Override
    public boolean eliminar(Long id) {
        return vehiculoRepository.deleteById(id);
    }

    @Override
    public List<Vehiculo> listarPorCliente(String dni) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo item : vehiculoRepository.findAll()) {
            if (item.equals(dni)) { // !!!! REVISA ESTO PORQUE SUENA LOCURA
                resultado.add(item);
            }
        }
        return resultado;
    }

    @Override
    public List<Vehiculo> listarVendidos() {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo item : vehiculoRepository.findAll()) {
            if (item.isVendido()) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    @Override
    public List<Vehiculo> listarDisponibles() {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo item : vehiculoRepository.findAll()) {
            if (!item.isVendido()) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    @Override
    public boolean cambiarPropietario(Long vehiculoId, String nuevoDni) {

        Vehiculo vehiculoCambiar = new Vehiculo();
        vehiculoCambiar = vehiculoRepository.findById(vehiculoId);
        vehiculoCambiar.setDniCliente(nuevoDni);
        return true;
    }

    @Override
    public boolean marcarComoVendido(Long vehiculoId) {
        Vehiculo vehiculoCambiar = new Vehiculo();
        vehiculoCambiar = vehiculoRepository.findById(vehiculoId);
        vehiculoCambiar.isVendido();
        return true;
    }

    @Override
    public boolean actualizarKilometros(Long vehiculoId, int kilometros) {
        Vehiculo vehiculoCambiar = new Vehiculo();
        vehiculoCambiar = vehiculoRepository.findById(vehiculoId);
        vehiculoCambiar.setKilometros(kilometros);
        return true;
    }

    @Override
    public double calcularPrecioMedio() {
        double resultado = 0;
        int contador = 0;
        for (Vehiculo item : vehiculoRepository.findAll()) {
                resultado = resultado + item.getPrecio();
                contador++;
            }
            return resultado = resultado/contador;
        }
    

    @Override
    public double calcularValorTotalDisponible() {
        double suma = 0;
        for (Vehiculo item : vehiculoRepository.findAll()) {
            if (!item.isVendido()) {
                suma = suma + item.getPrecio();
            }
        }

        return suma;

    }

    @Override
    public int contarVehiculosDeCliente(String dniCliente) {
        // Cliente clienteBuscar = new Cliente();
        // clienteBuscar = clienteRepository.findById(dniCliente);
        // return clienteBuscar.listarPorCliente().size();
        throw new IllegalArgumentException();
    }

    private boolean validar(Vehiculo vehiculo) {
        return vehiculo != null && vehiculo.getId() != null && vehiculo.getMatricula() != null
                && !vehiculo.getMatricula().trim().isEmpty();
    }

}
