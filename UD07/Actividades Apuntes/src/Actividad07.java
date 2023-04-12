import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Actividad07 extends Application{
    final int FILAS = 8;
    final int COLUMNAS = 8;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tablero");


        Button btn = new Button("X");
        btn.setPrefHeight(200);
        btn.setPrefWidth(200);
        btn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Scene scene = new Scene(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
