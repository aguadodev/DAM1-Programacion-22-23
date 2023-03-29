public class App {

    public static void main(String[] args) {
        // 1.1. Modelo de Clases
        // Crea un piso en una 5a planta, de 100m2, 3 habitaciones y 2 baños en la
        // dirección “Calle Curtidoira”. Establece los precios de alquiler y de Venta.
        Piso piso1 = new Piso("Calle Mayor 10", 50, 2, 1, 500, 100000, 1);
        Piso piso2 = new Piso("Calle Mayor 11", 75, 3, 2, 750, 150000, 2);
        Casa casa1 = new Casa("Calle Ancha 20", 100, 3, 2, 1000, 200000, 500);
        Casa casa2 = new Casa("Calle Ancha 21", 150, 4, 3, 1500, 300000, 1000);


        // Imprimir Inmueble: Piso, Casa
        System.out.println(piso1);
        System.out.println(casa1);
        System.out.println("");

        // Mostrar Detalle Inmueble: Piso, Casa
        System.out.println(piso1.detalle());
        System.out.println("");
        System.out.println(piso2.detalle());
        System.out.println("");
        System.out.println(casa2.detalle());

    }
}
