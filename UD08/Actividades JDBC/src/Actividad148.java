import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

public class Actividad148 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://" + Conexion.HOST + "/" + Conexion.DATABASE;

        try {
            Connection con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);


            System.out.print("Introduce el curso de alumnado para el listado: ");
            String curso = new Scanner(System.in).nextLine();

            // Construimos la sentencia SELECT
            String sql = "SELECT * FROM Alumnos WHERE curso = ?";

            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, curso);

            ResultSet rs = sentencia.executeQuery();

            System.out.println("Listado de alumnos: ");

            while (rs.next()){
                System.out.print(rs.getInt("num") + " - ");
                System.out.print(rs.getString("nombre") + " - ");
                System.out.print(rs.getDate("fnac") + " - ");
                System.out.print(rs.getDouble("media") + " - ");
                System.out.print(rs.getString("curso"));                
                System.out.println();
            }

            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
        }
    }
}



            /*
            int num = new Scanner(System.in).nextInt();

            System.out.println("Nombre: ");

            String nombre = new Scanner(System.in).nextLine();

            System.out.println("Fecha de nacimiento");

            String fnac = new Scanner(System.in).nextLine();

            System.out.println("Media: ");

            Double media;

            media = new Scanner(System.in).useLocale(Locale.US).nextDouble();

            System.out.println("Curso: ");

            String curso = new Scanner(System.in).nextLine();
*/