import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilTest {
    @Test
    public void testEsNumero() {
        float f = (float)2.5;
        short s = (short)2;
        byte b = (byte)2;
        long l = (long)6;

        assertFalse(Util.esNumero(new Persona("Pepe"))); 

        assertTrue(Util.esNumero(2));
        assertTrue(Util.esNumero(2.5));
        assertFalse(Util.esNumero("2"));
        assertFalse(Util.esNumero('2'));        
        assertTrue(Util.esNumero(f));        
        assertTrue(Util.esNumero(s));        
        assertTrue(Util.esNumero(b));        
        assertTrue(Util.esNumero(l)); 
    }

}
