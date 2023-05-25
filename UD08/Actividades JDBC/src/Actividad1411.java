import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javafx.collections.ObservableList;

public class Actividad1411 {
    public static void main(String[] args) {

        
        // Ejemplo de alumno.create()
            System.out.print("Número de alumno: ");
            int num = new Scanner(System.in).nextInt();

            System.out.print("Nombre: ");
            String nombre = new Scanner(System.in).nextLine();

            System.out.print("Fecha de nacimiento (aaaa-mm-dd):");
            String fnac = new Scanner(System.in).nextLine();

            System.out.print("Media: ");
            Double media;
            media = new Scanner(System.in).useLocale(Locale.US).nextDouble();

            System.out.print("Curso: ");
            String curso = new Scanner(System.in).nextLine();

            Alumno alumno = new Alumno(num, nombre, fnac, media, curso);


            AlumnoDAO.create(alumno);
            

            
            // Ejemplo alumno.read()
            Alumno alumno2 = AlumnoDAO.read(3);
            System.out.println(alumno2);

            // Ejemplo alumno.update()
            alumno2.setNombre("Pedro Gómez Ramírez");
            alumno2.setMedia(9);
            AlumnoDAO.update(alumno2);

            // Ejemplo alumno.delete()
            AlumnoDAO.delete(3); 
            
            
            // Ejemplo de Alumno.findAll()
            List<Alumno> alumnos = AlumnoDAO.findAll();
            
            System.out.println(alumnos);

    }
}
