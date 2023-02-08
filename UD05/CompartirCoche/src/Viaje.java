import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Override
    public String toString() {
        String fechaFormateada = fechaHoraSalida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        /*String fechaFormateada = fechaHoraSalida.getDayOfMonth() 
        + "/" + fechaHoraSalida.getMonthValue()
        + "/" + fechaHoraSalida.getYear()
        + " " + fechaHoraSalida.getHour()
        + ":" + fechaHoraSalida.getMinute();*/

        String str = "\nViaje compartido:"
             + "\n================="
             + "\nFecha y hora: " + fechaFormateada 
             + "\nLugar de salida: " + puntoSalida
             + "\nLugar de llegada: " + puntoLlegada 
             + "\nPlazas ofertadas: " + plazas 
             + "\nConductor@: " + conductor 
             + "\nCoche: " + conductor.coche 
             + "\nPasajer@s: ";
             
        for(int i = 0; i < pasajeros.length; i++){
            str += pasajeros[i];
            if(i < pasajeros.length - 1)
                str += ", ";
            else 
                str += ".";
        }
            

        return str;
    }
    
    
    
}
