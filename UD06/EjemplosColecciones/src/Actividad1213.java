public class Actividad1213 {
    public static void main(String[] args) {
        System.out.println("SORTEO DE LA PRIMITIVA (Integer)");
        Sorteo<Integer> primitiva = new Sorteo<>();

        // Añade al "bombo" los números del 1 al 49
        for (int i = 1; i < 50; i++){
            primitiva.add(i);
        }
    
        System.out.println("Premiados: " + primitiva.premiados(6));        


        System.out.println("SORTEO DE CLIENTES (Cliente)");
        Sorteo<Cliente> sorteoClientes = new Sorteo<>();
        
        // Añade los clientes "bombo". Los repetidos no los añadirá (devuelven e imprimen "false")
        Cliente marta = new Cliente("111", "Marta", "12/02/2000" );
        sorteoClientes.add(marta);
        sorteoClientes.add(new Cliente("115", "Jorge", "16/03/1999" ));
        sorteoClientes.add(new Cliente("112", "Carlos", "01/10/2002" ));
        sorteoClientes.add(new Cliente("118", "Jorgito", "16/03/1999" ));
        sorteoClientes.add(new Cliente("132", "Carloitos", "01/10/2002" ));
        System.out.println(sorteoClientes.add(marta));
        System.out.println(sorteoClientes.add(new Cliente("115", "Jorge", "16/03/1999" )));
        System.out.println(sorteoClientes.add(new Cliente("112", "Carlos", "01/10/2002" )));
        sorteoClientes.add(new Cliente("113", "Sofía", "16/03/1999" ));
        sorteoClientes.add(new Cliente("142", "Vero", "01/10/2002" ));
    
        System.out.println("Premiados: " + sorteoClientes.premiados(3));        

    }
}
