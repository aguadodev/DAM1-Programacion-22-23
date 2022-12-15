/* OBTENER DATOS JSON DE SERVICIOS WEB COMO 
 * - OpenFoodFacts
 * - Open Street Maps
 * - INE: https://www.ine.es/dyngs/DataLab/manual.html?cid=66
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author cosme
 */
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



    public static void ejemploOpenFoodFacts(){
        try {
            // Obtiene el JSON a partir de la URL de la API que incluye el código de barras
            String json = stream(new URL("https://world.openfoodfacts.org/api/v0/product/8424523060914.json"));
            System.out.println("JSON COMPLETO: " + json);
            
            // Obtiene y muestra algunos campos del JSON
            JSONObject objeto = new JSONObject(json);            
            String codigo = objeto.getString("code");
            System.out.println("Código: " + codigo);            
            JSONArray keywords = objeto.getJSONObject("product").getJSONArray("_keywords");
            String marca = objeto.getJSONObject("product").getString("brands");
            String nombre = objeto.getJSONObject("product").getString("generic_name_es");
            System.out.println(nombre + ". Marca: " + marca);
            System.out.println("Palabras clave: " + keywords);
        } catch (Exception e){

        }
        Scanner sc = new Scanner(System.in);
        sc.nextLine();                
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
    
    public static void main(String[] args) throws MalformedURLException{
        String urlConsola; 

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una URL: ");
        urlConsola = sc.nextLine();
        System.out.println(stream(new URL(urlConsola)));


        double latitud_inicio = 42.428181;
        double longitud_inicio = -8.634701;
        double latitud_fin = 42.389456;
        double longitud_fin = -8.710098;

        double distancia = distanciaCoche(latitud_inicio, longitud_inicio, latitud_fin, longitud_fin);
        System.out.println("Distancia: " + distancia + " metros.");
        System.out.println("URL WEB: " + urlRutaCoche(latitud_inicio, longitud_inicio, latitud_fin, longitud_fin));

        String direccion = "Praza Ponte Bolera, 1 Pontevedra"; // Añadir Ponte Boleira
        System.out.println(direccion + ": " + urlDireccionJson(direccion));
        System.out.println(direccion + ": " + urlDireccionOsm(direccion));
    }    
}
