import java.time.LocalTime;
import java.util.Scanner;

public class Ud02Practica02Tiempo {
    public static void main(String[] args) {
        final int MIN_SEGUNDOS = 5;
        final int MAX_SEGUNDOS = 30;

        LocalTime horaInicio, horaFin;
        int segundos;

        segundos = (int)(Math.random() * (MAX_SEGUNDOS - MIN_SEGUNDOS + 1)) + MIN_SEGUNDOS;

        horaInicio = LocalTime.now();

        System.out.println("Contando " + segundos + "...");
        System.out.println("Pulsa ENTER al terminar de contar...");

        Scanner sc;
        sc = new Scanner(System.in);
        sc.nextLine();

        horaFin = LocalTime.now();

        /*System.out.println("Hora de inicio: " + horaInicio.toSecondOfDay());
        System.out.println("Hora de fin: " + horaFin.toSecondOfDay());*/        

        int segundosTrascurridos = horaFin.toSecondOfDay() - horaInicio.toSecondOfDay();

        System.out.println("Segundos transcurridos: " + segundosTrascurridos);;

        int diferenciaSegundos = Math.abs(segundosTrascurridos - segundos);

        if( diferenciaSegundos == 0){
            System.out.println("Enhorabuena!! Tienes una gran precepción del tiempo!!");
        } else {
            System.out.println("Te has desviado en " + diferenciaSegundos + " segundos");
        }
    }
}
