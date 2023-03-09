import rol.Personaje;

/**
 * AppCombateGrupoOrdenado1
 */
public class AppCombateGrupoOrdenado1 {

    public static void main(String[] args) {
        
        Personaje[] grupo1 = {
            new Personaje("Alonso", "HUMANO"),
            new Personaje("Sandra", "ELFO"),
            new Personaje("Lolo", "ENANO")
        };

        Personaje[] grupo2 = {
            new Personaje("Ana", "HUMANO"),
            new Personaje("Paco", "ELFO") ,           
            new Personaje("Frodo", "HOBBIT")            
        };

        mostrarGrupo(grupo1);
        mostrarGrupo(grupo2);

        if (combateGrupoOrdenado(grupo1, grupo2))
            System.out.println("El grupo 1 ha ganado el combate");
        else
            System.out.println("El grupo 2 ha ganado el combate");
    }

    private static void mostrarGrupo(Personaje[] grupo) {
        System.out.println("GRUPO DE PERSONAJES");
        for(Personaje p: grupo)
            System.out.println(p);
        System.out.println();
    }

    private static boolean combateGrupoOrdenado(Personaje[] grupo1, Personaje[] grupo2) {
        // Bucle mientras hay personaje vivos de ambos grupos

        return false;
    }
}