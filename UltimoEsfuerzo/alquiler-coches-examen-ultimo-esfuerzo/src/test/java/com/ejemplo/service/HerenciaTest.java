package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Persona;
import org.junit.jupiter.api.*;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HerenciaTest {
    @Test @Order(1)
    void personaEsClaseAbstracta() {
        assertTrue(Modifier.isAbstract(Persona.class.getModifiers()));
    }

    @Test @Order(2)
    void clienteHeredaDePersona() {
        assertEquals(Persona.class, Cliente.class.getSuperclass());
    }

    @Test @Order(3)
    void clienteEsInstanciaDePersona() {
        Cliente cliente = new Cliente("12345678Z", "Juan Perez", "612345678", "juan@email.com", 1);
        assertInstanceOf(Persona.class, cliente);
    }
}
