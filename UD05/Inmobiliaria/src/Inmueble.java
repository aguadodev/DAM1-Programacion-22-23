public abstract class Inmueble {
    String direccion;
    int numHab;
    int numBanhos;
    int m2;
    int precioAlquiler;
    int precioVenta;

    
    public Inmueble() {
    }

    public Inmueble(String direccion, int numHab, int numBanhos, int m2, int precioAlquiler, int precioVenta) {
        this.direccion = direccion;
        this.numHab = numHab;
        this.numBanhos = numBanhos;
        this.m2 = m2;
        this.precioAlquiler = precioAlquiler;
        this.precioVenta = precioVenta;
    }

    

    public Inmueble(String direccion, int numHab, int numBanhos, int m2) {
        this.direccion = direccion;
        this.numHab = numHab;
        this.numBanhos = numBanhos;
        this.m2 = m2;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    abstract String detalle();

    @Override
    public String toString() {
        return "Inmueble  en " + direccion + " (" +  m2 + " m2, " + numHab + " hab)";
    }

    
    
}
