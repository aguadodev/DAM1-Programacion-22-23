
package entidad;


public class Troll extends Monstruo {

    public Troll(String nombre) {
        super(nombre, 
                randomRango(60,120), 
                randomRango(50,70), 
                randomRango(20,40), 
                randomRango(100,200)
        );
    }

    public Troll() {
        this(null);
    }
    
}
