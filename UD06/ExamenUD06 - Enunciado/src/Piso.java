public class Piso extends Inmueble{
    int numPlanta;

    public Piso(String direccion, int m2, int numHab, int numBanhos, int precioAlquiler, int precioVenta, int numPlanta) {
        super(direccion, m2, numHab, numBanhos, precioAlquiler, precioVenta);
        this.numPlanta = numPlanta;
    }

    @Override
    String detalle() {
        String str = "Piso en " + direccion + ".\n"
         + m2 + " m2, " + numHab + " hab, " + numBanhos+ " baños, " + numPlanta + "ª planta.\n";
         if (precioAlquiler > 0)
         str += "Precio de Alquiler: " + precioAlquiler + " €\n";

         if (precioVenta > 0)
         str += "Precio de Venta: " + precioVenta + " €\n";

        return str;
    }

    

}
