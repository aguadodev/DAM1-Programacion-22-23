import java.util.Arrays;
import java.util.Scanner;

public class AppComparar {
    public static void main(String[] args) throws Exception {
        System.out.println("JUEGO DE ROL: Compara y ordena Personajes");

        Personaje pj1 = new Personaje("Jose", "HUMANO", 50,50,50);
        Personaje pj2 = new Personaje("Jose", "HUMANO", 50,50,50);

        pj1.mostrar();
        pj2.mostrar();

        System.out.println("pj1 == pj2? " + (pj1 == pj2));
        System.out.println("pj1.equals(pj2)? " + pj1.equals(pj2));

        Personaje[] grupo = new Personaje[5];
        grupo[0] = pj1;
        grupo[1] = pj2;
        grupo[2] = new Personaje("Pers2", "HUMANO");
        grupo[3] = new Personaje("Pers3", "HUMANO");;
        grupo[4] = new Personaje("Pers4", "HUMANO");;

        System.out.println();
        System.out.println(Arrays.toString(grupo));

        grupo = Personaje.sortPuntosVidaDesc(grupo);
        System.out.println(Arrays.toString(grupo));

        grupo = Personaje.sortPuntosVidaAsc(grupo);
        System.out.println(Arrays.toString(grupo));

    }
}
