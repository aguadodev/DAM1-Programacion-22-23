package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Persona;

/**
 * PersonaController
 */
public class PersonaController implements Initializable {

    @FXML
    ListView<Persona> personasListView;

    @FXML
    TextField dniTextField, nombreTextField, telefonoTextField, emailTextField;

    File ficheroActual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Cargar personas iniciales en el ListView

        personasListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> personaSeleccionada(newSelection));

    }

    // Muestra los datos de la persona en el formulario
    private void personaSeleccionada(Persona e) {
        System.out.println(e);
        dniTextField.setText(String.valueOf(e.getDni()));
        nombreTextField.setText(e.getNombre());
        telefonoTextField.setText(e.getTelefono());
        emailTextField.setText(e.getEmail());
    }

    @FXML
    void agregar() {
        // Crea una persona con los datos de los campos de texto
        Persona persona = new Persona(dniTextField.getText(),
                nombreTextField.getText(),
                telefonoTextField.getText(), 
                emailTextField.getText());

        if (personasListView.getItems().contains(persona)) {
            // La persona ya existe
            Alert alert = new Alert(AlertType.ERROR, "Ya existe una emprea con ese ID");
            alert.showAndWait();
        } else {
            personasListView.getItems().add(persona);
        }

    }

    @FXML
    void actualizar() {
        Persona persona = new Persona(dniTextField.getText(),
                nombreTextField.getText(),
                telefonoTextField.getText(), 
                emailTextField.getText());

        int i = personasListView.getItems().indexOf(persona);
        if (i == -1) {
            // La persona no existe
            Alert alert = new Alert(AlertType.ERROR, "No existe una emprea con ese ID");
            alert.showAndWait();
        } else {
            personasListView.getItems().set(i, persona);
        }
    }

    @FXML
    void borrar() {
        Persona persona = new Persona(dniTextField.getText(),
                nombreTextField.getText(),
                telefonoTextField.getText(), 
                emailTextField.getText());

        int i = personasListView.getItems().indexOf(persona);
        if (i == -1) {
            // La persona no existe
            Alert alert = new Alert(AlertType.ERROR, "No existe una emprea con ese ID");
            alert.showAndWait();
        } else {
            personasListView.getItems().remove(i);
        }
    }

    @FXML
    void guardar() {
        if (ficheroActual != null){
            /*Ya estoy trabajando con un fichero*/
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
        // Guardar en este fichero la lista de personas en formato CSV
        System.out.println(fichero);
        guardarFichero(fichero);
    }

    private void guardarFichero(File fichero) {
        try (BufferedWriter ficheroSalida = new BufferedWriter(new FileWriter(fichero))) {
            /*ficheroActual = fichero; // Actualiza la referencia al fichero de trabajo actual
            for (Persona persona : personasListView.getItems()) {
                ficheroSalida.write(persona.toCsv());
                ficheroSalida.newLine();
            }*/
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

        try (BufferedReader ficheroEntrada = new BufferedReader(new FileReader(fichero))) {
            /*ficheroActual = fichero;  // Actualiza la referencia al fichero de trabajo actual
            personasListView.getItems().clear();
            String linea = ficheroEntrada.readLine();
            while (linea != null){
                String[] campos = linea.split(",");
                Persona persona = new Persona(Integer.parseInt(campos[0]), campos[1], campos[2]);
                personasListView.getItems().add(persona);
                linea = ficheroEntrada.readLine();
            }*/
        } catch (IOException e1) {
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
         * "Gestor de personas desarrollado en clase de Programación de DAM1. Curso 2022-23"
         * );
         * alert.showAndWait();
         */

        Dialog dialog = new Dialog();
        dialog.setTitle("Acerca de...");
        dialog.setContentText("Gestor de personas desarrollado en clase de Programación de DAM1. Curso 2022-23");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();

    }

}