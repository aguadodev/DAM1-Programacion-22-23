
package entidad;


public class Aranha extends Monstruo {

    public Aranha(String nombre) {
        super(nombre, 
                randomRango(10,50), 
                randomRango(20,40), 
                randomRango(40,70), 
                randomRango(30,80)
        );
    }

    public Aranha() {
        this(null);
    }
    
}
