import java.util.Arrays;

/**
 * Paraninfo515
 * 
 * Debes desarrollar una aplicación que ayude a gestionar las notas de un centro educativo. 
 * Los alumnos se organizan en grupos compuestos por 5 personas. 
 * Leer las notas (números enteros) del primer, segundo y tercer trimestre de un grupo. 
 * Debes mostrar al final la nota media del grupo en cada trimestre 
 * y la media del alumno que se encuentra en una posición dada (que el usuario introduce por teclado).
 */
public class Paraninfo515 {
    public static void main(String[] args) {
        final int NUM_ALUMNOS = 5;
        final int NUM_TRIMESTRES = 3;
        int notas[][];

        notas = new int[NUM_ALUMNOS][NUM_TRIMESTRES];

        for(int i = 0; i < NUM_ALUMNOS; i++)
            for(int j = 0; j < NUM_TRIMESTRES; j++)
                notas[i][j] = (int) (Math.random() * 8 + 3); // Notas aleatorias entre 3 y 10

        System.out.println(Arrays.deepToString(notas));

        for(int i = 0; i < NUM_ALUMNOS; i++){
            System.out.println(Arrays.toString(notas[i]));
        }

        // mostrar al final la nota media del grupo en cada trimestre
        System.out.println("\nMEDIAS DE LA CLASE PARA CADA TRIMESTRE");
        System.out.println("======================================\n");
        for(int j = 0; j < NUM_TRIMESTRES; j++){
            int suma = 0;
            for(int i = 0; i < NUM_ALUMNOS; i++){
                suma += notas[i][j];
            }
            System.out.printf("La media del trimestre %d es %.2f %n", j + 1, (double) suma / NUM_ALUMNOS);
        }

        // mostrar al final la nota media del grupo en cada trimestre
        System.out.println("\nMEDIAS DE CADA ALUMNO");
        System.out.println("=====================\n");
        for(int i = 0; i < NUM_ALUMNOS; i++){
            int suma = 0;
            for(int j = 0; j < NUM_TRIMESTRES; j++){
                suma += notas[i][j];
            }
            System.out.printf("La media del alumno %d es %.2f %n", i + 1, (double) suma / NUM_TRIMESTRES);
        }



    }
    
}