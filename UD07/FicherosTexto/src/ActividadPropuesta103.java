import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActividadPropuesta103 {
    static List<Jugador> lista = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("jugadores.txt"))) {
            String linea = in.readLine();
            while (linea != null) {
                // MÉTODO 1 : USANDO UNA CLASE ESCANER PARA EVALUAR EL FLUJO DE ENTRADA DE CADA
                // LINEA
                Scanner sc = new Scanner(linea);
                lista.add(new Jugador(sc.next(), sc.nextInt(), sc.nextDouble()));


                // MÉTODO 2 : USANDO SPLIT Y parseInt o valueOf                 
                /* String campos[] = linea.split(" ");
                 * lista.add(new Jugador(campos[0], Integer.parseInt(campos[1]), Double.valueOf(campos[2])));
                 */


                linea = in.readLine();

            }
            System.out.println(lista.toString());

            System.out.println("Media de edades: " + Jugador.mediaEdad(lista));
            System.out.println("Media de estatura: " + Jugador.mediaEstatura(lista));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}