import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Actividad1214 {
    public static void main(String[] args) {
        List<Registro> temperaturas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Double suma = 0.0;


        int opcion = leerMenu();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    System.out.print("Temperatura: ");
                    Double temp = sc.nextDouble();
                    Registro r = new Registro(temp, LocalTime.now());
                    temperaturas.add(r);
                    suma += temp;
                    break;
                case 2:
                    System.out.println(temperaturas);
                    break;
                case 3:
                    System.out.println("Temperatura máxima: " + Collections.max(temperaturas));
                    System.out.println("Temperatura mínima: " + Collections.min(temperaturas));
                    System.out.println("Temperatura promedio: " + suma / temperaturas.size());
                    break;
            }
            opcion = leerMenu();
        }
    }

    static int leerMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Nuevo Registro");
        System.out.println("2. Listar Registros");
        System.out.println("3. Mostrar estadística");
        System.out.println("0. SALIR");

        int opcion = sc.nextInt();
        return opcion;
    }
}