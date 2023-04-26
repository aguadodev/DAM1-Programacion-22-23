import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Actividad02 extends Application {

    TextField textField;
    Label label;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hola Mundo!!!");

        textField = new TextField();
        Button boton = new Button("Púlsame");
        boton.setOnAction(e -> botonPulsado());
        label = new Label();

        VBox vbox = new VBox(textField);
        vbox.getChildren().add(boton);
        vbox.getChildren().add(label);

        Scene scene = new Scene(vbox,600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void botonPulsado() {
        System.out.println(textField.getText());
        label.setText("Hola " + textField.getText());
    }
}