import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CrearPersonaje extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Crear Personaje");

        TextField txtNombre = new TextField("Escribe un nombre...");
        HBox hBoxNombre = new HBox(10, new Label("Nombre"), txtNombre);

        System.out.println(Personaje.Raza.values());

        ComboBox<Personaje.Raza> cmbRaza = new ComboBox<>();
        cmbRaza.getItems().addAll(Personaje.Raza.values());

        HBox hBoxRaza = new HBox(10, new Label("Raza"), cmbRaza);

        Personaje p = new Personaje("Sin nombre", "HUMANO");

        Label lblAtributos = new Label("Atributos Físicos del Personaje: \n" + 
        "Fuerza: " + p.fuerza + "\n" +
        "Agilidad: " + p.agilidad + "\n" +
        "Constitución: " + p.constitucion + "\n" +
        "Puntos de Vida: " + p.puntosVida + "\n" +
        "Puntos de Experiencia: " + p.experiencia + "\n" +
        "Nivel: " + p.nivel + "\n"
        );

        Button btnCrear = new Button("Crear");
        btnCrear.setStyle("-fx-color: red;");
        btnCrear.setOnAction(e -> {
            p.nombre = txtNombre.getText();
            p.raza = cmbRaza.getValue();
            p.mostrar();

            primaryStage.close();
         });
        
        VBox vBox = new VBox(10, hBoxNombre, hBoxRaza, lblAtributos, btnCrear);
        Scene scene = new Scene(vBox, 250, 230);
        scene.getStylesheets().add("CrearPersonaje.css");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
