package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Empresa;

/**
 * EmpresaController
 */
public class EmpresaController implements Initializable{

    @FXML
    ListView<Empresa> empresasListView;

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
    void empresasMouseClicked(MouseEvent e){
        System.out.println(e);
        ListView empresas = (ListView) e.getSource();
        // TODO...
    }

    @FXML
    void agregar(){
        
    }

    @FXML
    void actualizar(){
        
    }

    @FXML
    void borrar(){
        
    }

    
}