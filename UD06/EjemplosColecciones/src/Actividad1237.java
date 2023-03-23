import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Actividad1237 {
    public static void main(String[] args) {
        Map<Integer, Jugador> dam1FC;
    
        dam1FC = new TreeMap<>();       
    
        Jugador.altaJugador(dam1FC, 6, new Jugador("66666666A", "Alberto", "Centrocampista"));
        Jugador.altaJugador(dam1FC, 7, new Jugador("77777777A", "Brais", "Centrocampista"));
        Jugador.altaJugador(dam1FC, 8, new Jugador("88888888A", "Gabriel", "Centrocampista"));
        Jugador.altaJugador(dam1FC, 9, new Jugador("99999999A", "Aarón", "Delantero"));
        Jugador.altaJugador(dam1FC, 10, new Jugador("00000000A", "Maicol", "Delantero"));
        Jugador.altaJugador(dam1FC, 11, new Jugador("11111111B", "Giuseppe", "Delantero"));        
        Jugador.altaJugador(dam1FC, 1, new Jugador("11111111A", "Adrián T.", "Portero"));
        Jugador.altaJugador(dam1FC, 2, new Jugador("22222222A", "Martín", "Defensa"));
        Jugador.altaJugador(dam1FC, 3, new Jugador("33333333A", "Gonzalo", "Defensa"));
        Jugador.altaJugador(dam1FC, 4, new Jugador("44444444A", "Adrián R.", "Defensa"));
        Jugador.altaJugador(dam1FC, 5, new Jugador("55555555A", "Diego", "Defensa"));
        Jugador.altaJugador(dam1FC, 12, new Jugador("22222222B", "Iago", "Portero"));
        System.out.print("Intento de añadir un nuevo jugador en un dorsal ya ocupado. Muestra el jugador que tiene el dorsal actualmente:");
        System.out.println(Jugador.altaJugador(dam1FC, 12, new Jugador("22222222B", "Manu", "Portero")));
    
        System.out.println("Plantilla Inicial");
        Jugador.mostrar(dam1FC);
    
        Jugador jEliminado = Jugador.eliminarJugador(dam1FC, 12);
    
        System.out.println("\nJugador Eliminado: " + jEliminado);
    
        System.out.println("\nPlantilla sin el jugador eliminado");
        Jugador.mostrar(dam1FC);        
    
        System.out.println("\nDefensas: ");
        Jugador.mostrar(dam1FC, "Defensa");
        System.out.println("Centrocampistas: ");
        Jugador.mostrar(dam1FC, "Centrocampista");
    
        boolean editado = Jugador.editarJugador(dam1FC, 5, new Jugador("55555555A", "Diego", "Centrocampista"));
        System.out.println("\nJugador editado? " + editado);
    
        System.out.println("\nDefensas: ");
        Jugador.mostrar(dam1FC, "Defensa");
        System.out.println("Centrocampistas: ");
        Jugador.mostrar(dam1FC, "Centrocampista");        
    }
        
}


class Jugador {
    
    enum Posicion {PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}
    
    String dni;
    String nombre;
    Posicion posicion;
    Double estatura;

    public Jugador(String dni, String nombre, Posicion posicion, Double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
        this.estatura = estatura;
    }

    public Jugador(String dni, String nombre, String posicion) {        
        this(dni, nombre, Posicion.valueOf(posicion.toUpperCase()), null);
    }    

    @Override
    public String toString() {
        return nombre;
    }
    
    static Jugador altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador){
        return plantilla.putIfAbsent(dorsal, jugador);
    }
    
    static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal){
        return plantilla.remove(dorsal);
    }
        
    static void mostrar (Map<Integer, Jugador> plantilla){
        System.out.println(plantilla);
    }
        
    static void mostrar (Map<Integer, Jugador> plantilla, String posicion){        
        List<Jugador> jugadores = new ArrayList(plantilla.values());
        
        for(Jugador j: jugadores){
            if (j.posicion.equals(Posicion.valueOf(posicion.toUpperCase())))
                System.out.println(j);
        }
    }
        
    static boolean editarJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador){
        boolean editado = false;
        if (plantilla.containsKey(dorsal)){
            if(plantilla.get(dorsal).dni == jugador.dni){
                plantilla.put(dorsal, jugador);
                editado = true;
            }
        }

        return editado;
    }
}



