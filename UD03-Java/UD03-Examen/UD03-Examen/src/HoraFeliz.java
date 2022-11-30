import java.time.LocalTime;

public class HoraFeliz {
    public static void main(String[] args) {
        // 1. Generar hora aleatoria
        int horaFeliz = (int) (Math.random()*24);
        int minFeliz = (int) (Math.random()*60);
        // 2. Obtener la hora del momento
        
        LocalTime ahora = LocalTime.now();
        int horaActual = ahora.getHour();
        int minActual = ahora.getMinute();

        // 3. Mostrar ambas
        System.out.printf("Hora Feliz: %02d:%02d %n", horaFeliz,  minFeliz);
        System.out.printf("Hora Actual: %02d:%02d %n", horaActual,  minActual);

        // 4. Calcular diferencia en minutos
        int diferencia = minutosTranscurridos(horaFeliz, minFeliz, horaActual, minActual);

        // 5. Comparar horas
        if (diferencia > 60){
            System.out.println("Ya pasó la hora feliz de hoy");
        } else if (diferencia >= 0) {
            System.out.println("ES LA HORA FELIZ!!");
        } else {
            System.out.printf("Faltan %d minutos para que comience la hora feliz.%n%n", -diferencia);
        }    
    }

    public static int minutosTranscurridos(int horaActual, int minActual, int horaFeliz, int minFeliz){
        
        int minutosHoraFeliz = horaFeliz * 60 + minFeliz;
        int minutosHoraActual = horaActual * 60 + minActual;

        
        return minutosHoraActual - minutosHoraFeliz;
    }

}
