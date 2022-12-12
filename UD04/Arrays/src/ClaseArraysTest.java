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
    public void testGetImpares() {
        int[] t1 = {52, 64, 57, 61, 100, 86, 47, 23, 47, 54};
        int[] tr1 = {57, 61, 47, 23, 47};
        
        assertArrayEquals(tr1, ClaseArrays.getImpares(t1));

        int[] t2 = {8, 7, 8, 8, 5, 3, 3, 10, 5, 10};
        int[] tr2 = {7, 5, 3, 3, 5};     
        assertArrayEquals(tr2, ClaseArrays.getImpares(t2));
        

        int[] t3 = {};
        int[] tr3 = {};
        assertArrayEquals(tr3, ClaseArrays.getImpares(t3));        
    }

    @Test
    public void testGetPares() {
        int[] t1 = {52, 64, 57, 61, 100, 86, 47, 23, 47, 54};
        int[] tr1 = {52, 64, 100, 86, 54};
        
        assertArrayEquals(tr1, ClaseArrays.getPares(t1));

        int[] t2 = {8, 7, 8, 8, 5, 3, 3, 10, 5, 10};
        int[] tr2 = {8, 8, 8, 10, 10};     
        assertArrayEquals(tr2, ClaseArrays.getPares(t2));
        

        int[] t3 = {};
        int[] tr3 = {};
        assertArrayEquals(tr3, ClaseArrays.getPares(t3));        
    }

    @Test
    public void testInsertarOrdenado() {
        int[] t1 = {3, 4, 6, 6, 9, 10, 15, 20};
        int num1 = 1;
        int[] tr1 = {1, 3, 4, 6, 6, 9, 10, 15, 20};
        assertArrayEquals(tr1, ClaseArrays.insertarOrdenado(t1, num1));

        int[] t2 = {3, 4, 6, 6, 9, 10, 15, 20};
        int num2 = 21;
        int[] tr2 = {3, 4, 6, 6, 9, 10, 15, 20, 21};
        assertArrayEquals(tr2, ClaseArrays.insertarOrdenado(t2, num2));

        int[] t3 = {3, 4, 6, 6, 9, 10, 15, 20};
        int num3 = 7;
        int[] tr3 = {3, 4, 6, 6, 7, 9, 10, 15, 20};
        assertArrayEquals(tr3, ClaseArrays.insertarOrdenado(t3, num3));
    }

    @Test
    public void testInsertarOrdenado2() {
        int[] t1 = {3, 4, 6, 6, 9, 10, 15, 20};
        int num1 = 1;
        int[] tr1 = {1, 3, 4, 6, 6, 9, 10, 15, 20};
        assertArrayEquals(tr1, ClaseArrays.insertarOrdenado2(t1, num1));

        int[] t2 = {3, 4, 6, 6, 9, 10, 15, 20};
        int num2 = 21;
        int[] tr2 = {3, 4, 6, 6, 9, 10, 15, 20, 21};
        assertArrayEquals(tr2, ClaseArrays.insertarOrdenado2(t2, num2));

        int[] t3 = {3, 4, 6, 6, 9, 10, 15, 20};
        int num3 = 7;
        int[] tr3 = {3, 4, 6, 6, 7, 9, 10, 15, 20};
        assertArrayEquals(tr3, ClaseArrays.insertarOrdenado2(t3, num3));        
    }

}
