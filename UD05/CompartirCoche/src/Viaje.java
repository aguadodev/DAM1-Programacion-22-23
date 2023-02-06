import java.time.LocalDateTime;
import java.util.Arrays;

public class Viaje {
    protected Conductor conductor;
    protected LocalDateTime fechaHoraSalida;    
    protected PuntoEncuentro puntoSalida;    
    protected PuntoEncuentro puntoLlegada;  
    protected byte plazas;
    Pasajero[] pasajeros;

    public Viaje(Conductor conductor, LocalDateTime fechaHoraSalida, PuntoEncuentro puntoSalida,
            PuntoEncuentro puntoLlegada, int plazas) {
        this.conductor = conductor;
        this.fechaHoraSalida = fechaHoraSalida;
        this.puntoSalida = puntoSalida;
        this.puntoLlegada = puntoLlegada;
        this.plazas = (byte) plazas;
        this.pasajeros = new Pasajero[0];
    }

    public boolean addPasajero(Pasajero pasajero){
        boolean anhadido = false;
        if (pasajeros.length < plazas){
            pasajeros = Arrays.copyOf(pasajeros, pasajeros.length + 1);
            pasajeros[pasajeros.length - 1] = pasajero; 
            anhadido = true;          
        }
        return anhadido;
    }
    
    
}
