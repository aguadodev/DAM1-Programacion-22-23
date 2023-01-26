public class SintonizadorFM {

    private double frecuencia;

    final static double MAX_FRECUENCIA = 108;
    final static double MIN_FRECUENCIA = 80;

    public SintonizadorFM(double frecuencia) {
        // Controlo que la frecuencia indicada no sobrepase los límites
        if (frecuencia > MAX_FRECUENCIA)
            this.frecuencia = MAX_FRECUENCIA;
        else if (frecuencia < MIN_FRECUENCIA)
            this.frecuencia = MIN_FRECUENCIA;
        else
            this.frecuencia = frecuencia;
    }    

    public SintonizadorFM() {
    }

    public void up(){
        frecuencia += 0.5;
        if (frecuencia > MAX_FRECUENCIA)
            frecuencia = MIN_FRECUENCIA;            
    }

    public void down(){
        frecuencia -= 0.5;
        if (frecuencia < MIN_FRECUENCIA)
            frecuencia = MAX_FRECUENCIA;            
    }

    public void display(){
        System.out.println("Frecuencia: " + frecuencia + " MHz");
    }
    
    public double getFrecuencia() {
        return frecuencia;
    }

    public static void main(String[] args) {
        SintonizadorFM radio1 = new SintonizadorFM(88.5);
        SintonizadorFM radio2 = new SintonizadorFM();
    }
    
}
