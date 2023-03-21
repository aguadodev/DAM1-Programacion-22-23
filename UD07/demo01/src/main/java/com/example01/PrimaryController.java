package com.example01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PrimaryController implements Initializable{
    @FXML
    private VBox frmPrimary;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void paintInBlue() {
        // crear un objeto Background con el color deseado
        Background background = new Background(new BackgroundFill(Color.BLUE, null, null));
        // asignar el background al contenedor raíz
        frmPrimary.setBackground(background);
    }
    @FXML
    private void paintInRed() {
        // crear un objeto Background con el color deseado
        Background background = new Background(new BackgroundFill(Color.RED, null, null));
        // asignar el background al contenedor raíz
        frmPrimary.setBackground(background);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }    
}
