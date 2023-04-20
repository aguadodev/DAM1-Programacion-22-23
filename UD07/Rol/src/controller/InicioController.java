package controller;

import java.io.IOException;
import java.net.MalformedURLException;

import app.App;

public class InicioController {
    public void comenzar() {
        // cambiar escena
        try {
            App.cargarEscena("CrearPersonaje.fxml");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
