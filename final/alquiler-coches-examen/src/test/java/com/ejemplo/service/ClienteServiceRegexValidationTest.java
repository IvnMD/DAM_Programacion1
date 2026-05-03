package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteServiceRegexValidationTest {
    private ClienteService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new ClienteService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertFalse(service.findAll().isEmpty()); }

    @Test @Order(2)
    void findByDniInvalidoDevuelveNull() { assertNull(service.findByDni("1234")); }

    @Test @Order(3)
    void createDniInvalidoDevuelveFalse() {
        Cliente cliente = new Cliente("1234", "Juan Perez", "612345678", "juan@email.com", 1);
        assertFalse(service.create(cliente));
    }

    @Test @Order(4)
    void createEmailInvalidoDevuelveFalse() {
        Cliente cliente = new Cliente("12345678Z", "Juan Perez", "612345678", "juanemail.com", 1);
        assertFalse(service.create(cliente));
    }

    @Test @Order(5)
    void createTelefonoInvalidoDevuelveFalse() {
        Cliente cliente = new Cliente("12345678Z", "Juan Perez", "512345678", "juan@email.com", 1);
        assertFalse(service.create(cliente));
    }

    @Test @Order(6)
    void createNombreInvalidoDevuelveFalse() {
        Cliente cliente = new Cliente("12345678Z", "J", "612345678", "juan@email.com", 1);
        assertFalse(service.create(cliente));
    }

    @Test @Order(7)
    void findByEmailExistenteDevuelveCliente() { assertNotNull(service.findByEmail("ana@email.com")); }
}
