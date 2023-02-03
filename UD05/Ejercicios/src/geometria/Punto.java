package geometria;

public class Punto {
    double x;
    double y;
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distancia(Punto otroPunto){
        return Math.sqrt(Math.pow(x - otroPunto.x, 2) + Math.pow(y - otroPunto.y, 2));
    }
}
