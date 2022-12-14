import java.util.Arrays;
import java.util.Scanner;

public class Agenda {
    static Persona[] contactos = new Persona[0];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            imprimirMenu();
            // Leer opción
            opcion = sc.nextInt();
            // Ejecutar opción
            switch(opcion){
                case 1: anhadirContacto(); break;
                case 2: listarContactos(); break;
                case 3: eliminarContacto(); break;
                case 4: break;
                case 5: break;
            }

        } while( opcion != 0);        
    }

    static public void imprimirMenu(){
        System.out.println("\nMENU");
        System.out.println("====\n");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Vaciar agenda");
        System.out.println("5. Buscar contacto");
        System.out.println("0. SALIR");    
    }

    static public void anhadirContacto(){
        Scanner sc = new Scanner(System.in);
        Persona p = new Persona();

        System.out.print("Nombre: ");
        p.setNombre(sc.nextLine());
        System.out.print("Apellidos: ");
        p.setApellidos(sc.nextLine());
        System.out.print("Teléfono: ");
        p.setTelefono(sc.nextLine());
        System.out.print("Correo electrónico: ");
        p.setCorreoE(sc.nextLine());

        contactos = Arrays.copyOf(contactos, contactos.length + 1);
        contactos[contactos.length - 1] = p;
    }

    static public void listarContactos(){
        for(int i = 0; i < contactos.length; i++){
            System.out.println(i+1 + " - " + contactos[i]);
        }
    }
    
    static public void eliminarContacto(){
        // PENDIENTE DE REVISAR!!!!!!!
        Scanner sc = new Scanner(System.in);

        System.out.print("Índice de contacto a eliminar? ");
        int indice = sc.nextInt();

        if (indice < 1 || indice > contactos.length)
            System.out.println("Ese contacto no existe.");
        else {        
            Persona[] aux = new Persona[contactos.length - 1];            
            for (int i = 0; i < contactos.length; i++){
                if(i != indice - 1)
                    aux[i] = contactos[i];
            }
            contactos = aux;
        }

    }

}
