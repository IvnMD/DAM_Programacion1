package com.docencia.ficheros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceAgregadosTest extends BaseTest {
    @Test
    void totalGastadoCliente101Test() {
        assertEquals(560.0, service.totalGastadoPorCliente(101));
    }

    @Test
    void totalGastadoCliente102Test() {
        assertEquals(640.0, service.totalGastadoPorCliente(102));
    }

    @Test
    void totalGastadoCliente103Test() {
        assertEquals(500.0, service.totalGastadoPorCliente(103));
    }

    @Test
    void totalGastadoCliente104Test() {
        assertEquals(80.0, service.totalGastadoPorCliente(104));
    }

    @Test
    void totalGastadoClienteMissingThrowsTest() {
        assertThrows(IllegalArgumentException.class, () -> service.totalGastadoPorCliente(999));
    }

    @Test
    void hotelMasRentableIdTest() {
        assertEquals(203, service.hotelMasRentable().getId());
    }

    @Test
    void hotelMasRentableNombreTest() {
        assertEquals("Hotel Sierra", service.hotelMasRentable().getNombre());
    }

    @Test
    void totalReservasPorHotel201Test() {
        assertEquals(2, service.totalReservasPorHotel(201));
    }

    @Test
    void totalReservasPorHotel202Test() {
        assertEquals(2, service.totalReservasPorHotel(202));
    }

    @Test
    void totalReservasPorHotel203Test() {
        assertEquals(2, service.totalReservasPorHotel(203));
    }
}
