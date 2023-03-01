package animales;

import javax.sound.sampled.SourceDataLine;

public class Perro implements Sonido {

    @Override
    public void voz() {
        System.out.println("Guau!");        
    }

    public void moverRabo(){
        System.out.println("El perro está contento y mueve el rabo.");
    }
    
}