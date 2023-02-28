package animales;

public class Leon implements Sonido{

    @Override
    public void voz() {
        System.out.println("Grrrr");        
    }

    @Override
    public void vozDurmiendo() {
        //Sonido.super.vozDurmiendo();
        System.out.println("Grrrrrrrrrrrr");
    }

    
    
}
