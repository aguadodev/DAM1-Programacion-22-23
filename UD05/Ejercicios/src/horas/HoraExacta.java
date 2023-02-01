package horas;

public class HoraExacta extends Hora {
    int segundo;

    public HoraExacta(int hora, int minuto, int segundo) {
        super(hora, minuto);
        this.segundo = segundo >= 0 && segundo < 60 ? segundo : 0;
    }

    public boolean setSegundo(int segundo) {        
        boolean segValido = segundo >= 0 && segundo < 60;

        if (segValido)
            this.segundo = segundo;
        
        return segValido;         
    }

    @Override
    public void inc() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            super.inc();
        }        
    }

    @Override
    public String toString() {
        String str = super.toString() + ":";

        if (segundo < 10)
            str += "0";

        str += segundo;
        
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        HoraExacta h = (HoraExacta) obj;

        return hora == h.hora && minuto == h.minuto && segundo == h.segundo;
    }

    

    

    
    
}
