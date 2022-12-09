import java.util.Arrays;

public class ClaseArrays {
    public static void main(String[] args) {
        final int MAX = 10;
        int[] t = new int[MAX];


        t = tablaRandom(MAX);
        t = new int[0];
        System.out.println(Arrays.toString(t));
        System.out.println(Arrays.toString(sinRepetidos(t)));


/*        Arrays.fill(t, 5);
        Arrays.fill(t, 5, 8, 10);
        for(int i = 0; i < t.length; i++)
            t[i] = (int) (1 + Math.random() * 100);

        System.out.println(Arrays.toString(t));
        
        System.out.println("Valor máximo del array: " + maximo(t));

        // Ordenar
        Arrays.sort(t);

        System.out.println(Arrays.toString(t));
    
        int clave = 77;
        int indice = Arrays.binarySearch(t, clave);
        if (indice < 0)
            System.out.println("El valor " + clave + " no se encuentra en al array.");
        else 
            System.out.println("El valor " + clave + " se encuentra en la posición " + indice);


        System.out.println("Fin del programa");*/
    }

    static int maximo(int t[]) {
        int maximo = t[0]; // Contiene el maximo valor encontrado hasta el momento
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximo) {
                maximo = t[i];
            }
        }
    
        return maximo;
    }

    static public int[] sinRepetidos(int[] t){
        int[] tsr = new int[t.length]; // Array auxiliar sin repetidos
        int j = 0; // índice para recorrer el array sin repetidos

        for(int e:t){
            // Buscamos cada elemento en el array auxiliar sin repetidos
            boolean Repetido = false;
            for(int k = 0; k < j; k++){
                if(e == tsr[k])
                    Repetido = true;                    
            }
            // Si no está en tsr, lo añadimos          
            if (!Repetido){
                tsr[j] = e;
                j++;
            }                
        }
        
        // Truncamos las posiciones no utilizadas del array sin repetidos con copyOf()
        return Arrays.copyOf(tsr, j);
    }

    /**
     * Genera una tabla de n elementos aleatorios entre 1 y 100 inclusive
     * @param n
     * @return
     */
    static int[] tablaRandom(int n){
        int[] t = new int[n];

        for(int i = 0; i < t.length; i++)
            t[i] = (int) (1 + Math.random() * 10);

        return t;
    }


    static double media(int[] t){
        // Devuelve la media de los elementos del array
        double suma = 0;

        for(int i = 0; i < t.length; i++){
            suma += t[i];
        }
        return suma / t.length;
    }    

    static double media(double[] t){
        // Devuelve la media de los elementos del array
        double suma = 0;

        for(int i = 0; i < t.length; i++){
            suma += t[i];
        }
        return suma / t.length;
    }
 
    static int buscar(int t[], int clave){
        int i = 0;
        boolean claveEncontrada = false;

        while (i < t.length && !claveEncontrada){
            if(t[i] == clave){
                claveEncontrada = true;
            } else {
                i++;
            }                        
        }

        return claveEncontrada? i : -1;
    }

    // Contar las veces que aparece un valor clave en una tabla de enteros.
    static int contar(int t[], int clave){
        int contador = 0;
        for(int i = 0; i < t.length; i++)
            if(t[i] == clave)
                contador++;
        
        return contador;
    }

    /**
     * Devuelve la lista de posiciones de una tabla en las que se encuentra un valor clave.
     */
    static int[] buscarVarios(int t[], int clave){
        int numVeces = contar(t,clave);
        int[] posiciones = null;

        if(numVeces > 0) {
            posiciones = new int[numVeces];
            int iPosiciones = 0;
            for(int i = 0; i < t.length; i++)
                if(t[i] == clave){
                    posiciones[iPosiciones] = i;
                    iPosiciones++;
                }
        }

        return posiciones;  
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

    public static int[] getPares(int t[]){
        return null;
    }

    public static int[] getImpares(int t[]){
        return null;
    }

      
}
