import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class AppEjemplosColecciones {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();

        Collection<Cliente> coleccionClie = listaClientes;

        Cliente cliente = new Cliente("111", "Marta", "12/02/2000");
        Cliente cliente2 = new Cliente("112", "Juan", "22/03/2002");
        Cliente cliente3 = new Cliente("113", "Lola", "12/07/2001");    
        Cliente cliente4 = new Cliente("114", "Pedro", "12/07/2001");    
        
        
        System.out.println("Size:" + coleccionClie.size() + " isEmpty: " + coleccionClie.isEmpty());
        coleccionClie.add(cliente);
        coleccionClie.add(cliente2);
        coleccionClie.add(cliente3);

        System.out.println("RECORREMOS UNA COLECCION CON UN BUCLE FOR-EACH");
        for(Cliente c : coleccionClie){
            System.out.print(c);
        }

        System.out.println("RECORREMOS UNA COLECCION CON UN ITERATOR");
        Iterator<Cliente> it = coleccionClie.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
            it.remove();
        }
        System.out.println("Size:" + coleccionClie.size() + " isEmpty: " + coleccionClie.isEmpty());



        /*
        System.out.println("Colleción (toString): " + coleccionClie.toString());
        System.out.println("Size:" + coleccionClie.size() + " isEmpty: " + coleccionClie.isEmpty());
        System.out.println("Contains (cliente dni = 111): " + coleccionClie.contains(new Cliente("111")));
        System.out.println("Contains (cliente dni = 115): " + coleccionClie.contains(new Cliente("115")));
        coleccionClie.remove(cliente);
        System.out.println("Colleción (toString): " + coleccionClie.toString());
        System.out.println("Size:" + coleccionClie.size() + " isEmpty: " + coleccionClie.isEmpty());
        System.out.println("Contains (cliente): " + coleccionClie.contains(cliente));
        coleccionClie.clear();
        System.out.println("Colleción (toString): " + coleccionClie.toString());
        System.out.println("Size:" + coleccionClie.size() + " isEmpty: " + coleccionClie.isEmpty());
        System.out.println("Contains (cliente): " + coleccionClie.contains(cliente));*/


    }
}
