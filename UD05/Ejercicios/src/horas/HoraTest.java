package horas;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HoraTest {
    @Test
    public void testInc() {
        // Prueba el método inc
        Hora hora = new Hora(23,59);
        hora.inc();               
        assertEquals(hora.hora, 0);
        assertEquals(hora.minuto, 0);

        Hora hora2 = new Hora(22,58);

        hora2.inc();                       
        assertEquals(hora2.hora, 22);
        assertEquals(hora2.minuto, 59);  

        hora2.inc();                       
        assertEquals(hora2.hora, 23);
        assertEquals(hora2.minuto, 0);        
    }

    @Test
    public void testSetHora() {
        Hora hora = new Hora(23,59);

        assertFalse(hora.setHora(-1));
        assertFalse(hora.setHora(24));
        assertEquals(hora.hora, 23);        
        assertTrue(hora.setHora(0));
        assertEquals(hora.hora, 0);                
        assertTrue(hora.setHora(23)); 
        assertEquals(hora.hora, 23);        
        
    }

    @Test
    public void testSetMinuto() {
        Hora hora = new Hora(23,59);

        assertFalse(hora.setMinuto(-1));
        assertFalse(hora.setMinuto(60));
        assertEquals(hora.minuto, 59);        
        assertTrue(hora.setMinuto(0));
        assertEquals(hora.minuto, 0);                
        assertTrue(hora.setMinuto(59)); 
        assertEquals(hora.minuto, 59);                
    }
}
