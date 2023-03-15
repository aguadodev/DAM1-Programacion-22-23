import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Actividad124
 */
public class Actividad124 {
    public static void main(String[] args) {
        System.out.println("Actividad 12.4");
        Scanner sc = new Scanner(System.in);
        Collection<Integer> lista = new ArrayList<>();
        System.out.println("Introduce números enteros no negativos. -1 para terminar: ");
        int n = sc.nextInt();
        while(n != -1){
            lista.add(n);
            n = sc.nextInt();
        }
    
        System.out.println("Colección inicial: " + lista.toString() + "\n");
    
        Iterator<Integer> it = lista.iterator();
    
        System.out.println("Muestra los valores pares: ");
        while (it.hasNext()) {
            Integer numero = it.next();
            if (numero % 2 == 0) {
                System.out.println(numero + " ");
            }
        }
        System.out.println("\n");

        System.out.println("Elimina los múltiplos de 3:");
        /*
        // RECORRIENDO LA COLECCIÓN CON UN ITERATOR
        it = lista.iterator();
        while (it.hasNext()) {
            Integer numero = it.next();
            if (numero % 3 == 0) {
                System.out.println("Eliminando " + numero + " por ser múltiplo de 3.");
                it.remove();
            }
        }
        System.out.println("\n");*/

        // RECORRIENDO LA COLECCIÓN CON UN FOR-EACH
        for(Integer e : lista){
            if (e % 3 == 0){
                System.out.println("Eliminando " + e + " por ser múltiplo de 3.");
                lista.remove(e);
            }                
        }
    
        System.out.println("Colección sin múltiplos de 3: " + lista.toString() + "\n");
    }
        
}