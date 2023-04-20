package controller;

import java.io.IOException;

import app.App;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class InicioController {

    private Application miAplicacion;
    
    public void comenzar(Event e) throws IOException{

        /** MÉTODO 2: Invocar un método estático en la clase App */
        App.cargarFXML("CrearPersonaje");

        /** MÉTODO 1 */
        /* Parent root = FXMLLoader.load(getClass().getResource("../view/CrearPersonaje.fxml"));
        Scene scene = ((Node) e.getSource()).getScene();
        scene.setRoot(root);
        scene.getWindow().sizeToScene();*/
    }
}
