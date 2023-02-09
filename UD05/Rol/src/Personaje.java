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



    public void mostrar(){

    }

    public void subirNivel(){

    }

    public void curar(){

    }
}
