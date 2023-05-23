import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Actividad143 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://" + Conexion.HOST + "/" + Conexion.DATABASE;

        try {
            Connection con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);

            Statement sentencia = con.createStatement();


            System.out.print("Introduce el curso de alumnos que se borrarán: ");
            String curso = new Scanner(System.in).nextLine();

            String sql = "DELETE FROM Alumnos WHERE curso = " + curso;
            System.out.println(sql);
            int n = sentencia.executeUpdate(sql);
            System.out.println(n);

            con.close();

            System.out.println("Se han eliminado datos.");

        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
        }
    }
}
