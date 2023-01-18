/**
 * CLASE DE PRUEBAS junit-4
 */
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    @Test
    public void testRango() {

        int[] t = null;
        int[] t2 = {};
        int[] t3 = {5};
        int[] t4 = {5,8};
        int[] t5 = {4, 6, 2, 9, 10, -2};        

        assertEquals(0, App.rango(t));
        assertEquals(0, App.rango(t2));
        assertEquals(0, App.rango(t3));
        assertEquals(3, App.rango(t4));
        assertEquals(12, App.rango(t5));

	// NUEVOS TESTS
	int[] t6 = {-4, -6, -2, -9, -10, -2};
	assertEquals(8, App.rango(t6));
    }

    @Test
    public void testCambiarColor() {
        int[][] img = {
            {0,1,2,3,4},
            {0,1,2,3,4},
            {0,1,2,3,4},
            {0,1,2,3,4}
        };

        int[][] img2 = {
            {5,1,2,3,4},
            {5,1,2,3,4},
            {5,1,2,3,4},
            {5,1,2,3,4}
        };    
        
        int[][] img3 = {
            {5,1,2,3,7},
            {5,1,2,3,7},
            {5,1,2,3,7},
            {5,1,2,3,7}
        };         

        assertTrue(App.cambiarColor(img, 0, 5));
        assertArrayEquals(img, img2);

        assertFalse(App.cambiarColor(img, 0, 5));
        assertTrue(App.cambiarColor(img, 4, 7));        

        assertArrayEquals(img, img3);

        // NUEVOS TESTS
        int[][] img42 = {
            {0,1},
            {0,1},
            {0,1},
            {0,1}
        };

        int[][] img42b = {
            {5,10},
            {5,10},
            {5,10},
            {5,10}
        };    
        assertTrue(App.cambiarColor(img42, 0, 5));
        assertTrue(App.cambiarColor(img42, 1, 10));
        assertFalse(App.cambiarColor(img42, 1, 10));
        assertArrayEquals(img42, img42b);

    }

    @Test
    public void testCaminoValido() {
        String[] mapa = {
            "  X       ",
            " *        ",
            "  *  *    ",
            "          ",
            " S        "
        };

        assertTrue(App.caminoValido(mapa, "NNONNEE"));
        assertTrue(App.caminoValido(mapa, "EENNNNO"));
        assertTrue(App.caminoValido(mapa, "ENENENENOOO"));            
        assertTrue(App.caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOO"));            
        assertFalse(App.caminoValido(mapa, "S"));            
        assertFalse(App.caminoValido(mapa, "OO"));            
        assertFalse(App.caminoValido(mapa, "NEEEEEEEEE"));            
        assertFalse(App.caminoValido(mapa, "ONNNNNNN"));            
        assertFalse(App.caminoValido(mapa, "NNNNE"));            
        assertFalse(App.caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOOO"));            
        assertFalse(App.caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOONNNN"));            
    }

}