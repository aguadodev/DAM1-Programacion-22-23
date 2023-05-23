import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

public class Actividad142 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://" + Conexion.HOST + "/" + Conexion.DATABASE;

        try {
            Connection con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);

            Statement sentencia = con.createStatement();

            System.out.println("Número de alumno: ");

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

            // Construimos la sentencia INSERT
            String sql = "INSERT INTO Alumnos (num, nombre, fnac, media, curso) " +
                    "VALUES (" + num + ", " + nombre + ", " + fnac + ", " + media + ", " + curso + ")";
            
            System.out.println(sql);

            sentencia.executeUpdate(sql);

            con.close();
            
            System.out.println("Se ha insertado el nuevo alumno.");

        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
        }
    }
}
