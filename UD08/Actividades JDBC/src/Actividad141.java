import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad141 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://" + Conexion.HOST + "/" + Conexion.DATABASE;

        try {
            Connection con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);

            Statement sentencia = con.createStatement();

            String curso = "15";

            String sql = "UPDATE Alumnos SET media = media + 1 WHERE curso = " + curso;

            int n = sentencia.executeUpdate(sql);
            System.out.println(n);

            con.close();

            System.out.println("Se ha modificado la nota media.");

        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
        }
    }
}
