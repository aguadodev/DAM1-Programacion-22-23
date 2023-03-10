package rol;
import java.util.Arrays;

public class Personaje implements Comparable {
    
    protected String nombre;
    enum Raza {HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL}
    protected Raza raza;
    protected int fuerza;
    public int agilidad;
    protected int constitucion;
    protected int nivel;
    protected int experiencia;
    protected int puntosVida;


    // Este constructor puede lanzar una excepción si los parámetros no són válidos
    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion, int nivel,
            int experiencia, int puntosVida) throws IllegalArgumentException {
        this.nombre = nombre;
        
        try {            
            // Capturo la posible excepción de valueOf si el valor de raza no es válido
            this.raza = Raza.valueOf(raza);
        } catch (IllegalArgumentException e) {
            // Personalizo y lanzo una excepción de tipo IllegalArgumentException
            throw new IllegalArgumentException("Personaje no válido");
        }
        
        this.fuerza = fuerza >= 1 ? fuerza : 1;
        this.agilidad = agilidad >= 1 ? agilidad : 1;
        this.constitucion = constitucion >= 1 ? constitucion : 1;
        this.nivel = nivel >= 1 ? nivel : 1;
        this.experiencia = experiencia >= 0 ? experiencia : 0;
        this.puntosVida = puntosVida >= 1 ? puntosVida : 1;
    }

    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion) {
        this(nombre, raza, fuerza, agilidad, constitucion, 1, 0, constitucion + 50);
    }

    public Personaje(String nombre, String raza) {
        this(nombre, raza, rnd1a100(), rnd1a100(), rnd1a100());
    }
    
    static int rnd1a100(){
        return (int)(Math.random()*100 + 1);
    }

    public void mostrar(){
        System.out.println("PERSONAJE: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Constitución: " + constitucion);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Puntos de Vida: " + puntosVida);
    }

    @Override
    public String toString() {
        return nombre + " (" + puntosVida + "/" + (constitucion + 50) + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        Personaje otro = (Personaje)obj;
        return nombre.equals(otro.nombre)
            && raza.equals(otro.raza)
            && fuerza == otro.fuerza
            && agilidad == otro.agilidad
            && constitucion == otro.constitucion;
    }

    public boolean sumarExperiencia(int puntos){
        int nivelAnterior = experiencia / 1000;

        experiencia += puntos;

        int nivelActual = experiencia / 1000;

        return nivelAnterior != nivelActual;
    }

    public void subirNivel(){
        nivel++;
        fuerza = (int) Math.round(fuerza * 1.05);
        agilidad = (int) Math.round(agilidad * 1.05);
        constitucion = (int) Math.round(constitucion * 1.05);
    }

    public void curar(){
        if (puntosVida < constitucion + 50)
            puntosVida = constitucion + 50;
    }

    public boolean perderVida(int puntos){
        boolean muerto = false;
        puntosVida -= puntos;
        if (puntosVida <= 0){
            muerto = true;
            puntosVida = 0;
        }
        return muerto;
    }

    public boolean estaVivo(){
        return puntosVida > 0;
    }

    public int atacar(Personaje enemigo){
        int ataque = fuerza + rnd1a100();
        int defensa = enemigo.agilidad + rnd1a100();
        int resultado = ataque - defensa;

        if (resultado > enemigo.puntosVida){
            resultado = enemigo.puntosVida;           
        }            
        else if (resultado < 0)
            resultado = 0;

        sumarExperiencia(resultado);    
        enemigo.sumarExperiencia(resultado);
        enemigo.perderVida(resultado);             

        return resultado;
    }

    public int atacar(Monstruo enemigo){
        int ataque = fuerza + rnd1a100();
        int defensa = enemigo.defensa + rnd1a100();
        int resultado = ataque - defensa;

        if (resultado > enemigo.puntosVida){
            resultado = enemigo.puntosVida;           
        }            
        else if (resultado < 0)
            resultado = 0;

        sumarExperiencia(resultado);    
        enemigo.perderVida(resultado);             

        return resultado;
    }    

    public static Personaje[] sortPuntosVidaDesc(Personaje[] personajes){
        Personaje[] A = Arrays.copyOf(personajes, personajes.length);

        int i, j;
        Personaje aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {                                                              
                if (A[j + 1].puntosVida > A[j].puntosVida) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }        
        return A;
    }

    public static Personaje[] sortPuntosVidaAsc(Personaje[] personajes){
        Personaje[] A = Arrays.copyOf(personajes, personajes.length);

        int i, j;
        Personaje aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {                                                              
                if (A[j + 1].puntosVida < A[j].puntosVida) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }        
        return A;
    }

    @Override
    public int compareTo(Object o) {
        int res = nombre.compareTo(((Personaje) o).nombre);
        if (res == 0)
            return puntosVida - ((Personaje) o).puntosVida;
        else
            return res;
    }

}
