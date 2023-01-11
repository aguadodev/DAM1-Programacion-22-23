import java.util.Scanner;

public class Paraninfo619 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un texto: ");
        String frase = sc.nextLine();

        System.out.println("Que palabra quieres sustituir? ");
        String palabraVieja = sc.nextLine();

        System.out.println("Que otra palabra quieres usar? ");
        String palabraNueva = sc.nextLine();

        System.out.println(frase.replace(palabraVieja, palabraNueva));
    }


}
