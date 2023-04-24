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
        Empresa empresa = new Empresa(1, "Coremain", "https://www.coremain.com/");
        Empresa empresa2 = new Empresa(2, "Dinahosting", "https://www.dinahosting.com/");
        App.empresas.add(empresa);
        App.empresas.add(empresa2);
        
        empresasListView.getItems().addAll(App.empresas);
    }

    @FXML
    void empresasMouseClicked(){
        int i = empresasListView.getSelectionModel().getSelectedIndex();

        idTextField.setText(String.valueOf(App.empresas.get(i).getId()));
        nombreTextField.setText(App.empresas.get(i).getNombre());
        webTextField.setText(App.empresas.get(i).getWeb());

    }

    @FXML
    void agregar(){
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
                                    nombreTextField.getText(),
                                    webTextField.getText());
        App.empresas.add(empresa);
        empresasListView.getItems().add(empresa);
    }

    @FXML
    void actualizar(){
        Empresa empresa = new Empresa(Integer.parseInt(idTextField.getText()),
        nombreTextField.getText(),
        webTextField.getText());

        if (App.empresas.contains(empresa)){

        } else {

        }

    }

    @FXML
    void borrar(){
        
    }

    
}