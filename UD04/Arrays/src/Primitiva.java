import java.util.Arrays;

public class Primitiva {
    /**
     * Ejercicio 5.6. de https://docs.google.com/document/d/1ZS8D0Rc_Y72wKhkmBECAz0aC8UtlVAuTHNdTtX8nAoc/edit?usp=sharing
     * 
     * Definir una función que tome como parámetros dos tablas, 
     * la primera con los 6 números de una apuesta de la primitiva, 
     * y la segunda (ordenada) con los 6 números de la combinación ganadora. 
     * La función devolverá el número de aciertos.
     * 
     * El programa principal genera los arrays aleatoriamente, los muestra e 
     * invoca la función para mostrar el número de aciertos.
     */
    public static void main(String[] args) {
        final int MAX_RANDOM = 50;
        final int LONGITUD = 6;
        int[] apuesta = new int[LONGITUD];        
        int[] ganadora = new int[LONGITUD];

        ganadora = ClaseArrays.generaSinRepetidos(LONGITUD, 1, MAX_RANDOM);

        apuesta = ClaseArrays.generaSinRepetidos(LONGITUD, 1, MAX_RANDOM);


        Arrays.sort(ganadora);

        System.out.println("\nPRIMITIVA");
        System.out.println("=========\n");
        System.out.println("Apuesta: " + Arrays.toString(apuesta));
        System.out.println("Combinación ganadora: " + Arrays.toString(ganadora));

        System.out.println("Nº de aciertos: " + numAciertos(apuesta, ganadora));

        System.out.println("\n\n");

    }

    /**
     * 
     * @param apuesta  - array con los números de la apuesta del jugador
     * @param ganadora - array con la combinación ganadora (ordenado)
     * @return
     */
    static int numAciertos(int[] apuesta, int[] ganadora){
        int cont = 0;

        for(int e: apuesta)
            if(Arrays.binarySearch(ganadora, e) >= 0)
                cont++;

        return cont;
    }
}
