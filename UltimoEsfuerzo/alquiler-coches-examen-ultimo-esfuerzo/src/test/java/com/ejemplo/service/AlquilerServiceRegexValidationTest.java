package com.ejemplo.service;

import com.ejemplo.model.Alquiler;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlquilerServiceRegexValidationTest {
    private AlquilerService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new AlquilerService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertFalse(service.findAll().isEmpty()); }

    @Test @Order(2)
    void findByIdInvalidoDevuelveNull() { assertNull(service.findById(-1)); }

    @Test @Order(3)
    void createEstadoInvalidoDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "11111111H", 2, LocalDate.of(2030, 7, 1), LocalDate.of(2030, 7, 3), "PENDIENTE");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(4)
    void createDniInvalidoDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "1234", 2, LocalDate.of(2030, 7, 1), LocalDate.of(2030, 7, 3), "ACTIVO");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(5)
    void createFechaPasadaDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "11111111H", 2, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 3), "ACTIVO");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(6)
    void createVehiculoInexistenteDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "11111111H", 999, LocalDate.of(2030, 7, 1), LocalDate.of(2030, 7, 3), "ACTIVO");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(7)
    void cancelByIdAlquilerYaCanceladoDevuelveFalse() {
        assertFalse(service.cancelById(3));
    }
}
