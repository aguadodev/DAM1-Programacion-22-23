import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppEjemplosColecciones {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();

        Collection<Cliente> coleccionClie = listaClientes;

        coleccionClie.add(new Cliente("111", "Marta", "12/02/2000"));

    }
}
