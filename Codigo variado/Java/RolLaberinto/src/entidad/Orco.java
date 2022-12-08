
package entidad;


public class Orco extends Monstruo {

    public Orco(String nombre) {
        super(nombre, 
                randomRango(30,80), 
                randomRango(30,50), 
                randomRango(30,60), 
                randomRango(30,100)
        );
    }

    public Orco() {
        this(null);
    }
    
}
