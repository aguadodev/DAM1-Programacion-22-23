
package entidad;

import entidad.Personaje;


public class Monstruo {
    
    String nombre;
    int ataque;
    int defensa;
    int velocidad;
    int puntosVida;


    // CONSTRUCTORES    
    public Monstruo(){        
    }
    
    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        this.nombre = nombre;
        // Asegura que los atributos no sean negativos
        if (ataque > 0) this.ataque = ataque;
        if (defensa > 0) this.defensa = defensa;
        if (velocidad > 0) this.velocidad = velocidad;
        if (puntosVida > 0) this.puntosVida = puntosVida;
    }

    public Monstruo(int ataque, int defensa, int velocidad, int puntosVida) {
        this(null, ataque, defensa, velocidad, puntosVida);
    }
    
    // MÉTODOS PÚBLICOS    
    
    /**
     * Genera y devuelve un monstruo aleatorio
     * @return
     */
    public static Monstruo generarAleatorio() {
        double numero = Math.random() * 100;
        Monstruo m;
        if (numero < 40) {
            m = new Orco();
        } else if (numero < 70) {
            m = new Aranha();
        } else if (numero < 90) {
            m = new Troll();
        } else {
            m = new Dragon();
        }
        return m;
    }    
    
    /**
     * Genera un código HTML con las características del personaje
     */
    public String mostrarHTML(){
        String clase = (nombre != null)?nombre:(getClass().getSimpleName());
        return "<html>"
                + "<div>"
                + "MONSTRUO<br>"
                + "=========<br>"
                + "Nombre/Clase: " + clase + "<br>"
                + "Ataque: " + ataque + "<br>"
                + "Defensa: " + defensa + "<br>"
                + "Velocidad: " + velocidad + "<br>"
                + "Puntos de Vida: " + puntosVida + "<br>"
                + "</div>"
                + "</html>";       
    }           
    
    public boolean estaVivo(){
        return puntosVida >= 0;
    }
 
    public boolean perderVida(int puntos){
        puntosVida -= puntos;
        return puntosVida < 0;
    }
    
    // REDEFINICIÓN DE MÉTODOS
    @Override
    public String toString() {
        String cad = "";
        if (nombre != null) cad += nombre + "-";
        cad += this.getClass().getSimpleName() + " (PV=" + puntosVida + ") ";
        return cad;
    }
    
    
    // OTROS MÉTODOS
    protected static int random100(){
        return (int)(Math.random() * 100 + 1);
    }
    
    // OTROS MÉTODOS
    protected static int randomRango(int inicio, int fin){
        return (int)(Math.random() * (fin - inicio + 1) + inicio);
    }    

    
    
    
    
    
    // GETTERS

    public String getNombre() {
        if (null == nombre || nombre.equals("")){
            return getClass().getSimpleName();
        }
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getPuntosVida() {
        return puntosVida;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    // MÉTODOS VERSIONES ANTERIORES, CON SALIDA POR CONSOLA
    /**
     * Muestra las características del monstruo por consola
     */
    public void mostrar() {
        System.out.println("MONSTRUO");
        System.out.println("=======");        
        if (nombre != null) System.out.println("Nombre: " + nombre);
        System.out.println("Clase: " + getClass().getSimpleName());
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Puntos de Vida: " + puntosVida);
        System.out.println("");
    }    
    
    /**
     * Ataca a un personaje y lo muestra por consola
     * @param p 
     */
    public void atacar(Personaje p){
        System.out.println(nombre + "("+ puntosVida +") ataca a " + 
                p.nombre + "(" + p.puntosVida + "): ");
        int dadosPj = random100();
        int ataque = this.ataque + dadosPj;
        System.out.print("* Ataque = (ataque + random100) = ");
        System.out.println("(" + this.ataque + " + " + dadosPj + ") = " + ataque);
        int dadosM = random100();
        int defensa = p.agilidad + dadosM;        
        System.out.print("* Defensa = (defensa + random100) = ");
        System.out.println("(" + p.agilidad + " + " + dadosM + ") = " + defensa);
        
        System.out.print("* Resultado: ");
        int resultado = ataque - defensa;
        
        if (resultado > 0) {
            // El personaje suma experiencia también por las heridas recibidas.
            p.sumarExperiencia(resultado);
            System.out.println(p.nombre + " suma " + resultado + " puntos de experiencia.");
            if (p.perderVida(resultado))
                System.out.println(nombre + " mata a " + p.nombre + "!!! (-" + resultado + " PV)");
            else
                System.out.println(nombre + " hiere a " + p.nombre + " (-" + resultado + " PV)");                                   
        } else {
            System.out.println(p.nombre + " esquiva o para el ataque.");
        }                
    }   



    
}
