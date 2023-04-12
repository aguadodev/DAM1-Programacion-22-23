import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppEjemplo1 extends Application {

    int contador = 0;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hola Mundo!!!");
        Button boton = new Button("Púlsame");
        boton.setOnAction(e -> botonPulsado());
        Scene scene = new Scene(boton,600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void botonPulsado() {
        contador++;
        System.out.println("Botón pulsado " + contador + " veces!!!"); 
    }
}