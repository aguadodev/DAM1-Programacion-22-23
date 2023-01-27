import java.util.Arrays;

public class Lista {
    private Integer[] elementos;

    public Lista() {
        elementos = new Integer[0];
    }

    public int size(){
        return elementos.length;
    }

    public void add(Integer e){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = e;
    }

    public void add(int index, Integer e){
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        for (int i = elementos.length - 1; i > index; i--){
            elementos[i] = elementos[i - 1];
        }
        elementos[index] = e;
    }

    public void addInicio(Integer e){
        Integer[] aux = new Integer[size() + 1];

        System.arraycopy(elementos,0,aux,1,size());
        elementos = aux;
        elementos[0] = e;
    }

    public void add(Lista l){
        elementos = Arrays.copyOf(elementos, size() + l.size());
        System.arraycopy(l, 0, elementos, size() - l.size(), l.size());
    }

    public Integer remove (int index){
        Integer e = elementos[index];

        Integer [] aux = new Integer[size() - 1];
        System.arraycopy(elementos, 0, aux, 0, index);
        System.arraycopy(elementos, index + 1, aux, index, size() - index - 1);
        
        elementos = aux;

        return e;
    }

    public Integer get (int index) {
        return elementos[index];
    }

    public int indexOf(Integer e){
        int pos = -1;
        int i = 0;
        while (pos == -1 && i < size()){
            if (get(i) == e)
                pos = i;
        }

        return pos;
    }

    @Override
    public String toString() {
        return "Lista [elementos=" + Arrays.toString(elementos) + "]";
    }
    
}
