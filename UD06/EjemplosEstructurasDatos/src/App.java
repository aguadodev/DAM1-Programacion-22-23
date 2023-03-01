import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Interfaces y estructuras de datos");

        Cola cola = new Lista();
        Pila pila = new Lista();
        Lista lista = new Lista();

        int numero;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un número entero (negativo para terminar): ");
        numero = sc.nextInt();

        while (numero >= 0) {
            cola.encolar(numero);
            pila.apilar(numero);
            System.out.println("Escribe otro número entero: ");
            numero = sc.nextInt();
        }

        System.out.println("Scamos los elementos de la cola:");
        Integer e = cola.desencolar();
        while (e != null){
            System.out.println(e);
            e = cola.desencolar();
        }

        System.out.println("Sacamos los elementos de la pila:");
        e = pila.desapilar();
        while (e != null){
            System.out.println(e);
            e = pila.desapilar();
        }        

    }
}
