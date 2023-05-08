import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Actividad108 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("salida.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter("copia de salida.txt"))) {
            String linea = in.readLine();
            while (linea != null){
                out.write(linea);
                out.newLine();
                linea = in.readLine();
            } 

        } catch (Exception e) {

        }
    }
}
