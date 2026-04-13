package com.docencia.ficheros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteRepositoryJsonTest extends BaseTest {
    @Test
    void jsonFindAllSizeTest() {
        assertEquals(4, clienteRepository.findAll().size());
    }

    @Test
    void jsonFindByIdExistingTest() {
        assertNotNull(clienteRepository.findById(101));
    }

    @Test
    void jsonFindByIdMissingTest() {
        assertNull(clienteRepository.findById(999));
    }

    @Test
    void jsonNombreAnaTest() {
        assertEquals("Ana", clienteRepository.findById(101).getNombre());
    }

    @Test
    void jsonNombreLuisTest() {
        assertEquals("Luis", clienteRepository.findById(102).getNombre());
    }

    @Test
    void jsonNombreMartaTest() {
        assertEquals("Marta", clienteRepository.findById(103).getNombre());
    }

    @Test
    void jsonNombreCarlosTest() {
        assertEquals("Carlos", clienteRepository.findById(104).getNombre());
    }

    @Test
    void jsonContainsCliente101Test() {
        assertTrue(clienteRepository.findAll().stream().anyMatch(c -> c.getId() == 101));
    }

    @Test
    void jsonContainsCliente104Test() {
        assertTrue(clienteRepository.findAll().stream().anyMatch(c -> c.getId() == 104));
    }

    @Test
    void jsonNotContainsCliente999Test() {
        assertFalse(clienteRepository.findAll().stream().anyMatch(c -> c.getId() == 999));
    }
}
