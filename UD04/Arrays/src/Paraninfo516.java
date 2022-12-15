import java.util.*;

public class Paraninfo516 {
    public static void main(String[] args) {
        /*
         * PROBLEMA DE GRAFOS
         * 
         * SOLUCIÓN A: Añadir una estructura que recuerde los lugares visitados y que
         * se irá actualizando a lo largo de toda la pila de llamadas.
         * Se pasa de una llamada a otra como un 4º parámetro.
         * Se puede eliminar este 4º parámetro cun una versión sobrecargada del método para
         * la primera llamada.
         */
        int mapa[][] = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };

        int mapa2[][] = {
        //   0  1  2  3  4  5
            {0, 1, 1, 0, 0, 0}, //0
            {0, 0, 0, 1, 0, 0}, //1
            {0, 0, 0, 0, 1, 0}, //2
            {0, 1, 0, 0, 0, 0}, //3
            {0, 0, 0, 0, 0, 1}, //4
            {0, 0, 0, 0, 0, 0}, //5
        };        
        /*
         * 0 > 1 <> 3
         *   > 2 > 4 > 5
         */

        // Pruebas con 3 implementaciones distintas
        System.out.println(hayCamino(mapa2, 0, 5) + " " + 
                           hayCaminoAnchura(mapa2, 0, 5) + " " + 
                           hayCaminoProfundidad(mapa2, 0, 5));

        System.out.println(hayCamino(mapa2, 1, 5) + " " + 
                           hayCaminoAnchura(mapa2, 1, 5) + " " + 
                           hayCaminoProfundidad(mapa2, 1, 5));

                           
    }
    


    static boolean hayCaminoDirecto(int[][] t, int o, int d){          
        return t[o][d] == 1;
    }


    // Función sobrecargada para evitar el 4º parámetro;
    static boolean hayCamino(int[][] t, int o, int d){
        return hayCamino(t, o, d, new boolean[t.length]);
    }

    // Solución que implementa la búsqueda en profundidad con recursividad
    static boolean hayCamino(int[][] t, int o, int d, boolean[] visitados){
        boolean hayCamino = false;
        visitados[o] = true; // Cada vez que visitamos un lugar ponemos a true su índice

        if (o == d || hayCaminoDirecto(t, o, d))
            hayCamino = true;
        else {
            for(int i = 0; i < t.length; i++){
                if(hayCaminoDirecto(t, o, i) && !visitados[i])
                    hayCamino = hayCamino(t, i, d, visitados);
            }
        }               
        return hayCamino;
    }


    // Solución que implementa la búsqueda en profundidad con una pila
    static boolean hayCaminoProfundidad(int[][] t, int o, int d){
        // Crear una pila para almacenar los lugares a visitar
        Stack<Integer> pila = new Stack<>();

        // Crear un conjunto para almacenar los lugares visitados
        Set<Integer> visitados = new HashSet<>();

        // Añadir el lugar de origen a la pila
        pila.push(o);

        // Mientras la pila no esté vacía...
        while (!pila.isEmpty()) {
            // Sacar el primer lugar de la pila
            int lugar = pila.pop();

            // Si el lugar es el lugar de destino, entonces se ha encontrado un camino
            // desde el lugar de origen al lugar de destino
            if (lugar == d) {
                return true;
            }

            // Marcar el lugar como visitado
            visitados.add(lugar);

            // Recorrer cada lugar conectado al lugar actual
            for (int i = 0; i < t[lugar].length; i++) {
                // Si el lugar está conectado y no ha sido visitado...
                if (t[lugar][i] == 1 && !visitados.contains(i)) {
                    // Añadir el lugar a la pila
                    pila.push(i);
                }
            }
        }

        // Si se recorrió todo el grafo y no se encontró un camino, entonces no es
        // posible viajar desde el lugar de origen al lugar de destino
        return false;
        }

    

    // Solución que implementa la búsqueda en anchura con una cola
    static boolean hayCaminoAnchura(int[][] t, int o, int d){
        // Crear una cola para almacenar los lugares a visitar
        Queue<Integer> cola = new LinkedList<>();

        // Crear un conjunto para almacenar los lugares visitados
        Set<Integer> visitados = new HashSet<>();

        // Añadir el lugar de origen a la cola
        cola.add(o);

        // Mientras la cola no esté vacía...
        while (!cola.isEmpty()) {
            // Sacar el primer lugar de la cola
            int lugar = cola.remove();

            // Si el lugar es el lugar de destino, entonces se ha encontrado un camino
            // desde el lugar de origen al lugar de destino
            if (lugar == d) {
                return true;
            }

            // Marcar el lugar como visitado
            visitados.add(lugar);

            // Recorrer cada lugar conectado al lugar actual
            for (int i = 0; i < t[lugar].length; i++) {
                // Si el lugar está conectado y no ha sido visitado...
                if (t[lugar][i] == 1 && !visitados.contains(i)) {
                    // Añadir el lugar a la cola
                    cola.add(i);
                }
            }
        }

        // Si se recorrió todo el grafo y no se encontró un camino, entonces no es
        // posible viajar desde el lugar de origen al lugar de destino
        return false;
    }

}
