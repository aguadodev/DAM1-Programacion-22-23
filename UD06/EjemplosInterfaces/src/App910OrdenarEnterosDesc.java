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

        Comparator ordenDesc  = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o2 - (Integer)o1;
            }            
        };

        Arrays.sort(numeros, ordenDesc);

        System.out.println(Arrays.toString(numeros));

    }
}