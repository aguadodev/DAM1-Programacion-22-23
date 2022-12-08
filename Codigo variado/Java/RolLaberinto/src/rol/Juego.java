package rol;

import entidad.Monstruo;
import entidad.Personaje;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Juego {

    // Variables globales del Juego.
    static String nombreJugador;
    static Personaje pj;
    static Monstruo[] monstruos;
    static JFrame frmInicio;
    static JFrameMapa mapa;

    // Mapa y Posición inicial en la clase Mapa
    // ...
    
    
    
    /**
     * Programa principal
     * @param args 
     */
    public static void main(String args[]) {
        nombreJugador = JOptionPane.showInputDialog("¿Cómo te llamas?", "Jugador/a");                
        frmInicio = new JFrameInicio();
        frmInicio.setVisible(true);
    }

    
    /**
     * Genera un número aleatorio entre 0 y n-1
     * @param n
     * @return 
     */
    private static int random(int n) {
        return (int) (Math.random() * n);
    }

    
    /**
     * Genera un número aleatorio entre 1 y 100
     * @return 
     */
    public static int random100() {
        return (int) (Math.random() * 100 + 1);
    }


    //  MÉTODOS DE VERSIONES ANTERIORES; DE CONSOLA..
/*
    public static void JuegoConsola() {

        Scanner entrada = new Scanner(System.in);
        int opcion;

        Personaje[] personajes = new Personaje[6];
        Monstruo monstruo = null;

        personajes[0] = new Personaje("Aragorn", Raza.HOBBIT, 77, 77, 77, 77, 77, 77, 42, 43, 24);
        personajes[1] = new Personaje("Gimil", Raza.ENANO, 77, 77, 77, 77, 77, 77, 42, 46, 44);
        personajes[2] = new Personaje("Roberto", Raza.HOBBIT, 77, 77, 77, 77, 77, 77, 66, 56, 43);
        personajes[3] = new Personaje("Ana", Raza.HOBBIT, 77, 77, 77, 77, 77, 77, 7, 23, 54);
        personajes[4] = new Personaje("Anxo", Raza.HOBBIT, 77, 77, 77, 77, 77, 77, 35, 45, 55);
        personajes[5] = new Personaje("Julio", Raza.HOBBIT, 77, 77, 77, 77, 77, 77, 28, 12, 67);

        // Crea y muestra el mapa
        //new frmMapa();
        do {
            // MENÚ
            System.out.println("MENÚ:\n=====\n"
                    + "1.- Mostrar Personajes ordenados de mayor a menor nivel y experiencia\n"
                    + "2.- Mostrar Personajes ordenados por PV ascendentemente\n"
                    + "3.- Mostrar Personajes ordenados por PV descendentemente\n"
                    + "4.- Generar Monstruo\n"
                    + "5.- Combate singular\n"
                    + "0.- SALIR\n");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    Arrays.sort(personajes);
                    mostrarPersonajes(personajes);
                    break;
                case 2:
                    Arrays.sort(personajes, new ComparatorPuntosVida());
                    mostrarPersonajes(personajes);
                    break;
                case 3:
                    Arrays.sort(personajes, new ComparatorPuntosVida().reversed());
                    mostrarPersonajes(personajes);
                    break;
                case 4:
                    monstruo = generaMonstruoAleatorio();
                    monstruo.mostrar();
                    break;
                case 5:
                    combateSingular(personajes[0], monstruo);
            }
        } while (opcion != 0);

    }

    public static void mostrarPersonajes(Personaje[] personajes) {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }
 
    public static void combateSingular(Personaje p, Monstruo m) {
        // Decidir iniciativa - Quién ataca primero?
        p.mostrar();
        m.mostrar();
        if (p.agilidad >= m.velocidad) {
            do {
                p.atacar(m);
                if (m.estaVivo()) {
                    m.atacar(p);
                }
            } while (p.estaVivo() && m.estaVivo());

        } else {
            do {
                m.atacar(p);
                if (p.estaVivo()) {
                    p.atacar(m);
                }
            } while (p.estaVivo() && m.estaVivo());
        }
        p.mostrar();
        m.mostrar();
    }
        
  */ 
}
