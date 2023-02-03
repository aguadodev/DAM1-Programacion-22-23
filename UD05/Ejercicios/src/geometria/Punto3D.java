package geometria;

public class Punto3D extends Punto{
    double z;

    public Punto3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    double distancia(Punto otroPunto) {
        Punto3D aux = (Punto3D) otroPunto;
        return Math.sqrt(
            Math.pow(x - aux.x, 2) + 
            Math.pow(y - aux.y, 2) +
            Math.pow(z - aux.z, 2));
    }

    double distancia(Punto3D otroPunto) {
        return Math.sqrt(
            Math.pow(x - otroPunto.x, 2) + 
            Math.pow(y - otroPunto.y, 2) +
            Math.pow(z - otroPunto.z, 2));
    }
    

    

}
