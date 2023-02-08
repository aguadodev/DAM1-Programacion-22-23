public class Coche {
    protected String marca;
    protected String color;
    protected byte plazas;
    protected String matricula;
    public Coche(String marca, String color, int plazas, String matricula) {
        this.marca = marca;
        this.color = color;
        this.plazas = (byte)plazas;
        this.matricula = matricula;
    }
    @Override
    public String toString() {
        return marca + " " + color + ", " + plazas + " plazas, matrícula " + matricula;
    }    

    
}
