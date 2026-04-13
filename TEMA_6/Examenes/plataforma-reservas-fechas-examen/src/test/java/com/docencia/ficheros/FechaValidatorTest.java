package com.docencia.ficheros;

import com.docencia.ficheros.model.Reserva;
import com.docencia.ficheros.util.FechaValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FechaValidatorTest {

    @Test
    void fechaValidaFormatoIsoTest() {
        assertTrue(FechaValidator.isFechaValida("2026-03-15"));
    }

    @Test
    void fechaInvalidaMesIncorrectoTest() {
        assertFalse(FechaValidator.isFechaValida("2026-13-15"));
    }

    @Test
    void fechaInvalidaTextoLibreTest() {
        assertFalse(FechaValidator.isFechaValida("15/03/2026"));
    }

    @Test
    void rangoValidoMismoDiaTest() {
        assertTrue(FechaValidator.isRangoValido("2026-03-15", "2026-03-15"));
    }

    @Test
    void rangoInvalidoFechaFinAnteriorTest() {
        assertFalse(FechaValidator.isRangoValido("2026-03-20", "2026-03-15"));
    }

    @Test
    void validarRangoLanzaExcepcionSiFechaInicioEsInvalidaTest() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> FechaValidator.validarRango("2026/03/20", "2026-03-25"));
        assertTrue(ex.getMessage().contains("Fecha de inicio inválida"));
    }

    @Test
    void validarRangoLanzaExcepcionSiFechaFinEsAnteriorTest() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> FechaValidator.validarRango("2026-03-20", "2026-03-19"));
        assertTrue(ex.getMessage().contains("La fecha fin no puede ser anterior"));
    }

    @Test
    void reservaConFechasTextoCalculaNochesCorrectamenteTest() {
        Reserva reserva = new Reserva(99, 101, 201, "2026-04-01", "2026-04-05");
        assertEquals(4, reserva.getNoches());
        assertEquals("2026-04-01", reserva.getFechaInicio());
        assertEquals("2026-04-05", reserva.getFechaFin());
    }
}
