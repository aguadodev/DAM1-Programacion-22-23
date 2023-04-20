package controller;
import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController {
    @FXML
    Button btnComenzar;
    
    @FXML
    public void comenzar(Event e) throws IOException{
        System.out.println("Comenzar");
        Parent root = FXMLLoader.load(getClass().getResource("../view/personaje.fxml"));
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setTitle("Crear Personaje");
        source.getScene().setRoot(root);
    }    
}
