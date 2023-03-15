import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Actividad2ColeccionesReales {
    public static void main(String[] args) {
        Collection<Double> cPositivos = new ArrayList<>();
        Collection<Double> cNegativos = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Double n = Math.random() * 201 - 100;
            if (n > 0)
                cPositivos.add(n);
            else
                cNegativos.add(n);
        }

        System.out.println("Colección de número positivos: " + cPositivos.toString());
        System.out.println("Suma de los números positivos: " + sumaColeccion(cPositivos));
        eliminarMayoresAbsolutos(cPositivos, 10);
        System.out.println("\nColección final de menores de 10: " + cPositivos.toString() + "\n\n");


        System.out.println("Colección de número negativos: " + cNegativos.toString());  
        System.out.println("Suma de los números negativos: " + sumaColeccion(cNegativos));
        eliminarMayoresAbsolutos(cNegativos, 10);
        System.out.println("\nColección final de mayores de -10: " + cNegativos.toString());                     
    }

    private static void eliminarMayoresAbsolutos(Collection<Double> c, int n) {
        Iterator<Double> it = c.iterator();
        while(it.hasNext())
            if (Math.abs(it.next()) > n)
                it.remove();
    }

    private static double sumaColeccion(Collection<Double> c) {
        double suma = 0;

        Iterator<Double> it = c.iterator();
        while(it.hasNext())
            suma += it.next();        
        return suma;
    }
}
