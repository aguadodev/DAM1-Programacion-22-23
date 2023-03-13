import java.util.Arrays;
import java.util.Comparator;

/**
 * App910OrdenarEnterosDesc
 */
public class App910OrdenarEnterosDesc {

    public static void main(String[] args) {
        final int SIZE = 100;

        Integer[] numeros = new Integer[SIZE];

        for (int i = 0; i < SIZE; i++)
            numeros[i] = (int) (Math.random() * 100);

        Comparator<Integer> compInt = Comparator.naturalOrder();

        Arrays.sort(numeros, compInt.reversed());

        System.out.println(Arrays.toString(numeros));

    }
}