package instrumentos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InstrumentoTest {
    @Test
    public void testEquals() {
        String[] melodia = {"LA", "RE", "MI"};        
        Piano piano = new Piano(melodia);
        Guitarra guitarraRitmica = new Guitarra(melodia);  
        Guitarra guitarraRitmica2 = new Guitarra(melodia);  
        Guitarra guitarraSolista = new Guitarra();

        assertTrue(guitarraRitmica.equals(guitarraRitmica2));
        assertFalse(guitarraRitmica.equals(guitarraSolista));
        assertFalse(guitarraRitmica.equals(piano));
    }
}
