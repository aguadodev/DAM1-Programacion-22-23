import java.io.Serializable;
import java.util.Collection;

public class Jugador implements Serializable {
    String nombre;
    int edad;
    double estatura;
    
    public Jugador() {
    }

    public Jugador(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return nombre + ", edad=" + edad + ", estatura=" + estatura + "\n";
    }

    static double mediaEdad(Collection<Jugador> c) {
        double suma = 0;
        for (Jugador j : c) {
            suma += j.edad;
        }

        return suma / c.size();
    }

    static double mediaEstatura(Collection<Jugador> c) {
        double suma = 0;
        for (Jugador j : c) {
            suma += j.estatura;
        }

        return suma / c.size();
    }

}
