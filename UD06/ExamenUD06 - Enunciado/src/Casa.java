public class Casa extends Inmueble{
    int m2Terreno;

    public Casa(String direccion, int m2, int numHab, int numBanhos, int precioAlquiler, int precioVenta, int m2Terreno) {
        super(direccion, m2, numHab, numBanhos, precioAlquiler, precioVenta);
        this.m2Terreno = m2Terreno;
    }

    @Override
    String detalle() {
        String str = "Casa en " + direccion + ".\n"
         + m2 + " m2, " + numHab + " hab, " + numBanhos+ " baños, con terreno de " + m2Terreno + " m2.\n";
         if (precioAlquiler > 0)
         str += "Precio de Alquiler: " + precioAlquiler + " €\n";

         if (precioVenta > 0)
         str += "Precio de Venta: " + precioVenta + " €\n";

        return str;
    }
    }
