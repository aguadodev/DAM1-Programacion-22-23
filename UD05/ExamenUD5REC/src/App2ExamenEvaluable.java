public class App2ExamenEvaluable {
    public static void main(String[] args) {
        System.out.println("\nEXÁMENES TIPO TEST CON CORRECCIÓN");
        System.out.println("=================================\n");

        ExamenEvaluable examen = new ExamenEvaluable("POO básica en Java: Clases y Objetos");

        App1Examen.cargarPreguntas(examen);

        int[] respuestas = examen.responderConsola();

        int respuestasCorrectas = examen.corregir(respuestas);

        System.out.println("\nRESULTADOS:");

        System.out.println("* Respuestas correctas: " + respuestasCorrectas + "/" + examen.numPreguntas());
        System.out.printf("* Puntuación Final (sobre 10): %.1f%n%n", examen.puntuacionSobre10(respuestasCorrectas));

    }
}
