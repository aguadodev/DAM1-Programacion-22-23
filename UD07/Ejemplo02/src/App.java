import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplos Eventos");

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

        /*
        Label label = new Label("Label");
        Label label2 = new Label("Label2");
        label.setBackground(Background.fill(Paint.valueOf("LIGHTBLUE")));
        label2.setBackground(Background.fill(Paint.valueOf("LIGHTGREEN")));

        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 5);
        gridPane.add(label2, 5, 2);
        */

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

        // Eventos de Ventana
        primaryStage.setOnCloseRequest(e -> System.out.println(e));
        primaryStage.setOnHidden(e -> System.out.println(e));
        primaryStage.setOnHiding(e -> System.out.println(e));
        primaryStage.setOnShowing(e -> System.out.println(e));
        primaryStage.setOnShown(e -> System.out.println(e));

        // Eventos de Escena
        scene.setOnMouseClicked(e -> System.out.println(e));
        scene.setOnKeyPressed(e -> System.out.println(e));
        scene.setOnMouseEntered(e -> {
            scene.setCursor(Cursor.HAND);
            System.out.println(e);
        });
        scene.setOnMouseExited(e -> {
            scene.setCursor(Cursor.DEFAULT);
            System.out.println(e);
        });
        scene.setOnContextMenuRequested(e -> System.out.println(e));

        primaryStage.show();
    }
}
