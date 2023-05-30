package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Usuario;

/**
 * usuarioController
 */
public class InicioController implements Initializable {

    @FXML
    ListView<Usuario> usuariosListView;

    @FXML
    TextField userLoginTextField, passLoginTextField, userRegistroTextField, passRegistroTextField;

    File ficheroActual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void registrarse() {
        if ("".equals(userRegistroTextField.getText()) ||
                "".equals(passRegistroTextField.getText())) {
            System.out.println("Los campos de registro no pueden estar vacíos");
        } else {
            UsuarioDAO uDAO = new UsuarioDAO();
            uDAO.crearUsuario(new Usuario(userRegistroTextField.getText(), passRegistroTextField.getText()));

        }
    }



    @FXML
    void iniciarSesion() {
        if ("".equals(userLoginTextField.getText()) ||
                "".equals(passLoginTextField.getText())) {
            System.out.println("Los campos de login no pueden estar vacíos");
        } else {
            UsuarioDAO uDAO = new UsuarioDAO();
            Usuario usuario = uDAO.obtenerUsuario(userLoginTextField.getText());
            if (usuario.getPassword().equals(passLoginTextField.getText())) {
                    System.out.println("Login OK!!");
                    // TODO Actualizar lastLogin
                    // TODO Log de accesos OK
                    App.usuario = usuario;
                    // TODO Cambiar vista
                } else {
                    System.out.println("ERROR DE PASSWORD");
                    // TODO Log de accesos OK
                    // TODO Mostrar mensaje de error
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

}