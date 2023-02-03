package instrumentos;

import java.util.Arrays;

public abstract class Instrumento {
    enum NotaMusical {DO, RE, MI, FA, SOL, LA, SI};
    NotaMusical[] melodia;

    public void add(NotaMusical n){
        melodia = Arrays.copyOf(melodia, melodia.length + 1);
        melodia[melodia.length - 1] = n;
    }

    public abstract void interpretar();
    
    public Instrumento() {
        melodia = new NotaMusical[0];
    }

    public Instrumento(String[] melodia) {
        this();
        for(String str: melodia)
            add(NotaMusical.valueOf(str));
    }

    
    @Override
    /**
     * Compara si dos instrumentos son del mismo tipo y tienen la misma melodia
     */
    public boolean equals(Object obj) {
        Instrumento instrumento = (Instrumento) obj;
        return this.getClass().equals(obj.getClass()) && Arrays.equals(melodia, instrumento.melodia);                
    }

    

    
}
