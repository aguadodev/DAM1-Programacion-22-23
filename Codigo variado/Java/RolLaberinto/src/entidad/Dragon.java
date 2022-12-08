
package entidad;


public class Dragon extends Monstruo {

    public Dragon(String nombre) {
        super(nombre, 
                randomRango(100,200), 
                randomRango(60,100), 
                randomRango(80,120), 
                randomRango(120,250)
        );
    }

    public Dragon() {
        this(null);
    }
    
}
