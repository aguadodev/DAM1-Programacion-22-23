public class Piso extends Inmueble{
    int numPlanta;

    public Piso(String direccion, int numHab, int numBanhos, int m2, int numPlanta) {
        super(direccion, numHab, numBanhos, m2);
        this.numPlanta = numPlanta;
    }

    @Override
    String detalle() {
        // TODO Auto-generated method stub
        return null;
    }

    

}
