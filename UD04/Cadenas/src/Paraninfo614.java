import java.util.Arrays;
import java.util.Scanner;

public class Paraninfo614 {
    public static void main(String[] args) {
        String[] agenda = new String[0]; // "nombre:teléfono"
        int opcion;
        Scanner sc = new Scanner(System.in);

        do{
            // Mostrar Menú
            System.out.println("MENU");
            System.out.println("====");
            System.out.println("1) Añadir un nuevo contacto (nombre y teléfono).");
            System.out.println("2) Buscar el teléfono a partir de un nombre.");
            System.out.println("3) Mostrar contactos ordenados alfabéticamente.");
            System.out.println("0) SALIR");

            // leer Opción
            opcion = sc.nextInt();

            // Evaluar y ejecutar la opción
            switch (opcion){
                case 1: 
                    sc.nextLine();
                    System.out.print("Introduce el nombre:");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce el teléfono:");
                    String telefono = sc.nextLine();   
                    // Añadir al Array
                    agenda = Arrays.copyOf(agenda, agenda.length + 1);
                    agenda[agenda.length - 1] = nombre + ":" + telefono;
                    break;
                case 2: 
                    sc.nextLine();
                    System.out.print("Introduce el nombre a buscar:");
                    String nombreBuscar = sc.nextLine().toUpperCase();
                    int i = 0;
                    while (i < agenda.length && !agenda[i].toUpperCase().contains(nombreBuscar)){
                        i++;
                    }
                    if (i == agenda.length){
                        System.out.println("El nombre buscado no existe.");
                    } else {
                        String telefonoBuscar = agenda[i].split(":")[1];
                        //String telefonoBuscar = agenda[i].substring(agenda[i].indexOf(":") + 1);
                        System.out.println("El teléfono de " + nombreBuscar +
                        " es " + telefonoBuscar);
                    }
                    break;
                case 3: 
                    Arrays.sort(agenda);
                    System.out.println(Arrays.toString(agenda));
                    break;
            }
        } while(opcion != 0);
    }
}
