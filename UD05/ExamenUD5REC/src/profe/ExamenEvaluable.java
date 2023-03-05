package profe;

import java.util.Scanner;

public class ExamenEvaluable extends Examen {

    public ExamenEvaluable(String titulo) {
        super(titulo);
    }

    public int[] responderConsola() {
        int[] respuestas = new int[preguntas.length];

        System.out.println("EXAMEN TEST - " + titulo + "\n");

        for (int i = 0; i < preguntas.length; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(preguntas[i]);

            System.out.print("Respuesta? ");
            respuestas[i] = leerRespuesta(preguntas[i].respuestas.length);

            System.out.println();
        }

        return respuestas;
    }

    /**
     * Método privado auxiliar para leer y validar la respuesta de teclado y
     * convertirla a un índice numérico válido.
     * @param length
     * @return
     */
    private int leerRespuesta(int maximoIndice) {
        boolean respuestaValida = false;
        int respuesta = 0;
        Scanner sc = new Scanner(System.in);

        do {
            String linea = sc.nextLine();
            char letra = linea.charAt(0);
            respuesta = letra - 'a';
            if (respuesta >= 0 && respuesta <= maximoIndice)
                respuestaValida = true;
            else 
                System.out.print("Respuesta inválida. Prueba otra vez: ");
        } while (!respuestaValida);

        return respuesta;
    }

    public int corregir(int[] respuestas) {
        int respuestasCorrectas = 0;

        for (int i = 0; i < preguntas.length; i++)
            if (preguntas[i].corregir(respuestas[i]))
                respuestasCorrectas++;

        return respuestasCorrectas;
    }

    public double puntuacionSobre10(double respuestasCorrectas) {
        return respuestasCorrectas / numPreguntas() * 10;
    }

}
