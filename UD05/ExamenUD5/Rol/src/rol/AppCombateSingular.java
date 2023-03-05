package rol;

public class AppCombateSingular {
    public static void main(String[] args) {
        System.out.println("JUEGO DE ROL: Combate singular");

        // Se crean y muestran las fichas de los personajes
        Personaje pj1 = new Personaje("Aragorn", "HUMANO");
        Personaje pj2 = new Personaje("Legolas", "ELFO");
        System.out.println("Contendientes: ");
        System.out.println();
        pj1.mostrar();
        System.out.println();
        pj2.mostrar();
        System.out.println();

        // Se decide el primer turno según la agilidad
        boolean turnoPj1; 
        if (pj1.agilidad > pj2.agilidad)
            turnoPj1 = true;
        else if (pj1.agilidad < pj2.agilidad)
            turnoPj1 = false;
        else
            turnoPj1 = Math.random() > 0.5;

        // Los personajes se atacan alternativamente mientras ambos sigan vivos
        do {
            if (turnoPj1){
                System.out.print(pj1 + " ataca a " + pj2);
    
                if (pj1.atacar(pj2) > 0)
                    System.out.println(" => " + pj2 + " pierde PV");
                else
                    System.out.println(" => " + pj2 + " esquiva o para el ataque");
            }                
            else {
                System.out.print(pj2 + " ataca a " + pj1);

                if (pj2.atacar(pj1) > 0)
                    System.out.println(" => " + pj1 + " pierde PV");
                else
                    System.out.println(" => " + pj1 + " esquiva o para el ataque");
            }
            turnoPj1 = !turnoPj1;
        } while(pj1.estaVivo() && pj2.estaVivo());

        // Muestra el ganador
        System.out.print("Vencedor: ");
        if(pj1.estaVivo())
            System.out.println(pj1);
        else
            System.out.println(pj2);

    }
}
