public class Bombilla {
    private boolean interruptor;

    static boolean interruptorGeneral;

    public boolean estaEncendida() {
        return interruptor && interruptorGeneral;
    }

    public void setInterruptor(boolean interruptor) {
        this.interruptor = interruptor;
    }
    
    public void apagar() {
        this.interruptor = false;
    }

    public void encender() {
        this.interruptor = true;
    }

    public static void setInterruptorGeneral(boolean interruptorGeneral) {
        Bombilla.interruptorGeneral = interruptorGeneral;
    }

    public static void apagarInterruptorGeneral() {
        Bombilla.interruptorGeneral = false;
    }

    public static void encenderInterruptorGeneral() {
        Bombilla.interruptorGeneral = true;
    }

    
    
}
