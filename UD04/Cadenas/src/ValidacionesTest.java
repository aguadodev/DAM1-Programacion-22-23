import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidacionesTest {
    @Test
    public void testEsMatriculaValida() {
        assertEquals(Validaciones.esMatriculaValida("123"), false);
        assertEquals(Validaciones.esMatriculaValida("1234BBBB"), false);
        assertEquals(Validaciones.esMatriculaValida("12A4BBB"), false);
        assertEquals(Validaciones.esMatriculaValida("12.4BBB"), false);
        assertEquals(Validaciones.esMatriculaValida("1234BAB"), false);
        assertEquals(Validaciones.esMatriculaValida("1234BB."), false);
        assertEquals(Validaciones.esMatriculaValida("1234B5B"), false);
        assertEquals(Validaciones.esMatriculaValida("1234BúB"), false);
        assertEquals(Validaciones.esMatriculaValida("1234BÚB"), false);
        assertEquals(Validaciones.esMatriculaValida("1234BñB"), false);
        
        assertEquals(Validaciones.esMatriculaValida("1234BbB"), true);
        assertEquals(Validaciones.esMatriculaValida("1234BBB"), true);
        assertEquals(Validaciones.esMatriculaValida("9999BBZ"), true);
        assertEquals(Validaciones.esMatriculaValida("9999BBD"), true);
        assertEquals(Validaciones.esMatriculaValida("9999ZZZ"), true);
    }

    @Test
    public void testEsValidoDNI() {

    }
}
