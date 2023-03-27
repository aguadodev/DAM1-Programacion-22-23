import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Contenedor
 */
public class ContenedorM<T>{
//    private T[] elementos;
    private T[] elementos = (T[]) (new Object[0]);

    public ContenedorM() {
        /*T[] aux = new T[0];
        elementos = Arrays.copyOf(aux, 0);*/
    }

    void insertarAlPrincipio(T nuevo){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        for (int i = elementos.length - 1; i > 0; i--)
            elementos[i] = elementos[i - 1];
        elementos[0] = nuevo;
    }

    void insertarAlFinal(T nuevo){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = nuevo;
    }    

    @Override
    public String toString() {
        return "ContenedorM [elementos=" + Arrays.toString(elementos) + "]";
    }

    void ordenar(){
        Arrays.sort(elementos);
    }

    void ordenar (Comparator<T> c){
        Arrays.sort(elementos, c);
    }  


    T get (int indice){
        if (indice < elementos.length - 1)
            return elementos[indice];
        else
            return null;
    }

    static <E> List<E> sinRepetidos(List<E> l){
        Set<E> sinRepetidos = new LinkedHashSet<>(l);
        
        List<E> res = new ArrayList<>(sinRepetidos);

        return res;
    }

}