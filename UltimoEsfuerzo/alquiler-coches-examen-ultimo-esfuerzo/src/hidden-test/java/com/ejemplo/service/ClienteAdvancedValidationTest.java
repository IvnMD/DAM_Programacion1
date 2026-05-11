package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteAdvancedValidationTest {
    private ClienteService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new ClienteService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertFalse(service.findAll().isEmpty()); }

    @Test @Order(2)
    void findByDniExistenteDevuelveCliente() { assertNotNull(service.findByDni("11111111H")); }

    @Test @Order(3)
    void createDniConLetraIncorrectaDevuelveFalse() {
        Cliente cliente = new Cliente("12345678A", "Juan Perez", "612345678", "juan@email.com", 1);
        assertFalse(service.create(cliente));
    }

    @Test @Order(4)
    void createEmailSinDominioDevuelveFalse() {
        Cliente cliente = new Cliente("12345678Z", "Juan Perez", "612345678", "juan@", 1);
        assertFalse(service.create(cliente));
    }

    @Test @Order(5)
    void createClienteDuplicadoDevuelveFalse() {
        Cliente cliente = new Cliente("11111111H", "Ana Martin", "600111222", "ana2@email.com", 1);
        assertFalse(service.create(cliente));
    }
}
