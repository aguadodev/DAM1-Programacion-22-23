import java.util.Arrays;

public class ColaPersona {
    private Persona[] elementos;

    public void encolar(Persona e){        
        if (elementos == null)
            // Si elementos es null lo creamos
            elementos = new Persona[1];
        else
            // Si no aumentamos el tamaño de elementos
            elementos = Arrays.copyOf(elementos, elementos.length + 1);
        
        // Insertamos el elemento al final
        elementos[elementos.length - 1] = e;
    }

    public Persona desencolar(){
        Persona e; // valor a devolver
        // Si la cola está vacía devolvemos null
        if (elementos == null || elementos.length == 0)
            e = null;
        else {
            // copiar el primer elemento y eliminarlo del array
            e = elementos[0];
            if (elementos.length == 1)
                elementos = null;
            else
                elementos = Arrays.copyOfRange(elementos, 1, elementos.length);
        }
                
        // devolver el primer elemento
        return e;
    }

}
