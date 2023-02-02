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
    public boolean equals(Object obj) {
        boolean iguales = false;
        
        Instrumento instrumento = (Instrumento) obj;
        
        if (this.getClass() == obj.getClass())
            if (Arrays.equals(melodia, instrumento.melodia))
                iguales = true;

        return iguales;                
    }

    

    
}
