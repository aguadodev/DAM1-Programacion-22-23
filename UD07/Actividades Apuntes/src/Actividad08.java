import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Actividad08 extends Application{
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






































/*        
// Dibujar un tablero de ajedrez con un GridPane de Etiquetas
        final int FILAS = 8;
        final int COLUMNAS = 8;

        GridPane gridPane = new GridPane();
        Label labels[][] = new Label[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                labels[i][j] = new Label(i + " - " + j);
                labels[i][j].setPrefHeight(40);
                labels[i][j].setPrefWidth(40);
                labels[i][j].setAlignment(Pos.CENTER);
                if ((i + j) % 2 == 0)
                    labels[i][j].setBackground(Background.fill(Paint.valueOf("WHITE")));
                else
                    labels[i][j].setBackground(Background.fill(Paint.valueOf("GREY")));
                gridPane.add(labels[i][j],j, i);
            }

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);         
*/