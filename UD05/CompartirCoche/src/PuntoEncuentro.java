public class PuntoEncuentro {
    protected String nombre;
    protected double latitud;
    protected double longitud;
    
    public PuntoEncuentro(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return nombre + "(" + latitud + ", " + longitud + ")";
    }
    
}
