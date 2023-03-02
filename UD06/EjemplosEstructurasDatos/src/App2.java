import java.util.Arrays;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {

        // Implementar una Cola anónima
        Cola cola = new Cola() {
            Integer elementos[] = new Integer[0];

            @Override
            public void encolar(Integer e) {
                elementos = Arrays.copyOf(elementos, elementos.length + 1);
                elementos[elementos.length - 1] = e;
            }

            @Override
            public Integer desencolar() {
                Integer e = null;
                if (elementos.length > 0){
                    e = elementos[0];
                    elementos = Arrays.copyOfRange(elementos,1,elementos.length);
                }
                return e;
            }

            @Override
            public String toString() {
                return elementos.length == 0? null : Arrays.toString(elementos);
            }         
            
            
        };


        // Uso de la cola para almacenar y mostrar números positivos leídos de teclado.
        int numero;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un número entero (negativo para terminar): ");
        numero = sc.nextInt();

        while (numero >= 0) {
            if (numero == 3)
                cola.encolarMultiple(numero, 3);
            else
                cola.encolar(numero);
            System.out.println("Escribe otro número entero: ");
            numero = sc.nextInt();
        }

        System.out.println(cola);
        System.out.println("Sacamos todos los elementos de la cola de una vez:");
        Integer[] elementos = cola.desencolarTodos();
        System.out.println(Arrays.toString(elementos));
        System.out.println(cola);



/*         System.out.println("Sacamos los elementos de la cola de uno en uno:");
        Integer e = cola.desencolar();
        while (e != null){
            System.out.println(e);
            e = cola.desencolar();
        }        */
        
    }
}
