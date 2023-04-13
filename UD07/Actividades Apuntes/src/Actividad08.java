import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Actividad08 extends Application {
    final int FILAS = 8;
    final int COLUMNAS = 8;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tablero");

        GridPane gridBtn = new GridPane();

        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                Button btn = new Button();
                btn.setPrefSize(50, 50);
                btn.setOnMouseClicked(e -> btn.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null))));
                
                if ((i + j) % 2 != 0)
                    btn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                else
                    btn.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                gridBtn.add(btn, j, i);
            }

        GridPane gridRect = new GridPane();
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                Rectangle rect = new Rectangle(50, 50, (i + j) % 2 != 0 ? Color.BLACK : Color.WHITE);
                rect.setOnMouseClicked(e -> rect.setFill(Color.RED));
                gridRect.add(rect, j, i);
            }

        HBox hBox = new HBox(100, gridBtn, gridRect);
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

/*
 * // Dibujar un tablero de ajedrez con un GridPane de Etiquetas
 * final int FILAS = 8;
 * final int COLUMNAS = 8;
 * 
 * GridPane gridPane = new GridPane();
 * Label labels[][] = new Label[FILAS][COLUMNAS];
 * 
 * for (int i = 0; i < FILAS; i++)
 * for (int j = 0; j < COLUMNAS; j++) {
 * labels[i][j] = new Label(i + " - " + j);
 * labels[i][j].setPrefHeight(40);
 * labels[i][j].setPrefWidth(40);
 * labels[i][j].setAlignment(Pos.CENTER);
 * if ((i + j) % 2 == 0)
 * labels[i][j].setBackground(Background.fill(Paint.valueOf("WHITE")));
 * else
 * labels[i][j].setBackground(Background.fill(Paint.valueOf("GREY")));
 * gridPane.add(labels[i][j],j, i);
 * }
 * 
 * Scene scene = new Scene(gridPane);
 * primaryStage.setScene(scene);
 */