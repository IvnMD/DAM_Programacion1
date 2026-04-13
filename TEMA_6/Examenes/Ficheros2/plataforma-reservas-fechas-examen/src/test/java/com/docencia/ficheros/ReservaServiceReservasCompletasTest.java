package com.docencia.ficheros;

import com.docencia.ficheros.model.ReservaCompleta;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceReservasCompletasTest extends BaseTest {
    @Test
    void reservasCompletasListSizeTest() {
        assertEquals(6, service.getReservasCompletas().size());
    }

    @Test
    void reservaCompleta1ClienteNombreTest() {
        assertEquals("Ana", service.getReservaCompletaById(1).clienteNombre());
    }

    @Test
    void reservaCompleta1HotelNombreTest() {
        assertEquals("Hotel Sol", service.getReservaCompletaById(1).hotelNombre());
    }

    @Test
    void reservaCompleta2ClienteNombreTest() {
        assertEquals("Luis", service.getReservaCompletaById(2).clienteNombre());
    }

    @Test
    void reservaCompleta4HotelNombreTest() {
        assertEquals("Hotel Sierra", service.getReservaCompletaById(4).hotelNombre());
    }

    @Test
    void reservaCompleta1NochesTest() {
        assertEquals(4, service.getReservaCompletaById(1).noches());
    }

    @Test
    void reservaCompleta2PrecioTotalTest() {
        assertEquals(240.0, service.getReservaCompletaById(2).precioTotal());
    }

    @Test
    void reservaCompleta5PrecioTotalTest() {
        assertEquals(80.0, service.getReservaCompletaById(5).precioTotal());
    }

    @Test
    void reservaCompletaIdMissingThrowsTest() {
        assertThrows(IllegalArgumentException.class, () -> service.getReservaCompletaById(999));
    }

    @Test
    void reservasCompletasContainsHotelMarTest() {
        List<ReservaCompleta> reservasCompletas = service.getReservasCompletas();
        assertTrue(reservasCompletas.stream().anyMatch(d -> d.hotelNombre().equals("Hotel Mar")));
    }
}
