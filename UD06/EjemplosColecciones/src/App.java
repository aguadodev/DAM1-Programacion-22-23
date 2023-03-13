import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Tipos Genéricos");
        Contenedor<Integer> c = new Contenedor<>();

        c.guardar(5);
        Integer n = c.extraer();
        System.out.println(n);

        Contenedor cSinTipo = new Contenedor();

        cSinTipo.guardar("asdkah");

        String d = (String) cSinTipo.extraer();

        Integer[] numeros = {0,1,2,3,4,5,6,7,8,9};
        Integer[] numeros2 = {20,21,22,23,24,25,26,27,28,29};

        System.out.println(Contenedor.numeroDeNulos(numeros));

        String[] nombres = {"Óscar", null, "Ana", null, "Pablo"};
        String[] nombres2 = {"Andrea", "María", "Juan"};
        System.out.println(Contenedor.numeroDeNulos(nombres));

        System.out.println(Arrays.toString(Contenedor.concatenaTablas(numeros, numeros2)));

        System.out.println(Arrays.toString(Contenedor.concatenaTablas(nombres, nombres2)));

    }
}
