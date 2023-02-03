package geometria;

public class Main {
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo();
        t1.altura = 10;
        t1.base = 20;
        System.out.println("Área del triángulo: " + t1.area());

        Rectangulo r1 = new Rectangulo();
        r1.altura = 10;
        r1.base = 20;
        System.out.println("Área del rectángulo: " +  r1.area());

        Punto a = new Punto(0,0);
        Punto b = new Punto(0,2);
        System.out.println("Distancia entre a y b: " + a.distancia(b));
        
        Punto c = new Punto3D(0,0,0);
        Punto d = new Punto3D(0,2,0);
        System.out.println("Distancia entre c y d: " + c.distancia(d));
        

    }
}
