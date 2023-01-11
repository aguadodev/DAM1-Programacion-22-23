import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Paraninfo615 {
    public static void main(String[] args) {
        System.out.println("\nGENERADOR DE PÁGINAS WEB");
        System.out.println("========================\n");

        // Leer datos de consola
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el título de la página web:");
        String titulo = sc.nextLine();
        System.out.println("Escribe el contenido:");
        String contenido = sc.nextLine();

        String html = 
        "\n<html>" + 
        "\n<head>" +
        "\n\t<title>" + titulo + "</title>" +
        "\n</head>" + 
        "\n<body>" +
        "\n\t<h1>" + titulo + "</h1>" +
        "\n\t<p>" + contenido + "</p>" +
        "\n</body>" +
        "\n</html>";

        // Genera el código HTML
        System.out.println(html);
        
        // Genera un fichero HTML con el código
        writeStringToFile(html, "index.html");

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
    
}
