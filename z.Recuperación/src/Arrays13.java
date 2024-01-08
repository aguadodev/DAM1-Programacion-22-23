import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Arrays13 {

    public boolean esDiagonal(int[][] t) {
        if (t == null || t.length == 0 || t.length != t[0].length) {
            return false;
        }
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (i != j && t[i][j] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }


@Test
public void pruebaMatrizDiagonal() {
    int[][] matriz = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
    assertTrue(esDiagonal(matriz));
}

@Test
public void pruebaMatrizNoDiagonal() {
    int[][] matriz = {{1, 0, 0}, {0, 2, 0}, {0, 1, 3}};
    assertFalse(esDiagonal(matriz));
}

@Test
public void pruebaMatrizNoCuadrada() {
    int[][] matriz = {{1, 0, 0}, {0, 2, 0}};
    assertFalse(esDiagonal(matriz));
}

@Test
public void pruebaMatrizNoCuadrada2() {
    int[][] matriz = {{1, 0}, {0, 2}, {0, 0}};
    assertFalse(esDiagonal(matriz));
}

@Test
public void pruebaMatrizVacia() {
    int[][] matriz = {};
    assertFalse(esDiagonal(matriz));
}

@Test
public void pruebaMatrizNull() {
    int[][] matriz = null;
    assertFalse(esDiagonal(matriz));
}

}
