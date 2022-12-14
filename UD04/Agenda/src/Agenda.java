import java.util.Scanner;

public class Agenda {
    Persona[] contactos;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            imprimirMenu();
            // Leer opción
            opcion = sc.nextInt();
            // Ejecutar opción

        } while( opcion != 0);        
    }

    static public void imprimirMenu(){
        System.out.println("\nMENU");
        System.out.println("====\n");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Eliminar contactos");
        System.out.println("4. Vaciar agenda");
        System.out.println("5. Buscar contacto");
        System.out.println("0. SALIR");    
    }
    
}
