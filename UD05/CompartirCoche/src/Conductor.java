import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conductor extends Persona{
    LocalDate fechaExpedicionPermiso;
    Coche coche;

    public Conductor(String nombre, Coche coche) {
        this(nombre, null, coche);
    }

    public Conductor(String nombre, String fechaExpedicionPermiso, Coche coche) {
        super(nombre);
        if (fechaExpedicionPermiso != null) 
            this.fechaExpedicionPermiso = LocalDate.parse(fechaExpedicionPermiso, DateTimeFormatter.ofPattern("dd/M/yyyy"));
        this.coche = coche;
    }

    @Override
    public String toString() {
        String str = nombre;
        if (fechaExpedicionPermiso != null)
            str += " (" + getAntiguedadPermiso() + " años de carnet)";
        return  str;
    }

    private Byte getAntiguedadPermiso() {
        if (fechaExpedicionPermiso == null)
            return null;
        else {
            LocalDate hoy = LocalDate.now();
            int anhos = hoy.getYear() - fechaExpedicionPermiso.getYear();            
            // TODO Revisar meses y días también
            /*if (fechaExpedicionPermiso.getMonthValue() > hoy.getMonthValue())

            hoy = hoy.minusDays(fechaExpedicionPermiso.getDayOfMonth());
            hoy = hoy.minusMonths(fechaExpedicionPermiso.getMonthValue());*/
            
            return (byte)anhos;
        }
    }
    
    

}
