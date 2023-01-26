import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SintonizadorFMTest {
    @Test
    public void testDown() {
        SintonizadorFM radio1 = new SintonizadorFM(80.2);
        radio1.down();
        assertTrue(radio1.getFrecuencia() == 108);
    }

    @Test
    public void testUp() {
        SintonizadorFM radio1 = new SintonizadorFM(107.8);
        radio1.up();
        assertTrue(radio1.getFrecuencia() == 80);     
        
        SintonizadorFM radio2 = new SintonizadorFM(108);
        radio2.up();
        assertTrue(radio2.getFrecuencia() == 80);          
    }
}
