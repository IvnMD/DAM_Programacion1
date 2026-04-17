package com.ejemplo.service;

import com.ejemplo.model.Vehiculo;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoServiceSqliteTest {


    private IVehiculoService vehiculoService;
    private IClienteService clienteService;

    @BeforeEach
    void setUp() {
        try {

            Files.copy(
                    Path.of(TestBackupManager.rutaBackupDb),
                    Path.of(TestBackupManager.rutaDb),
                    StandardCopyOption.REPLACE_EXISTING);
            clienteService = new ClienteService();
            vehiculoService = new VehiculoService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    private void crearClientesBase() {
        clienteService.crear(TestDataFactory.cliente1());
        clienteService.crear(TestDataFactory.cliente2());
        clienteService.crear(TestDataFactory.cliente3Inactivo());
    }

    @Test
    void crearVehiculoValidoFunciona() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        assertTrue(vehiculoService.crear(vehiculo));
        assertNotNull(vehiculo.getId());
    }

    @Test
    void noPermiteCrearVehiculoSinClienteExistente() {
        assertFalse(vehiculoService.crear(TestDataFactory.vehiculo1("11111111A")));
    }

    @Test
    void noPermiteCrearVehiculoConMatriculaVacia() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculo.setMatricula(" ");
        assertFalse(vehiculoService.crear(vehiculo));
    }

    @Test
    void noPermiteCrearVehiculoConMarcaVacia() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculo.setMarca(" ");
        assertFalse(vehiculoService.crear(vehiculo));
    }

    @Test
    void noPermiteCrearVehiculoConModeloVacio() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculo.setModelo(" ");
        assertFalse(vehiculoService.crear(vehiculo));
    }

    @Test
    void noPermiteCrearVehiculoConKilometrosNegativos() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculo.setKilometros(-1);
        assertFalse(vehiculoService.crear(vehiculo));
    }

    @Test
    void noPermiteCrearVehiculoConPrecioNoPositivo() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculo.setPrecio(0.0);
        assertFalse(vehiculoService.crear(vehiculo));
    }

    @Test
    void noPermiteCrearVehiculoDuplicadoPorMatricula() {
        crearClientesBase();
        assertTrue(vehiculoService.crear(TestDataFactory.vehiculo1("11111111A")));
        assertFalse(vehiculoService.crear(TestDataFactory.vehiculo1("11111111A")));
    }

    @Test
    void buscarPorIdExistenteDevuelveVehiculo() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertEquals("Seat", vehiculoService.buscarPorId(vehiculo.getId()).getMarca());
    }

    @Test
    void buscarPorIdInexistenteDevuelveNull() {
        assertNull(vehiculoService.buscarPorId(99L));
    }

    @Test
    void listarTodosEmpiezaVacioEnCadaTest() {
        assertEquals(0, vehiculoService.listarTodos().size());
    }

    @Test
    void actualizarVehiculoExistenteFunciona() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        vehiculo.setColor("Blanco");
        assertTrue(vehiculoService.actualizar(vehiculo));
        assertEquals("Blanco", vehiculoService.buscarPorId(vehiculo.getId()).getColor());
    }

    @Test
    void noPermiteActualizarVehiculoInexistente() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculo.setId(999L);
        assertFalse(vehiculoService.actualizar(vehiculo));
    }

    @Test
    void noPermiteActualizarVehiculoConClienteInexistente() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        vehiculo.setDniCliente("99999999Z");
        assertFalse(vehiculoService.actualizar(vehiculo));
    }

    @Test
    void eliminarVehiculoExistenteFunciona() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertTrue(vehiculoService.eliminar(vehiculo.getId()));
        assertNull(vehiculoService.buscarPorId(vehiculo.getId()));
    }

    @Test
    void eliminarVehiculoInexistenteDevuelveFalse() {
        assertFalse(vehiculoService.eliminar(1L));
    }

    @Test
    void listarPorClienteDevuelveSusVehiculos() {
        crearClientesBase();
        vehiculoService.crear(TestDataFactory.vehiculo1("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo2("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo3Vendido("22222222B"));
        assertEquals(2, vehiculoService.listarPorCliente("11111111A").size());
    }

    @Test
    void listarVendidosSoloIncluyeVendidos() {
        crearClientesBase();
        vehiculoService.crear(TestDataFactory.vehiculo1("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo3Vendido("22222222B"));
        assertEquals(1, vehiculoService.listarVendidos().size());
    }

    @Test
    void listarDisponiblesSoloIncluyeNoVendidos() {
        crearClientesBase();
        vehiculoService.crear(TestDataFactory.vehiculo1("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo3Vendido("22222222B"));
        assertEquals(1, vehiculoService.listarDisponibles().size());
    }

    @Test
    void cambiarPropietarioFuncionaSiNuevoClienteExiste() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertTrue(vehiculoService.cambiarPropietario(vehiculo.getId(), "22222222B"));
        assertEquals("22222222B", vehiculoService.buscarPorId(vehiculo.getId()).getDniCliente());
    }

    @Test
    void cambiarPropietarioFallaSiVehiculoNoExiste() {
        crearClientesBase();
        assertFalse(vehiculoService.cambiarPropietario(999L, "22222222B"));
    }

    @Test
    void cambiarPropietarioFallaSiClienteNoExiste() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertFalse(vehiculoService.cambiarPropietario(vehiculo.getId(), "99999999Z"));
    }

    @Test
    void marcarComoVendidoFuncionaUnaVez() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertTrue(vehiculoService.marcarComoVendido(vehiculo.getId()));
        assertTrue(vehiculoService.buscarPorId(vehiculo.getId()).isVendido());
    }

    @Test
    void marcarComoVendidoFallaSiYaEstaVendido() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo3Vendido("11111111A");
        vehiculoService.crear(vehiculo);
        assertFalse(vehiculoService.marcarComoVendido(vehiculo.getId()));
    }

    @Test
    void marcarComoVendidoFallaSiNoExiste() {
        assertFalse(vehiculoService.marcarComoVendido(1L));
    }

    @Test
    void actualizarKilometrosFunciona() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertTrue(vehiculoService.actualizarKilometros(vehiculo.getId(), 30000));
        assertEquals(30000, vehiculoService.buscarPorId(vehiculo.getId()).getKilometros());
    }

    @Test
    void actualizarKilometrosFallaSiValorEsNegativo() {
        crearClientesBase();
        Vehiculo vehiculo = TestDataFactory.vehiculo1("11111111A");
        vehiculoService.crear(vehiculo);
        assertFalse(vehiculoService.actualizarKilometros(vehiculo.getId(), -10));
    }

    @Test
    void actualizarKilometrosFallaSiVehiculoNoExiste() {
        assertFalse(vehiculoService.actualizarKilometros(1L, 100));
    }

    @Test
    void calcularPrecioMedioDevuelveCeroSinVehiculos() {
        assertEquals(0.0, vehiculoService.calcularPrecioMedio(), 0.001);
    }

    @Test
    void calcularPrecioMedioFunciona() {
        crearClientesBase();
        vehiculoService.crear(TestDataFactory.vehiculo1("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo2("11111111A"));
        assertEquals(11150.0, vehiculoService.calcularPrecioMedio(), 0.001);
    }

    @Test
    void calcularValorTotalDisponibleSumaSoloNoVendidos() {
        crearClientesBase();
        vehiculoService.crear(TestDataFactory.vehiculo1("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo2("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo3Vendido("22222222B"));
        assertEquals(22300.0, vehiculoService.calcularValorTotalDisponible(), 0.001);
    }

    @Test
    void contarVehiculosDeClienteFunciona() {
        crearClientesBase();
        vehiculoService.crear(TestDataFactory.vehiculo1("11111111A"));
        vehiculoService.crear(TestDataFactory.vehiculo2("11111111A"));
        assertEquals(2, vehiculoService.contarVehiculosDeCliente("11111111A"));
    }

    @Test
    void crearVehiculoParaClienteInactivoEsValidoPorqueExiste() {
        crearClientesBase();
        assertTrue(vehiculoService.crear(TestDataFactory.vehiculo1("33333333C")));
    }

    @Test
    void restauracionDeBackupAislaLosTests() {
        crearClientesBase();
        assertEquals(0, vehiculoService.listarTodos().size());
    }
}
