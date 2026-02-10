package unidad3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class Ejercicio01Test {

    @Test
    void testCalificacionesValidas() {
        assertEquals("Insuficiente", Ejercicio01.calificar(0));
        assertEquals("Insuficiente", Ejercicio01.calificar(4));
        assertEquals("Suficiente", Ejercicio01.calificar(5));
        assertEquals("Bien", Ejercicio01.calificar(6));
        assertEquals("Notable", Ejercicio01.calificar(7));
        assertEquals("Notable", Ejercicio01.calificar(8));
        assertEquals("Sobresaliente", Ejercicio01.calificar(9));
        assertEquals("Sobresaliente", Ejercicio01.calificar(10));
    }

    @Test
    void testNotaFueraDeRangoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio01.calificar(-1));
        assertThrows(IllegalArgumentException.class, () -> Ejercicio01.calificar(11));
    }
}
