import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Actividad112 {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cancionPirata.dat"))) {
            out.writeObject("Con diez cañones por banda,");
            out.writeObject("viento en popa a toda vela,");
            out.writeObject("no corta el mar, sino vuela");
            out.writeObject("un velero bergantin.");

        } catch (IOException ex) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }

        String cancion = "";

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cancionPirata.dat"))) {

            while (true) {
                cancion += "\n" + (String) in.readObject();
            }
        } catch (EOFException ex) {
        } 
        catch (ClassNotFoundException ex) {
        }         
        catch (IOException ex) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }

        
        System.out.println(cancion);

    }
}
