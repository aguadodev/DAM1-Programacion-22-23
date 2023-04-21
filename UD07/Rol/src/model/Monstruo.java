package model;
public abstract class Monstruo {
    String nombre;
    int ataque;
    int defensa;
    int velocidad;
    int puntosVida;
    

    public Monstruo() {
    }

    public Monstruo(String nombre){
        this();
        this.nombre = nombre;
    }    

    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.puntosVida = puntosVida;
    }

    static Monstruo generaMonstruoAleatorio(){
        int rnd = rnd1a100();
        Monstruo m;

        if (rnd <= 40) 
            // Orco
            m = new Orco();
        else if (rnd <= 70)
            // Aranha
            m = new Aranha();
        else if (rnd <= 90)
            // Troll
            m = new Troll();
        else
            // Dragon
            m = new Dragon();

        return m;
    }


    boolean perderVida(int puntos){
        boolean muerto = false;
        puntosVida -= puntos;
        if (puntosVida <= 0){
            muerto = true;
            puntosVida = 0;
        }
        return muerto;
    }

    boolean estaVivo(){
        return puntosVida > 0;
    }
    
    
    static int rnd1a100(){
        return (int)(Math.random()*100 + 1);
    }

    int rnd(int min, int max){
        return (int)(Math.random()*(max - min + 1) + min);
    }    


    int atacar(Personaje2 enemigo){
        int ataque = this.ataque + rnd1a100();
        int defensa = enemigo.agilidad + rnd1a100();
        int resultado = ataque - defensa;

        if (resultado > enemigo.puntosVida){
            resultado = enemigo.puntosVida;           
        }            
        else if (resultado < 0)
            resultado = 0;
  
        enemigo.sumarExperiencia(resultado);
        enemigo.perderVida(resultado);             

        return resultado;
    }    

    public void mostrar(){

        System.out.print("MONSTRUO: ");
        if (nombre == null)
       System.out.println(getClass().getSimpleName());
            else
        System.out.println(nombre);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Puntos de Vida: " + puntosVida);
    }

    @Override
    public String toString() {
        String str = "";
        String clase = getClass().getSimpleName();

        if (nombre != null)
            str = nombre + "-";

        return str + clase + " (" + puntosVida + ")";
    }


}
