package entidad;

public class Personaje implements Comparable<Personaje>{

    String nombre;
    // Raza
    public enum Raza {HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL}
    Raza raza;
    // Atributos físicos
    int fuerza;
    int agilidad;
    int constitucion;
    int inteligencia;
    int intuicion ;
    int presencia;
    // Nivel, experiencia y PV
    int nivel;
    int experiencia;
    int puntosVida;

    // CONSTRUCTORES
    public Personaje(String nombre, Raza raza, int fuerza, int agilidad, int constitucion, int inteligencia, int intuicion, int presencia, int nivel, int experiencia, int puntosVida) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza>0?fuerza:0;
        this.agilidad = agilidad>0?agilidad:0;
        this.constitucion = constitucion>0?constitucion:0;
        this.inteligencia = inteligencia>0?inteligencia:0;
        this.intuicion = intuicion>0?intuicion:0;
        this.presencia = presencia>0?presencia:0;
        this.nivel = nivel>0?nivel:0;
        this.experiencia = experiencia>0?experiencia:0;
        this.puntosVida = puntosVida>0?puntosVida:0;
    }

    public Personaje(String nombre, Raza raza, int fuerza, int agilidad, int constitucion, int inteligencia, int intuicion, int presencia) {
        this(nombre, raza, fuerza, agilidad, constitucion, inteligencia, intuicion, presencia, 1, 0, 50+constitucion);
    }
    
    public Personaje(String nombre, Raza raza) {
        this(nombre, raza, random100(), random100(), random100(), random100(), random100(), random100());
    }

    public Personaje(String nombre) {
        this(nombre, Raza.HUMANO);
    }

    
    // MÉTODOS PÚBLICOS    
    /**
     * Genera un código HTML con las características del personaje
     */
    public String mostrarHTML(){
        return "<html>"
                + "<div>"
                + "PERSONAJE<br>"
                + "=========<br>"
                + "Nombre: " + nombre + "<br>"
                + "Fuerza: " + fuerza + "<br>"
                + "Agilidad: " + agilidad + "<br>"
                + "Constitucion: " + constitucion + "<br>"
                + "Inteligencia: " + inteligencia + "<br>"
                + "Intuicion: " + intuicion + "<br>"
                + "Presencia: " + presencia + "<br>"
                + "Nivel: " + nivel + "<br>"
                + "Experiencia: " + experiencia + "<br>"
                + "Puntos de Vida: " + puntosVida + "<br>"
                + "</div>"
                + "</html>";       
    }    
    


    public void subirNivel(){
        nivel++;
    }    
    
    public void curar(){
        if (puntosVida < constitucion + 50){
            puntosVida = constitucion + 50;
        }
    }
    
    public boolean estaVivo(){
        return puntosVida >= 0;
    }
 
    public boolean perderVida(int puntos){
        puntosVida -= puntos;
        return puntosVida < 0;
    }

    public void sumarExperiencia(int puntos){
        experiencia += puntos;
    }


    // REDEFINICIÓN DE MÉTODOS
    @Override
    public String toString() {
        String cad;
        cad = (nombre == null || nombre.compareTo("") == 0)?raza.toString():nombre;
        cad += "(PV=" + puntosVida + "; N=" + nivel + "; PX=" + experiencia + ")";
        return cad;          
    }
    
    // IMPLEMENTACIÓN INTERFAZ COMPARABLE
    @Override
    public int compareTo(Personaje o) {
        // Ordena de mayor a menor nivel y de más a menos experiencia
        return nivel == o.nivel ? o.experiencia - experiencia : o.nivel - nivel;
    }    
    
    // OTROS MÉTODOS
    private static int random100(){
        return (int)(Math.random() * 100 + 1);
    } 


    
    
    
    
    
    
    
    
    


    // MÉTODOS VERSIONES ANTERIORES, CON SALIDA POR CONSOLA
    /**
     * Muestra las características del personaje por consola
     */
    public void mostrar(){
        System.out.println("PERSONAJE");
        System.out.println("=========");
        System.out.println("Nombre: " + nombre);
    // Raza
        System.out.println("Raza: " + raza);
    // Atributos físicos
        System.out.println("fuerza: " + fuerza);
        System.out.println("agilidad: " + agilidad);
        System.out.println("constitucion: " + constitucion);
        System.out.println("inteligencia: " + inteligencia);
        System.out.println("intuicion: " + intuicion);
        System.out.println("presencia: " + presencia);
    // Nivel, experiencia y PV       
        System.out.println("nivel: " + nivel);
        System.out.println("experiencia: " + experiencia);
        System.out.println("puntosVida: " + puntosVida);
        System.out.println("");
        
    }

    /**
     * Ataca a un monstruo y lo muestra por consola
     * @param m 
     */
    public void atacar(Monstruo m){
        System.out.println(nombre + "("+ puntosVida +") ataca a " + 
                m.nombre + "(" + m.puntosVida + "): ");
        int dadosPj = random100();
        int dadosM = random100();
        int ataque = fuerza + dadosPj;
        int defensa = m.defensa + dadosM;        
        System.out.print("* Ataque = (fuerza + random100) = ");
        System.out.println("(" + fuerza + " + " + dadosPj + ") = " + ataque);
        System.out.print("* Defensa = (defensa + random100) = ");
        System.out.println("(" + m.defensa + " + " + dadosM + ") = " + defensa);
        System.out.print("* Resultado: ");
        int resultado = ataque - defensa;
        
        if (resultado > 0) {
            sumarExperiencia(resultado);   
            System.out.println(nombre + " suma " + resultado + " puntos de experiencia.");            
            if (resultado > m.puntosVida)
                System.out.println(nombre + " mata a " + m.nombre + "!!! (-" + resultado + " PV)");
            else
                System.out.println(nombre + " hiere a " + m.nombre + " (-" + resultado + " PV)");                                   
            m.perderVida(resultado);
        } else {
            System.out.println(m.nombre + " esquiva o para el ataque.");
        }                
    }    

    /**
     * Ataca a otro personaje y lo muestra por consola
     * @param p 
     */    
    public void atacar(Personaje p){
        System.out.println(nombre + "("+ puntosVida +") ataca a " + 
                p.nombre + "(" + p.puntosVida + "): ");
        int dadosPj = random100();
        int ataque = fuerza + dadosPj;
        System.out.print("* Ataque = (fuerza + random100) = ");
        System.out.println("(" + fuerza + " + " + dadosPj + ") = " + ataque);
        int dadosM = random100();
        int defensa = p.agilidad + dadosM;        
        System.out.print("* Defensa = (defensa + random100) = ");
        System.out.println("(" + p.agilidad + " + " + dadosM + ") = " + defensa);
        
        System.out.print("* Resultado: ");
        int resultado = ataque - defensa;
        
        if (resultado > 0) {
            sumarExperiencia(resultado);
            System.out.println(nombre + " suma " + resultado + " puntos de experiencia.");
            if (p.perderVida(resultado))
                System.out.println(nombre + " mata a " + p.nombre + "!!! (-" + resultado + " PV)");
            else
                System.out.println(nombre + " hiere a " + p.nombre + " (-" + resultado + " PV)");                                   
        } else {
            System.out.println(p.nombre + " esquiva o para el ataque.");
        }                
    }    

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getIntuicion() {
        return intuicion;
    }

    public int getPresencia() {
        return presencia;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getPuntosVida() {
        return puntosVida;
    }


           
}