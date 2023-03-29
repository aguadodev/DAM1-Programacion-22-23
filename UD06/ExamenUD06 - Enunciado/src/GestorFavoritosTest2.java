import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GestorFavoritosTest2 {
    private GestorFavoritos gestorFavoritos;
    private Persona persona1;
    private Persona persona2;
    private Piso piso1;
    private Piso piso2;
    private Casa casa1;
    private Casa casa2;
    private Piso piso3;

    @Before
    public void setUp() {
        gestorFavoritos = new GestorFavoritos();
        persona1 = new Persona("Juan", "12345678A");
        persona2 = new Persona("Ana", "87654321B");
        piso1 = new Piso("Calle Mayor 10, 5º", 50, 2, 1, 500, 100000, 1);
        piso2 = new Piso("Calle Mayor 11, 3A", 75, 3, 2, 0, 150000, 2);
        casa1 = new Casa("Calle Ancha 20", 100, 3, 2, 1000, 200000, 500);
        casa2 = new Casa("Calle Ancha 21", 150, 4, 3, 0, 300000, 1000);
        piso3 = new Piso("Calle Nueva 1, 2A", 1, 1, 30, 300, 50000, 1);
    }

    @Test
    public void testMarcarFavorito() {
        assertTrue(gestorFavoritos.marcarFavorito(persona1, piso1));
        assertTrue(gestorFavoritos.marcarFavorito(persona1, casa1));
        assertTrue(gestorFavoritos.marcarFavorito(persona2, piso2));
        assertFalse(gestorFavoritos.marcarFavorito(persona1, piso1)); // Ya está en la lista de favoritos de persona1

        Collection<Inmueble> favoritosPersona1 = gestorFavoritos.getFavoritos(persona1);
        Collection<Inmueble> favoritosPersona2 = gestorFavoritos.getFavoritos(persona2);

        assertEquals(2, favoritosPersona1.size());
        assertTrue(favoritosPersona1.contains(piso1));
        assertTrue(favoritosPersona1.contains(casa1));

        assertEquals(1, favoritosPersona2.size());
        assertTrue(favoritosPersona2.contains(piso2));
    }

    @Test
    public void testDesmarcarFavorito() {
        gestorFavoritos.marcarFavorito(persona1, piso1);
        gestorFavoritos.marcarFavorito(persona1, casa1);
        gestorFavoritos.marcarFavorito(persona2, piso2);

        assertTrue(gestorFavoritos.desmarcarFavorito(persona1, piso1));
        assertFalse(gestorFavoritos.desmarcarFavorito(persona1, piso1)); // Ya se eliminó de la lista de favoritos de persona1
        assertFalse(gestorFavoritos.desmarcarFavorito(persona2, casa2)); // No está en la lista de favoritos de persona2

        Collection<Inmueble> favoritosPersona1 = gestorFavoritos.getFavoritos(persona1);
        Collection<Inmueble> favoritosPersona2 = gestorFavoritos.getFavoritos(persona2);

        assertEquals(1, favoritosPersona1.size());
        assertTrue(favoritosPersona1.contains(casa1));

        assertEquals(1, favoritosPersona2.size());
        assertTrue(favoritosPersona2.contains(piso2));
    }

    @Test
    public void testGetFavoritosEnComun() {
        gestorFavoritos.marcarFavorito(persona1, piso1);
        gestorFavoritos.marcarFavorito(persona1, casa1);
        gestorFavoritos.marcarFavorito(persona1, piso3);
    
        gestorFavoritos.marcarFavorito(persona2, piso2);
        gestorFavoritos.marcarFavorito(persona2, casa1);
        gestorFavoritos.marcarFavorito(persona2, casa2);
    
        Collection<Inmueble> favoritosEnComun = gestorFavoritos.getFavoritosEnComun(persona1, persona2);
    
        assertEquals(1, favoritosEnComun.size());
        assertTrue(favoritosEnComun.contains(casa1));
    }

}