package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import app.App;
import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Usuario;

/**
 * usuarioController
 */
public class InicioController implements Initializable {
    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passPasswordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void registrarse() {
        if ("".equals(userTextField.getText()) ||
                "".equals(passPasswordField.getText())) {
                    alert(AlertType.ERROR,"Los campos de login no pueden estar vacíos");
        } else {
            UsuarioDAO uDAO = new UsuarioDAO();
            if (uDAO.crearUsuario(new Usuario(userTextField.getText(), passPasswordField.getText()))){
                alert(AlertType.CONFIRMATION,"El usuario se ha creado correctamente");
            } else {
                alert(AlertType.ERROR,"Error al crear el usaurio"); // El usuario ya existe
            }
        }
    }


    @FXML
    void iniciarSesion() throws IOException {
        if ("".equals(userTextField.getText()) ||
                "".equals(passPasswordField.getText())) {
                    alert(AlertType.ERROR,"Los campos de login no pueden estar vacíos");
        } else {
            UsuarioDAO uDAO = new UsuarioDAO();
            Usuario usuario = uDAO.obtenerUsuario(userTextField.getText());
            if (usuario != null && usuario.getPassword().equals(passPasswordField.getText())) {
                    System.out.println("Login OK!!");
                    // Actualizar lastLogin
                    usuario.setLastLogin(LocalDateTime.now());
                    uDAO.actualizarUsuario(usuario);
                    // TODO Log de accesos OK
                    App.usuario = usuario;
                    // Cambiar vista
                    App.stage.setTitle("App - Actividades");
                    App.stage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/view/Actividades.fxml"))));
                } else {
                    System.out.println("ERROR DE ACCESO");
                    // TODO Log de accesos OK
                    // Mostrar mensaje de error
                    alert(AlertType.ERROR,"ERROR DE ACCESO");
                }
            } 
            // TODO Acceso "admin"??
            /*else if ("admin".equals(userLoginTextField.getText()) && "abc123.,".equals(passLoginTextField.getText())){
                // Inicio sesión con ADMIN por defecto
                System.out.println("Inicio sesión con ADMIN por defecto");
                App.usuario = new Usuario("admin", "abc123.,");
            } else {
                System.out.println("USUARIOS INCORRECTO");
            }  */
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
        dialog.setContentText("Aplicación desarrollada en clase de Programación de DAM1. Curso 2022-23");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();

    }

    private void alert(AlertType alertType, String str) {
    Alert alert = new Alert(alertType, str);
    alert.showAndWait();
}
}