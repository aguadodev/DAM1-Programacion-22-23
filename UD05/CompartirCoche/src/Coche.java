public class Coche {
    protected String marca;
    protected String color;
    protected byte plazas;
    protected String matricula;
    enum Combustible {DIESEL, GASOLINA, ELÉCTRICO, HIBRIDO}
    Combustible combustible;
    enum DistintivoAmbiental {CERO, ECO, C, B}
    DistintivoAmbiental distintivoAmbiental;

    public Coche(String marca, String color, int plazas, String matricula) {
        this(marca, color, plazas, matricula, null, null);
    }

    public Coche(String marca, String color, int plazas, String matricula, String combustible,
            String distintivoAmbiental) {
        this.marca = marca;
        this.color = color;
        this.plazas = (byte)plazas;
        this.matricula = matricula;
        if (combustible != null) this.combustible = Combustible.valueOf(combustible);
        if (distintivoAmbiental != null) this.distintivoAmbiental = DistintivoAmbiental.valueOf(distintivoAmbiental);
    }


    @Override
    public String toString() {
        return marca + " " + color + ", " + plazas + " plazas, matrícula " + matricula;
    }    

    
}
