import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Actividad126 {
    public static void main(String[] args) {
        Collection<Integer> coleccion = new ArrayList<>();

        for (int i = 0; i < 1000000; i++)
            coleccion.add((int) (Math.random() * 10) + 1);

        LocalTime ti = LocalTime.now();
        //System.out.println("Colección inicial: " + coleccion.toString() + "\n");

       /*  
        // SOLUCION SIN ITERADOR 
        while(coleccion.remove(5));*/

        // SOLUCIÓN CON ITERADOR
        Iterator<Integer> it = coleccion.iterator();
        while (it.hasNext()) {
            if (it.next() == 5)
                it.remove();
        }
         
        //System.out.println("Colección SIN 5s: " + coleccion.toString() + "\n");
        System.out.println(ti.until(LocalTime.now(), ChronoUnit.MILLIS));
    }
}
