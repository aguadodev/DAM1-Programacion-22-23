package controller;
import java.io.IOException;

import app.App;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonajeController {
    
    @FXML
    public void saltar(Event e) throws IOException{
        System.out.println("Saltar");
        App.cargarEscena("Tienda - Comprar y vender", new Scene(FXMLLoader.load(getClass().getResource("../view/tienda.fxml"))));
    }    
    @FXML
    public void crear(Event e) throws IOException{
        System.out.println("Crear");
       /*  Parent root = FXMLLoader.load(getClass().getResource("view/personaje.fxml"));
        Node source = (Node) e.getSource();
        source.getScene().setRoot(root);*/
    }    
}
