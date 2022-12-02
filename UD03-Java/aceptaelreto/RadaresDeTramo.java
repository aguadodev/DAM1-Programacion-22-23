// https://www.aceptaelreto.com/problem/statement.php?id=112&cat=5
import java.util.Scanner;

public class RadaresDeTramo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int metros, velocidadMax, segundos;
        do {
            metros = sc.nextInt();
            velocidadMax = sc.nextInt();
            segundos = sc.nextInt();

            double velocidad = (metros / 1000.0) / (segundos / 3600.0);

            if (metros < 0 || velocidadMax < 0 || segundos < 0)
                System.out.println("ERROR");
            else
                if (velocidad < velocidadMax)
                    System.out.println("OK");
                else if (velocidad < (velocidadMax * 1.2))
                    System.out.println("MULTA");
                else
                    System.out.println("PUNTOS");

        } while (metros != 0 || velocidadMax !=0 || segundos != 0);
        
    }
}
