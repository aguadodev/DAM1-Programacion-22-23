public class Personaje {
    
    String nombre;
    enum Raza {HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL}
    Raza raza;
    int fuerza;
    int agilidad;
    int constitucion;
    int nivel;
    int experiencia;
    int puntosVida;


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

    


}
