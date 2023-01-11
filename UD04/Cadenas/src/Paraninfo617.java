import java.util.Scanner;

public class Paraninfo617 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra o una frase: ");
        String frase = sc.nextLine();

        for(int i = 0; i < frase.length(); i++){
            if (i != 0 && i % 4 == 0)
                System.out.println();
            System.out.print(frase.charAt(i));
        }

    }


}
