import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Actividad1215 {
    public static void main(String[] args) {
        Map<String, Integer> productos = new HashMap<>();

        productos.put("Neumáticos", 20);
        productos.put("Neumáticos", 20);
        productos.put("Neumáticos", 20);


        int opcion = leerMenu();
        while (opcion != 0){
            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            opcion = leerMenu();
        }

    }

    static int leerMenu(){
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Menú");
        System.out.println("1. Alta");
        System.out.println("2. Baja");
        System.out.println("3. Actualiza existencias");
        System.out.println("0. SALIR");
        opcion = sc.nextInt();
        return opcion;
    }
}
