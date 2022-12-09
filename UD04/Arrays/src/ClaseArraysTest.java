import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ClaseArraysTest {
    @Test
    public void testSinRepetidos() {
       
        int[] t1 = {52, 64, 57, 61, 100, 86, 47, 23, 47, 54};
        int[] tr1 = {52, 64, 57, 61, 100, 86, 47, 23, 54};
        
        assertArrayEquals(tr1, ClaseArrays.sinRepetidos(t1));

        int[] t2 = {8, 7, 8, 8, 5, 3, 3, 10, 5, 10};
        int[] tr2 = {8, 7, 5, 3, 10};     
        assertArrayEquals(tr2, ClaseArrays.sinRepetidos(t2));
        

        int[] t3 = {};
        int[] tr3 = {};
        assertArrayEquals(tr3, ClaseArrays.sinRepetidos(t3));

    }

    @Test
    public void testExtraerImpares() {
        int[] t1 = {52, 64, 57, 61, 100, 86, 47, 23, 47, 54};
        int[] tr1 = {57, 61, 47, 23, 47};
        
        assertArrayEquals(tr1, ClaseArrays.sinRepetidos(t1));

       int[] t2 = {8, 7, 8, 8, 5, 3, 3, 10, 5, 10};
        int[] tr2 = {7, 5, 3, 3, 5};     
        assertArrayEquals(tr2, ClaseArrays.sinRepetidos(t2));
        

        int[] t3 = {};
        int[] tr3 = {};
        assertArrayEquals(tr3, ClaseArrays.sinRepetidos(t3));        
    }

    @Test
    public void testExtraerPares() {
        
    }


}
