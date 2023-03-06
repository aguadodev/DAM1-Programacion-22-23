import java.util.Arrays;

public class Examen extends Pregunta{
    String titulo;
    Pregunta[] preguntas = new Pregunta[4];
    String[] respuestasUsuario = {"a", "b", "c", "d"};


    public Examen(String string) {
    }

    public boolean addPregunta(Pregunta pregunta1) {
        boolean anhadida = false;
        for(int i = 0 ; i < preguntas.length; i++){
            if(preguntas[i] != pregunta1){
                preguntas = Arrays.copyOf(preguntas, preguntas.length + 1);
                preguntas[preguntas.length - 1] = pregunta1;
                anhadida = true;

            }
        }

        return anhadida;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta[] preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "Examen TEST = " + titulo + "\n" +  Arrays.toString(preguntas);
    }


    public int numPreguntas(){

        return preguntas.length;
    }


   


    
}
