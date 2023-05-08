import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Actividad1022 {
    public static void main(String[] args) {
        double sumaEdad = 0, sumaPeso = 0, sumaEstatura = 0;


        try (BufferedReader in = new BufferedReader(new FileReader("deportistas.txt"))) {        
            String linea = in.readLine();
            int i = 0;
            while (linea != null){
                if (i > 0){
                    Scanner sc = new Scanner(linea);
                    String nombre = "";
                    while (!sc.hasNextInt())
                        nombre += sc.next() + " ";
                    int edad = sc.nextInt();
                    sumaEdad += edad;
                    double peso = sc.nextDouble();
                    sumaPeso += peso;
                    double estatura = sc.nextDouble();
                    sumaEstatura += estatura;
                    System.out.println(nombre + edad + " " + peso + " " + estatura);
                }
                i++;
                linea = in.readLine();
            }

            System.out.println("Media de edad: " + sumaEdad / (i - 1));
            System.out.println("Media de peso: " + sumaPeso / (i - 1));
            System.out.println("Media de estatura: " + sumaEstatura / (i - 1));


        } catch (Exception e) {
            // TODO: handle exception
        }



    }
}
