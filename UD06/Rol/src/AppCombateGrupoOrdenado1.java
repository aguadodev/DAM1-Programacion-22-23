import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import javax.lang.model.util.ElementScanner14;

/**
 * AppCombateGrupoOrdenado1
 */
public class AppCombateGrupoOrdenado1 {

    public static void main(String[] args) {
        
        PersonajeV2[] grupo1 = {
            new PersonajeV2("Alonso", "HUMANO"),
            new PersonajeV2("Sandra", "ELFO"),
            new PersonajeV2("Lolo", "ENANO")
        };

        PersonajeV2[] grupo2 = {
            new PersonajeV2("Ana", "HUMANO"),
            new PersonajeV2("Paco", "ELFO") ,           
            new PersonajeV2("Frodo", "HOBBIT"),            
            new PersonajeV2("Sam", "HOBBIT"),            
        };

        mostrarGrupo(grupo1);
        mostrarGrupo(grupo2);

        if (combateGrupoOrdenado(grupo1, grupo2)){
            System.out.println("El grupo 1 ha ganado el combate");
            System.out.println(Arrays.toString(grupo1));
        }
        else {
            System.out.println("El grupo 2 ha ganado el combate");
            System.out.println(Arrays.toString(grupo2));
        }
    }

    private static void mostrarGrupo(PersonajeV2[] grupo) {
        System.out.println("GRUPO DE PERSONAJES");
        for(PersonajeV2 p: grupo)
            System.out.println(p);
        System.out.println();
    }

    private static boolean combateGrupoOrdenado(PersonajeV2[] grupo1, PersonajeV2[] grupo2) {
        // Bucle mientras hay personaje vivos de ambos grupos

        // Creo un array con todos los personajes y lo ordena de mayor a menos agilidad
        PersonajeV2[] todos = new PersonajeV2[grupo1.length + grupo2.length];
        System.arraycopy(grupo1, 0, todos, 0, grupo1.length);
        System.arraycopy(grupo2, 0, todos, grupo1.length, grupo2.length);

        // Ordenar por Agilidad descendente
        Comparator compAgilidad = new Comparator<PersonajeV2>(){

            @Override
            public int compare(PersonajeV2 o1, PersonajeV2 o2) {
                return o1.agilidad - o2.agilidad;
            }            
        };
        Arrays.sort(todos, compAgilidad.reversed());

        int turno = 1;
        // Este bucle se repite cada turno y pasa por todos los personajes.
        while (algunVivo(grupo1) && algunVivo(grupo2)){
            System.out.println("\nCOMIENZA EL TURNO " + turno + "\n");
            System.out.println(Arrays.toString(todos));
            for(PersonajeV2 p: todos){
                if (p.estaVivo())
                    if (perteneceAGrupo(p, grupo1))
                        p.atacarMasDebil(grupo2);
                    else
                        p.atacarMasDebil(grupo1);
            } 
            turno++;                       
        }

        return false;
    }

    private static boolean perteneceAGrupo(PersonajeV2 p, PersonajeV2[] grupo) {
        boolean encontrado = false;
        if (grupo != null){
            int i = 0;
            while (i < grupo.length && !encontrado)
                if (grupo[i].equals(p))
                    encontrado = true;
                else
                    i++;
        }        

        return encontrado;
    }

    private static boolean algunVivo(PersonajeV2[] grupo) {
            int i = 0;
            while (i < grupo.length && !grupo[i].estaVivo())
                i++;
                        
        return i == grupo.length ? false : true;
    }
}