package controller;

import java.io.File;
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
import model.Empresa;

/**
 * EmpresaController
 */
public class EmpresaController implements Initializable {

    @FXML
    ListView<Empresa> empresasListView;

    @FXML
    TextField idTextField, nombreTextField, webTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Cargar empresas iniciales en el ListView
        Empresa empresa1 = new Empresa(1, "Coremain", "https://www.coremain.com/");
        Empresa empresa2 = new Empresa(2, "Dinahosting", "https://www.dinahosting.com/");

        empresasListView.getItems().add(empresa1);
        empresasListView.getItems().add(empresa2);

        empresasListView.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> empresaSeleccionada(newSelection));

    }

    // Muestra los datos de la empresa en el formulario
    private void empresaSeleccionada(Empresa e) {
        System.out.println(e);
        idTextField.setText(String.valueOf(e.getId()));
        nombreTextField.setText(e.getNombre());
        webTextField.setText(e.getWeb());

    }

    @FXML
    void agregar() {
        // Crea una empresa con los datos de los campos de texto
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
                nombreTextField.getText(),
                webTextField.getText());

        if (empresasListView.getItems().contains(empresa)) {
            // La empresa ya existe
            Alert alert = new Alert(AlertType.ERROR, "Ya existe una emprea con ese ID");
            alert.showAndWait();            
        } else {
            empresasListView.getItems().add(empresa);
        }

    }

    @FXML
    void actualizar() {
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
                nombreTextField.getText(),
                webTextField.getText());

        int i = empresasListView.getItems().indexOf(empresa);
        if (i == -1) {
            // La empresa no existe
            Alert alert = new Alert(AlertType.ERROR, "No existe una emprea con ese ID");
            alert.showAndWait();            
        } else {
            empresasListView.getItems().set(i, empresa);
        }
    }

    @FXML
    void borrar() {
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
                nombreTextField.getText(),
                webTextField.getText());

        int i = empresasListView.getItems().indexOf(empresa);
        if (i == -1) {
            // La empresa no existe
            Alert alert = new Alert(AlertType.ERROR, "No existe una emprea con ese ID");
            alert.showAndWait();
        } else {
            empresasListView.getItems().remove(i);
        }
    }

    @FXML
    void guardarComo(Event e){
        FileChooser fileChooser = new FileChooser();
        //fileChooser.setSelectedExtensionFilter());
        //Node n = (Node)e.getSource();
        // n.getScene().getWindow()
        
        File fichero = fileChooser.showSaveDialog(null);

        // Guardar en este fichero la lista de empresas en formato CSV
        System.out.println(fichero);
        try (FileWriter file = new FileWriter(fichero)) {
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    void cerrar(){
        System.exit(0); // Cerrar la aplicación
    }

    @FXML
    void acercaDe(){
        /** CUADRO DE DIÁLOGO CON Alert */
        /*Alert alert = new Alert(AlertType.INFORMATION, "Gestor de empresas desarrollado en clase de Programación de DAM1. Curso 2022-23");
        alert.showAndWait();*/

        Dialog dialog = new Dialog();
        dialog.setTitle("Acerca de...");
        dialog.setContentText("Gestor de empresas desarrollado en clase de Programación de DAM1. Curso 2022-23");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();

    }

}