import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Actividad111 {
    public static void main(String[] args) {
        // Escribe 10 números enteros e un fichero binario
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("datos.dat"))) {
            for (int i = 0; i < 10; i++) {
                out.writeInt(i);
            }

        } catch (IOException ex) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }
        int suma = 0;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("datos.dat"))) {

            for (int i = 0; i < 11; i++) {
                suma += in.readInt();
            }
            System.out.println("Suma del 0 al 9: " + suma);

        } catch (EOFException e) {

            System.out.println("Fin del fichero!! La suma hasta ese momento fue de : " + suma);

        } catch (Exception e) {
            System.out.println("Escribiendo... Error Entrada/Salida");
        }

        System.out.println("Suma después del try-catch: " + suma);
    }
}
