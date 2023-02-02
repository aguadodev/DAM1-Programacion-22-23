package instrumentos;

import java.util.Arrays;

public class Guitarra extends Instrumento{

    @Override
    public void interpretar() {
        System.out.print("Melodía de guitarra: " + Arrays.toString(melodia) + "\n\n");        
    }

    public Guitarra(String[] melodia) {
        super(melodia);
    }

    public Guitarra() {
    }         
}
