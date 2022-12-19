import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.html.parser.Entity;

import com.google.gson.Gson;

public class Agenda {
    static Persona[] contactos = new Persona[0];
    public static void main(String[] args) throws Exception {

        // Importa la agenda de disco si existe.
        importarAgenda();

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
                case 4: vaciarAgenda(); break;
                case 5: buscarContacto(); break;
                case 6: importarAgenda(); break;
                case 7: exportarAgenda(); break;
                case 0: exportarAgenda(); break;
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
        System.out.println("6. Importar");
        System.out.println("7. Exportar");
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
            System.arraycopy(contactos, 0, aux, 0, indice - 1);                      
            System.arraycopy(contactos, indice, aux, indice-1, contactos.length - indice);                      
            /*for (int i = 0; i < contactos.length; i++){
                if(i < indice - 1)
                    aux[i] = contactos[i];
                else if (i > indice - 1){
                    aux[i-1] = contactos[i];
                }*/
            contactos = aux;
            }
            
        }

        static void vaciarAgenda(){
            contactos = new Persona[0];
        }


        static void buscarContacto(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre a buscar: ");
            String nombre = sc.nextLine();

            boolean encontrado = false;
            
            for(int i = 0; i < contactos.length; i++){
                if(nombre.equalsIgnoreCase(contactos[i].getNombre())){
                    System.out.println(contactos[i]);
                    encontrado = true;
                }
                    
            }

            if(!encontrado)
                System.out.println("No existe en la agenda nadie con el nombre de \"" + nombre + "\".");
        }


        static void exportarAgenda(){
            // 1. Generar String JSON a partir del contenido de la agenda.
            Gson gson = new Gson();
            String json = gson.toJson(contactos);

            System.out.println(json);
            // 2. Escribe el string en un fichero de texto
            writeStringToFile(json, "agenda.json");
        }

        static void importarAgenda(){
            // 1. Leer el fichero de texto agenda.json a un String
            String json = readFileToString("agenda.json");

            // 2. Cargar el contenido del String/Json en el array de personas.
            Gson gson = new Gson();
            contactos = gson.fromJson(json, Persona[].class);
        }



    /**
     * Crea un fichero de texto con el contenido de un String (fuente OpenAI)
     * @param str
     * @param filePath
     */
    public static void writeStringToFile(String str, String filePath) {
        try {
          // Creamos un objeto FileWriter que nos permitirá escribir en el fichero
          FileWriter writer = new FileWriter(filePath);
    
          // Escribimos el String en el fichero
          writer.write(str);
    
          // Cerramos el fichero
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
    /**
     * Lee y carga el contenido de un fichero de texto a un String (fuente OpenAI)
     * @param filePath
     * @return
     */
    public static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            // Creamos un objeto FileReader que nos permitirá leer el fichero
            FileReader reader = new FileReader(filePath);
        
            // Creamos un buffer para leer el fichero de forma más eficiente
            BufferedReader buffer = new BufferedReader(reader);
        
            // Leemos el fichero línea a línea
            String line;
            while ((line = buffer.readLine()) != null) {
                // Vamos añadiendo cada línea al StringBuilder
                fileContent.append(line);
                // Añadimos un salto de línea al final de cada línea
                fileContent.append("\n");
            }
        
            // Cerramos el buffer y el fichero
            buffer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
            //e.printStackTrace();
        }
    
        // Devolvemos el contenido del fichero como un String
        return fileContent.toString();
    }

    }


