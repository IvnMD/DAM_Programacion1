package com.docencia.ficheros;

import com.docencia.ficheros.repo.ReservaRepositoryCsv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservaRepositoryCsvTest extends BaseTest {
    @Test
    void csvFindAllSizeTest() {
        assertEquals(6, reservaRepository.findAll().size());
    }

    @Test
    void csvFirstIdTest() {
        assertEquals(1, reservaRepository.findAll().get(0).getId());
    }

    @Test
    void csvFindByIdExistingTest() {
        assertNotNull(reservaRepository.findById(1));
    }

    @Test
    void csvFindByIdMissingTest() {
        assertNull(reservaRepository.findById(999));
    }

    @Test
    void csvClienteIdReserva1Test() {
        assertEquals(101, reservaRepository.findById(1).getClienteId());
    }

    @Test
    void csvHotelIdReserva2Test() {
        assertEquals(202, reservaRepository.findById(2).getHotelId());
    }

    @Test
    void csvNochesReserva1Test() {
        assertEquals(4, reservaRepository.findById(1).getNoches());
    }

    @Test
    void csvNochesReserva5Test() {
        assertEquals(1, reservaRepository.findById(5).getNoches());
    }

    @Test
    void csvFechaInicioReserva3Test() {
        assertEquals("2026-03-10", reservaRepository.findById(3).getFechaInicio());
    }

    @Test
    void csvFechaFinReserva4Test() {
        assertEquals("2026-03-20", reservaRepository.findById(4).getFechaFin());
    }

    @Test
    void csvInvalidoFechaFinAnteriorTest() {
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> new ReservaRepositoryCsv("data/reservas-invalidas.csv"));
        assertTrue(ex.getCause().getMessage().contains("La fecha fin no puede ser anterior"));
    }
}
