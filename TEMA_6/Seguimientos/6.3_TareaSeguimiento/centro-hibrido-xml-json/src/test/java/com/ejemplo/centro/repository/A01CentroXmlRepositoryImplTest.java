package com.ejemplo.centro.repository;

import com.ejemplo.centro.TestDataHelper;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class A01CentroXmlRepositoryImplTest {

    @TempDir Path tempDir;
    private CentroXmlRepository repository;

    @BeforeEach
    void setUp() {
        Path xmlPath = tempDir.resolve("centro.xml");
        TestDataHelper.seedXml(xmlPath);
        repository = new CentroXmlRepositoryImpl(xmlPath);
    }

    @Test @Order(1)
    void xmlDevuelveTresProfesoresInicialesTest() {
        assertEquals(3, repository.findAllProfesores().size());
    }

    @Test @Order(2)
    void xmlDevuelveCuatroModulosInicialesTest() {
        assertEquals(4, repository.findAllModulos().size());
    }

    @Test @Order(3)
    void xmlRecuperaProfesorExistentePorIdTest() {
        Optional<Profesor> profesor = repository.findProfesorById("P01");
        assertTrue(profesor.isPresent());
        assertEquals("Ana Pérez", profesor.get().getNombre());
    }

    @Test @Order(4)
    void xmlNoRecuperaProfesorInexistentePorIdTest() {
        assertTrue(repository.findProfesorById("P99").isEmpty());
    }

    @Test @Order(5)
    void xmlRecuperaModuloExistentePorIdTest() {
        Optional<Modulo> modulo = repository.findModuloById("M02");
        assertTrue(modulo.isPresent());
        assertEquals("Acceso a datos", modulo.get().getNombre());
    }

    @Test @Order(6)
    void xmlNoRecuperaModuloInexistentePorIdTest() {
        assertTrue(repository.findModuloById("M99").isEmpty());
    }

    @Test @Order(7)
    void xmlFindAllProfesoresDevuelveCopiaDefensivaTest() {
        List<Profesor> profesores = repository.findAllProfesores();
        profesores.clear();
        assertEquals(3, repository.findAllProfesores().size());
    }

    @Test @Order(8)
    void xmlFindAllModulosDevuelveCopiaDefensivaTest() {
        List<Modulo> modulos = repository.findAllModulos();
        modulos.clear();
        assertEquals(4, repository.findAllModulos().size());
    }
}
