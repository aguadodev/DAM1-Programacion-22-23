public class Coche {
    protected String marca;
    protected String color;
    protected byte plazas;
    protected String matricula;

    enum Combustible {
        DIESEL, GASOLINA, ELÉCTRICO, HIBRIDO
    }

    Combustible combustible;

    enum DistintivoAmbiental {
        CERO, ECO, C, B
    }

    DistintivoAmbiental distintivoAmbiental;

    public Coche(String marca, String color, int plazas, String matricula) {
        this(marca, color, plazas, matricula, null, null);
    }

    public Coche(String marca, String color, int plazas, String matricula, String combustible,
            String distintivoAmbiental) {
        this.marca = marca;
        this.color = color;
        this.plazas = (byte) plazas;
        this.matricula = Coche.validarMatricula(matricula) ? matricula : null;
        if (combustible != null)
            this.combustible = Combustible.valueOf(combustible);
        if (distintivoAmbiental != null)
            this.distintivoAmbiental = DistintivoAmbiental.valueOf(distintivoAmbiental);
    }

    @Override
    public String toString() {
        String str = "";

        str += marca + " " + color + ", " + plazas + " plazas";
        if (matricula != null)
            str += ", matrícula " + matricula;
        if (combustible != null)
            str += ", " + combustible;
        if (distintivoAmbiental == null)
            str += ", sin distintivo ambiental";
        else
            str += ", distintivo ambiental " + distintivoAmbiental;

        return str;

    }

    public static boolean validarMatricula(String matricula) {
        // Valida matrículas "modernas" de 3 letras y 4 numeros;
        return matricula.toUpperCase().matches("[BCDFGHJKLMNPQRSTVWXYZ]{3}[0-9]{4}");
    }

}
