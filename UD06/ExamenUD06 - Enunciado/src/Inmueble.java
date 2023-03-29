public abstract class Inmueble {
    String direccion;
    int numHab;
    int numBanhos;
    int m2;
    int precioAlquiler;
    int precioVenta;

    
    public Inmueble() {
    }

    public Inmueble(String direccion, int m2, int numHab, int numBanhos, int precioAlquiler, int precioVenta) {
        this.direccion = direccion;
        this.numHab = numHab;
        this.numBanhos = numBanhos;
        this.m2 = m2;
        this.precioAlquiler = precioAlquiler;
        this.precioVenta = precioVenta;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public int getNumBanhos() {
        return numBanhos;
    }

    public void setNumBanhos(int numBanhos) {
        this.numBanhos = numBanhos;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }


    
    
}
