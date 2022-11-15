
/*
 * Leer JSON desde URL (Ejemplo con OpenFoodFacts)
 *
 * Basado en: https://www.baeldung.com/java-read-json-from-url
 * 
 */
package Proyectos.Java;
import java.io.*;
import java.net.*;
//import org.json.JSONObject;


public class ReadJsonFromUrl {
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


    public static void main(String[] args){
        try {
            String json = stream(new URL("https://world.openfoodfacts.org/api/v0/product/8424523060914.json"));
            System.out.println(json);
        } catch (Exception e){

        }
        
    }
}
