import java.time.LocalDateTime;

public class App3 {
    public static void main(String[] args) {
        // Crea un coche indicando nombre, color, número de plazas y matrícula
        Coche coche1 = new Coche("Seat Ibiza", "Negro", 5, "FDD1234", "DIESEL", null);
        // Crea un conductor indicando el nombre y el coche que conduce
        Conductor conductor1 = new Conductor("Uxía", "08/01/2023", coche1);
                
        // Crea un viaje indicando el conductor, la fecha y hora de salida, 
        // los puntos de salida y llegada (indicando para cada uno un nombre descriptivo
        // y sus coordenadas GPS de latitud y longitud) y el número de plazas
        // ofertadas a pasajeros.
        LocalDateTime fechaHoraSalida = LocalDateTime.of(2023, 02, 8, 14, 30, 00);
        PuntoEncuentro puntoSalida = new PuntoEncuentro("Praza de Galicia (Pontevedra)",42.42801,-8.64441);
        PuntoEncuentro puntoLlegada = new PuntoEncuentro("IES Chan do Monte (Marín)",42.38962,-8.7096);
        Viaje viaje1 = new Viaje(conductor1, fechaHoraSalida, puntoSalida, puntoLlegada, 3);
        
        // Imprime por consola la información resumida del viaje
        System.out.println(viaje1);
    }   
}
