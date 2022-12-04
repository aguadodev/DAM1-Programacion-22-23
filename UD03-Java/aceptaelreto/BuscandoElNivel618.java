import java.util.Scanner;

public class BuscandoElNivel618 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numNiveles = sc.nextInt();

        while(numNiveles != 0){
            int[] duracionNiveles = new int[numNiveles];

            for(int i = 0; i < numNiveles; i++)
                duracionNiveles[i] = sc.nextInt();
            sc.nextLine();
    
            int numSubconsultas = sc.nextInt();
    
            for (int i = 0; i < numSubconsultas; i++){
                int ultimoNivel = sc.nextInt() - 1; // restamos 1 para ajustarlo al índice del array
                int siguienteNivel = sc.nextInt() - 1;
    
                int desplazamiento = 0;
    
                if (siguienteNivel > ultimoNivel) 
                    for(int j = ultimoNivel + 1; j < siguienteNivel; j++)
                        desplazamiento += duracionNiveles[j];
                else 
                    for(int j = ultimoNivel; j >= siguienteNivel; j--)
                        desplazamiento -= duracionNiveles[j];

                System.out.println(desplazamiento);
    
            }
            System.out.println("---");

            // Siguiente caso de prueba?
            numNiveles = sc.nextInt();
        }

        

    }
}
