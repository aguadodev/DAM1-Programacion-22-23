import java.util.Arrays;

public class ComparaArraysMatrices {
    public static void main(String[] args) {
        System.out.println("\nCOMPARACIÓN DE ARRAYS Y MATRICES");
        System.out.println("================================\n");
        
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};

        System.out.println("array1 = " + Arrays.toString(array1));
        System.out.println("array2 = " + Arrays.toString(array2));
        System.out.println("Arrays iguales (Arrays.equals()? " 
        + Arrays.equals(array1, array2));

        int[][] matriz1 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
        };
        
        int[][] matriz2 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
        };

        System.out.println("\nmatriz1 = " + Arrays.deepToString(matriz1));
        System.out.println("matriz2 = " + Arrays.deepToString(matriz2));
        System.out.println("Matrices iguales (con Arrays.equals()? "
        + Arrays.equals(matriz1, matriz2));
        System.out.println("Matrices iguales (Arrays.deepEquals()? "
        + Arrays.deepEquals(matriz1, matriz2) + "\n");        
    }
}
