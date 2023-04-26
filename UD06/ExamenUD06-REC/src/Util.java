import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONArray;

//import com.google.gson.Gson;

public class Util {
    /**
     * Exporta el personaje p a un fichero "personaje.json"
     * @param t
     */
   /* static public void exportarJson(Personaje p){
        final String filename = "personaje.json";
        Gson gson = new Gson();

        String json = gson.toJson(p);
        writeStringToFile(json, filename);
        System.out.printf("Se ha generado el fichero %s con el siguiente contenido: %n %s %n", filename, json);
    }*/

    /**
     * Devuelve un array de Personas cargado desde "agenda.json" o null si hay problemas
     * @return
     */
    /*static public Personaje importarJson(){
        final String filename = "personaje.json";
        Gson gson = new Gson();
        Personaje p;
        
        String json = readFileToString(filename);
        p = gson.fromJson(json, Personaje.class);

        return p;
    }*/

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


    public static String stream(URL url) {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (Exception e){
            return "";
        }
    }    

    public static String urlRutaCoche(double latitudInicio, double longitudInicio, double latitudFin, double longitudFin){
        return "https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route="
                + latitudInicio + "," + longitudInicio + ";"
                + latitudFin + "," + longitudFin;
    }
    
    
    public static double distanciaCoche(double latitudInicio, double longitudInicio, double latitudFin, double longitudFin){
        double distancia;
        String tipoRuta = "driving";
        String url = "https://router.project-osrm.org/route/v1/"+ tipoRuta + "/"
                  + longitudInicio + "," + latitudInicio + ";"
                  + longitudFin + "," + latitudFin + "?overview=false";
        System.out.println("URL: " + url);
        System.out.println(urlRutaCoche(latitudInicio, longitudInicio, latitudFin, longitudFin));
        try {
           String json = stream(new URL(url));
           JSONObject objeto = new JSONObject(json);
           JSONArray array = objeto.getJSONArray("routes");
           objeto = array.getJSONObject(0);
           distancia = objeto.getDouble("distance");
           
        } catch (Exception e){
           distancia = -1;
        }
        return distancia;
    }

    public static String urlDireccionJson(String direccion){
        return "https://nominatim.openstreetmap.org/search?q="
                + direccion.replace(" ", "+")
                + "&format=geojson";
    }
    
    public static String urlDireccionOsm(String direccion){
        return "https://nominatim.openstreetmap.org/search?q="
                + direccion.replace(" ", "+");
    }

}
