import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Actividad125 {
    public static void main(String[] args) {
        Collection<Integer> lista = new ArrayList<>();
        Collection<Integer> listaAux = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            lista.add((int) (Math.random() * 10) + 1);

        System.out.println("Colección inicial: " + lista.toString() + "\n");

        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            Integer numero = it.next();
            if (!listaAux.contains(numero)) {
                listaAux.add(numero);
            }
        }
        lista = listaAux;

        System.out.println("Colección SIN REPETIDOS: " + lista.toString() + "\n");

    }
}
