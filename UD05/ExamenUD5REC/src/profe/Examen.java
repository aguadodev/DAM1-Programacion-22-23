package profe;
import java.util.Arrays;

public class Examen {
    String titulo;
    Pregunta [] preguntas;

    public Examen(String titulo) {
        this.titulo = titulo;
        preguntas = new Pregunta[0];
    }

    public void addPregunta(Pregunta pregunta) {
        boolean repetida = false;
        int i = 0;
        while(!repetida && i < preguntas.length){
            if(preguntas[i].equals(pregunta))
                repetida = true;
            i++;
        }
        
        if (!repetida) {
            preguntas = Arrays.copyOf(preguntas, preguntas.length + 1);
        preguntas[preguntas.length - 1] = pregunta;
        }
    }

    @Override
    public String toString() {
        String str = "EXAMEN TEST - " + titulo + "\n\n";
        for(int i = 0; i < preguntas.length; i++){
            str += (i + 1) + ". ";
            str += preguntas[i] + "\n";
        } 
        return str;
    }

    public int numPreguntas() {
        return preguntas == null? 0 : preguntas.length;
    }



    
}
