import java.util.Scanner;

// https://www.aceptaelreto.com/problem/statement.php?id=617&cat=151
public class MensajesSpaceInvaders617 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();

        for (int i = 0; i < numCasos; i++) {
            int numPuntuaciones = sc.nextInt(); sc.nextLine();
            String[] puntuaciones = new String[numPuntuaciones];
            for (int j = 0; j < numPuntuaciones; j++)
                puntuaciones[j] = sc.nextLine();
            
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < numPuntuaciones; k++){
                    System.out.print(puntuaciones[k].charAt(j));
            }
            System.out.println();
        }        
    }
}

/*
 * 
 * 
Fecha
04/12/2022, 11:34:41 (UTC)

Lenguaje del envío
Java

Veredicto
Accepted (AC)
Tiempo
0.513 segs.

Memoria
1734 KiB
 * 
 */
