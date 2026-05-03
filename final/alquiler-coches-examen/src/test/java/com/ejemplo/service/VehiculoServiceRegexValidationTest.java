package com.ejemplo.service;

import com.ejemplo.model.Vehiculo;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehiculoServiceRegexValidationTest {
    private VehiculoService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new VehiculoService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertFalse(service.findAll().isEmpty()); }

    @Test @Order(2)
    void findByIdInvalidoDevuelveNull() { assertNull(service.findById(-1)); }

    @Test @Order(3)
    void createTipoInvalidoDevuelveFalse() {
        Vehiculo vehiculo = new Vehiculo(null, "Seat", "Leon", "LUJO", 1);
        assertFalse(service.create(vehiculo));
    }

    @Test @Order(4)
    void createMarcaInvalidaDevuelveFalse() {
        Vehiculo vehiculo = new Vehiculo(null, "S", "Leon", "ECONOMICO", 1);
        assertFalse(service.create(vehiculo));
    }

    @Test @Order(5)
    void createDisponibleInvalidoDevuelveFalse() {
        Vehiculo vehiculo = new Vehiculo(null, "Seat", "Leon", "ECONOMICO", 3);
        assertFalse(service.create(vehiculo));
    }

    @Test @Order(6)
    void findByTipoExistenteDevuelveLista() { assertFalse(service.findByTipo("ECONOMICO").isEmpty()); }
}
