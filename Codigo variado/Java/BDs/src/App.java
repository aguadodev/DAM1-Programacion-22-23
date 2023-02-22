/**
 * Descargar librería con conector .jar a MariaDB desde:
 * https://mariadb.com/docs/skysql/connect/programming-languages/java/install/
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("BDs - Conexión y SELECT");
        Connection con;
        Statement sentencia;
        ResultSet rs;

        String url = "jdbc:mariadb://192.168.0.10:49153/bacharelato";
        try {
            con = DriverManager.getConnection(url, "bacharelato", "bac123.,");
            sentencia = con.createStatement();
            rs = sentencia.executeQuery("SELECT * FROM grao");
            System.out.println("Lista de Graos:");
            while(rs.next()){
                System.out.println("- " + rs.getString("nome"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
