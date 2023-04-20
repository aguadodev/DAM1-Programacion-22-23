import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CrearPersonajeController implements Initializable{

    @FXML
    Label lblAtributos;
    
    @FXML
    ComboBox<Personaje.Raza> cmbRaza;

    @FXML
    TextField txtNombre;
    
    Personaje p;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p = new Personaje("Sin nombre", "HUMANO");

        lblAtributos.setText("Atributos Físicos del Personaje: \n" + 
        "Fuerza: " + p.fuerza + "\n" +
        "Agilidad: " + p.agilidad + "\n" +
        "Constitución: " + p.constitucion + "\n" +
        "Puntos de Vida: " + p.puntosVida + "\n" +
        "Puntos de Experiencia: " + p.experiencia + "\n" +
        "Nivel: " + p.nivel + "\n"
        );        

        cmbRaza.getItems().addAll(Personaje.Raza.values());
    }

    public void crearPersonaje() {
        p.nombre = txtNombre.getText();
        p.raza = cmbRaza.getValue();
        p.mostrar();

     }
    


}
