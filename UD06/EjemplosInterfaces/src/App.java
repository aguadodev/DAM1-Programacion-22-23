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
        perro.moverRabo();
        gato.voz();
        gato.vozDurmiendo();
        gato.aranhar();

        leon.voz();
        leon.vozDurmiendo();
        Sonido.bostezo();        
        
        System.out.println(Sonido.version);
        System.out.println(Perro.version);

        System.out.println("Variables de tipo Interfaz");
        Sonido son;
        son = new Gato();

        son.voz();

        son = leon;
        son.voz();
        son = perro;
        son.voz();
    
        // CLASES ANÓNIMAS
        Sonido animalDesconocido = new Sonido() {

            @Override
            public void voz() {
                System.out.println("Jajejijojuuu");
            }

        };

        animalDesconocido.voz();
        animalDesconocido.vozDurmiendo();




    }
}
