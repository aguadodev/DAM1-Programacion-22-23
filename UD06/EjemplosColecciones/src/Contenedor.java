import java.util.Arrays;

/**
 * Contenedor
 */
public class Contenedor<T> {
    private T objeto;

    public Contenedor() {
    }

    void guardar(T nuevo){
        objeto = nuevo;
    }

    T extraer(){
        T res = objeto;
        objeto = null;
        return res;
    }

    static <U> int numeroDeNulos(U[] t){
        int cont = 0;

        for(U e: t)
            if (e == null)
                cont++;

        return cont;
    }

    public static <U> U[] add(U e, U[] t) {
        U[] aux = Arrays.copyOf(t, t.length + 1);
        aux[aux.length - 1] = e;
        return aux;
    }

    public static <U> boolean buscar(U e, U[] t) {
        for (U ei : t){
            if (ei.equals(e)){
                return true;
            }
        }
        return false;
    }

    public static <U> U[] concatenaTablas(U[] t1, U[] t2){
        U[] t = Arrays.copyOf(t1, t1.length + t2.length);
        for(int i = 0; i < t2.length; i++)
            t[i + t1.length] = t2[i];

        return t;
    }



}