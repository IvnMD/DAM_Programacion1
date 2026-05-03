package com.ejemplo.service;

import com.ejemplo.model.Vehiculo;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehiculoServiceSqliteTest {
    private VehiculoService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new VehiculoService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertTrue(service.findAll().size() >= 4); }

    @Test @Order(2)
    void findByIdExistenteDevuelveVehiculo() {
        Vehiculo vehiculo = service.findById(1);
        assertNotNull(vehiculo);
        assertEquals("Toyota", vehiculo.getMarca());
    }

    @Test @Order(3)
    void findByIdInexistenteDevuelveNull() { assertNull(service.findById(999)); }

    @Test @Order(4)
    void createDatosValidosGuardaVehiculo() {
        Vehiculo vehiculo = new Vehiculo(null, "Seat", "Leon", "ECONOMICO", 1);
        assertTrue(service.create(vehiculo));
    }

    @Test @Order(5)
    void updateDatosValidosActualizaVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Yaris Hybrid", "ECONOMICO", 1);
        assertTrue(service.update(vehiculo));
        assertEquals("Yaris Hybrid", service.findById(1).getModelo());
    }

    @Test @Order(6)
    void deleteByIdExistenteEliminaVehiculo() {
        assertTrue(service.deleteById(4));
        assertNull(service.findById(4));
    }
}
