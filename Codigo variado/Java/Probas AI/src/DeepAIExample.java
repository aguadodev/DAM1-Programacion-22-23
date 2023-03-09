import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

// Requiere una API-KEY de pago

public class DeepAIExample {

    public static void main(String[] args) throws IOException {
        
        // Define los parámetros para la solicitud a la API
        String text = "Un hermoso paisaje natural";
        String apiKey = "API-KEY";
        String apiUrl = "https://api.deepai.org/api/text2img";
        String parameters = "text=" + URLEncoder.encode(text, "UTF-8");
        
        // Realiza la solicitud a la API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(30000); // Establece el tiempo de espera en 10 segundos
        connection.setReadTimeout(30000); // Establece el tiempo de espera de lectura en 30 segundos

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("api-key", apiKey);
        connection.setDoOutput(true);
        connection.getOutputStream().write(parameters.getBytes());
        
        // Procesa la respuesta de la API y almacena la imagen en disco
        InputStream in = connection.getInputStream();
        FileOutputStream out = new FileOutputStream("paisaje.jpg");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
        
        System.out.println("La imagen fue generada y almacenada en disco.");
    }
}