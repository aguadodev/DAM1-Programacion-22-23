package horas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HoraExactaTest {
    @Test
    public void testInc() {
        HoraExacta hora = new HoraExacta(23,59,59);
        hora.inc();               
        assertEquals(hora.hora, 0);
        assertEquals(hora.minuto, 0);
        assertEquals(hora.segundo, 0);

    }

    @Test
    public void testSetSegundo() {
        HoraExacta hora = new HoraExacta(23,59,59);

        assertFalse(hora.setSegundo(-1));
        assertFalse(hora.setSegundo(60));
        assertEquals(hora.segundo, 59);                
        assertTrue(hora.setSegundo(0));       
        assertEquals(hora.segundo, 0);                
        assertTrue(hora.setSegundo(59)); 
        assertEquals(hora.segundo, 59);                
    }

    @Test
    public void testToString() {
        HoraExacta hora = new HoraExacta(23,59,59);
        assertEquals(hora.toString(), "23:59:59");                

        HoraExacta hora2 = new HoraExacta(3,9,5);
        assertEquals(hora2.toString(), "03:09:05");                
    }

    @Test
    public void testEquals() {
        HoraExacta hora = new HoraExacta(23,59,59);
        HoraExacta hora2 = new HoraExacta(23,59,59);
        HoraExacta hora3 = new HoraExacta(23,59,58);

        assertTrue(hora.equals(hora2)); 
        assertFalse(hora.equals(hora3)); 


    }
}
