import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ActividadPropuesta215 {
    public static void main(String[] args) {
        Set<Cliente> conjuntoClientes = new HashSet<>();
        Cliente marta = new Cliente("111", "Marta", "12/02/2000" );
        conjuntoClientes.add(marta);
        conjuntoClientes.add(new Cliente("115", "Jorge", "16/03/1999" ));
        conjuntoClientes.add(new Cliente("112", "Carlos", "01/10/2002" ));
        conjuntoClientes.add(new Cliente("118", "Jorgito", "16/03/1999" ));
        conjuntoClientes.add(new Cliente("132", "Carloitos", "01/10/2002" ));

        System.out.println(conjuntoClientes);

        System.out.println(conjuntoClientes.add(marta));

        Comparator<Cliente> cEdad = new Comparator<Cliente>(){
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.edad() - c2.edad();
            } };

        Comparator<Cliente> cNombre = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNombre().compareTo(c2.getNombre());
            }            
        };

        List<Cliente> cClientesEdad = new ArrayList<>(conjuntoClientes);
        cClientesEdad.sort(cEdad);
        System.out.println(cClientesEdad);

        TreeSet<Cliente> cClientesNombre = new TreeSet<>(cNombre);
        cClientesNombre.addAll(conjuntoClientes);
        System.out.println(cClientesNombre);

        TreeSet<Cliente> cClientesDNI = new TreeSet<>(conjuntoClientes);
        System.out.println(cClientesDNI);
    }
}
