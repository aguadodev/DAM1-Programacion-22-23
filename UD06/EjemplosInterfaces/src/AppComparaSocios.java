import java.util.Arrays;

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
        Arrays.sort(socios);
        System.out.println(Arrays.toString(socios));
    }

}
