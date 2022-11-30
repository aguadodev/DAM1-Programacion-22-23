import java.time.LocalTime;

public class HoraFeliz2 {
    public static void main(String[] args) {
        // 1. Generar hora aleatoria
        LocalTime horaFeliz = LocalTime.of((int) (Math.random()*24), (int) (Math.random()*60));

        // 2. Obtener la hora del momento
        LocalTime horaActual = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute() );

        // 3. Mostrar ambas
        System.out.println("Hora Feliz: " + horaFeliz);
        System.out.println("Hora Actual: " + horaActual);

        // 4. Comparar horas
        if (horaActual.isBefore(horaFeliz)) {
            // 5. Calcular diferencia en minutos
            int diferencia = (horaFeliz.toSecondOfDay() - horaActual.toSecondOfDay()) / 60;
            System.out.printf("Faltan %d minutos para que comience la hora feliz.%n%n", diferencia);
        } else if (horaActual.isBefore(horaFeliz.plusMinutes(60))){
            System.out.println("ES LA HORA FELIZ!!");
        } else {
            System.out.println("Ya pasó la hora feliz de hoy");
        }
    }
}
