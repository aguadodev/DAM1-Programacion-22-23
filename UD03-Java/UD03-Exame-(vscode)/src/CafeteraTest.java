import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CafeteraTest {
    @Test
    public void testAgregarCafe() {
        Cafetera c = new Cafetera();
        c.agregarCafe(500);
        assertEquals(c.getCantidadActual(), 500);
        c.agregarCafe(500);
        assertEquals(c.getCantidadActual(), 1000);
        c.agregarCafe(500);
        assertEquals(c.getCantidadActual(), 1000);
    }

    @Test
    public void testLlenarCafetera() {
        Cafetera c = new Cafetera();
        c.llenarCafetera();
        assertEquals(c.getCantidadActual(), 1000);
    }

    @Test
    public void testServirTaza() {
        Cafetera c = new Cafetera();
        c.setCantidadActual(100);
        c.servirTaza(75);
        assertEquals(c.getCantidadActual(), 25);
        c.servirTaza(1700);
        assertEquals(c.getCantidadActual(), 0);

    }

    @Test
    public void testSetCantidadActual() {
        Cafetera c = new Cafetera();
        c.setCantidadActual(700);
        assertEquals(c.getCantidadActual(), 700);
        c.setCantidadActual(1700);
        assertEquals(c.getCantidadActual(), 1000);
    }

    @Test
    public void testVaciarCafetera() {
        Cafetera c = new Cafetera();
        c.setCantidadActual(700);
        c.vaciarCafetera();
        assertEquals(c.getCantidadActual(), 0);

    }
}
