package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Personaje;

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
        "Fuerza: " + p.getFuerza() + "\n" +
        "Agilidad: " + p.getAgilidad() + "\n" +
        "Constitución: " + p.getConstitucion() + "\n" +
        "Puntos de Vida: " + p.getPuntosVida() + "\n" +
        "Puntos de Experiencia: " + p.getExperiencia() + "\n" +
        "Nivel: " + p.getNivel() + "\n"
        );        

        cmbRaza.getItems().addAll(Personaje.Raza.values());
    }

    public void crearPersonaje() {
        p.setNombre(txtNombre.getText());
        p.setRaza(cmbRaza.getValue());
        p.mostrar();

     }
    


}
