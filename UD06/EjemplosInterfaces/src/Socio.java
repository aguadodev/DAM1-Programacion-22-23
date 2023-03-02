import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class Socio implements Comparable{
    int id;
    String nombre;
    String apellidos;
    LocalDate fechaAlta;

    public Socio() {
    }

    public Socio(int id, String nombre, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = LocalDate.parse(fechaAlta, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + fechaAlta;
    }

    @Override
    public int compareTo(Object o) {       
        int res = fechaAlta.compareTo(((Socio) o).fechaAlta);

        return res == 0? id - ((Socio) o).id : res;
    }

}
