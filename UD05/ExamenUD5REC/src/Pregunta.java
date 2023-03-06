import java.util.Arrays;

public class Pregunta {
   
    String enunciado;
    String[] respuestas = new String[4];
    int indiceCorrecta;
    String respuestaCorrecta;
    int correctas = 0;

    public Pregunta(String enunciado, String[] respuestas, int indiceCorrecta) {
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.indiceCorrecta = indiceCorrecta;


        for(int i = 0; i < respuestas.length; i++){
            if(i == indiceCorrecta){
                respuestas[i] = respuestaCorrecta;
            }

        }
    }

    
    public Pregunta() {
    }


    public String getEnunciado() {
        return enunciado;
    }


    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }


    public String[] getRespuesta() {
        return respuestas;
    }


    public void setRespuesta(String[] respuestas) {
        this.respuestas = respuestas;
    }


    public int getCorrecta() {
        return indiceCorrecta;
    }


    public void setCorrecta(int indiceCorrecta) {
        this.indiceCorrecta = indiceCorrecta;
    }


    



        
   


    @Override
    public String toString() {
        return "1." + enunciado + ":\n" + "a) " + Arrays.toString(respuestas) + ".\n"
        + "b) " + Arrays.toString(respuestas) + ".\n" 
        + "c) " + Arrays.toString(respuestas) + ".\n"
        + "d) " + Arrays.toString(respuestas) + ".\n";
    }


    public boolean corregir(int opcionElegida){
        boolean correcta = false;
        if(opcionElegida == indiceCorrecta){
            correcta = true;
        }

        return correcta;


    }


    @Override
    public boolean equals(Object obj) {
        Pregunta aux = (Pregunta)obj;
        return enunciado.equals(aux.enunciado) &&
            respuestas.equals(aux.respuestas);
    }


    public int corregir(int[] respuestas) {
        return correctas;
    }


    
}
