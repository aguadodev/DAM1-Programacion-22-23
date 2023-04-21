package controller;
import java.io.IOException;

import app.App;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class TiendaController {
    
    @FXML
    public void saltar(Event e) throws IOException{
        System.out.println("Saltar");
        App.cargarEscena("Juego Principal", new Scene(FXMLLoader.load(getClass().getResource("../view/juego.fxml"))));
        /*Parent root = FXMLLoader.load(getClass().getResource("view/personaje.fxml"));
        Node source = (Node) e.getSource();
        source.getScene().setRoot(root);*/
    }    
    @FXML
    public void comerciar(Event e) throws IOException{
        System.out.println("Comerciar");
       /*  Parent root = FXMLLoader.load(getClass().getResource("view/personaje.fxml"));
        Node source = (Node) e.getSource();
        source.getScene().setRoot(root);*/
    }    
}
