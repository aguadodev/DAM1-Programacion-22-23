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
        int[] tsr = new int[t.length];
        int j = 0;
        for(int e:t){
            // Para cada elemento 
            // 1. Si ya está en tsr
            boolean Repetido = false;
            for(int k = 0; k < j; k++){
                if(e == tsr[k])
                    Repetido = true;                    
            }
            if (!Repetido){
                tsr[j] = e;
                j++;
            }                
        }
        
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

    public static int[] getPares(int t[]){
        int[] aux = new int[t.length];
        int i = 0; // indice del array auxiliar

        for(int e:t){
            if(e % 2 == 0){
                aux[i] = e;
                i++;
            }                
        }

        return Arrays.copyOf(aux, i);
    }

    public static int[] getImpares(int t[]){
        int[] aux = new int[t.length];
        int i = 0; // indice del array auxiliar

        for(int e:t){
            if(e % 2 != 0){
                aux[i] = e;
                i++;
            }                
        }

        return Arrays.copyOf(aux, i);
    }

    static public int[] insertarOrdenado(int[] t, int num){
        int[] aux = null;

        // 1. Crear un array con una posición más.

        // 2. Buscar la posición donde insertarlo

        // 3. Copiar elementos anteriores a la posición
        // 4. Insertar num
        // 5. Copiar el resto de elementos

        return aux;
    }


      
}
