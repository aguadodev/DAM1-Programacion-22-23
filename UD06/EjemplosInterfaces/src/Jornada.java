import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Jornada implements Comparable<Jornada>{
    protected String dni;
    protected LocalDate fecha;
    protected LocalTime horaInicio;
    protected LocalTime horaFin;
    static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Jornada(String dni, String fecha, String horaInicio, String horaFin) {
        this.dni = dni;
        this.fecha = LocalDate.parse(fecha, formatoFecha);
        this.horaInicio = LocalTime.parse(horaInicio);
        this.horaFin = LocalTime.parse(horaFin);
    }

    @Override
    public int compareTo(Jornada o) {
        int compDni = dni.compareTo(o.dni);

        return  compDni != 0 ? compDni : fecha.compareTo(o.fecha);        
    }

    public int minutosTrabajados(){
        //return (int) horaInicio.until(horaFin, ChronoUnit.MINUTES);
        //return (int) Duration.between(horaInicio, horaFin).toMinutes();
        return (horaFin.toSecondOfDay() - horaInicio.toSecondOfDay()) / 60;
    }

    @Override
    public String toString() {
        return "DNI=" + dni + ", fecha=" + fecha.format(formatoFecha) + ", minutos trabajados=" + minutosTrabajados() + "]";
    }

    

    


}
