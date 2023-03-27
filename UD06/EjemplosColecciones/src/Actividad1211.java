import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Actividad1211 {
    public static void main(String[] args) {
        ContenedorM<Integer> numeros = new ContenedorM<>();

        for (int i = 0; i < 30; i++)
            numeros.insertarAlFinal((int) (Math.random() * 10 + 1));

        ContenedorM<Integer> numeros2 = new ContenedorM<>();

        for (int i = 0; i < 20; i++)
            numeros2.insertarAlFinal((int) (Math.random() * 10 + 1));

        System.out.println(numeros);

        numeros.ordenar();

        System.out.println(numeros);

        Comparator<Integer> compEnteros = Comparator.naturalOrder();
        numeros.ordenar(compEnteros.reversed());

        System.out.println(numeros);

        System.out.println("CROMOS");

        ContenedorM<Cromo> cromos = new ContenedorM<>();

        cromos.insertarAlFinal(new Cromo(1, "coche"));
        cromos.insertarAlFinal(new Cromo(2, "moto"));

        cromos.ordenar();

        System.out.println(cromos);

        cromos.ordenar((a, b) -> a.ficheroImg.compareTo(b.ficheroImg));

        System.out.println(cromos);

        List<Integer> listaNum = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            listaNum.add((int) (Math.random() * 10 + 1));

        listaNum.sort(Comparator.naturalOrder());

        System.out.println(listaNum);

        listaNum = ContenedorM.sinRepetidos(listaNum);

        System.out.println(listaNum);

    }
}

class Cromo implements Comparable<Cromo> {
    int numero;
    String ficheroImg;

    public Cromo(int numero, String ficheroImg) {
        this.numero = numero;
        this.ficheroImg = ficheroImg;
    }

    @Override
    public int compareTo(Cromo o) {
        return o.numero - numero;
    }

    @Override
    public String toString() {
        return "Cromo [numero=" + numero + ", ficheroImg=" + ficheroImg + "]";
    }

}