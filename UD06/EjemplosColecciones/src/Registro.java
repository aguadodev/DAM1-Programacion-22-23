import java.time.LocalTime;

public class Registro implements Comparable<Registro> {
    Double temperatura;
    LocalTime hora;

    public Registro(Double temperatura, LocalTime hora) {
        this.temperatura = temperatura;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Hora=" + hora + ". Temperatura=" + temperatura + " grados.\n";
    }

    @Override
    public int compareTo(Registro o) {
        return temperatura.compareTo(o.temperatura);
    }
}