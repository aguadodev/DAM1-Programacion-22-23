import java.util.Arrays;

public class Pila {
    private Integer[] elementos;

    public void apilar(Integer e){        
        if (elementos == null)
            // Si elementos es null lo creamos
            elementos = new Integer[1];
        else
            // Si no aumentamos el tamaño de elementos
            elementos = Arrays.copyOf(elementos, elementos.length + 1);
        
        // Insertamos el elemento al final
        elementos[elementos.length - 1] = e;
    }

    public Integer desapilar(){
        Integer e; // valor a devolver
        // Si la pila está vacía devolvemos null
        if (elementos == null || elementos.length == 0)
            e = null;
        else {
            // copiar el ultimo elemento y eliminarlo del array
            e = elementos[elementos.length - 1];
            if (elementos.length == 1)
                elementos = null;
            else
                elementos = Arrays.copyOfRange(elementos, 0, elementos.length - 1);
        }
                
        // devolver el primer elemento
        return e;
    }

}
