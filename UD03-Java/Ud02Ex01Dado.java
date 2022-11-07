public class Ud02Ex01Dado {
    public static void main(String[] arg) {
        // Constante
        final long NUM_LANZAMIENTOS = 100000;

        // Declarar variables
        int caras1, caras2, caras3, caras4, caras5, caras6;
        // Inicializar variables
        caras1 = caras2 = caras3 = caras4 = caras5 = caras6 = 0;

        // Proceso
        for(int i = 1; i <= NUM_LANZAMIENTOS; i++){
            int valorDado = (int)(Math.random() * 6) + 1;
            switch (valorDado) {
                case 1: caras1++; break;
                case 2: caras2++; break;
                case 3: caras3++; break;
                case 4: caras4++; break;
                case 5: caras5++; break;
                case 6: caras6++; break;
            }
        }

        // Salida de resultados
        System.out.println("LANZANDO UN DADO " + NUM_LANZAMIENTOS + " VECES");
        System.out.println("\nRESULTADOS:");
        System.out.println("Ha salido 1: " + caras1 + " veces (" + caras1 * 100.0 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 2: " + caras2 + " veces (" + caras2 * 100.0 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 3: " + caras3 + " veces (" + caras3 * 100.0 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 4: " + caras4 + " veces (" + caras4 * 100.0 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 5: " + caras5 + " veces (" + caras5 * 100.0 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 6: " + caras6 + " veces (" + caras6 * 100.0 / NUM_LANZAMIENTOS + "%)");

        /* Ejemplo de versión con printf para imprimir sólo dos decimales.
        double porcentaje1 = caras1 * 100.0 / NUM_LANZAMIENTOS;
        System.out.printf("Ha salido 1: %d veces ( %.2f %%) %n", caras1, porcentaje1);
        */

    }
}
