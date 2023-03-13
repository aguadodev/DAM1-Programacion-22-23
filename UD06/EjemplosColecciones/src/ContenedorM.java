import java.util.Arrays;

/**
 * Contenedor
 */
public class ContenedorM<T> {
    private T[] elementos;

    public ContenedorM() {
        T[] aux = null;
        elementos = Arrays.copyOf(aux, 0);
    }
}