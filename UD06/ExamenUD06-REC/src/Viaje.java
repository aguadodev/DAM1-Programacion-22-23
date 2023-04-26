import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Viaje {
    protected Conductor conductor;
    protected LocalDateTime fechaHoraSalida;    
    protected PuntoEncuentro puntoSalida;    
    protected PuntoEncuentro puntoLlegada;  
    protected byte plazas;
    protected Pasajero[] pasajeros;

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

        String str = "\nViaje compartido:"
             + "\n================="
             + "\nFecha y hora: " + fechaFormateada 
             + "\nLugar de salida: " + puntoSalida
             + "\nLugar de llegada: " + puntoLlegada 
             + "\nPlazas libres: " + getPlazasLibres() + "/" + plazas 
             + "\nConductor@: " + conductor 
             + "\nCoche: " + conductor.coche 
             + "\nPasajer@s: ";
        
        if(getPlazasOcupadas() == 0)
            str += "sin pasajeros.";
        else 
            for(int i = 0; i < pasajeros.length; i++){
                str += pasajeros[i];
                if(i < pasajeros.length - 1)
                    str += ", ";
                else 
                    str += ".";
            }
            
        return str;
    }

    public Byte getPlazasOcupadas() {
        return (byte)pasajeros.length;
    }
    
    public Byte getPlazasLibres() {
        return (byte)(plazas - pasajeros.length);
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public PuntoEncuentro getPuntoSalida() {
        return puntoSalida;
    }

    public void setPuntoSalida(PuntoEncuentro puntoSalida) {
        this.puntoSalida = puntoSalida;
    }

    public PuntoEncuentro getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(PuntoEncuentro puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public byte getPlazas() {
        return plazas;
    }

    public void setPlazas(byte plazas) {
        this.plazas = plazas;
    }

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }
    

    
}
