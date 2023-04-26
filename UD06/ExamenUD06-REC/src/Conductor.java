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
            this.fechaExpedicionPermiso = LocalDate.parse(fechaExpedicionPermiso, DateTimeFormatter.ofPattern("d/M/yyyy"));
        this.coche = coche;
    }

    

    public Conductor(String nombre) {
        super(nombre);
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
            if (fechaExpedicionPermiso.getMonthValue() > hoy.getMonthValue() ||
               (fechaExpedicionPermiso.getMonthValue() == hoy.getMonthValue() && 
               fechaExpedicionPermiso.getDayOfMonth() > hoy.getDayOfMonth()))
                anhos--;        
            
            return (byte)anhos;
        }
    }
    
    

}
