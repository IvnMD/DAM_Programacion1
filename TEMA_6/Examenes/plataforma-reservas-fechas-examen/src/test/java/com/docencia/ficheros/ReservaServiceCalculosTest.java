package com.docencia.ficheros;

import com.docencia.ficheros.model.Reserva;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceCalculosTest extends BaseTest {
    @Test
    void calcularPrecioReserva1Test() {
        assertEquals(320.0, service.calcularPrecio(reservaRepository.findById(1)));
    }

    @Test
    void calcularPrecioReserva2Test() {
        assertEquals(240.0, service.calcularPrecio(reservaRepository.findById(2)));
    }

    @Test
    void calcularPrecioReserva3Test() {
        assertEquals(240.0, service.calcularPrecio(reservaRepository.findById(3)));
    }

    @Test
    void calcularPrecioReserva4Test() {
        assertEquals(500.0, service.calcularPrecio(reservaRepository.findById(4)));
    }

    @Test
    void calcularPrecioReserva5Test() {
        assertEquals(80.0, service.calcularPrecio(reservaRepository.findById(5)));
    }

    @Test
    void calcularPrecioReserva6Test() {
        assertEquals(400.0, service.calcularPrecio(reservaRepository.findById(6)));
    }

    @Test
    void calcularPrecioNullThrowsTest() {
        assertThrows(IllegalArgumentException.class, () -> service.calcularPrecio((Reserva) null));
    }

    @Test
    void totalIngresosTest() {
        assertEquals(1780.0, service.totalIngresos());
    }

    @Test
    void contarNochesTotalesTest() {
        assertEquals(18, service.contarNochesTotales());
    }

    @Test
    void reservaMasLargaTest() {
        assertEquals(5, service.reservaMasLarga().getNoches());
    }
}
