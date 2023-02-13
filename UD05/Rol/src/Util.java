public class Util {
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
