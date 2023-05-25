import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
        /*
     * MÉTODOS DE CONEXIÓN CON LA BD
     */

     static private Connection conexion() {
        Connection c = null;
        String url = "jdbc:mysql://" + Conexion.HOST + "/" + Conexion.DATABASE;

        try {
            c = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);

        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BD");
        }
        return c;
    }

    public static void create(Alumno alumno) {
        Connection c = conexion();

        String sql = "INSERT INTO Alumnos VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(1, alumno.getNum());
            sentencia.setString(2, alumno.getNombre());
            sentencia.setDate(3, Date.valueOf(alumno.getFnac()));
            sentencia.setDouble(4, alumno.getMedia());
            sentencia.setString(5, alumno.getCurso());

            if (sentencia.executeUpdate() > 0) {
                System.out.println("Se ha insertado un registro");
            } else {
                System.out.println("No se han insertado registros");
            }

            sentencia.close();
            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Alumno read(int num) {
        Alumno alumno = null;
        Connection c = conexion();

        String sql = "SELECT * FROM Alumnos WHERE num = ?";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(1, num);

            ResultSet rs = sentencia.executeQuery();


            if (rs.next()) {
                alumno = new Alumno(
                    num, 
                    rs.getString(2),
                    rs.getDate("fnac").toLocalDate(),
                    rs.getDouble(4),
                    rs.getString("curso"));

                System.out.println("Se ha obtenido un registro");
            } else {
                System.out.println("No se han obtenido registros");
            }

            sentencia.close();
            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return alumno;
    }

    public static void update(Alumno alumno) {
        Connection c = conexion();

        String sql = "UPDATE Alumnos SET nombre=?, fnac=?, media=?, curso=? WHERE num=?";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(5, alumno.getNum());
            sentencia.setString(1, alumno.getNombre());
            sentencia.setDate(2, Date.valueOf(alumno.getFnac()));
            sentencia.setDouble(3, alumno.getMedia());
            sentencia.setString(4, alumno.getCurso());

            if (sentencia.executeUpdate() > 0) {
                System.out.println("Se ha modificado un registro");
            } else {
                System.out.println("No se han modificado registros");
            }

            sentencia.close();
            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

    public static void delete(int num) {
        Connection c = conexion();

        String sql = "DELETE FROM Alumnos WHERE num=?";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(1, num);

            if (sentencia.executeUpdate() > 0) {
                System.out.println("Se ha borrado un registro");
            } else {
                System.out.println("No se han borrado registros");
            }

            sentencia.close();
            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }          
    }

    public static List<Alumno> findAll() {
        List<Alumno> alumnos = null;
        
        Connection c = conexion();

        String sql = "SELECT * FROM Alumnos ORDER BY nombre";

        try {
            alumnos = new ArrayList<>();
            PreparedStatement sentencia = c.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
                alumnos.add(new Alumno(
                    rs.getInt("num"),
                    rs.getString("nombre"),
                    rs.getDate("fnac").toLocalDate(),
                    rs.getDouble("media"),
                    rs.getString("curso")
                ));
            }

            sentencia.close();
            c.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
        
        return alumnos;
    }
}
