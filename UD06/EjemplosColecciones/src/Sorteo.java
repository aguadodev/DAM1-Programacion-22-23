import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorteo<T> {
    // Atributos
    Set<T> elementos = new HashSet<>();    
    
    // Métodos
    boolean add(T elemento){
        return elementos.add(elemento);
    }
    
    Set<T> premiados(int numPremiados){
        List<T> listaAux = new ArrayList(elementos);
        Collections.shuffle(listaAux);
        
        Set<T> premiados = new TreeSet<>();
        for (int i = 0; i < numPremiados; i++)
            premiados.add(listaAux.get(i));
        
        return premiados;
    }    
}
