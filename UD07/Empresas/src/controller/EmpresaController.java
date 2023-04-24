package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Empresa;

/**
 * EmpresaController
 */
public class EmpresaController implements Initializable{

    @FXML
    ListView<Empresa> empresasListView;

    @FXML
    TextField idTextField, nombreTextField, webTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Cargar empresas iniciales
        Empresa empresa1 = new Empresa(1, "Coremain", "https://www.coremain.com/");
        Empresa empresa2 = new Empresa(2, "Dinahosting", "https://www.dinahosting.com/");
        
        empresasListView.getItems().add(empresa1);
        empresasListView.getItems().add(empresa2);
    }

    @FXML
    void empresasMouseClicked(){
        Empresa empresa = empresasListView.getSelectionModel().getSelectedItem();

        idTextField.setText(String.valueOf(empresa.getId()));
        nombreTextField.setText(empresa.getNombre());
        webTextField.setText(empresa.getWeb());

    }

    @FXML
    void agregar(){
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
                                    nombreTextField.getText(),
                                    webTextField.getText());
        empresasListView.getItems().add(empresa);
    }

    @FXML
    void actualizar(){
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
        nombreTextField.getText(),
        webTextField.getText());

    }

    @FXML
    void borrar(){
        
    }

    
}