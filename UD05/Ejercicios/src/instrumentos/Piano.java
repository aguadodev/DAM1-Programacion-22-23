package instrumentos;

import java.util.Arrays;

public class Piano extends Instrumento{

    @Override
    public void interpretar() {
        System.out.print("Melodía de piano: " + Arrays.toString(melodia) + "\n\n");        
    }
    
    public Piano(String[] melodia) {
        super(melodia);
    }

    public Piano() {
    }     

    
    
}
