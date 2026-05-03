package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteServiceSqliteTest {
    private ClienteService service;

    @BeforeEach
    void setUp() { TestDatabaseSupport.resetDatabase(); service = new ClienteService(); }

    @Test @Order(1)
    void findAllConDatosDevuelveLista() { assertTrue(service.findAll().size() >= 4); }

    @Test @Order(2)
    void findByDniExistenteDevuelveCliente() {
        Cliente cliente = service.findByDni("11111111H");
        assertNotNull(cliente);
        assertEquals("Ana Martin", cliente.getNombre());
    }

    @Test @Order(3)
    void findByDniInexistenteDevuelveNull() { assertNull(service.findByDni("99999999R")); }

    @Test @Order(4)
    void createDatosValidosGuardaCliente() {
        Cliente cliente = new Cliente("66666666Q", "Pedro Lopez", "655666777", "pedro@email.com", 1);
        assertTrue(service.create(cliente));
    }

    @Test @Order(5)
    void updateDatosValidosActualizaCliente() {
        Cliente cliente = new Cliente("11111111H", "Ana Martin", "600111222", "ana.nueva@email.com", 1);
        assertTrue(service.update(cliente));
        assertEquals("ana.nueva@email.com", service.findByDni("11111111H").getEmail());
    }

    @Test @Order(6)
    void deleteByDniExistenteEliminaCliente() {
        assertTrue(service.deleteByDni("44444444A"));
        assertNull(service.findByDni("44444444A"));
    }

    @Test @Order(7)
    void findActivosConDatosDevuelveLista() { assertTrue(service.findActivos().size() >= 3); }
}
