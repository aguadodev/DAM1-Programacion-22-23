import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AppEjemplosMapas {
    public static void main(String[] args) {
        
        Map<String,Double> m = new HashMap<>();

        m.put("Ana", 1.65);
        m.put("Marta", 1.60);
        m.put("Luis", 1.73);
        m.put("Luisa", 1.73);
        m.put("Pedro", 1.69);

        System.out.println(m);

        Set<String> claves = m.keySet();

        System.out.println(claves);

        Collection<Double> valores = m.values();

        System.out.println(valores);

        Set<Map.Entry<String, Double>> entradas = m.entrySet();

        System.out.println(entradas);

        /* BORRAR ELEMENTOS USANDO UN ITERADOR SOBRE LA VISTA DE ENTRADAS
        Iterator<Map.Entry<String, Double>> it = entradas.iterator();
        while(it.hasNext()){
            Map.Entry<String, Double> entrada = it.next();
            if (entrada.getValue() > 1.71)
                it.remove();
        }
         */

        /* BORRAR ELEMENTOS USANDO UN ITERADOR SOBRE LA VISTA DE VALORES */
        Iterator<Double> it = valores.iterator();
        while (it.hasNext()){
            if (it.next() > 1.71)
                it.remove();
        }
        
        System.out.println(m);

    }
}
