package animales;

public class Gato implements Sonido{

    boolean unhas = true;;

    @Override
    public void voz() {
        System.out.println("Miau!");        
    }

    public void quitarUnhas(){
        unhas = false;
    }

    public void aranhar(){
        if (unhas)
            System.out.println("El gato araña");
        else
            System.out.println("El gato no tiene unñas, no puede arañar");
    }
    
}
