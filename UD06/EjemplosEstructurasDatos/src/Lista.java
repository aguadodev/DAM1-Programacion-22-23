import java.util.Arrays;

/**
 * Lista
 */
public class Lista implements ColaDoble, Pila {
    private Integer [] elementos;

    // MÉTODOS DE LA INTERFAZ Pila
    public void apilar(Integer e){
        addFinal(e);
    }
    
    public Integer desapilar(){
        return length() > 0 ? delPosicion(length() - 1) : null;
    }

    // MÉTODOS DE LA INTERFAZ Cola
    public void encolar(Integer e){
        addFinal(e);
    }
    
    public Integer desencolar(){
        return length() > 0 ? delPosicion(0) : null;
    }

    // MÉTODOS DE LA INTERFAZ ColaDoble
    @Override
    public Integer desencolarFinal() {
        return length() > 0 ? delPosicion(length() - 1) : null;
    }

    @Override
    public void encolarCabeza(Integer e) {
        addInicio(e);
    }


    // MÉTODOS DE LA CLASE LISTA
    public Lista() {
        elementos = new Integer[0];
    }

    public int length(){
        return elementos.length;
    }

    public void addFinal(Integer e){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = e;
    }

    public void addInicio(Integer e){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        for(int i = elementos.length - 1; i > 0; i--){
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = e;
    } 

    public void addPosicion(Integer e, int pos){
        if (pos >= 0 && pos <= elementos.length) {
            // Amplío el array
            elementos = Arrays.copyOf(elementos, elementos.length + 1);

            // Hago hueco al nuevo elemento
            for(int i = elementos.length - 1; i > pos; i--){
                elementos[i] = elementos[i - 1];
            }            
            // Inserto el nuevo elemento
            elementos[pos] = e;
        }              
    }  

    public void mostrar(){
        System.out.println(Arrays.toString(elementos));
    }
    
    public void addLista(Lista lista){
        // Amplío el array
        elementos = Arrays.copyOf(elementos, elementos.length + lista.length()); 
        // copiamos elementos de la lista que se pasa como parámetro
        for (int i = 0; i < lista.length(); i++){
            elementos[elementos.length - lista.length() + i] = lista.elementos[i];
        }
    }
    
    public Integer delPosicion(int pos){
        Integer e = elementos[pos];            

        for(int i = pos; i < elementos.length - 1; i++){
            elementos[i] = elementos[i+1];
        }
        
        elementos = Arrays.copyOf(elementos, elementos.length - 1);         
        
        return e;
    }
    
    public Integer getPosicion(int pos){            
        return elementos[pos];
    }    

    public Integer buscar(Integer e){
        int i = 0;
        boolean encontrado = false;
        
        while (i < elementos.length && !encontrado){
            if (elementos[i] == e) {
                encontrado = true;
            }
            i++;
        }
        
        if (encontrado) {
            return i - 1;
        } else {
            return - 1;
        }            
    }    

    public static Lista concatena(Lista l1, Lista l2) {
        Lista l3 = new Lista();
        
        l3.addLista(l1);
        l3.addLista(l2);
       
        return l3;
    }


}