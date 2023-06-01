package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import dao.ActividadDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Actividad;

public class ActividadesController implements Initializable{

    Actividad actividad;

    @FXML
    private Label userLabel;
    
    @FXML
    private TextField lugarTextField;

    @FXML
    private ListView<Actividad> actividadesListView;

    @FXML
    private TextArea descripcionTextArea;

    @FXML
    private DatePicker finDatePicker;

    @FXML
    private DatePicker inicioDatePicker;

    @FXML
    private TextField plazasTextField;

    @FXML
    private TextField tituloTextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userLabel.setText(App.usuario.getUsername());
        actividadesListView.getItems().addAll(ActividadDAO.getActividades(App.usuario)); 
        actividadesListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> actividadSeleccionada(newSelection));
    }

    private void actividadSeleccionada(Actividad act) {
        actividad = act;
        tituloTextField.setText(act.getTitulo());
        inicioDatePicker.setValue(act.getFechaHoraFin().toLocalDate());
        finDatePicker.setValue(act.getFechaHoraInicio().toLocalDate());
        lugarTextField.setText(act.getLugar());

        plazasTextField.setText(String.valueOf(act.getPlazas()));
        descripcionTextArea.setText(act.getDescripcion());
    }

    @FXML
    void abrir(ActionEvent event) {

    }

    @FXML
    void guardar(ActionEvent event) {

    }

    @FXML
    void guardarComo(ActionEvent event) {

    }

    @FXML
    void cerrar(ActionEvent event) {
        System.exit(0); // Cerrar la aplicación
    }

    @FXML
    void agregar(ActionEvent event) {
        // TODO Validar campos
        ActividadDAO actDAO = new ActividadDAO();
        Actividad actividad = new Actividad(
            tituloTextField.getText(),
            inicioDatePicker.getValue().atStartOfDay(),
            finDatePicker.getValue().atStartOfDay(),
            lugarTextField.getText(),
            Integer.parseInt(plazasTextField.getText()),
            descripcionTextArea.getText(),
            App.usuario
        );
        actDAO.crearActividad(actividad);
        actividadesListView.getItems().add(actividad);
    }

    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void borrar(ActionEvent event) {
        ActividadDAO actDAO = new ActividadDAO();
        actDAO.eliminarActividad(actividad.getId());
        actividadesListView.getItems().remove(actividad);
        // TODO: Limpiar controles
    }

    @FXML
    void acercaDe(ActionEvent event) {

    }

}
