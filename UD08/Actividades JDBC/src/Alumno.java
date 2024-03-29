import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private int num;
    private String nombre;
    private LocalDate fnac;
    private double media;
    private String curso;

    @Override
    public String toString() {
        return "Alumno [num=" + num + ", nombre=" + nombre + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + num;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (num != other.num)
            return false;
        return true;
    }

    public Alumno(int num, String nombre, LocalDate fnac, double media, String curso) {
        this.num = num;
        this.nombre = nombre;
        this.fnac = fnac;
        this.media = media;
        this.curso = curso;
    }

    public Alumno(int num, String nombre, String fnac, double media, String curso) {
        this(num, nombre, LocalDate.parse(fnac), media, curso);
    }

    
    public Alumno(int num) {
        this.num = num;
    }

    public Alumno() {
    }






    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    
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

    public void create() {
        Connection c = conexion();

        String sql = "INSERT INTO Alumnos VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(1, num);
            sentencia.setString(2, nombre);
            sentencia.setDate(3, Date.valueOf(fnac));
            sentencia.setDouble(4, media);
            sentencia.setString(5, curso);

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

    public void read() {
        Connection c = conexion();

        String sql = "SELECT * FROM Alumnos WHERE num = ?";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(1, num);

            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                nombre = rs.getString(2);
                fnac = rs.getDate("fnac").toLocalDate();
                media = rs.getDouble(4);
                curso = rs.getString("curso");
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

    }

    public void update() {
        Connection c = conexion();

        String sql = "UPDATE Alumnos SET nombre=?, fnac=?, media=?, curso=? WHERE num=?";

        try {
            PreparedStatement sentencia = c.prepareStatement(sql);
            sentencia.setInt(5, num);
            sentencia.setString(1, nombre);
            sentencia.setDate(2, Date.valueOf(fnac));
            sentencia.setDouble(3, media);
            sentencia.setString(4, curso);

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

    public void delete() {
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
