public class App {
    public static void main(String[] args){
        System.out.println("ARRAYS!!!");
        
        // Declaración array de nombres inicializado
        String nombres[] = {"Alex","Xoán","Patricia","Brais","Ander",
                            "Javier","Fabricio","Hugo F.","Manuel","David G.",
                            "Pilar","María","Ramón","Xoel","Hugo I.",
                            "Andrés","César","David M.","Borja","Xabier",
                            "Diego","Girma","Yago","Anxo","David S.",
                            "Mario","Daniel","Antonella","Manuel"};

        // Declaración constante tamaño arrays
        final int NUM_ALUMNOS = nombres.length;

        // Declaración de variables de arrays
        double notasReales[];   // 8
        int notasBoletin[];     // 4
        boolean aprobados[];    // 1b                    

        // Creamos los arrays con new
        notasReales = new double[NUM_ALUMNOS];
        notasBoletin = new int[NUM_ALUMNOS];
        aprobados = new boolean[NUM_ALUMNOS];

        // Inicializar notasReales a valores aleatorios flotantes entre 0 y 10;
        for(int i = 0; i < NUM_ALUMNOS; i++){
            notasReales[i] = Math.random() * 10; // Valora aleatorio entre 0 y 10 inclusives
        }  

        // 
        
        for(int i = 0; i < NUM_ALUMNOS; i++){
            System.out.printf("La nota de %s es %.2f %n", nombres[i], notasReales[i]);
        }
    }
}
