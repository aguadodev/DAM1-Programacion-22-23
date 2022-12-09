import java.util.Scanner;

public class LaPulga615 {
    // https://www.aceptaelreto.com/problem/statement.php?id=615&cat=151
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();

        for (int i = 0; i < numCasos; i++) {
            int potencia = 0;
            int n = sc.nextInt();
            int f = sc.nextInt();
            int t = sc.nextInt();

            potencia = (t % (n + 1)) * f;

            System.out.println(potencia);
        }
    }

}
