import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AlumnosController {
    @FXML
    TextField nombreTextField, mediaTextField, cursoTextField;
    @FXML
    DatePicker fnacDatePicker;

    @FXML
    void insertar(ActionEvent event) throws SQLException {
        String url = "jdbc:mysql://localhost/Instituto";
        Connection con = DriverManager.getConnection(url, "pepe", "abc123.,");

        String sql = "INSERT INTO Alumnos (nombre, fnac, media, curso) VALUES ('" 
        + nombreTextField.getText() + "', '" 
        + fnacDatePicker.getValue() + "', " 
        + mediaTextField.getText() + ", '" 
        + cursoTextField.getText() + "')";

        System.out.println(sql);

        Statement sentencia = con.createStatement();

        sentencia.executeUpdate(sql);

        sentencia.close();

        con.close();
    }
}
