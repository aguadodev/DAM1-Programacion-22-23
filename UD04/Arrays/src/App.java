public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("ARRAYS!!!");

        final int NUM_ALUMNOS = 3000;

        double notasReales[];   // 8
        int notasBoletin[];     // 4
        boolean aprobados[];    // 1b
        String nombres[];       // Referencia
        
        int notas2Av[], notas3Av[] = null;

        notasReales = new double[NUM_ALUMNOS];
        notasBoletin = new int[NUM_ALUMNOS];
        aprobados = new boolean[NUM_ALUMNOS];
        nombres = new String[NUM_ALUMNOS];
        notas2Av = notasBoletin;

        System.out.println(notasReales);
        System.out.println(notasBoletin);        
        System.out.println(notas2Av);        
        System.out.println(notas3Av);        
        System.out.println(aprobados);
        System.out.println(nombres);

        notasBoletin[5] = 8;
        notas2Av[5]++;

        System.out.println(notas2Av[5]);  
        System.out.println(nombres[5]);  
     
    }
}
