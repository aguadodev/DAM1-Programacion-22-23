import java.util.Arrays;

public class Primitiva {
    public static void main(String[] args) {
        final int MAX = 6;
        final int MAX_RANDOM = 50;
        final int LONGITUD = 6;
        int[] apuesta = new int[MAX];        
        int[] ganadora = new int[MAX];

        /*for(int i = 0; i < MAX; i++) {
            apuesta[i] = (int) (1 + Math.random() * MAX_RANDOM);
            ganadora[i] = (int) (1 + Math.random() * MAX_RANDOM);
        }*/

        ganadora = generaSinRepetidos(LONGITUD, 1, MAX_RANDOM);

        apuesta = generaSinRepetidos(LONGITUD, 1, MAX_RANDOM);


        Arrays.sort(ganadora);

        System.out.println("\nPRIMITIVA");
        System.out.println("=========\n");
        System.out.println("Apuesta: " + Arrays.toString(apuesta));
        System.out.println("Combinación ganadora: " + Arrays.toString(ganadora));

        System.out.println("Nº de aciertos: " + numAciertos(apuesta, ganadora));

        System.out.println("\n\n");

    }

    static int numAciertos(int[] apuesta, int[] ganadora){
        int cont = 0;

        for(int e: apuesta)
            if(Arrays.binarySearch(ganadora, e) >= 0)
                cont++;

        return cont;
    }

    static int buscar(int t[], int clave){
        for(int i = 0; i < t.length; i++)
            if(t[i] == clave)
                return i;
        return -1;
    }
    
    static int[] generaSinRepetidos(int longitud, int min, int max){
        int[] t = new int[longitud];

        for(int i = 0; i < longitud; i++){
            boolean valorNuevo;
            do {
                // Asignar a t[i] un valor aleatorio entre min y max (no repetido!)
                int rnd = (int) (min + Math.random() * (max - min + 1)); 

                // Buscar rnd en t
                valorNuevo = buscar(t, rnd) == -1;
                if (valorNuevo)
                    t[i] = rnd;
            } while (!valorNuevo);
        }

        return t;
    }

}
