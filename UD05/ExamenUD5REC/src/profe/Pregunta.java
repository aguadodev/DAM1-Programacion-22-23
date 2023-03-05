package profe;

import java.util.Arrays;

public class Pregunta {
    String enunciado;
    String[] respuestas;
    int opcionCorrecta;

    
    public Pregunta(String enunciado, String[] respuestas, int opcionCorrecta) {
        if (respuestas.length < 2)
            throw new IllegalArgumentException("Respuestas insuficientes");
        if (opcionCorrecta < 0 || opcionCorrecta >= respuestas.length)
            throw new IllegalArgumentException("Opción correcta fuera de límites");

        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.opcionCorrecta = opcionCorrecta;
    }

    boolean corregir(int opcionElegida){
        return opcionElegida == opcionCorrecta;
    }

    @Override
    public String toString() {
        String str = enunciado + "\n";
        char letra = 'a';
        for (String respuesta: respuestas){
            str += "\t" + letra + ") " + respuesta + "\n";
            letra++;
        }
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        Pregunta o = (Pregunta) obj;

        return enunciado.equals(o.enunciado) && Arrays.equals(respuestas, o.respuestas);
    }

    
}
