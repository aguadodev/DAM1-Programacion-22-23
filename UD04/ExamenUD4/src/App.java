import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// ANDRES IGNACIO PEREZ

public class App {
    public static void main(String[] args) throws Exception {

    }

    
    static int rango(int t[]) {
        int minimo = t[0];
        int maximo = t[0];

        try {
            t = null;
        } catch (Exception e) {
            return 0;
        } finally {
            if (t.length < 2) {
                return 0;

            } else {
                // Ordenar los enteros de forma decreciente
                Arrays.sort(t);
                // Mostrar todos los enteros ordenados
                System.out.println("Todos los enteros ordenados de forma decreciente: ");
                for (int i : t) {
                    System.out.println(i);
                }
                // Calcular el entero máximo y mínimo
                for (int i = 1; i < t.length; i++) {
                    if (t[i] > maximo) {
                        maximo = t[i];
                    }
                }
                for (int i = 1; i < t.length; i++) {
                    if (t[i] < minimo) {
                        minimo = t[i];
                    }
                }
                int diferencia = maximo - minimo;
            return diferencia;
            }
        }
    }


    
     
    static boolean cambiarColor(int[][] img, int colorViejo, int colorNuevo) {
        // Crear una pila para almacenar los colores
        Stack<Integer> pila = new Stack<>();
        // Crear un conjunto para almacenar los colores viejos
        Set<Integer> coloresViejos = new HashSet<>();
        // Añadir el color viejo a la pila
        pila.push(colorViejo);
        // Mientras la pila no esté vacía...
        while (!pila.isEmpty()) {
            // Sacar el primer color de la pila
            int color = pila.pop();
            // Si el primercolor es el color nuevo, entonces se ha encontrado una igualdad
            if (color == colorNuevo) {
                return true;
            }
            // Marcar el nuevo color como colorviejo
            coloresViejos.add(color);
            // Recorrer cada color conectado al color actual
            for (int i = 0; i < img[color].length; i++) {
                // Si el color está y no ha sido marcado...
                if (img[color][i] == 1 && !coloresViejos.contains(i)) {
                    // Añadir el color a la pila
                    pila.push(i);
                }
            }
        }
        // Si se recorrió toda la matriz y no se encontró un color, entonces no es
        // posible cambiar colores
        return false;
    }

    


    static boolean caminoValido(String[] mapa, String camino) {
        /*
         * mapa = new String(" ");
         * // mostramos el mapa
         * System.out.println(mapa);
         * // pedimos la cadena de caracteres
         * Scanner sc = new Scanner(System.in);
         * System.out.println("Introduce un camino, N para norte
         * , S para sur, O para oeste, E para este: ");
         * camino = sc.nextLine();
         */
        boolean caminoOk = true;
        

        return caminoOk;
    }
}
