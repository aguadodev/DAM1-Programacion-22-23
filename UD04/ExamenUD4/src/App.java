// Anxo Quintana Dopazo

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Escoge un progama.");
        System.out.println("\n1 Rango");
        System.out.println("2 Cambio de color");
        System.out.println("3 Camino válido");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nElección: ");
        int eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                rango(null);
                break;
            case 2:
                cambiarColor(null, eleccion, eleccion);
                break;
            case 3:
                caminoValido();
                break;
        }
    }

    public static int rango(int t[]) {
        System.out.println("\n=====");
        System.out.println("RANGO");
        System.out.println("=====\n");

        // Tamaño de array por teclado
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del array: ");
        int tamanho = sc.nextInt();

        int diferencia;

        try {
            t = new int[tamanho];

            if (tamanho == 0 || tamanho < 2) {
                diferencia = 0;

                System.out.println("0");

                return diferencia;
            } else {
                // Registro número más alto del array empezando desde el más bajo
                int numeroMayor = 0;

                // Registro número más bajo del array empezando desde el más alto
                int numeroMenor = 10;

                // Generación aleatoria valores del array del -10 al 10
                for (int i = 0; i < t.length; i++) {
                    t[i] = (int) (Math.random() * 20 - 10);

                    if (t[i] > numeroMayor) {
                        numeroMayor = t[i];
                    }

                    if (t[i] < numeroMenor) {
                        numeroMenor = t[i];
                    }
                }

                // Imprimir array
                System.out.println("\n" + Arrays.toString(t));

                // Cálculo de la distancia entre el número mayor y menor
                diferencia = numeroMayor - numeroMenor;

                System.out.print("\nLa diferencia es " + diferencia);

                return diferencia;
            }
        } catch (java.lang.NegativeArraySizeException exception) {
            System.out.println("0");

            diferencia = 0;

            return diferencia;
        }

    }

    static boolean cambiarColor(int[][] img, int colorViejo, int colorNuevo) {
        System.out.println("\n===============");
        System.out.println("CAMBIO DE COLOR");
        System.out.println("===============\n");

        // Asociación de colores (estos, por ejemplo)
        int rojo = 1;
        int azul = 2;
        int amarillo = 3;
        int blanco = 4;
        int negro = 5;

        // Generar imagen
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img.length; j++) {
                img[i][j] = (int) (Math.random() * 6 - 1);
            }
        }

        System.out.println("Su imagen:");
        System.out.println(Arrays.toString(img));

        // Cambios de colores
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el color a cambiar: ");
        colorViejo = sc.nextInt();

        System.out.print("\nIngrese el color a sustituir: ");
        colorNuevo = sc.nextInt();

        boolean cambio;

        // Comprobación del cambio
        if (colorViejo == colorNuevo) {
            cambio = false;

            System.out.println(Arrays.toString(img));

            return cambio;
        } else {
            cambio = true;

            for (int i = 0; i < img.length; i++) {
                for (int j = 0; j < img.length; j++) {
                    if (img[i][j] == colorViejo) {
                        colorViejo = colorNuevo;
                    }
                }
            }
        }
    }

    public static boolean caminoValido() {
        System.out.println("\n==================");
        System.out.println("JUEGO DE LABERINTO");
        System.out.println("==================\n");

        // Mapa
        String[] mapa = {
                "  X       ",
                " *        ",
                "  *  *    ",
                "          ",
                " S        "
        };

        System.out.println(mapa);

        // N --> norte, S --> sur, O --> oeste, E --> este
        System.out.println("\nN --> Norte");
        System.out.println("S --> Sur");
        System.out.println("O --> Oeste");
        System.out.println("E --> Este");

        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el camino que va a tomar: ");
        String camino = sc.nextLine().toUpperCase();

        boolean validacion = true;

        return validacion;
    }
}