package profe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PreguntaTest {
    Pregunta pregunta1, pregunta1b, pregunta2;

    @Before
    public void inicializar() {
        String[] respuestas1 = {
            "Sean visibles.",
            "Ambas dispongan del mismo número de constructores.",
            "Pertenezcan al mismo paquete.",
            "Todo lo anterior ha de cumplirse para que dos clases sean vecinas."
    };
    pregunta1 = new Pregunta(
            "Dos clases se consideran vecinas siempre y cuando:",
            respuestas1,
            2);

    String[] respuestas1b = {
            "Sean visibles.",
            "Ambas dispongan del mismo número de constructores.",
            "Pertenezcan al mismo paquete.",
            "Todo lo anterior ha de cumplirse para que dos clases sean vecinas."
    };
    pregunta1b = new Pregunta(
            "Dos clases se consideran vecinas siempre y cuando:",
            respuestas1b,
            3);

    String[] respuestas2 = {
            "El proceso en el que un atributo pasa de ser público a privado.",
            "El proceso en el que se define una variable local (en un método) con el mismo identificador que un atributo.",
            "El proceso en el que un atributo estático deja de serlo.",
            "Todas las respuestas anteriores son correctas."
    };
    pregunta2 = new Pregunta(
            "La ocultación de atributos puede definirse como:",
            respuestas2,
            1);
        
    }

    @Test
    public void testCorregir() {
        assertTrue(pregunta1.corregir(2));
        assertFalse(pregunta1.corregir(1));
    }

    @Test
    public void testEquals() {
        assertTrue(pregunta1.equals(pregunta1b));
        assertFalse(pregunta1.equals(pregunta2));
    }
}
