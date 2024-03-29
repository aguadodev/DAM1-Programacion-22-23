import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FicherosBinarios01 {
    public static void main(String[] args) {
        
        // Crea un objeto Jugador y lo escribe en un archivo binario
        try (FileOutputStream archivo = new FileOutputStream("jugadores.dat")) {
            ObjectOutputStream out = new ObjectOutputStream(archivo);
            Jugador jugador = new Jugador("Oscar", 40, 170);

            out.writeObject(jugador);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Lee un objeto Jugador desde un archivo binario
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("jugadores.dat"))) {
            Jugador jugador2 = (Jugador) in.readObject();
            System.out.println(jugador2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
