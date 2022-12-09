// https://www.aceptaelreto.com/problem/statement.php?id=620&cat=151
// VEREDICTO: Wrong answer (WA)  >:/

import java.util.Arrays;
import java.util.Scanner;

public class JuegosEnCintas620 {
    public static void main(String[] args) {
        try {


        Scanner sc = new Scanner(System.in);
        String linea = sc.nextLine();
        while (!linea.equals("")) {
            String datosLinea[] = linea.split(" ");
            int tamanhoCara = Integer.valueOf(datosLinea[0]);
            int numJuegos = Integer.valueOf(datosLinea[1]);
            int[] duracionJuegos = new int[numJuegos];
            int sumaDuracion = 0;

            linea = sc.nextLine();
            datosLinea = linea.split(" ");

            for (int i = 0; i < numJuegos; i++) {
                duracionJuegos[i] = Integer.valueOf(datosLinea[i]);
                sumaDuracion += duracionJuegos[i];
            }

            // Intenta Guardar los Juegos
            if (sumaDuracion <= tamanhoCara)
                System.out.println("SI");
            else if (sumaDuracion > tamanhoCara * 2)
                System.out.println("NO");
            else {
                // Cuando la suma de duración de los juegos es mayor que el tamanho de una cara
                // pero menor que el de las dos.
                // Ordenamos la duración de los juegos.
                Arrays.sort(duracionJuegos);
                int espacioCaraA = tamanhoCara;
                int espacioCaraB = tamanhoCara;

                int i = duracionJuegos.length - 1;
                boolean hayEspacio = true;
                while (hayEspacio && i >= 0) {
                    // Intentamos meter el juego más grande que falte por grabar en la cara con más
                    // espacio libre
                    if (espacioCaraA > espacioCaraB)
                        espacioCaraA -= duracionJuegos[i];
                    else
                        espacioCaraB -= duracionJuegos[i];

                    if (espacioCaraA < 0 || espacioCaraB < 0)
                        hayEspacio = false;
                    i--;
                }

                if (hayEspacio)
                    System.out.println("SI");
                else
                    System.out.println("NO");
            }

            // Lee un nuevo caso de prueba
            linea = sc.nextLine();

        }
    } catch (Exception e){

    }

    }
}
