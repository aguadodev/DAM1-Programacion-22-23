import java.util.Arrays;

public class Conjunto {
    private Integer[] elementos;

    public boolean insertar(Integer e){
        boolean modificado = false;
        if (elementos == null)
            // Si elementos es null lo creamos
            elementos = new Integer[1];
            
        else            
            Arrays.sort(elementos);
            if (Arrays.binarySearch(elementos, e) < 0){
                // Si el elemento no existe en el conjunto lo añadimos
                elementos = Arrays.copyOf(elementos, elementos.length + 1);
        
                // Insertamos el elemento al final
                elementos[elementos.length - 1] = e; 
                modificado = true;       
            }
        return modificado;
    }

}
