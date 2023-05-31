package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Usuario;

/**
 * usuarioController
 */
public class PerfilUsuarioController implements Initializable {


    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passPasswordField;
    @FXML
    private Label createdAtLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameTextField.setText(App.usuario.getUsername());
        createdAtLabel.setText(App.usuario.getCreatedAt().toString());
    }

    @FXML
    void actualizar() {
        if ("".equals(usernameTextField.getText()) ||
                "".equals(passPasswordField.getText())) {
            System.out.println("Los campos de registro no pueden estar vacíos");
        } else {
            //App.cargarUsuarios();

            //...
            
        }

    }

    @FXML
    void borrar() {
        Usuario usuario = new Usuario(
                usernameTextField.getText(),
                passPasswordField.getText());
    }



    @FXML
    void cerrar() {
        System.exit(0); // Cerrar la aplicación
    }

    @FXML
    void acercaDe() {
        /** CUADRO DE DIÁLOGO CON Alert */
        /*
         * Alert alert = new Alert(AlertType.INFORMATION,
         * "Gestor de usuarios desarrollado en clase de Programación de DAM1. Curso 2022-23"
         * );
         * alert.showAndWait();
         */

        Dialog dialog = new Dialog();
        dialog.setTitle("Acerca de...");
        dialog.setContentText("Gestor de usuarios desarrollado en clase de Programación de DAM1. Curso 2022-23");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();

    }

}