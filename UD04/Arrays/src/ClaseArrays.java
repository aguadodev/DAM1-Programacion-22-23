import java.util.Arrays;

public class ClaseArrays {

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

    static int maximo(int t[]) {
        int maximo = t[0]; // Contiene el maximo valor encontrado hasta el momento
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximo) {
                maximo = t[i];
            }
        }
    
        return maximo;
    }
    // Contar las veces que aparece un valor clave en una tabla de enteros.
    static int contar(int t[], int clave){
        int contador = 0;
        for(int i = 0; i < t.length; i++)
            if(t[i] == clave)
                contador++;
        
        return contador;
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

    public static int[] generaSinRepetidos(int longitud, int min, int max){
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
        // 1. Crear un array con una posición más.
        int[] aux = new int[t.length + 1];

        int i = 0;
        // 2. Buscar la posición donde insertarlo
        while (i < t.length && num > t[i]){
            // 3. Copiar elementos anteriores a la posición
            aux[i] = t[i];
            i++;
        }
        // 4. Insertar num
        aux[i] = num;

        // 5. Copiar el resto de elementos
        while (i < t.length){
            aux[i+1] = t[i];
            i++;
        }

        return aux;
    }

    static public int[] insertarOrdenado2(int[] t, int num){
        // 1. Crear un array con una posición más.
        int[] aux = new int[t.length + 1];

        // 2. Buscar la posición donde insertarlo
        int i = Arrays.binarySearch(t, num);
        if (i < 0)
            i = -i - 1;
        
        // 3. Copia los elementos anteriores (si los hay)
        System.arraycopy(t, 0, aux, 0, i);

        // 4. Inserta el elemento
        aux[i] = num;

        // 5. Copia el resto de elementos
        System.arraycopy(t, i, aux, i + 1, t.length - i);

        return aux;
    }    

    static public int[] borrarOrdenado(int[] t, int num){
        int [] aux = new int[t.length];

        int i = 0;
        for(int e: t){
            if (e != num){
                aux[i] = e;
                i++;                
            }
        }
        
        return Arrays.copyOf(aux, i);
    }

      
}
