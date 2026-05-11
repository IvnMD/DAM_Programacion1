package com.ejemplo.service;

import com.ejemplo.model.Alquiler;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlquilerServiceEdgeCaseTest {
    private AlquilerService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new AlquilerService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertFalse(service.findAll().isEmpty()); }

    @Test @Order(2)
    void findByIdExistenteDevuelveAlquiler() { assertNotNull(service.findById(1)); }

    @Test @Order(3)
    void createVehiculoConAlquilerSolapadoDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "44444444A", 1, LocalDate.of(2030, 5, 11), LocalDate.of(2030, 5, 13), "ACTIVO");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(4)
    void createMismoVehiculoFechasNoSolapadasDevuelveTrue() {
        Alquiler alquiler = new Alquiler(null, "44444444A", 1, LocalDate.of(2030, 5, 12), LocalDate.of(2030, 5, 14), "ACTIVO");
        assertTrue(service.create(alquiler));
    }

    @Test @Order(5)
    void cancelByIdLiberaVehiculoParaNuevoAlquiler() {
        assertTrue(service.cancelById(1));
        Alquiler alquiler = new Alquiler(null, "44444444A", 1, LocalDate.of(2030, 5, 10), LocalDate.of(2030, 5, 12), "ACTIVO");
        assertTrue(service.create(alquiler));
    }

    @Test @Order(6)
    void createFechaFinAntesDeInicioDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "44444444A", 2, LocalDate.of(2030, 8, 5), LocalDate.of(2030, 8, 4), "ACTIVO");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(7)
    void completeByIdAlquilerCanceladoDevuelveFalse() {
        assertFalse(service.completeById(3));
    }
}
