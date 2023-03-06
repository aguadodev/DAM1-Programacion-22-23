import java.util.Arrays;
import java.util.Scanner;

public class ExamenEvaluable extends Examen {
    String[] respuestasUsuario = { "a", "b", "c", "d" };

    public int[] responderConsola() {
        Scanner sc = new Scanner(System.in);
        int[] opcionUsuario = new int[respuestasUsuario.length];
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println(preguntas[i]);
            for (int j = 0; j < respuestasUsuario.length; j++) {
                opcionUsuario[j] = sc.nextInt();
                if (opcionUsuario[j] == indiceCorrecta) {
                    for (int k = 0; k < respuestasUsuario.length; k++) {
                        opcionUsuario[j] = Integer.parseInt(respuestasUsuario[k]);
                    }

                } else
                    System.out.println("Respuesta incorrecta. Intentalo de nuevo: ");
                opcionUsuario[j] = sc.nextInt();
            }
        }
        return opcionUsuario;
    }

    @Override
    public int corregir(int[] respuestas) {
        int Numcorrectas = 0;

        for (int i = 0; i < respuestas.length; i++) {
            if (responderConsola()[i] == respuestas[i]) {
                Numcorrectas++;
            }
        }
        return Numcorrectas;
    }

    public ExamenEvaluable(String string) {
        super(string);
    }

    public Object puntuacionSobre10(int respuestasCorrectas) {
        return null;
    }

    @Override
    public String toString() {
        return "ExamenEvaluable [respuestasUsuario=" + Arrays.toString(respuestasUsuario) + "]";
    }




    
}
