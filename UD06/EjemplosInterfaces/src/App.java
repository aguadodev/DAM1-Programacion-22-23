import animales.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Interfaces");
        System.out.println();

        Perro perro = new Perro();
        Gato gato = new Gato();
        Leon leon = new Leon();
        Caracol caracol = new Caracol();    

        perro.voz();
        perro.vozDurmiendo();
        gato.voz();
        gato.vozDurmiendo();
        leon.voz();
        leon.vozDurmiendo();
        Sonido.bostezo();
        
        
        System.out.println(Sonido.version);
        System.out.println(Perro.version);





    }
}
