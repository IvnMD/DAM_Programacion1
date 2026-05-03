package com.ejemplo.service;

import com.ejemplo.model.Alquiler;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AlquilerServiceSqliteTest {
    private AlquilerService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new AlquilerService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertTrue(service.findAll().size() >= 3); }

    @Test @Order(2)
    void findByIdExistenteDevuelveAlquiler() {
        Alquiler alquiler = service.findById(1);
        assertNotNull(alquiler);
        assertEquals("ACTIVO", alquiler.getEstado());
    }

    @Test @Order(3)
    void findByIdInexistenteDevuelveNull() { assertNull(service.findById(999)); }

    @Test @Order(4)
    void createDatosValidosGuardaAlquiler() {
        Alquiler alquiler = new Alquiler(null, "44444444A", 2, LocalDate.of(2030, 6, 1), LocalDate.of(2030, 6, 3), "ACTIVO");
        assertTrue(service.create(alquiler));
    }

    @Test @Order(5)
    void createClienteInactivoDevuelveFalse() {
        Alquiler alquiler = new Alquiler(null, "33333333P", 2, LocalDate.of(2030, 6, 1), LocalDate.of(2030, 6, 3), "ACTIVO");
        assertFalse(service.create(alquiler));
    }

    @Test @Order(6)
    void cancelByIdActivoCambiaEstado() {
        assertTrue(service.cancelById(1));
        assertEquals("CANCELADO", service.findById(1).getEstado());
    }

    @Test @Order(7)
    void completeByIdActivoCambiaEstado() {
        assertTrue(service.completeById(2));
        assertEquals("FINALIZADO", service.findById(2).getEstado());
    }
}
