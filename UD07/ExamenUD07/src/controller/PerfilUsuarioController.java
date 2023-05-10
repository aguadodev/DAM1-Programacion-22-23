package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Usuario;

/**
 * usuarioController
 */
public class PerfilUsuarioController implements Initializable {

    @FXML
    ListView<Usuario> usuariosListView;

    @FXML
    TextField usernameTextField, passwordTextField;

    @FXML
    Label fechaHoraAltaLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameTextField.setText(App.usuario.getUsername());
        fechaHoraAltaLabel.setText(App.usuario.getFechaHoraRegistro().toString());
    }

    @FXML
    void actualizar() {
        if ("".equals(usernameTextField.getText()) ||
                "".equals(passwordTextField.getText())) {
            System.out.println("Los campos de registro no pueden estar vacíos");
        } else {
            App.cargarUsuarios();

            //...
            
        }

    }

    @FXML
    void borrar() {
        Usuario usuario = new Usuario(
                usernameTextField.getText(),
                passwordTextField.getText());

        int i = usuariosListView.getItems().indexOf(usuario);
        if (i == -1) {
            // La usuario no existe
            Alert alert = new Alert(AlertType.ERROR, "No existe una usuario con ese username");
            alert.showAndWait();
        } else {
            usuariosListView.getItems().remove(i);
        }
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