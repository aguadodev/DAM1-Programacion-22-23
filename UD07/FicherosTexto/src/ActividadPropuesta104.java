import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ActividadPropuesta104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe líneas de texto que se guardarán en el archivo 'salida.txt' hasta que introduzcas la cadena 'fin'.");

        try (BufferedWriter out = new BufferedWriter(new FileWriter("salida.txt"))) {

            String linea = sc.nextLine();
            while (!linea.equals("fin")) {
                out.write(linea);
                out.newLine();
                linea = sc.nextLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
