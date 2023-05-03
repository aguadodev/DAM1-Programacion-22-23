import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Actividad105
 */
public class Actividad105 {
public static void main(String[] args) {
    BufferedReader in = null;
    try {
        in = new BufferedReader(new FileReader("Numeros.txt"));
        Scanner s;
        double numero;
        double suma = 0;
        String linea = in.readLine();
        while (linea != null){
            s = new Scanner(linea).useLocale(Locale.US);
            if (s.hasNextDouble()){
                numero = s.nextDouble();
                suma += numero;
            }
            linea = in.readLine();
        }
        System.out.println("La suma es: " + suma);
    } catch (IOException e){
        System.out.println(e.getMessage());
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
    
}