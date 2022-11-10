import java.time.LocalTime;
import java.util.Scanner;

public class Probas {
    public static void main(String[] args) {
        // Obtiene y muestra la hora local en formato hh:mm
        LocalTime horaActual;

        horaActual = LocalTime.now();

        int hora = horaActual.getHour();
        int minuto = horaActual.getMinute();

        System.out.printf("%d:%02d", hora, minuto);  
        

        // Lee un número y calcula su raíz cuadrada
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número positivo: ");
        
        double num = sc.nextDouble();

        double num2Decimales = Math.round(Math.sqrt(num) * 100) / 100.0;

        System.out.println(Math.sqrt(num));
        System.out.println(num2Decimales);

    }
}
