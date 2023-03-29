package controller;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Personaje;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PersonajeController {

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<Personaje.Raza> razaComboBox;

    @FXML
    private Label lblFuerza, lblAgilidad, lblConstitucion, lblPuntosVida;
    
    @FXML
    private Button btnLanzarDados, btnCrearPersonaje;

    Personaje p;
    final int MAX_INTENTOS = 3;
    int intentos = 0;

    // Inicializar la vista
    public void initialize() {
        razaComboBox.getItems().setAll(Personaje.Raza.values());
        btnLanzarDados.setText("Lanzar dados (" + intentos + "/" + MAX_INTENTOS + " intentos)");
        p = new Personaje();
        generarValoresAleatorios();
    }
 
    // Métodos para manejar eventos
    @FXML
    private void generarValoresAleatorios() {
        btnCrearPersonaje.setDisable(false);
        if (intentos < MAX_INTENTOS) {
            // Implementar la generación de valores aleatorios y actualizar las etiquetas
            p.setFuerza((int)(Math.random()*81+20));
            p.setAgilidad((int)(Math.random()*81+20));
            p.setConstitucion((int)(Math.random()*81+20));
            p.setPuntosVida(50 + p.getConstitucion());
            lblFuerza.setText("Fuerza = " + p.getFuerza());
            lblAgilidad.setText("Agilidad = " + p.getAgilidad());
            lblConstitucion.setText("Constitución = " + p.getConstitucion());   
            lblPuntosVida.setText("Puntos de Vida = " + p.getPuntosVida());   
            intentos++;         
            btnLanzarDados.setText("Lanzar dados (" + intentos + "/" + MAX_INTENTOS + " intentos)");
        }
    }

    @FXML
    private void crearPersonaje(Event e) throws IOException {
        // Implementar la creación del objeto Personaje y guardarlo en formato JSON en un archivo
        p.setNombre(txtNombre.getText());
        p.setRaza(razaComboBox.getValue());
        p.setNivel(1);
        p.setExperiencia(0);
        //Util.exportarJson(p);
        App.p = p; 
        
        App.mostrarMapa();
    }
}

