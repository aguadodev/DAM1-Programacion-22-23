public class Casa extends Inmueble{
    int m2Terreno;

    public Casa(String direccion, int numHab, int numBanhos, int m2, int m2Terreno) {
        super(direccion, numHab, numBanhos, m2);
        this.m2Terreno = m2Terreno;
    }

    @Override
    String detalle() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
