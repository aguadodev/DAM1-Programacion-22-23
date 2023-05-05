import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

// Utilizando la clase Jugador en lugar de Socio
public class Actividad118 {
    public static void main(String[] args) {
        
        Jugador[] jugadores = {
            new Jugador("Oscar", 40, 170),
            new Jugador("Marta", 40, 170),
            new Jugador("Juan", 40, 170),
            new Jugador("Sofía", 40, 170),
            new Jugador("Pepe", 40, 170),
            new Jugador("Lola", 40, 170),
            new Jugador("Marcos", 40, 170),
        };


        try (FileOutputStream archivo = new FileOutputStream("jugadores.dat")) {
            ObjectOutputStream out = new ObjectOutputStream(archivo);

            out.writeObject(jugadores);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("jugadores.dat"))) {
            Jugador[] jugadores2 = (Jugador[]) in.readObject();
            System.out.println(Arrays.toString(jugadores2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
