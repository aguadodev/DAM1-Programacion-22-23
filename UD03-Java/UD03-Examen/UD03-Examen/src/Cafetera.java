public class Cafetera {
    static final int CAPACIDAD_MINIMA = 50;
    static final int CAPACIDAD_MAXIMA = 1000;
    private int capacidad;
    private int cantidadActual;

    public Cafetera() {
        this(1000, 0);
    }

    public Cafetera(int capacidad) {
        this(capacidad, capacidad);
    }

    public Cafetera(int capacidad, int cantidadActual) {        
        if (capacidad < CAPACIDAD_MINIMA)
            this.capacidad = CAPACIDAD_MINIMA;
        else if (capacidad > CAPACIDAD_MAXIMA)
            this.capacidad = CAPACIDAD_MAXIMA;
        else
            this.capacidad = capacidad;

        this.cantidadActual = cantidadActual > capacidad ? capacidad : cantidadActual;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void llenarCafetera(){
        cantidadActual = capacidad;
    }

    public void servirTaza(int capacidadTaza){       
        if (capacidadTaza > cantidadActual)
            cantidadActual = 0;
        else
            cantidadActual -= capacidadTaza;

        // Usando operador ternario:
        // cantidadActual = capacidadTaza > cantidadActual ? 0 : cantidadActual - capacidadTaza;            
    }

    public void vaciarCafetera(){
        cantidadActual = 0;
    }
    
    public void agregarCafe(int cantidad){
        if (cantidad + cantidadActual > capacidad)
            cantidadActual = capacidad;
        else
            cantidadActual += cantidad;        
    }

    public void mostrar(){
        System.out.printf("CAFETERA: %d/%d cc. %n", cantidadActual, capacidad);
    }
    

    

    



}
