public class ArraysParalelosNotas {
    public static void main(String[] args){
        /*
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
            notasReales[i] = Math.random() * 8 + 2; // Valora aleatorio entre 0 y 10 inclusives
        }  

        // Inicializar notasBoletin a valores redondeados de notasReales. El valor mínimo es 1.
        for(int i = 0; i < NUM_ALUMNOS; i++){
            notasBoletin[i] = (int) Math.round(notasReales[i]);
            if (notasBoletin[i] == 0)
                notasBoletin[i] = 1;
            aprobados[i] = notasBoletin[i] >= 5;
        }  
        
        System.out.println("    Alumn@   NotaReal    Boletin     Aprobado");
        for(int i = 0; i < NUM_ALUMNOS; i++){
            System.out.printf("%10s %10.2f %10d", nombres[i], notasReales[i], notasBoletin[i]);
            System.out.println("\t" + aprobados[i]);
        }    
        
        System.out.printf("La nota media de la clase es de %.2f %n", ClaseArrays.media(notasReales));
        System.out.printf("La nota media de la clase en el boletín es de %.2f %n", ClaseArrays.media(notasBoletin));

        // Aprobado general con las notas del boletín
        int[] notasAprobadoGeneral = aprobadoGeneral(notasBoletin);

        // Vuelve a imprimir las tablas de notas
        System.out.println("    Alumn@   NotaReal    Boletin     BoletinAprobados Aprobado");
        for(int i = 0; i < NUM_ALUMNOS; i++){
            System.out.printf("%10s %10.2f %10d %10d", nombres[i], notasReales[i], notasBoletin[i], notasAprobadoGeneral[i]);
            System.out.println("\t" + aprobados[i]);
        }


        
        int[] notas10 = ClaseArrays.buscarVarios(notasBoletin, 10);
        if(notas10 != null){
            System.out.println("Alumnado susceptible de tener matrícula:");
            for(int i = 0; i < notas10.length; i++)
                System.out.println(i + 1 + " - " + nombres[notas10[i]]);
        } else {
            System.out.println("No hay alumnado con nota suficiente (=10)");
        }
            */



    }

    static int[] aprobadoGeneral(int[] t){
        // Devuelve una copia del array original con los elementos cuyo valor es menor que 5 igual a 5
        int[] tCopia = new int[t.length];
        for(int i = 0; i < t.length; i++)
            if (t[i] < 5)
                tCopia[i] = 5;
            else
                tCopia[i] = t[i];
        return tCopia;
    }
}
