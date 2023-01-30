public class Estudiante extends Persona{

    double nota1av, nota2av, nota3av;

    public Estudiante(String nombre, double nota1av, double nota2av, double nota3av) {
        super(nombre);
        this.nota1av = nota1av;
        this.nota2av = nota2av;
        this.nota3av = nota3av;
    }    

    public double notaMedia(){
        return (nota1av + nota2av + nota3av) / 3;
    }



    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", nota1av=" + nota1av + ", nota2av=" + nota2av + ", nota3av=" + nota3av + "]";
    }

    
    
    
}
