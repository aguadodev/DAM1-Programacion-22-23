public class App1Examen {
        public static void main(String[] args) throws Exception {
                System.out.println("\nEXÁMENES TIPO TEST");
                System.out.println("==================\n");

                Examen examen = new Examen("POO básica en Java: Clases y Objetos");

                cargarPreguntas(examen);

                System.out.println(examen);

        }

        public static void cargarPreguntas(Examen examen) {
                String[] respuestas1 = {
                                "Sean visibles.",
                                "Ambas dispongan del mismo número de constructores.",
                                "Pertenezcan al mismo paquete.",
                                "Todo lo anterior ha de cumplirse para que dos clases sean vecinas."
                };
                Pregunta pregunta1 = new Pregunta(
                                "Dos clases se consideran vecinas siempre y cuando:",
                                respuestas1,
                                2);

                String[] respuestas2 = {
                                "El proceso en el que un atributo pasa de ser público a privado.",
                                "El proceso en el que se define una variable local (en un método) con el mismo identificador que un atributo.",
                                "El proceso en el que un atributo estático deja de serlo.",
                                "Todas las respuestas anteriores son correctas."
                };
                Pregunta pregunta2 = new Pregunta(
                                "La ocultación de atributos puede definirse como:",
                                respuestas2,
                                1);

                String[] respuestas3 = {
                                "Todas las clases vecinas.",
                                "Todas las clases externas.",
                                "Es indistinto el paquete, pero será visible siempre que se importe la clase que lo contiene.",
                                "Ninguna de las respuestas anteriores."
                };
                Pregunta pregunta3 = new Pregunta(
                                "Un miembro cuyo modificador de acceso es private será visible desde:",
                                respuestas3,
                                3);

                String[] respuestas4 = {
                                "set().",
                                "get().",
                                "this().",
                                "this."
                };
                Pregunta pregunta4 = new Pregunta(
                                "Si desde un constructor queremos invocar a otro constructor de la misma clase, tendremos que usar:",
                                respuestas4,
                                2);

                examen.addPregunta(pregunta1);
                examen.addPregunta(pregunta2);
                examen.addPregunta(pregunta3);
                examen.addPregunta(pregunta4);

        }
}
