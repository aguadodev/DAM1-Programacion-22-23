package instrumentos;

import java.util.Arrays;

public class Campana extends Instrumento {

    @Override
    public void interpretar() {
        System.out.print("Melodía de campana: " + Arrays.toString(melodia) + "\n\n");                        
    }
        
}
