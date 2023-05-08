import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Actividad1115 {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("numeros.dat"))) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Cuántos números aleatorios quieres guardar en 'numeros.dat'?");
            int num = sc.nextInt();

            for (int i = 0; i < num; i++) {
                int numero = (int) (Math.random() * 199 - 99);
                System.out.print(numero + " ");
                out.writeInt(numero);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("numeros.dat"));
                ObjectOutputStream outPares = new ObjectOutputStream(new FileOutputStream("pares.dat"));
                ObjectOutputStream outImpares = new ObjectOutputStream(new FileOutputStream("impares.dat"))) {
            while (true) {
                int numero = in.readInt();
                if (numero % 2 == 0){
                    outPares.writeInt(numero);
                } else {
                    outImpares.writeInt(numero);
                }
            }
        } catch (EOFException e) {
            // Fin de fichero..
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        

    }
}
