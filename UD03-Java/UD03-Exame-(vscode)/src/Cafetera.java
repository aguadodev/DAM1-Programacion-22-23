public class Cafetera {
    final int CAPACIDAD_MINIMA = 50;
    final int CAPACIDAD_MAXIMA = 1000;
    
    int capacidad;
    int cantidadActual;

    public Cafetera() {
        this(1000, 0);
    }    

    public Cafetera(int capacidadMaxima) {
        this(capacidadMaxima, capacidadMaxima);
    }

    public Cafetera(int capacidadMaxima, int cantidadActual) {  
        this.capacidad = capacidadMaxima < 50 ? 50 : capacidadMaxima;        
        this.cantidadActual = cantidadActual > capacidadMaxima ? capacidadMaxima : cantidadActual;
        this.cantidadActual = cantidadActual < 0 ? 0 : cantidadActual;
    }

    public int getCapacidadMaxima() {
        return capacidad;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual > capacidad ? capacidad : cantidadActual;
    }

    public void llenarCafetera(){
        cantidadActual = capacidad;
    }

    public boolean servirTaza(int capacidadTaza){
        if (capacidadTaza > cantidadActual) {
            cantidadActual = 0;
            return false;
        } else {
            cantidadActual -= capacidadTaza;
            return true;
        }
    }

    public void vaciarCafetera(){
        cantidadActual = 0;
    }

    public int agregarCafe(int cantidad){
        int TotalCafe = cantidadActual + cantidad;
        if (TotalCafe > capacidad) {
            cantidadActual = capacidad;
            return TotalCafe - capacidad;
        } else {
            cantidadActual = TotalCafe;
            return 0;
        }
    }

    public void mostrar(){
        System.out.println("Cafetera: " + cantidadActual + "/" + capacidad + " cc.");
    }
    
}
