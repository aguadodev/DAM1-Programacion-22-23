import org.junit.Assert;
import org.junit.Test;

public class AparcamientoTest {
    @Test
    public void testAparcarVehiculo() {
        Aparcamiento aparcamiento = new Aparcamiento(2);
        Vehiculo vehiculo1 = new Vehiculo("1234AAA");
        Vehiculo vehiculo2 = new Vehiculo("5678BBB");

        boolean aparcado1 = aparcamiento.aparcarVehiculo(vehiculo1);
        Assert.assertTrue(aparcado1);
        Assert.assertEquals(1, aparcamiento.numPlazasLibres());

        boolean aparcado2 = aparcamiento.aparcarVehiculo(vehiculo2);
        Assert.assertTrue(aparcado2);
        Assert.assertEquals(0, aparcamiento.numPlazasLibres());

        boolean aparcado3 = aparcamiento.aparcarVehiculo(new Vehiculo("9999ZZZ"));
        Assert.assertFalse(aparcado3);
        Assert.assertEquals(0, aparcamiento.numPlazasLibres());
    }

    @Test
    public void testSacarVehiculo() {
        Aparcamiento aparcamiento = new Aparcamiento(2);
        Vehiculo vehiculo1 = new Vehiculo("1234AAA");
        Vehiculo vehiculo2 = new Vehiculo("5678BBB");

        aparcamiento.aparcarVehiculo(vehiculo1);
        aparcamiento.aparcarVehiculo(vehiculo2);

        boolean sacado1 = aparcamiento.sacarVehiculo(vehiculo1);
        Assert.assertTrue(sacado1);
        Assert.assertEquals(1, aparcamiento.numPlazasLibres());

        boolean sacado2 = aparcamiento.sacarVehiculo(vehiculo2);
        Assert.assertTrue(sacado2);
        Assert.assertEquals(2, aparcamiento.numPlazasLibres());

        boolean sacado3 = aparcamiento.sacarVehiculo(new Vehiculo("9999ZZZ"));
        Assert.assertFalse(sacado3);
        Assert.assertEquals(2, aparcamiento.numPlazasLibres());
    }

    @Test
    public void testNumPlazasLibres() {
        Aparcamiento aparcamiento = new Aparcamiento(3);
        Vehiculo vehiculo1 = new Vehiculo("1234AAA");
        Vehiculo vehiculo2 = new Vehiculo("5678BBB");

        int plazasLibres1 = aparcamiento.numPlazasLibres();
        Assert.assertEquals(3, plazasLibres1);

        aparcamiento.aparcarVehiculo(vehiculo1);

        int plazasLibres2 = aparcamiento.numPlazasLibres();
        Assert.assertEquals(2, plazasLibres2);

        aparcamiento.aparcarVehiculo(vehiculo2);

        int plazasLibres3 = aparcamiento.numPlazasLibres();
        Assert.assertEquals(1, plazasLibres3);
    }
}
