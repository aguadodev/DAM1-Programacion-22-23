import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ViajesCompartidosTest {

    private ViajesCompartidos viajesCompartidos;
    Viaje viaje1, viaje2, viaje3, viaje4, viaje5, viaje6, viaje7;
    Conductor conductor1, conductor2, conductor3, conductor4;

    PuntoEncuentro puntoSalida1, puntoSalida2, puntoSalida3, puntoSalida4, puntoLlegada1, puntoLlegada2, puntoLlegada3,
            puntoLlegada4;

            Pasajero pasajero1, pasajero2 , pasajero3, pasajero4, pasajero5, pasajero6, pasajero7, pasajero20;

    @Before
    public void setUp() {
        viajesCompartidos = new ViajesCompartidos();

        conductor1 = new Conductor("Juan");
        conductor2 = new Conductor("María");
        conductor3 = new Conductor("David");
        conductor4 = new Conductor("Laura");

        pasajero1 = new Pasajero("Juan");
        pasajero2 = new Pasajero("Alba");
        pasajero3 = new Pasajero("Pedro");
        pasajero4 = new Pasajero("Cris");
        pasajero5 = new Pasajero("Marcos");
        pasajero6 = new Pasajero("Laura");
        pasajero7 = new Pasajero("Angel");
        pasajero20 = new Pasajero("Jesús");

        puntoSalida1 = new PuntoEncuentro("Plaza Mayor", 40.4168, -3.7038);
        puntoSalida2 = new PuntoEncuentro("Puerta del Sol", 40.4167, -3.7033);
        puntoSalida3 = new PuntoEncuentro("Calle Gran Vía", 40.4204, -3.7065);
        puntoSalida4 = new PuntoEncuentro("Estación de Atocha", 40.4069, -3.6908);

        puntoLlegada1 = new PuntoEncuentro("Plaza España", 40.4239, -3.7121);
        puntoLlegada2 = new PuntoEncuentro("Parque del Retiro", 40.4150, -3.6861);
        puntoLlegada3 = new PuntoEncuentro("Calle Alcalá", 40.4203, -3.7058);
        puntoLlegada4 = new PuntoEncuentro("Aeropuerto", 40.4893, -3.5673);

        viaje1 = new Viaje(conductor1, LocalDateTime.of(2022, 5, 1, 10, 0), puntoSalida1, puntoLlegada1, 3);
        viaje2 = new Viaje(conductor2, LocalDateTime.of(2022, 5, 2, 11, 30), puntoSalida2, puntoLlegada2, 2);
        viaje3 = new Viaje(conductor3, LocalDateTime.of(2023, 4, 26, 19, 0), puntoSalida3, puntoLlegada3, 4);
        viaje4 = new Viaje(conductor4, LocalDateTime.of(2022, 5, 4, 13, 0), puntoSalida4, puntoLlegada4, 1);
        viaje5 = new Viaje(conductor1, LocalDateTime.of(2023, 4, 26, 14, 0), puntoSalida3, puntoLlegada2, 3);
        viaje6 = new Viaje(conductor1, LocalDateTime.of(2023, 5, 26, 14, 0), puntoSalida3, puntoLlegada4, 3);
        viaje7 = new Viaje(conductor3, LocalDateTime.of(2023, 4, 26, 9, 0), puntoSalida1, puntoLlegada3, 4);

    }

    @Test
    public void testAgregarViaje() {
        // Verificar que el viaje se agregó correctamente
        assertTrue(viajesCompartidos.agregarViaje(viaje1)); // Agrega un viaje
        assertFalse(viajesCompartidos.agregarViaje(viaje1)); // Intenta volver a agregarlo
        assertEquals(1, viajesCompartidos.getViajes().size()); // Comprueba el número de viajes
        assertEquals(viaje1, viajesCompartidos.getViajes().get(0));
        assertTrue(viajesCompartidos.agregarViaje(viaje2));
        assertTrue(viajesCompartidos.getViajes().contains(viaje2));
        assertEquals(2, viajesCompartidos.getViajes().size());

    }

    @Test
    public void testEliminarViaje() {
        assertTrue(viajesCompartidos.agregarViaje(viaje1));

        // Verificar que el viaje se eliminó correctamente
        assertTrue(viajesCompartidos.eliminarViaje(viaje1));
    }

    @Test
    public void testObtenerPasajeros() {
        // Fabriccio -
        viajesCompartidos.agregarViaje(viaje1);
        viaje1.addPasajero(pasajero1);
        viaje1.addPasajero(pasajero2);
        viaje1.addPasajero(pasajero3);
        viajesCompartidos.agregarViaje(viaje2);

        viaje2.addPasajero(pasajero4);
        viaje2.addPasajero(pasajero5); // En este viaje solo caben 2 pasajeros
        viaje2.addPasajero(pasajero6);
        viaje2.addPasajero(pasajero7);
        viaje2.addPasajero(pasajero20);

        assertEquals(3, viajesCompartidos.obtenerPasajeros(viaje1).size());
        assertEquals(2, viajesCompartidos.obtenerPasajeros(viaje2).size());
        assertTrue(viajesCompartidos.obtenerPasajeros(viaje1).contains(pasajero1));
        assertTrue(viajesCompartidos.obtenerPasajeros(viaje2).contains(pasajero4));

    }

    @Test
    public void testCalcularAsientosDisponibles() {
        // Xabi
        viajesCompartidos.agregarViaje(viaje1);
        viajesCompartidos.agregarViaje(viaje2);
        viajesCompartidos.agregarViaje(viaje3);
        viajesCompartidos.agregarViaje(viaje4);
        viajesCompartidos.agregarViaje(viaje5);

        Pasajero pasajero1 = new Pasajero("Juan");
        Pasajero pasajero2 = new Pasajero("Alba");
        Pasajero pasajero3 = new Pasajero("Pedro");

        // Añade pasajeros al viaje.
        // Nota: pasajero4 no se añadirá al haberse ocupado las plazas disponibles.
        viaje1.addPasajero(pasajero1);
        viaje1.addPasajero(pasajero2);
        viaje1.addPasajero(pasajero3);

        assertEquals(viajesCompartidos.calcularAsientosDisponibles(), 10);
    }

    @Test
    public void testGetViajesPorOrigenYFecha() {
        viajesCompartidos.agregarViaje(viaje1);
        viajesCompartidos.agregarViaje(viaje2);
        viajesCompartidos.agregarViaje(viaje3);
        viajesCompartidos.agregarViaje(viaje4);
        viajesCompartidos.agregarViaje(viaje5);

        // Filtra viajes que salen de punto de salida 3 el 26/4/2023
        List<Viaje> viajesFiltrados = viajesCompartidos.getViajesPorOrigenYFecha(puntoSalida3,
                LocalDate.of(2023, 4, 26));

        // Son dos viajes
        assertEquals(2, viajesFiltrados.size());

        // Ordenados ascendentemente por fecha (hora) son el viaje5 y el viaje3
        assertEquals(viaje5, viajesFiltrados.get(0));
        assertEquals(viaje3, viajesFiltrados.get(1));

    }

    @Test
    public void testObtenerPuntosEncuentro() {
        viajesCompartidos.agregarViaje(viaje1);
        viajesCompartidos.agregarViaje(viaje2);
        viajesCompartidos.agregarViaje(viaje3);
        List<PuntoEncuentro> puntosEncuentro = viajesCompartidos.obtenerPuntosEncuentro();
        assertEquals(6, puntosEncuentro.size()); // Esperamos que haya 6 puntos de encuentro diferentes
        assertTrue(puntosEncuentro.contains(puntoSalida1));
        assertTrue(puntosEncuentro.contains(puntoSalida2));
        assertTrue(puntosEncuentro.contains(puntoSalida3));
        assertFalse(puntosEncuentro.contains(puntoSalida4));

        viajesCompartidos.agregarViaje(viaje4);
        puntosEncuentro = viajesCompartidos.obtenerPuntosEncuentro();

        assertEquals(8, puntosEncuentro.size()); // Esperamos que haya 8 puntos de encuentro diferentes
        assertTrue(puntosEncuentro.contains(puntoSalida4));

        viajesCompartidos.agregarViaje(viaje5);
        puntosEncuentro = viajesCompartidos.obtenerPuntosEncuentro();

        assertEquals(8, puntosEncuentro.size()); // Esperamos que haya 8 puntos de encuentro diferentes
    }

    @Test
    public void testObtenerViajesPorDestino() {
        viajesCompartidos.agregarViaje(viaje1);
        viajesCompartidos.agregarViaje(viaje2);
        viajesCompartidos.agregarViaje(viaje3);
        viajesCompartidos.agregarViaje(viaje4);
        viajesCompartidos.agregarViaje(viaje5);
        viajesCompartidos.agregarViaje(viaje6);

        Map<PuntoEncuentro, List<Viaje>> viajesPorDestino = viajesCompartidos.obtenerViajesPorDestino();

        // Verificar que el tamaño del Map sea correcto
        assertEquals(4, viajesPorDestino.size());

        // Verificar que los viajes sean los esperados para cada destino
        List<Viaje> viajesPlazaEspaña = viajesPorDestino.get(puntoLlegada1);
        assertEquals(1, viajesPlazaEspaña.size());
        assertTrue(viajesPlazaEspaña.contains(viaje1));

        List<Viaje> viajesRetiro = viajesPorDestino.get(puntoLlegada2);
        assertEquals(2, viajesRetiro.size());
        assertTrue(viajesRetiro.contains(viaje2));
        assertTrue(viajesRetiro.contains(viaje5));

        List<Viaje> viajesCalleAlcala = viajesPorDestino.get(puntoLlegada3);
        assertEquals(1, viajesCalleAlcala.size());
        assertTrue(viajesCalleAlcala.contains(viaje3));

        List<Viaje> viajesAeropuerto = viajesPorDestino.get(puntoLlegada4);
        assertEquals(2, viajesAeropuerto.size());
        assertTrue(viajesAeropuerto.contains(viaje4));
    }

    @Test
    public void testCapacidadDisponible() {
        viajesCompartidos.agregarViaje(viaje1);
        viajesCompartidos.agregarViaje(viaje2);
        viajesCompartidos.agregarViaje(viaje3);
        viajesCompartidos.agregarViaje(viaje4);
        viajesCompartidos.agregarViaje(viaje5);        
        viajesCompartidos.agregarViaje(viaje6);
        viajesCompartidos.agregarViaje(viaje7); 

        assertEquals(3, viajesCompartidos.capacidadDisponible(puntoLlegada1, LocalDate.of(2022, 5, 1)));
        assertEquals(2, viajesCompartidos.capacidadDisponible(puntoLlegada2, LocalDate.of(2022, 5, 2)));

        assertEquals(8, viajesCompartidos.capacidadDisponible(puntoLlegada3, LocalDate.of(2023, 4, 26)));
        assertEquals(8, viajesCompartidos.capacidadDisponible(puntoLlegada3, LocalDate.of(2023, 4, 26)));

    }
}
