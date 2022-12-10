import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;

public class App {
    static Persona[] agenda = new Persona[0];
    public static void main(String[] args) throws Exception {
        System.out.println("\nAGENDA DE CONTACTOS");
        System.out.println("===================\n");

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            imprimirMenu();
            opcion = sc.nextInt();

            switch(opcion){
                case 1: System.out.println(Arrays.toString(agenda)); break;
                case 2: agenda = nuevaPersona(agenda); break;
                case 3: exportarJson(agenda); break;
                case 4: agenda = importarJson(); break;
            }
        } while (opcion != 0);

    }

    /**
     * 
     */
    static public void imprimirMenu(){
        System.out.println("1. Listar contactos (" + agenda.length + ")");
        System.out.println("2. Añadir Persona");
        System.out.println("3. Exportar JSON");
        System.out.println("4. Importar JSON (\"agenda.json\" debe existir en el directorio de la aplicación)");
        System.out.println("0. SALIR");
    }

    /**
     * 
     * @param t
     */
    static Persona[] nuevaPersona(Persona[] t){
        Persona p = new Persona();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre? ");
        p.setNombre(sc.nextLine());

        System.out.println("Apellidos? ");
        p.setApellidos(sc.nextLine());

        // Etc.. con el resto de los campos

        // Añade la persona al final de la agenda
        t = Arrays.copyOf(t, t.length + 1);
        t[t.length - 1] = p;
        return t;
    }

    /**
     * Exporta el contenido de la agenda al fichero "agenda.json"
     * @param t
     */
    static public void exportarJson(Persona[] t){
        final String filename = "agenda.json";
        Gson gson = new Gson();

        String json = gson.toJson(t);
        writeStringToFile(json, filename);
        System.out.printf("Se ha generado el fichero %s con el siguiente contenido: %n %s %n", filename, json);
    }

    /**
     * Devuelve un array de Personas cargado desde "agenda.json" o null si hay problemas
     * @return
     */
    static public Persona[] importarJson(){
        final String filename = "agenda.json";
        Gson gson = new Gson();
        Persona[] p;
        
        String json = readFileToString(filename);
        p = gson.fromJson(json, Persona[].class);
        if (p == null)
            p = new Persona[0];

        return p;
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
