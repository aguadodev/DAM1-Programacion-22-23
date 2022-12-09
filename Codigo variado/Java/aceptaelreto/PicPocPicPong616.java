// https://www.aceptaelreto.com/problem/statement.php?id=616&cat=151
import java.util.Scanner;

public class PicPocPicPong616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num != 0) {
            String partida = sc.nextLine();
            String[] movs = partida.split(" ");
            boolean sentidoDerecha = true; 
            int puntosIzq = 0, puntosDch = 0;
            for (int i = 0; i < movs.length; i++){
                if (movs[i].equals("PIC"))
                    sentidoDerecha = !sentidoDerecha;
                else if (movs[i].equals("PONG!"))
                    if (sentidoDerecha)
                        puntosIzq++;
                    else
                        puntosDch++;            
            }
            System.out.println(puntosIzq + " " + puntosDch);
            num = sc.nextInt();
        }        
    }
}
