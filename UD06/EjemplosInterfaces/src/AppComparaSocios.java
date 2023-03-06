import java.util.Arrays;
import java.util.Comparator;

public class AppComparaSocios {
    public static void main(String[] args) {
        Socio[] socios = {
                new Socio(3, "Anselmo", "11-07-2002"),
                new Socio(1, "Josefa", "21-11-2001"),
                new Socio(2, "Ana", "07-12-1995"),
                new Socio(5, "Jorge", "20-01-2002"),
                new Socio(4, "Juan", "20-01-2002")
        };

        System.out.println(Arrays.toString(socios));
        Arrays.sort(socios); // Orden natural = fecha Alta > id
        System.out.println(Arrays.toString(socios));
        Arrays.sort(socios, new ComparaSociosNombre());
        System.out.println(Arrays.toString(socios));

        Arrays.sort(socios,
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        Socio s1 = (Socio) o1;
                        Socio s2 = (Socio) o2;
                        return s2.id - s1.id;
                    };
                });
        System.out.println(Arrays.toString(socios));

    }

}
