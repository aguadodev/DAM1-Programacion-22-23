package controller;

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
public class UsuarioController implements Initializable {

    @FXML
    ListView<Usuario> usuariosListView;

    @FXML
    TextField idTextField, usernameTextField, passwordTextField;

    File ficheroActual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usuariosListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> userSelected(newSelection));

    }

    // Muestra los datos de la usuario en el formulario
    private void userSelected(Usuario e) {
        System.out.println(e);
        usernameTextField.setText(e.getUsername());
        passwordTextField.setText(e.getPassword());

    }

    @FXML
    void agregar() {
        // Crea una usuario con los datos de los campos de texto
        Usuario usuario = new Usuario(
                usernameTextField.getText(),
                passwordTextField.getText());

        if (usuariosListView.getItems().contains(usuario)) {
            // La usuario ya existe
            Alert alert = new Alert(AlertType.ERROR, "Ya existe un usuario con ese username");
            alert.showAndWait();
        } else {
            usuariosListView.getItems().add(usuario);
        }

    }

    @FXML
    void actualizar() {
        Usuario usuario = new Usuario(
                usernameTextField.getText(),
                passwordTextField.getText());

        int i = usuariosListView.getItems().indexOf(usuario);
        if (i == -1) {
            // La usuario no existe
            Alert alert = new Alert(AlertType.ERROR, "No existe una usuario con ese username");
            alert.showAndWait();
        } else {
            usuariosListView.getItems().set(i, usuario);
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
    void guardar() {
        if (ficheroActual != null) {
            /* Ya estoy trabajando con un fichero */
            /* Guardo la lista en el fichero */
            System.out.println("Guardar fichero");
            guardarFichero(ficheroActual);

        } else {
            guardarComo();
        }
    }

    @FXML
    void guardarComo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        // fileChooser.setSelectedExtensionFilter());

        File fichero = fileChooser.showSaveDialog(null);
        // Guardar en este fichero la lista de usuarios en formato CSV
        System.out.println(fichero);
        guardarFichero(fichero);
    }

    @FXML
    void exportarCsv() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        // fileChooser.setSelectedExtensionFilter());

        File fichero = fileChooser.showSaveDialog(null);
        // Guardar en este fichero la lista de usuarios en formato CSV
        try (BufferedWriter ficheroSalida = new BufferedWriter(new FileWriter(fichero))) {
            for (Usuario usuario : usuariosListView.getItems()) {
                ficheroSalida.write(usuario.toCsv());
                ficheroSalida.newLine();
            }
        } catch (IOException e1) {
            e1.getMessage();
        }
    }

    private void guardarFichero(File fichero) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
            ficheroActual = fichero; // Actualiza la referencia al fichero de trabajo actual

            Usuario[] t = (Usuario[]) usuariosListView.getItems().toArray();
            out.writeObject(t);

        } catch (IOException e1) {
            e1.getMessage();
        }
    }

    @FXML
    void abrir() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        // fileChooser.setSelectedExtensionFilter());

        File fichero = fileChooser.showOpenDialog(null);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero))) {
            ficheroActual = fichero; // Actualiza la referencia al fichero de trabajo actual
            usuariosListView.getItems().clear();

            Usuario[] t = (Usuario[]) in.readObject();
            usuariosListView.getItems().addAll(t);

        } catch (Exception e1) {
            e1.getMessage();
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