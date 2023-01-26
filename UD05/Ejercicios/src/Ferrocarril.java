import maquinaria.Locomotora;
import maquinaria.Tren;
import personal.Mecanico;

public class Ferrocarril {
    public static void main(String[] args) {
        Tren tren = new Tren();
        Locomotora locomotora = new Locomotora(
                                 "1231MDC", 
                        500, 
                 2005, 
                                  new Mecanico("Pepe", "67676767"));

        tren.locomotora = locomotora;                                  

        System.out.println(tren);
    }
}
