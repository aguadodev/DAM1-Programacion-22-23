package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

}