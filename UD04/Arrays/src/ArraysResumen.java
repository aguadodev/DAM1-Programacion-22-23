public class ArraysResumen {

    /**
     * Inicializa los elementos de un array de enteros a un valor fijo que se pasa como parámetro.
     * @param t
     * @param valor
     */
    static void inicializarValoresFijos(int[] t, int valor) {
        for(int i = 0; i < t.length; i++){
            t[i] = valor;
        }
    }

    /**
     * Inicializa los elementos de un array de enteros a un valor aleatorio entre 0 y 9 inclusives.
     * @param t
     */
    static void inicializarValoresAleatorios(int[] t) {
        for(int i = 0; i < t.length; i++){
            t[i] = (int)(Math.random()*10);
        }
    }
    
    /**
     * Comprueba si un array de enteros está ordenado ascendentemente.
     * @param t
     * @return
     */
    static boolean estaOrdenadoAsc(int[] t) {
        boolean ordenado = true;
    
        int i = 0;
        while (i < (t.length - 1) && ordenado) {
            if (t[i] > t[i+1]){
                ordenado = false;
            }            
            i++;
        }
        return ordenado;
    }
    

    /**
     * Ordena un array de enteros ascendentemente usando el algoritmo de Burbuja.
     * @param t
     */
    static void ordenarAsc(int[] t) {   
        int vueltas = t.length - 1; // Máximo número de vueltas para ordenar el array
        boolean ordenado = false;        
    
        while (vueltas > 0 && !ordenado) {
            ordenado = true;             
            // En cada vuelta, el elemento más grande queda ordenado al final,
            // por eso en cada vuelta solo necesitamos recorrer el array hasta
            // una posicion menos cada vez
            for(int i = 0; i < vueltas; i++) {
                // En cada vuelta comenzamos suponiendo el array ordenado, de modo
                // que si al final de la vuelta no hubo que hacer intercambios 
                // el bucle terminará porque el array ya estará ordenado
                if (t[i] > t[i+1]){
                    // Si dos elementos contiguos están desordenados se intercambian
                    int aux = t[i];
                    t[i] = t[i+1];
                    t[i+1] = aux;
                    ordenado = false;
                }  
            }
            vueltas--;
        }         
    }
    
    /**
     * Ordena un array de enteros descendentemente usando el algoritmo de Burbuja.
     * @param t
     */
    static void ordenarDesc(int[] t) {   
        int vueltas = t.length - 1; // Máximo número de vueltas para ordenar el array
        boolean ordenado = false;        
    
        while (vueltas > 0 && !ordenado) {
            ordenado = true;             
            // En cada vuelta, el elemento más grande queda ordenado al final,
            // por eso en cada vuelta solo necesitamos recorrer el array hasta
            // una posicion menos cada vez
            for(int i = 0; i < vueltas; i++) {
                // En cada vuelta comenzamos suponiendo el array ordenado, de modo
                // que si al final de la vuelta no hubo que hacer intercambios 
                // el bucle terminará porque el array ya estará ordenado
                if (t[i] < t[i+1]){
                    // Si dos elementos contiguos están desordenados se intercambian
                    int aux = t[i];
                    t[i] = t[i+1];
                    t[i+1] = aux;
                    ordenado = false;
                }  
            }
            vueltas--;
        }         
    }
    
    /**
     * Busca un valor en un array de enteros y devuelve la posición de la primera ocurrencia.
     * Si no se encuentra devuelve -1.
     * @param t
     * @param val
     * @return
     */
    static int busquedaLinealNoOrdenado(int[] t, int val) {
        int posicion = -1;
    
        int i = 0;
        while (i < t.length && posicion == -1) {
            if (t[i] == val) {
                posicion = i;
            }                        
            i++;
        }
    
        return posicion;
    }
    
    /**
     * Busca un valor en un array de enteros ordenado. Si no se encuentra devuelve -1.
     * @param t
     * @param val
     * @return
     */
    static int busquedaLinealOrdenado(int[] t, int val) {
        int posicion = -1;
    
        int i = 0;
        while (i < t.length && posicion == -1 && t[i] < val) {
            if (t[i] == val) {
                posicion = i;
            }                        
            i++;
        }
    
        return posicion;
    }
    
}
