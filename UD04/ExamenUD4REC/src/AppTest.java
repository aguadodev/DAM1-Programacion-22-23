import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void testSumas() {
        int[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ts1 = {55, 30, 25};
        int[] t2 = {1};
        int[] ts2 = {1, 0, 1};
        int[] t3 = {};
        int[] ts3 = {0, 0, 0};
        int[] t4 = null;
        int[] ts4 = null;

        assertArrayEquals(ts1, App.sumas(t1));
        assertArrayEquals(ts2, App.sumas(t2));
        assertArrayEquals(ts3, App.sumas(t3));
        assertArrayEquals(ts4, App.sumas(t4));

    }

    @Test
    public void testDiagonalesIguales() {
        int[][] t21 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };
        int[][] t22 = {{1}};
        int[][] t23 = {};
        int[][] t24 = null;   
        int[][] t25 = {
            {1, 2, 1},
            {1, 2, 3},
            {1, 2, 3}
        };
        int[][] t26 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };

        assertTrue(App.diagonalesIguales(t21));
        assertTrue(App.diagonalesIguales(t22));
        assertFalse(App.diagonalesIguales(t23));
        assertFalse(App.diagonalesIguales(t24));
        assertFalse(App.diagonalesIguales(t25));
        assertFalse(App.diagonalesIguales(t26));        
    }
        
    @Test
    public void testCambiaVogais() {
        String str1 = "Programar en Java mentres fas piragüismo é complicado";
        String stro1 = "Prigrimir in Jivi mintris fis pirigïismi í cimplicidi";
        char v1 = 'i';

        assertEquals(stro1, App.cambiaVogais(str1, v1));

        /*
        String str2 = "Programar en Java mentres fas piragüismo é complicado";
        String stro2 = "Prigrimir in Jivi mintris fis pirigïismi í cimplicidi";
        char v2 = 'i';
        */

        assertEquals(stro1, App.cambiaVogais(str1, v1));

    }

}
