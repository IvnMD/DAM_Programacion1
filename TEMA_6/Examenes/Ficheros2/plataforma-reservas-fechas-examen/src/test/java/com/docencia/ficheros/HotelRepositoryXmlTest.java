package com.docencia.ficheros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelRepositoryXmlTest extends BaseTest {
    @Test
    void xmlFindAllSizeTest() {
        assertEquals(3, hotelRepository.findAll().size());
    }

    @Test
    void xmlFindByIdExistingTest() {
        assertNotNull(hotelRepository.findById(201));
    }

    @Test
    void xmlFindByIdMissingTest() {
        assertNull(hotelRepository.findById(999));
    }

    @Test
    void xmlNombreHotel201Test() {
        assertEquals("Hotel Sol", hotelRepository.findById(201).getNombre());
    }

    @Test
    void xmlNombreHotel202Test() {
        assertEquals("Hotel Mar", hotelRepository.findById(202).getNombre());
    }

    @Test
    void xmlNombreHotel203Test() {
        assertEquals("Hotel Sierra", hotelRepository.findById(203).getNombre());
    }

    @Test
    void xmlPrecioHotel201Test() {
        assertEquals(80.0, hotelRepository.findById(201).getPrecioNoche());
    }

    @Test
    void xmlPrecioHotel202Test() {
        assertEquals(120.0, hotelRepository.findById(202).getPrecioNoche());
    }

    @Test
    void xmlPrecioHotel203Test() {
        assertEquals(100.0, hotelRepository.findById(203).getPrecioNoche());
    }

    @Test
    void xmlContainsHotel203Test() {
        assertTrue(hotelRepository.findAll().stream().anyMatch(h -> h.getId() == 203));
    }
}
