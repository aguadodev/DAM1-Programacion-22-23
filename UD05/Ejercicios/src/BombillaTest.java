import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BombillaTest {
    @Test
    public void testEstaEncendida() {

        Bombilla b1 = new Bombilla();
        Bombilla b2 = new Bombilla();

        b1.encender();
        b2.encender();
        b2.apagar();

        Bombilla.setInterruptorGeneral(true);

        assertTrue(b1.estaEncendida());
        assertFalse(b2.estaEncendida());

        Bombilla.setInterruptorGeneral(false);

        assertFalse(b1.estaEncendida());
        assertFalse(b2.estaEncendida());        

        Bombilla.setInterruptorGeneral(true);
        b2.encender();

        assertTrue(b1.estaEncendida());
        assertTrue(b2.estaEncendida());        
    }
}
