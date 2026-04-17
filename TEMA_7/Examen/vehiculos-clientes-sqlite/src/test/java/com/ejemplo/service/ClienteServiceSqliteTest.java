package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceSqliteTest {

    private IClienteService serviceCliente;


    @BeforeEach
    void setUp() {
        try {
            Files.copy(
                    Path.of(TestBackupManager.rutaBackupDb),
                    Path.of(TestBackupManager.rutaDb),
                    StandardCopyOption.REPLACE_EXISTING);
            serviceCliente = new ClienteService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }


    @Test
    void crearClienteValidoFunciona() {
        assertTrue(serviceCliente.crear(TestDataFactory.cliente1()));
        assertNotNull(serviceCliente.buscarPorDni("11111111A"));
    }

    @Test
    void crearDosClientesValidosFunciona() {
        assertTrue(serviceCliente.crear(TestDataFactory.cliente1()));
        assertTrue(serviceCliente.crear(TestDataFactory.cliente2()));
        assertEquals(2, serviceCliente.listarTodos().size());
    }

    @Test
    void noPermiteCrearClienteConDniNulo() {
        Cliente cliente = TestDataFactory.cliente1();
        cliente.setDni(null);
        assertFalse(serviceCliente.crear(cliente));
    }

    @Test
    void noPermiteCrearClienteConDniVacio() {
        Cliente cliente = TestDataFactory.cliente1();
        cliente.setDni(" ");
        assertFalse(serviceCliente.crear(cliente));
    }

    @Test
    void noPermiteCrearClienteConNombreNulo() {
        Cliente cliente = TestDataFactory.cliente1();
        cliente.setNombre(null);
        assertFalse(serviceCliente.crear(cliente));
    }

    @Test
    void noPermiteCrearClienteConNombreVacio() {
        Cliente cliente = TestDataFactory.cliente1();
        cliente.setNombre("  ");
        assertFalse(serviceCliente.crear(cliente));
    }

    @Test
    void noPermiteCrearClienteDuplicado() {
        assertTrue(serviceCliente.crear(TestDataFactory.cliente1()));
        assertFalse(serviceCliente.crear(TestDataFactory.cliente1()));
        assertEquals(1, serviceCliente.listarTodos().size());
    }

    @Test
    void buscarPorDniExistenteDevuelveCliente() {
        serviceCliente.crear(TestDataFactory.cliente1());
        assertEquals("Ana", serviceCliente.buscarPorDni("11111111A").getNombre());
    }

    @Test
    void buscarPorDniInexistenteDevuelveNull() {
        assertNull(serviceCliente.buscarPorDni("99999999Z"));
    }

    @Test
    void listarTodosEmpiezaVacioEnCadaTest() {
        assertEquals(0, serviceCliente.listarTodos().size());
    }

    @Test
    void actualizarClienteExistenteFunciona() {
        Cliente cliente = TestDataFactory.cliente1();
        serviceCliente.crear(cliente);
        cliente.setCiudad("Valencia");
        assertTrue(serviceCliente.actualizar(cliente));
        assertEquals("Valencia", serviceCliente.buscarPorDni(cliente.getDni()).getCiudad());
    }

    @Test
    void noPermiteActualizarClienteInexistente() {
        assertFalse(serviceCliente.actualizar(TestDataFactory.cliente1()));
    }

    @Test
    void noPermiteActualizarClienteInvalido() {
        Cliente cliente = TestDataFactory.cliente1();
        serviceCliente.crear(cliente);
        cliente.setNombre(" ");
        assertFalse(serviceCliente.actualizar(cliente));
    }

    @Test
    void eliminarClienteExistenteFunciona() {
        serviceCliente.crear(TestDataFactory.cliente1());
        assertTrue(serviceCliente.eliminar("11111111A"));
        assertNull(serviceCliente.buscarPorDni("11111111A"));
    }

    @Test
    void eliminarClienteInexistenteDevuelveFalse() {
        assertFalse(serviceCliente.eliminar("11111111A"));
    }

    @Test
    void listarActivosSoloIncluyeActivos() {
        serviceCliente.crear(TestDataFactory.cliente1());
        serviceCliente.crear(TestDataFactory.cliente3Inactivo());
        assertEquals(1, serviceCliente.listarActivos().size());
    }

    @Test
    void contarActivosFunciona() {
        serviceCliente.crear(TestDataFactory.cliente1());
        serviceCliente.crear(TestDataFactory.cliente2());
        serviceCliente.crear(TestDataFactory.cliente3Inactivo());
        assertEquals(2, serviceCliente.contarActivos());
    }

    @Test
    void buscarPorCiudadEncuentraCoincidencias() {
        serviceCliente.crear(TestDataFactory.cliente1());
        serviceCliente.crear(TestDataFactory.cliente2());
        serviceCliente.crear(TestDataFactory.cliente3Inactivo());
        assertEquals(2, serviceCliente.buscarPorCiudad("Madrid").size());
    }

    @Test
    void buscarPorCiudadIgnoraMayusculas() {
        serviceCliente.crear(TestDataFactory.cliente1());
        assertEquals(1, serviceCliente.buscarPorCiudad("madrid").size());
    }

    @Test
    void buscarPorCiudadSinCoincidenciasDevuelveVacio() {
        serviceCliente.crear(TestDataFactory.cliente1());
        assertEquals(0, serviceCliente.buscarPorCiudad("Bilbao").size());
    }

    @Test
    void crearClienteInactivoEsValido() {
        assertTrue(serviceCliente.crear(TestDataFactory.cliente3Inactivo()));
        assertFalse(serviceCliente.buscarPorDni("33333333C").isActivo());
    }

    @Test
    void restauracionDeBackupAislaLosTests() {
        serviceCliente.crear(TestDataFactory.cliente1());
        assertEquals(1, serviceCliente.listarTodos().size());
    }
}
