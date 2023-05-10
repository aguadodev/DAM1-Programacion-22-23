package controller;

import app.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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

            // Crea un usuario con los datos de los campos de texto
            Usuario usuario = new Usuario(
                    userRegistroTextField.getText(),
                    passRegistroTextField.getText());

            App.cargarUsuarios();

            if ("admin".equals(userRegistroTextField.getText()) || App.usuarios.contains(usuario)) {
                System.out.println("El usuario ya existe");
            } else {
                App.usuarios.add(usuario);
                App.guardarUsuarios();
            }
        }
    }



    @FXML
    void iniciarSesion() {
        if ("".equals(userLoginTextField.getText()) ||
                "".equals(passLoginTextField.getText())) {
            System.out.println("Los campos de login no pueden estar vacíos");
        } else {
            // Crea un usuario con los datos de los campos de texto
            Usuario usuario = new Usuario(
                    userLoginTextField.getText(),
                    passLoginTextField.getText());

            App.cargarUsuarios();
            
            
            if (App.usuarios.contains(usuario)) {
                int i = App.usuarios.indexOf(usuario);
                if (App.usuarios.get(i).getPassword().equals(usuario.getPassword())) {
                    System.out.println("Login OK!!");
                    App.usuario = App.usuarios.get(i);
                } else {
                    System.out.println("ERROR DE PASSWORD");
                }
            } else if ("admin".equals(userLoginTextField.getText()) && "abc123.,".equals(passLoginTextField.getText())){
                // Inicio sesión con ADMIN por defecto
                System.out.println("Inicio sesión con ADMIN por defecto");
                App.usuario = new Usuario("admin", "abc123.,");
            } else {
                System.out.println("USUARIOS INCORRECTO");
            }  
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