import java.util.Arrays;
import java.util.Comparator;

import examen20230223.PersonajeEx;

public class PersonajeV2 extends PersonajeEx implements Comparable {

    public PersonajeV2(String nombre, String raza) {
        super(nombre, raza);
    }

    

    public PersonajeV2(String nombre, String raza, int puntosVida) {
        super(nombre, raza);
        this.puntosVida = puntosVida;
    }



    @Override
    public int compareTo(Object o) {
        return ((PersonajeV2) o).agilidad - agilidad;
    }

    @Override
    public String toString() {
        return nombre + " [" + agilidad + "](" + puntosVida + "/" + (constitucion + 50) + ")";
    }



    public void atacarMasDebil(PersonajeV2[] grupo) {
        Comparator compPuntosDeVida = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((PersonajeV2)o1).puntosVida - ((PersonajeV2)o2).puntosVida;
            }
        };

        Arrays.sort(grupo, compPuntosDeVida);

        int i = 0;
        while (i < grupo.length && !grupo[i].estaVivo())
            i++;
        
        if (i < grupo.length){
            int puntos = this.atacar(grupo[i]);
            if (puntos > 0){
                System.out.println(nombre + " atacó a " + grupo[i].nombre + " y le hizo " + puntos + " de daño.");
                if (!grupo[i].estaVivo())
                    System.out.println(grupo[i].nombre + " ha muerto +++");
            }
                

        }
        
    }
    
    

}
