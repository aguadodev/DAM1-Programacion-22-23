import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;

public class Actividad127 {
    public static void main(String[] args) {
        Collection<Integer> coleccion = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            coleccion.add((int) (Math.random() * 10) + 1);

        LocalTime ti = LocalTime.now();
        System.out.println("Colección inicial: " + coleccion.toString() + "\n");

        Collection<Integer> col5 = new ArrayList<>();
        col5.add(5);
        col5.add(3);
        System.out.println("Hay 5 y 3?: " + coleccion.containsAll(col5));
        coleccion.removeAll(col5);
        System.out.println("Hay 5 y 3?: " + coleccion.containsAll(col5));

        System.out.println("Colección SIN 5s: " + coleccion.toString() + "\n");
        System.out.println(ti.until(LocalTime.now(), ChronoUnit.MILLIS));
    }
}
